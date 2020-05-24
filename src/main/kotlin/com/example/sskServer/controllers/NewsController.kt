package com.example.sskServer.controllers

import com.example.sskServer.models.NationalPlayer
import com.example.sskServer.models.Organizer
import com.example.sskServer.models.Player
import com.example.sskServer.models.Post
import com.example.sskServer.services.NationalPlayerService
import com.example.sskServer.services.OrganizerService
import com.example.sskServer.services.PostService
import io.swagger.annotations.ApiOperation
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
class NewsController {

    @Autowired
    lateinit var postService: PostService
    @Autowired
    lateinit var nationalPlayerService: NationalPlayerService
    @Autowired
    lateinit var organizerService: OrganizerService

    @PostMapping("/posts")
    @ApiOperation(value = "get all posts", response = Post::class)
    fun getAllPosts(): ResponseEntity<*>? {
        return try {
            ResponseEntity(postService.getAllPosts(), HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/post/{id}")
    @ApiOperation(value = "find a post by id", response = Post::class)
    fun findPostById(@RequestParam(name = "postId") postId: String): ResponseEntity<*>? {
        return try {
            val post = postService.findPostById(postId)
            if (post.isPresent) {
                ResponseEntity(postService.findPostById(postId), HttpStatus.OK)
            } else {
                noPostFoundResponseID(postId)
            }
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @GetMapping("post/{text}")
    @ApiOperation(value = "find post by text", response = Post::class)
    fun findPostByText(@RequestParam(name = "postText") postText: String): ResponseEntity<*>? {
        return try {
            val post: Optional<Post> = postService.findPostByText(postText)
            if (post.isPresent) {
                ResponseEntity(post.get(), HttpStatus.OK)
            } else {
                noPostFoundResponseText(postText)
            }
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @GetMapping("post/{timePublishing}")
    @ApiOperation(value = "find post by time publishing", response = Post::class)
    fun findPostByTimePublishing(@RequestParam(name = "timePublishing") timePublishing: Long): ResponseEntity<*>? {
        return try {
            val post: Optional<Post> = postService.findPostByTimePublishing(timePublishing)
            if (post.isPresent) {
                ResponseEntity(post.get(), HttpStatus.OK)
            } else {
                noPostFoundResponseTimePublishing(timePublishing)
            }
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @GetMapping("/players/{name}")
    @ApiOperation(value = "find player by name", response = Player::class)
    fun findPlayerByName(@RequestParam(name = "name") name: String): ResponseEntity<*>? {
        return try {
            val nationalPlayer: Optional<NationalPlayer> = nationalPlayerService.findNationalPlayerByName(name)
            if (nationalPlayer.isPresent) {
                ResponseEntity(nationalPlayer.get(), HttpStatus.OK)
            } else {
                noPlayerFoundResponseName(name)
            }
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/player/{institute}")
    @ApiOperation(value = "find player by institute", response = Player::class)
    fun findPlayerByInstitute(@RequestParam(name = "institute") institute: String): ResponseEntity<*>? {
        return try {
            val organizer: Optional<Organizer> = organizerService.findOrganizerByInstitute(institute)
            if (organizer.isPresent) {
                ResponseEntity(organizer.get(), HttpStatus.OK)
            } else {
                noOrganizerFoundResponseInstitute(institute)
            }
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/organizer/{institute}")
    @ApiOperation(value = "find organizer by name", response = Organizer::class)
    fun findOrganizerByName(@RequestParam(name = "name") name: String): ResponseEntity<*>? {
        return try {
            val organizer: Optional<Organizer> = organizerService.findOrganizerByName(name)
            if (organizer.isPresent) {
                ResponseEntity(organizer.get(), HttpStatus.OK)
            } else {
                noOrganizerFoundResponseName(name)
            }
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/organizer/{institute}")
    @ApiOperation(value = "find organizer by institute", response = Organizer::class)
    fun findOrganizerByInstitute(@RequestParam(name = "institute") institute: String): ResponseEntity<*>? {
        return try {
            val organizer: Optional<Organizer> = organizerService.findOrganizerByInstitute(institute)
            if (organizer.isPresent) {
                ResponseEntity(organizer.get(), HttpStatus.OK)
            } else {
                noOrganizerFoundResponseInstitute(institute)
            }
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/add")
    @ApiOperation(value = "add a new post", response = Post::class)
    fun savePost(@RequestBody post: Post): ResponseEntity<*>? {
        return try {
            ResponseEntity(postService.savePost(post), HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }

    @PostMapping("/update/{id}")
    @ApiOperation(value = "update an existing post", response = Post::class)
    fun updatePost(@RequestParam(name = "postId") postId: String, @Valid @RequestBody newPost: Post): ResponseEntity<*>? {
        return try {
            return postService.findPostById(postId).map { existingPost ->
                val updatedPost: Post = existingPost
                        .copy(postId = newPost.postId, postText = newPost.postText, postPicture = newPost.postPicture,
                                postTitle = newPost.postTitle, postTimePublish = newPost.postTimePublish)
                ResponseEntity.ok().body(postService.savePost(updatedPost))
            }.orElse(ResponseEntity.notFound().build())
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }


    @PostMapping("/delete")
    @ApiOperation(value = "delete a new post", response = Post::class)
    fun deletePost(@RequestBody post: Post): ResponseEntity<*>? {
        return try {
            ResponseEntity(postService.deletePost(post), HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            handleError(e)
        }
    }


    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleError(e: IllegalArgumentException) = ResponseEntity("Try server later", HttpStatus.INTERNAL_SERVER_ERROR)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun noPostFoundResponseID(id: String) = ResponseEntity("No post found with id: $id", HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun noPostFoundResponseText(text: String) = ResponseEntity("No post found with text: $text", HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun noPostFoundResponseTimePublishing(timePublishing: Long) = ResponseEntity("No post found with timePublishing: $timePublishing", HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun noPlayerFoundResponseName(name: String) = ResponseEntity("No player found with name: $name", HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun noOrganizerFoundResponseName(name: String) = ResponseEntity("No player found with name: $name", HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun noOrganizerFoundResponseInstitute(institute: String) = ResponseEntity("No player found with name: $institute", HttpStatus.NOT_FOUND)
}