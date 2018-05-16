package group.tonight.electricityfeehelper_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@RestController
public class MainController {
    private Logger logger = Logger.getLogger(MainController.class.getName());
    @Autowired
    public UserJPA mUserJPA;
    @Autowired
    public PowerUserJPA mPowerUserJPA;

    /**
     * @param userName
     * @param password
     * @return 这里返回的是实体，但在客户端收到的是json数据
     */
    @RequestMapping(value = "/register")
    public BaseResponseBean register(String userName, String password) {
        logger.info(userName + " " + password);
        if (StringUtils.isEmpty(userName)) {
            return new BaseResponseBean(-1, "缺少参数：userName");
        }
        if (StringUtils.isEmpty(password)) {
            return new BaseResponseBean(-1, "缺少参数：password");
        }
        List<User> byName = mUserJPA.findByName(userName);
        if (!byName.isEmpty()) {
            return new BaseResponseBean(-1, "用户名已存在");
        }
        logger.info("注册信息：userName:" + userName + ",password:" + password);
        mUserJPA.save(new User(userName, password));
        return new BaseResponseBean(0, "注册成功");
    }

    @RequestMapping(value = "/login")//如果没有定论括号内的路径，那么会以方法名做为路径
    public BaseResponseBean login(String userName, String password, HttpServletResponse response) throws IOException {
        logger.info(userName + " " + password);
        if (StringUtils.isEmpty(userName)) {
            return new BaseResponseBean(-1, "缺少参数：userName");
        }
        if (StringUtils.isEmpty(password)) {
            return new BaseResponseBean(-1, "缺少参数：password");
        }
        List<User> byName = mUserJPA.findByName(userName);
        if (byName.isEmpty()) {
            return new BaseResponseBean(-1, "用户名不存在");
        }
        if (!password.equals(byName.get(0).getPassword())) {
            return new BaseResponseBean(-1, "密码不正确");
        }
        logger.info("找到用户：" + byName);
        response.sendRedirect("/upload");
        return new BaseResponseBean(0, "登录成功");
    }

    @RequestMapping(value = "/getallpoweruserinfo")
    public BaseResponseBean getAllPowerUserInfo() {
        return new PowerUserResponse(mPowerUserJPA.findAll());
    }

    /**
     * 如果定义了参数，那么参数必须设置默认值，否则会抛异常
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/getpoweruserlist")
    public BaseResponseBean getPowerUserList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        PowerUserResponse powerUserResponse = new PowerUserResponse();
        if (size == -1) {
            //不分页
            List<PowerUser> powerUserList = mPowerUserJPA.findAll();
            powerUserResponse.setData(powerUserList);
        } else {
            //分页
            Page<PowerUser> powerUserPage = mPowerUserJPA.findAll(new PageRequest(page, size, new Sort(Sort.Direction.DESC, "id")));
            List<PowerUser> powerUserList = powerUserPage.getContent();
            powerUserResponse.setData(powerUserList);
        }
        logger.info("页数：" + page + "，每页数量：" + powerUserResponse.getData().size());
        return powerUserResponse;
    }

    @RequestMapping(value = "/searchpoweruser")
    public BaseResponseBean getPowerUserByKey(String searchKey) {
        if (StringUtils.isEmpty(searchKey)) {
            return new BaseResponseBean(-1, "缺少参数：searchKey");
        }
        Set<PowerUser> set = new HashSet<>();
        if (isNumeric(searchKey)) {
            List<PowerUser> list0 = mPowerUserJPA.findByUserIdContaining(Long.parseLong(searchKey));
            set.addAll(list0);
        }

        List<PowerUser> list1 = mPowerUserJPA.findByUserNameContains(searchKey);
        List<PowerUser> list2 = mPowerUserJPA.findByUserPhoneContaining(searchKey);
        List<PowerUser> list3 = mPowerUserJPA.findByPowerMeterIdContaining(searchKey);

        set.addAll(list1);
        set.addAll(list2);
        set.addAll(list3);
        List<PowerUser> newList = new ArrayList<>(set);

        logger.info("查询电力用户结果，查询关键字：" + searchKey + " 个数：" + newList.size());
        return new PowerUserResponse(newList);
    }

    public static boolean isNumeric(String str) {
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }
        return true;
    }
}
