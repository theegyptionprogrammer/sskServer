package com.example.server.controllers

import com.example.sskServer.modules.Player
import com.example.sskServer.modules.Post
import com.example.sskServer.repositores.PlayerRepository
import com.example.sskServer.repositores.PostRepository
import com.example.sskServer.utils.DefaultResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import kotlin.collections.ArrayList


@RestController
class NewsController() {

    @Autowired
    lateinit var postRepository: PostRepository
    @Autowired
    lateinit var playerRepository: PlayerRepository

    @PostMapping("/addPost")
    fun setPost(@RequestBody post: Post): Post = postRepository.save(post)

    @GetMapping("/getPosts")
    fun getPost(): Iterable<Post> = postRepository.findAll()

    @DeleteMapping("/deletePost{id}")
    fun deletePostById(@PathVariable(value = "id") postId: Long): ResponseEntity<Void> {
        return postRepository.findById(postId).map { article ->
            postRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/updatePost/{id}")
    fun updatePostById(@PathVariable(value = "id") postId: Long,
                       @Valid @RequestBody newPost: Post): ResponseEntity<Post> {

        return postRepository.findById(postId).map { existingPost ->
            val updatedPost: Post = existingPost
                    .copy(postText = newPost.postText, postPicture = newPost.postPicture)
            ResponseEntity.ok().body(postRepository.save(updatedPost))
        }.orElse(ResponseEntity.notFound().build())
    }

    @RequestMapping("searchPost")
    fun searchPost(@PathVariable id: Iterable<Long>): String{
        return postRepository.findAllById(id).toString()
    }

    @RequestMapping("/searchPostByText/{text}")
    fun searchPostByText(@PathVariable text: String): List<Post> {
        val postList: List<Post> = postRepository.searchByText(text)
        val postListUi: MutableList<Post> = ArrayList()
        for (post in postList) {
            postListUi.add(Post(postText = post.postText, postPicture = post.postPicture, postId = post.postId,
                    postTitle = post.postTitle, postTimePublish = post.postTimePublish))
        }
        return postListUi
    }

    @RequestMapping("/searchPostByYear/{year}")
    fun searchPostByYear(@PathVariable year: Long): List<Post> {
        val postList: List<Post> = postRepository.searchByYear(year)
        val postListUi: MutableList<Post> = ArrayList()
        for (post in postList){
            postListUi.add(Post(postText = post.postText, postPicture = post.postPicture, postId = post.postId,
                    postTitle = post.postTitle, postTimePublish = post.postTimePublish))
        }
        return postListUi
    }

    @RequestMapping("/searchPlayerByName/{Name}")
    fun searchPlayerByName(@PathVariable name: String): List<Player> {
        val playerList: List<Player> = playerRepository.searchPlayerByName(name)
        val playerListUi: MutableList<Player> = ArrayList()
        for (player in playerList){
            playerListUi.add(Player(playerId = player.playerId, playerPosition = player.playerPosition,
                    playerPP = player.playerPP, playerName = player.playerName))
        }
        return playerListUi
    }


    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleError(e: IllegalArgumentException): DefaultResponse = DefaultResponse.Error(statusCode = 400, message = "Bad request", error = e.message)
}