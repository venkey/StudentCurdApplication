package Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import DAO.Post_DAO;
import Model.Post;

@Service
@Transactional
public class Post_Service_Impl implements PostService {

	@Autowired
	private Post_DAO postdao;

	@Override
	public boolean savePost(Post post) {
		// TODO Auto-generated method stub
		return postdao.savePost(post);
	}

	@Override
	public List<Post> getPosts() {
		// TODO Auto-generated method stub
		return postdao.getPosts();
	}

	@Override
	public boolean deletePost(Post post) {
		// TODO Auto-generated method stub
		return postdao.deletePost(post);
	}

	@Override
	public List<Post> getPostByID(Post post) {
		// TODO Auto-generated method stub
		return postdao.getPostByID(post);
	}

	@Override
	public boolean updatePost(Post post) {
		// TODO Auto-generated method stub
		return postdao.updatePost(post);
	}

}
