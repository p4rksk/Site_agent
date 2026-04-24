package com.siteagent.backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.siteagent.backend.site.SiteService;
import com.siteagent.backend.site.response.SiteListResponse;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SiteService siteService;

    @PostMapping("/kakao-login")
    public ResponseEntity<?> kakaoLogin(@RequestBody Map<String, String> body) {
        String code = body.get("code");
        String token = userService.kakaoLogin(code);
        return ResponseEntity.ok(Map.of("token", token));
    }
    

    @GetMapping("/sites")
    public ResponseEntity<List<SiteListResponse>> getPublicSiteList() {
    return ResponseEntity.ok(siteService.getPublicSiteList());
}
}