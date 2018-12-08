package domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BlogBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String type;
	private String info;
	private String blog_text;
	private int userID;
	private Timestamp createDate;


	private UserBean author;
	private ArrayList<MessageBean> messages;
	
	
	public ArrayList<MessageBean> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<MessageBean> messages) {
		this.messages = messages;
	}

	public BlogBean(){
		super();
	}
	
	public BlogBean(String title, String type, String info, String blog_text, int userID) {
		this.title = title;
		this.type = type;
		this.info = info;
		this.blog_text = blog_text;
		this.userID = userID;
	}
	public BlogBean(int id, String title, String type, String info,
			String blog_text, int userID, Timestamp createDate) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.info = info;
		this.blog_text = blog_text;
		this.userID = userID;
		this.createDate = createDate;
	}
	
	
	
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



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	public String getBlog_text() {
		return blog_text;
	}



	public void setBlog_text(String blog_text) {
		this.blog_text = blog_text;
	}



	public int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
	}



	public Timestamp getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}



	@Override
	public String toString() {
		return "BlogBean [id=" + id + ", title=" + title + ", type=" + type
				+ ", info=" + info + ", blog_text=" + blog_text + ", userID="
				+ userID + ", createDate=" + createDate + "]";
	}
	
	
}
