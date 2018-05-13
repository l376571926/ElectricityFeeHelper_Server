package group.tonight.electricityfeehelper_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ElectricityFeeHelperServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ElectricityFeeHelperServerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ElectricityFeeHelperServerApplication.class);
//		return super.configure(builder);
    }
}
