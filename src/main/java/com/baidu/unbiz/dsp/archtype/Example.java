package com.baidu.unbiz.dsp.archtype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.unbiz.dsp.archtype.config.AppConfig2;

@RestController
@EnableAutoConfiguration
@ComponentScan("com.baidu.unbiz")
@ImportResource("classpath:applicationContext.xml")
//@SpringBootApplication
public class Example {

    @Autowired
    private AppConfig2 config;

    @RequestMapping("/")
    String home() {
        System.out.println(config.getKey());
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
