package com.ssafy.enjoytrip.domain;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
=======
import lombok.*;
>>>>>>> a08410f8922a003c8208b5148bde8cb9525af514

import javax.persistence.*;

@Getter
@Entity
<<<<<<< HEAD
@AllArgsConstructor
=======
@NoArgsConstructor
>>>>>>> a08410f8922a003c8208b5148bde8cb9525af514
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private User() {
    	
    }
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
