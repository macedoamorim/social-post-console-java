package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	private Integer number;
	
	private List<Comment> comments = new ArrayList<>();



	public Post(SimpleDateFormat sdf, Date moment, String title, String content, Integer likes, Integer number) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
		this.number = number;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Comment> getComents() {
		return comments;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void addComment(Comment coment) {
		comments.add(coment);
	}
	
	public void removeComment(Comment coment) {
		comments.remove(coment);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Post " + number + ":\n");
		sb.append(getTitle() + "\n");
		sb.append(likes + " Likes - " + sdf.format(getMoment()) + "\n");
		sb.append(getContent() + "\n");
		sb.append("Comments: \n");
		
		if (comments.isEmpty()) {
			sb.append("No comments yet");
		}
		
		else {
			
			for (Comment c : comments) {
				sb.append(c + "\n");
			}
		
		}
		
		return sb.toString();
	}
	
	
}
