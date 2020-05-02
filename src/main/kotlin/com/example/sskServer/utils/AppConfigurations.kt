package com.example.sskServer.utils

import com.example.sskServer.modules.Post
import com.example.sskServer.repositores.MatchRepository
import com.example.sskServer.repositores.PlayerRepository
import com.example.sskServer.repositores.PostRepository
import com.example.sskServer.repositores.ResultMatchRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfigurations {

    @Bean
    fun databaseInitializer(postRepository: PostRepository,
                            playerRepository: PlayerRepository,
                            matchRepository: MatchRepository,
                            resultMatchRepository: ResultMatchRepository) = ApplicationRunner{
        postRepository.save(Post(1234, "first post", "welcom in our app", "photo", 2019))
    }
}