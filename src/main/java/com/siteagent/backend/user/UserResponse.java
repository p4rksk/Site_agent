package com.siteagent.backend.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
    private String token;
    private Long userId;  
    private String role;
}