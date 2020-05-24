package com.example.sskServer

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/*
* {@link EnableAutoConfiguration Auto-configuration} for
* {@link ConfigurationProperties @ConfigurationProperties} beans. Automatically binds and
* validates any bean annotated with {@code @ConfigurationProperties}.
*/

@SpringBootApplication
@EntityScan("com.example.sskServer.models")
@ComponentScan("com.example.sskServer")
@EnableJpaRepositories("com.example.sskServer.repositories")
@Configuration
@EnableAutoConfiguration
class SSkServerApplication

fun main(args: Array<String>) {
	SpringApplication.run(SSkServerApplication::class.java, *args)
}

/*
object AutoConfigurationPackagesTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val app = SpringApplication(AutoConfigurationPackagesTest::class.java)
        app.setBannerMode(Banner.Mode.OFF)
        app.setLogStartupInfo(false)
        val c = app.run(*args)
        val packages = AutoConfigurationPackages.get(c)
        println("packages: $packages")
    }
}

 */