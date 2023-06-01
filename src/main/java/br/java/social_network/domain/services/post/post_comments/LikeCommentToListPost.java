package br.java.social_network.domain.services.post.post_comments;

import br.java.social_network.application.models.post.IPostService;
import br.java.social_network.application.models.post.PostDTO;
import br.java.social_network.application.models.post.PostRequest;
import br.java.social_network.application.models.post.UpdatePostRequest;
import br.java.social_network.application.models.post.comment.CommentRequest;
import br.java.social_network.application.utils.ConvertFormatId;
import br.java.social_network.domain.embedded.Comment;
import br.java.social_network.domain.embedded.Likes;
import br.java.social_network.infrastructure.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("LikeCommentToListPost")
public class LikeCommentToListPost implements IPostService {
    @Autowired
    private IPostRepository postRepository;

    @Override
    public List<PostDTO> findPosts(String userId) {
        return null;
    }

    @Override
    public PostDTO findPostById(String postId) {
        return null;
    }

    @Override
    public PostDTO createPost(PostRequest post, String userId) {
        return null;
    }

    @Override
    public void updatePost(String postId, UpdatePostRequest dataToUpdate) throws Exception {

    }

    @Override
    public void deletePost(String postId) throws Exception {

    }

    @Override
    public String likePost(String postId, String userId) {
        return null;
    }

    @Override
    public String likeAndUnlikeCommentToPost(String postId, String commentId, String userId) {
        var post = this.postRepository.findById(ConvertFormatId.toUUID(postId));
        var like = new Likes(ConvertFormatId.toUUID(userId));
        var comment = post.get().getComments().stream()
                .filter(c -> c.getId().equals(ConvertFormatId.toUUID(commentId)))
                .findFirst();

        if (comment != null && comment.get().getLikes().contains(like)) {
            comment.get().getLikes().remove(like);
            this.postRepository.save(post.get());
            return "like removed!";
        } else {
            comment.get().getLikes().add(like);
            this.postRepository.save(post.get());
            return "like added!";
        }
    }

    @Override
    public void saveCommentToList(Comment comment, String postId) {

    }

    @Override
    public void updateCommentToPost(String postId, String commentId, CommentRequest dataToUpdate) throws Exception {

    }

    @Override
    public void deleteCommentToPost(String postId, String commentId) throws Exception {

    }
}
