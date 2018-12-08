package domain;

import java.sql.Timestamp;

public class MessageBean {
	
	private int id;
	private int userId;
	private int blogId;
	private String text;
	private int status;
	private Timestamp createdate;
	private UserBean author;
	
	
	public UserBean getAuthor() {
		return author;
	}
	public void setAuthor(UserBean author) {
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "MessageBean [id=" + id + ", userId=" + userId + ", blogId="
				+ blogId + ", text=" + text + ", status=" + status
				+ ", createdate=" + createdate + "]";
	}
	
	
}
