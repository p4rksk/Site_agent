 package com.siteagent.backend.admin.request;


 public record AdminSignupRequest(
    String companyName,
    String businessNumber,
    String phone,
    String siteAdminId,
    String password
) {}
 