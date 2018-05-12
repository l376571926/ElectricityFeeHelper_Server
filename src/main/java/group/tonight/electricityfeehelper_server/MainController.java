package group.tonight.electricityfeehelper_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class MainController {
    private Logger logger = Logger.getLogger(MainController.class.getName());
    @Autowired
    public UserJPA userJPA;

//    @RequestMapping(value = "/hello")
//    public String hello() {
//        return "Hello World!";
//    }

//    @RequestMapping(value = "/")
//    public String index() {
//        return "Welcome to electricity helper page";
//    }

    /**
     * @param userName
     * @param password
     * @return 这里返回的是实体，但在客户端收到的是json数据
     */
    @RequestMapping(value = "/register")
    public BaseResponseBean register(String userName, String password) {
        if (StringUtils.isEmpty(userName)) {
            return new BaseResponseBean(-1, "缺少参数：userName");
        }
        if (StringUtils.isEmpty(password)) {
            return new BaseResponseBean(-1, "缺少参数：password");
        }
        List<User> byName = userJPA.findByName(userName);
        if (!byName.isEmpty()) {
            return new BaseResponseBean(-1, "用户名已存在");
        }
        logger.info("注册信息：userName:" + userName + ",password:" + password);
        userJPA.save(new User(userName, password));
        return new BaseResponseBean(0, "");
    }

    @RequestMapping(value = "/login")//如果没有定论括号内的路径，那么会以方法名做为路径
    public Object login(String userName, String password, HttpServletResponse response) throws IOException {
        if (StringUtils.isEmpty(userName)) {
            return new BaseResponseBean(-1, "缺少参数：userName");
        }
        if (StringUtils.isEmpty(password)) {
            return new BaseResponseBean(-1, "缺少参数：password");
        }
        List<User> byName = userJPA.findByName(userName);
        if (byName.isEmpty()) {
            return new BaseResponseBean(-1, "用户名不存在");
        }
        if (!password.equals(byName.get(0).getPassword())) {
            return new BaseResponseBean(-1, "密码不正确");
        }
        logger.info("找到用户：" + byName);
        response.sendRedirect("/upload");
        return new BaseResponseBean(0, "");
    }
}
