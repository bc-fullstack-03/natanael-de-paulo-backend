package br.java.social_network.application.post.controllers;

import br.java.social_network.application.post.services.IPostService;
import br.java.social_network.application.post.controllers.request.InputDataToPostService;
import br.java.social_network.application.post.controllers.response.PostResponseDTO;
import br.java.social_network.application.post.controllers.request.PostRequestDTO;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@RequestMapping("/posts")
public class CreatePostController {
    @Autowired
    @Qualifier("CreatePostServiceImpl")
    private IPostService<InputDataToPostService, PostResponseDTO> postService;

    @PostMapping
    public ResponseEntity<PostResponseDTO> handle(PostRequestDTO postRequestDTO, @RequestParam String userId, @RequestPart(required = false) MultipartFile file) {
        var input = InputDataToPostService.build().postRequest(postRequestDTO).userId(userId).file(file);
        var response = this.postService.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}