package org.omoknoone.member.security;

import jakarta.servlet.Filter;
import org.omoknoone.member.service.AuthService;
import org.omoknoone.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurity {

    private final MemberService memberService;
    private final AuthService authService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Environment environment;
    private final JwtUtil jwtUtil;
    private final JwtTokenProvider jwtTokenProvider;
    private final CorsConfig corsConfig;

    @Autowired
    public WebSecurity(MemberService memberService, AuthService authService,
                       BCryptPasswordEncoder bCryptPasswordEncoder,
                       Environment environment,
                       JwtUtil jwtUtil, JwtTokenProvider jwtTokenProvider, CorsConfig corsConfig) {
        this.memberService = memberService;
        this.authService = authService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.environment = environment;
        this.jwtUtil = jwtUtil;
        this.jwtTokenProvider = jwtTokenProvider;
        this.corsConfig = corsConfig;
    }

    /* 설명. 인가(Authorization)용 메소드 */
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

        /* 설명. 로그인 시 추가할 내용 */
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(memberService).passwordEncoder(bCryptPasswordEncoder);

        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        /* 설명. JWT 로그인 처리를 할 것이므로 csrf는 신경쓸 필요가 없다. */
        http.csrf((csrf) -> csrf.disable());

        http.cors(corsConfig -> corsConfig.getClass());


        http.authorizeHttpRequests((auth) -> auth
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
//                        .requestMatchers("/**").access(
//                                new WebExpressionAuthorizationManager("hasIpAddress('127.0.0.1') or hasIpAddress('192.168.0.21') or hasIpAddress('192.168.0.250')"))
                        .anyRequest().authenticated()
                )
                .authenticationManager(authenticationManager)
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        /* 설명. 로그아웃 처리 */
//        http.logout((logout) -> logout.logoutUrl("/auth/logout"))

        http.addFilter(getAuthenticationFilter(authenticationManager));
        http.addFilterBefore(new JwtFilter(memberService, environment, authService, jwtUtil, jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /* 설명. 인증(Authentication)용 메소드 */
    private Filter getAuthenticationFilter(AuthenticationManager authenticationManager) {
        return new AuthenticationFilter(authenticationManager, memberService, authService, environment, jwtTokenProvider);
    }

}
