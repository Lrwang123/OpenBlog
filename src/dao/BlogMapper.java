package dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import domain.BlogBean;
import domain.MessageBean;
import domain.UserBean;

public interface BlogMapper {
	
	public ArrayList<BlogBean> getAllBlogByUserId(int id);

	public ArrayList<BlogBean> getAllBlog();

	public BlogBean getBlogByBlogId(int blogId);

	public UserBean getUserByUserId(int userId);

	public int addBlog(@Param("blog") BlogBean blog,@Param("user_id") int user_id);
	
	public int UpdateBlog(@Param("blog") BlogBean new_blog,@Param("user_id") int user_id);

	public int delete(int blog_id, int user_id);
	
	public int addMessage(MessageBean message);
	
	public int deleteMessage(@Param("id") int id, @Param("userId") int userId);
	
	public ArrayList<MessageBean> getMessagesByBlogId(int blogId);
}
