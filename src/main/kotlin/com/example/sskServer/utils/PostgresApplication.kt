package com.example.sskServer.utils

import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


object PostgresApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(PostgresApplication::class.java, *args)
    }

    @Configuration
    internal class OklaOAuth2WebSecurityConfigureAdapter : WebSecurityConfigurerAdapter() {
        @Throws(Exception::class)
        override fun configure(http: HttpSecurity) {
            http
                    .authorizeRequests().anyRequest().authenticated()
                    .and()
                    .oauth2ResourceServer().jwt()
        }
    }
}

