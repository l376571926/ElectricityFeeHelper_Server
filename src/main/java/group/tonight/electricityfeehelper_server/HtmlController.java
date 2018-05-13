package group.tonight.electricityfeehelper_server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Html页面的访问用@Controller，不能用通常的@RestController
 */
@Controller
public class HtmlController {
    //这里不能写为(value = "/index")，否则http://localhost:8080/访问不了
    @GetMapping(value = "/")
    public String index() {
//        return "index";
        return "login";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    /**
     * 访问aaa.html页面
     * http://localhost:8080/upload
     *
     * @return
     */
    @GetMapping(value = "/upload")
    public String upload() {
        return "upload";//返回的是显示数据的html的文件名
    }

    @GetMapping(value = "/uploadStatus")
    public String uploadStatus(HttpServletRequest request, String key) {
        request.setAttribute("key", key);
        return "uploadStatus";//返回的是显示数据的html的文件名
    }
}
