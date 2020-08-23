package com.bstek.urule.console;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Jacky.gao
 * @since 2016年10月12日
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.infisa.tools","com.bstek.urule"})
@MapperScan("cn.infisa.tools")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
