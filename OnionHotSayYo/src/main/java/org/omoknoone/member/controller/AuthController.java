package org.omoknoone.member.controller;

import org.omoknoone.member.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader String refreshTokenId) throws AuthenticationException {
        authService.logout(refreshTokenId);

        return ResponseEntity.noContent().build();
    }


}
