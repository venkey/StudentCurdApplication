package DAO;

import java.util.List;

import Model.Post;



public interface Post_DAO {
	
	public boolean savePost(Post post);
	public List<Post> getPosts();
	public boolean deletePost(Post post);
	public List<Post> getPostByID(Post post);
	public boolean updatePost(Post post);

}
