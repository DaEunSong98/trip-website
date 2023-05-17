package com.ssafy.enjoytrip.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginTokenInfo {
	
    private Long userId;
    private String nickName;

}
