package io.github.natanaeldepaulo.api.application.models.post;

import io.github.natanaeldepaulo.api.application.models.post.comment.CommentRequest;
import io.github.natanaeldepaulo.api.domain.embedded.Comment;

import java.util.List;

public interface IPostService {
    List<PostDTO> findPosts(String userId);
    PostDTO findPostById(String postId);
    PostDTO createPost(PostRequest post, String userId);
    void updatePost(String postId, UpdatePostRequest dataToUpdate) throws Exception;
    void deletePost(String postId) throws Exception;
    String likePost(String postId, String userId);
    String likeAndUnlikeCommentToPost(String postId, String commentId, String userId);
    void saveCommentToList(Comment comment, String postId);
    void updateCommentToPost(String postId, String commentId, CommentRequest dataToUpdate) throws Exception;
    void deleteCommentToPost(String postId, String commentId) throws Exception;
}
