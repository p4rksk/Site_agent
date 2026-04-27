package com.siteagent.backend.user.response;

public record UserLoginResponse(
    String token,
    String role,
    Long id
) {}