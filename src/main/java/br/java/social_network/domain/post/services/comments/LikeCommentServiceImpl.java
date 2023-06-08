package br.java.social_network.domain.post.services.comments;

import br.java.social_network.application.post.services.IPostService;
import br.java.social_network.application.comment.services.ICommentService;
import br.java.social_network.application.comment.controllers.request.InputDataToCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("LikeCommentServiceImpl")
public class LikeCommentServiceImpl implements ICommentService<InputDataToCommentService, String> {
    @Autowired
    @Qualifier("LikeCommentToListPost")
    private IPostService<InputDataToCommentService, String> postService;

    @Override
    public String execute(InputDataToCommentService input){
        try {
            var response = this.postService.execute(input);
            return response;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}