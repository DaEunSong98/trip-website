package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.User;
import com.ssafy.enjoytrip.session.LoginSessionInfo;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    User findUserById(Long userId);

    LoginSessionInfo loginUser(String loginId, String password);

    void join(User user);

    void updateUser(User user);

    void deleteUser(Long userId);
}
