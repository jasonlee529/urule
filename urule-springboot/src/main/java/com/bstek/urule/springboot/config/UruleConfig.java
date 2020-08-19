package com.bstek.urule.springboot.config;import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
    * @Title: UruleConfig
    * @Description: 
    * @author libo
    * @date 2020/8/19 18:07
    * @Version 1.0
    */
@Slf4j
@Configuration
@ImportResource({"classpath:context.xml"})
public class UruleConfig {
}
