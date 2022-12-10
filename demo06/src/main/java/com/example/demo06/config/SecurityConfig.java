package com.example.demo06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
@Bean
public BCryptPasswordEncoder encodePwd() {
	return new BCryptPasswordEncoder();
	}

@Override
protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable(); // disabled하지 않으면 csrf값을 post할 때 일일히 전달해야 함
	http.authorizeRequests()
		.antMatchers("/user/*").authenticated() // user로 넘어오는 것에 시큐리티 적용
		.anyRequest()
		.permitAll()
	.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/")
	.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/")
		.invalidateHttpSession(true);
		}
}
