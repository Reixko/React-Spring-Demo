package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
class DemoApplication {
	@Bean
	fun passwordEncoder(): PasswordEncoder? {
		return BCryptPasswordEncoder()
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
