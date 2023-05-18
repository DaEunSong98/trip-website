package com.ssafy.enjoytrip.config;

import com.ssafy.enjoytrip.token.interceptor.TokenInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/error", "/attraction/**", "/user/login/**", "/user/signup", "/board", "/board/{boardId}", "/board/{boardId}/comments");
    }
}
