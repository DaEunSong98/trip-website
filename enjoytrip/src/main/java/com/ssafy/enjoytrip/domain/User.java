package com.ssafy.enjoytrip.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String loginId;
    private String nickname;
    private String mail;
    private String name;
    private String password;
    private String phoneNumber;

    @Builder
    public User(Long userId, String loginId, String nickname, String mail, String name, String password, String phoneNumber) {
        this.userId = userId;
        this.loginId = loginId;
        this.nickname = nickname;
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public boolean loginLogic(String password) {
        return this.password.equals(password);
    }

    public void updateUser(User user) {
        this.mail = user.getMail();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
        this.phoneNumber = user.getPhoneNumber();
    }
}
