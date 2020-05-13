package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private val userDetailsService: UserDetailServiceImpl? = null

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/login/**").permitAll()
                .anyRequest().authenticated()
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
        http.logout()
                .permitAll()
        http.httpBasic()
    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService<UserDetailsService?>(userDetailsService).passwordEncoder(BCryptPasswordEncoder())
    }
}