package ee.mrtnh.opera_codility_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OperaCodilityTestApplication extends SpringBootServletInitializer {
    // extends and override are needed to start as a .war without embedded Tomcat

    public static void main(String[] args) {
        SpringApplication.run(OperaCodilityTestApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(OperaCodilityTestApplication.class);
    }

}
