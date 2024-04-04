package org.omoknoone.onionhotsayyo.member.service;

import javax.naming.AuthenticationException;

public interface AuthService {
    String successLogin(String memberId, String refreshToken);
    void logout(String refreshTokenId) throws AuthenticationException;
    boolean checkRefreshToken(String refreshTokenId);
}
