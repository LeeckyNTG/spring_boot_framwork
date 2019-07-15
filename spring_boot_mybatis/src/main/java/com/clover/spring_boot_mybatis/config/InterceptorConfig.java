package com.clover.spring_boot_mybatis.config;

import com.clover.spring_boot_mybatis.interceptor.LoginTnterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        String[] pathPatterns = {
                "/student/**",
                "/user/**"
        };
        String[] excludePathPatterns = {
                "/user/getResource",
                "/student/getStudentAll",
        };

        registry.addInterceptor(new LoginTnterceptor())
                .addPathPatterns(pathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}
