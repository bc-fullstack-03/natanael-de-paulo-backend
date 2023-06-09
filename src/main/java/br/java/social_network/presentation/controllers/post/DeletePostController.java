package br.java.social_network.presentation.controllers.post;

import br.java.social_network.application.models.post.IPostService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class DeletePostController {
    @Autowired
    @Qualifier("DeletePostServiceImpl")
    private IPostService<String, Void> postService;
    
    @SneakyThrows
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> handle(@PathVariable String postId) {
        this.postService.execute(postId);
        return ResponseEntity.ok().body("successfully deleted");
    }
}
