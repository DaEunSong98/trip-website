package com.ssafy.enjoytrip.interceptor;

import com.ssafy.enjoytrip.auth.JwtUtil;
import com.ssafy.enjoytrip.domain.User;
import com.ssafy.enjoytrip.service.UserService;
import com.ssafy.enjoytrip.token.LoginTokenConst;
import com.ssafy.enjoytrip.token.LoginTokenInfo;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.ssafy.enjoytrip.token.LoginTokenConst.USER_INFO;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    private final UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("call TokenInterceptor");

        String accessToken = request.getHeader(JwtUtil.ACCESS_TOKEN_NAME);

        if (jwtUtil.checkToken(accessToken)) {
            Claims claims = jwtUtil.parseToken(accessToken);
            LoginTokenInfo loginTokenInfo = claims.get(LoginTokenConst.LOGIN_TOKEN, LoginTokenInfo.class);
            request.setAttribute(USER_INFO, loginTokenInfo);
            return true;
        }

        String refreshToken = request.getHeader(JwtUtil.REFRESH_TOKEN_NAME);

        if (jwtUtil.checkToken(refreshToken)) {
            Claims claims = jwtUtil.parseToken(refreshToken);
            LoginTokenInfo loginTokenInfo = claims.get(LoginTokenConst.LOGIN_TOKEN, LoginTokenInfo.class);
            User user = userService.findUserById(loginTokenInfo.getUserId());

            if (user.getRefreshToken().equals(refreshToken)) {
                String newAccessToken = jwtUtil.createAccessToken(LoginTokenConst.LOGIN_TOKEN, loginTokenInfo);
                response.setHeader(JwtUtil.REFRESH_TOKEN_NAME, newAccessToken);
                return true;
            }

        }

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return false;
    }
}