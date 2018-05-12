package group.tonight.electricityfeehelper_server;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * 但是大于1MB的文件上传时会提示出错的，所以要进行设置。添加一个配置文件就可以了。
 * 也可以在application.properties中加入这两句：
 * spring.http.multipart.maxFileSize=100Mb
 * spring.http.multipart.maxRequestSize=100Mb
 */
@Configuration
public class FileUploadConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("100MB");
        factory.setMaxRequestSize("100MB");
        return factory.createMultipartConfig();
    }
}  