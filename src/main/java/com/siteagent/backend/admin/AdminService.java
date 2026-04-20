package com.siteagent.backend.admin;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siteagent.backend.admin.request.AdminSignupRequest;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {
    
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 회원가입
    @Transactional
    public Admin signUp(AdminSignupRequest request ){
        
        checkDuplicateAdminId(request.siteAdminId());
        
        Admin admin = adminRepository.save(
         Admin.builder()
         .companyName(request.companyName())
         .businessNumber(request.businessNumber())
         .siteAdminId(request.siteAdminId())
         .password(passwordEncoder.encode(request.password()))
         .build()
        );

        return admin;

    } ;

    //Admin 아이디 중복체크
    public boolean checkDuplicateAdminId(String siteAdminId) {
        return adminRepository.existsBySiteAdminId(siteAdminId);
    }
}