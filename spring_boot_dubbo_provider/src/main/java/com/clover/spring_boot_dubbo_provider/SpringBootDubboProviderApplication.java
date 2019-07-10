package com.clover.spring_boot_dubbo_provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo   //开启dubbo的自动配置
public class SpringBootDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDubboProviderApplication.class, args);
    }

}
