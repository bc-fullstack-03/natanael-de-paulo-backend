package br.java.social_network.domain.post.services.post_comments;

import br.java.social_network.application.post.services.IPostService;
import br.java.social_network.domain.post.embedded.Comment;
import br.java.social_network.infrastructure.exception.HandleNotFoundException;
import br.java.social_network.infrastructure.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Qualifier("SaveCommentToPostListServiceImpl")
public class SaveCommentToPostListServiceImpl implements IPostService<Comment, Void> {
    @Autowired
    private IPostRepository postRepository;

    @Override
    public Void execute(Comment comment) {
        try {
            var post = this.postRepository.findById(comment.getPost_id());

            post.get().getComments().add(comment);

            this.postRepository.save(post.get());

            return null;
        } catch (Exception e){
            if (e.getMessage() == "No value present") throw new HandleNotFoundException("Post not found");
            throw new HandleNotFoundException(e.getMessage());
        }
    }
}