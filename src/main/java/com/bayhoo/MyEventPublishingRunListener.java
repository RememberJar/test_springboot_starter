package com.bayhoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by lenovo on 2019/12/9.
 */
public class MyEventPublishingRunListener implements SpringApplicationRunListener {

    private SpringApplication application;

    private String[] args;

    public MyEventPublishingRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        //配置文件读取到程序中 需要自己将本地文件读取到程序中，然后在放入springboot容器中
        Properties properties = new Properties();
        try {
            //1.读取我们的my.properties文件
            properties.load(this.getClass().getClassLoader().getResourceAsStream("my.properties"));
            //2.读取名称为my
            PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("my", properties);
            //3.将资源添加到springboot项目中
            MutablePropertySources propertySources = environment.getPropertySources();
//            4.通过api接口可以将配置文件读取到springboot项目中
            propertySources.addLast(propertiesPropertySource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
