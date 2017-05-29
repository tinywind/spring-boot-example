package com.gogokwon.config;

import com.gogokwon.interceptor.LoginRedirectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

/**
 * Created by KJShin on 2017-05-07.
 */
@Configuration
public class StaticResourceConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private LoginRedirectInterceptor loginRedirectInterceptor;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/files/**").addResourceLocations(
                new File(System.getProperty("user.dir") + "/files/").toURI().toString());
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginRedirectInterceptor);
        super.addInterceptors(registry);
    }
}
