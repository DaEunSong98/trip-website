package com.ssafy.enjoytrip.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginSessionInfo {
	
    private Long userId;
    private String nickName;

}
