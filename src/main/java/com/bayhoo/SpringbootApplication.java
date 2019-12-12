package com.bayhoo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.bayhoo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2019/12/5.
 */

@RestController
@SpringBootApplication
public class SpringbootApplication {

    @Autowired
    private TokenService tokenService;

    @Value("${name}")
    private String name;

    @RequestMapping("/userName")
    public String userName(){

        return tokenService.getToken();
    }
    @RequestMapping("/name")
    public String name(){

        return name;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class);
    }

}
