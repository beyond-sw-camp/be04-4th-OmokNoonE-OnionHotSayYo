package org.omoknoone.onionhotsayyo.member.service;

import org.omoknoone.onionhotsayyo.member.aggregate.Auth;
import org.omoknoone.onionhotsayyo.member.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;

@Service
public class AuthServiceImpl implements AuthService{

    private final AuthRepository authRepository;

    @Autowired
    public AuthServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    /* 설명. 로그인 성공 시 redis에 token 값 저장 후 Id 반환 */
    @Override
    @Transactional
    public String successLogin(String memberId, String refreshToken) {

        Auth auth = new Auth(
                refreshToken,
                memberId,
                false
        );

        return authRepository.save(auth).getId();
    }

    @Override
    @Transactional
    public void logout(String refreshTokenId) throws AuthenticationException {
        Auth auth = authRepository.findById(refreshTokenId).orElseThrow(AuthenticationException::new);
        auth.setExpired(true);

        authRepository.save(auth);
    }

    @Override
    public boolean checkRefreshToken(String refreshTokenId) {
        Auth auth = null;

        try {
            auth = authRepository.findById(refreshTokenId).orElseThrow(AuthenticationException::new);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }

        return !auth.isExpired();
    }
}
