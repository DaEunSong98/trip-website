package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.User;
import com.ssafy.enjoytrip.exception.LoginException;
import com.ssafy.enjoytrip.exception.UserException;
import com.ssafy.enjoytrip.repository.UserRepository;
import com.ssafy.enjoytrip.session.LoginSessionInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserException("잘못된 접근입니다."));
    }

    @Override
    public LoginSessionInfo loginUser(String loginId, String password) {
        User findUser = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new LoginException("잘못된 아이디 또는 비밀번호를 입력했습니다."));
        if (findUser.loginLogic(password)) {
            return new LoginSessionInfo(findUser.getUserId(), findUser.getNickname());
        }
        throw new LoginException("잘못된 아이디 또는 비밀번호를 입력했습니다.");
    }

    @Override
    public void join(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        User findUser = userRepository.findById(user.getUserId())
                .orElseThrow(() -> new UserException("잘못된 접근입니다."));
        findUser.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
