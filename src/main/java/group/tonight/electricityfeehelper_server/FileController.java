package group.tonight.electricityfeehelper_server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/file")
public class FileController {
    private Logger logger = Logger.getLogger(FileController.class.getName());

    @Autowired
    public PowerUserJPA mPowerUserJPA;

    /**
     * 单文件上传
     *
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public BaseResponseBean upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        String saveFileName = file.getOriginalFilename();
        File saveFile = new File(request.getSession().getServletContext().getRealPath("/upload/") + saveFileName);
        logger.info(saveFile.getAbsolutePath());
        if (!saveFile.getParentFile().exists()) {
            boolean mkdirs = saveFile.getParentFile().mkdirs();
        }
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
            out.write(file.getBytes());
            out.flush();
            out.close();

            new Thread(() -> parseExcel(saveFile)).start();

            //url中的中文要编码，否则在浏览器上会显示乱码
            response.sendRedirect("/uploadStatus?key=" + URLEncoder.encode("上传成功，文件名为：" + saveFileName, "utf-8"));
            return new BaseResponseBean(0, saveFile.getName() + " 上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            try {
                response.sendRedirect("/uploadStatus?key=" + URLEncoder.encode("上传失败，原因：" + e.getMessage(), "utf-8"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return new BaseResponseBean(-1, "上传失败," + e.getMessage());
        }
    }

    public static void main(String[] args) {
    }

    private void parseExcel(File file) {
        try {
            //为要读取的excel文件名
            Workbook book = Workbook.getWorkbook(file);
//            book = Workbook.getWorkbook(new File("D://478.xls"));//excel2007无法解析
            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            PowerUser aInstance = new PowerUser();
            Field[] fields = aInstance.getClass().getDeclaredFields();
            List<String> list = new ArrayList<>();
            for (Field field : fields) {
                list.add(field.getName());
            }
//            System.out.println("PowerUser中所有成员变量名称：" + Arrays.toString(list.toArray()));
            Sheet sheet = book.getSheet(0);
            if (sheet.getRows() != 0) {
                Cell[] row = sheet.getRow(0);//获取excel表第一行的数据
                JSONArray array = new JSONArray();
                for (int i = 1; i < sheet.getRows(); i++) {
                    JSONObject object = new JSONObject();
                    if ("".equals(sheet.getCell(0, i).getContents())) {
                        continue;
                    }
                    for (int m = 0; m < row.length; m++) {
                        object.put(list.get(m + 1), sheet.getCell(m, i).getContents());
                    }
                    array.add(object);
                }
                book.close();
                if (array.size() != 0) {
                    //PowerUser要有Getter、Setter方法才可以正常解析
                    List<PowerUser> powerUserList = JSON.parseArray(array.toString(), PowerUser.class);
                    for (PowerUser newPowerUser : powerUserList) {
                        long userId = newPowerUser.getUserId();
                        List<PowerUser> byUserId = mPowerUserJPA.findByUserId(userId);
                        if (byUserId.isEmpty()) {//如果没有就插入
                            mPowerUserJPA.save(newPowerUser);
                        }else {////如果有有就更新
                            newPowerUser.setId(byUserId.get(0).getId());
                            mPowerUserJPA.save(newPowerUser);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 多文件上传
     *
     * @param request
     * @return
     */
    @RequestMapping("/uploadFiles")
    @ResponseBody
    public String uploadFiles(HttpServletRequest request) throws IOException {
        File savePath = new File(request.getSession().getServletContext().getRealPath("/upload/"));
        if (!savePath.exists()) {
            savePath.mkdirs();
        }
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    File saveFile = new File(savePath, file.getOriginalFilename());
                    stream = new BufferedOutputStream(new FileOutputStream(saveFile));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    if (stream != null) {
                        stream.close();
                        stream = null;
                    }
                    return "第 " + i + " 个文件上传有错误" + e.getMessage();
                }
            } else {
                return "第 " + i + " 个文件为空";
            }
        }
        return "所有文件上传成功";
    }
}  