package com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
class DemoDeployable : SpringBootServletInitializer() {

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder? {
        return application.sources(DemoDeployable::class.java)
    }

    fun main(args: Array<String>) {
        SpringApplication.run(DemoDeployable::class.java, *args)
    }
}