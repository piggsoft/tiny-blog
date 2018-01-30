package com.piggsoft.tinyblog.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author piggsoft
 * @version 1.0
 * @create 2018/1/30
 * @since 1.0
 */
@EnableCaching
@Configuration
public class TinyBlogConfig {

    /*@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return container -> {
            container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400"));
            container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
        };
    }*/


}
