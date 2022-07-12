package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Model.Post;

@Repository
public class Post_DAO_Imp implements Post_DAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean savePost(Post post) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().save(post);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Post> getPosts() {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("hi");
		Query<Post> query = currentSession.createQuery("from Post", Post.class);
		List<Post> list = query.getResultList();
		return list;
	}

	@Override
	public boolean deletePost(Post post) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().delete(post);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Post> getPostByID(Post post) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Post> query = currentSession.createQuery("from Post where id=:id", Post.class);
		query.setParameter("id", post.getId());
		List<Post> list = query.getResultList();
		return list;
	}

	@Override
	public boolean updatePost(Post post) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().update(post);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
