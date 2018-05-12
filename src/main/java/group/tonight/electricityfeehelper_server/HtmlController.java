package group.tonight.electricityfeehelper_server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Html页面的访问用@Controller，不能用通常的@RestController
 */
@Controller
public class HtmlController {
    @GetMapping
    public String index() {
        return "index";
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
}
