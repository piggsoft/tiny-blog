package com.piggsoft.tinyblog.config;

import com.piggsoft.tinyblog.interceptor.AdminInterceptor;
import com.piggsoft.tinyblog.interceptor.BaseInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private BaseInterceptor baseInterceptor;
    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor);
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**");
        super.addInterceptors(registry);
    }
}