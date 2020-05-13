package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImpl @Autowired constructor(private val passwordEncoder: PasswordEncoder) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        if (username == "user") {
            return org.springframework.security.core.userdetails.User(
                    "user",
                    passwordEncoder.encode("user"),
                    mutableListOf()
            )
        }
        throw UsernameNotFoundException("User with this username: '$username' does NOT exist.")
    }
}