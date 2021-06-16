import java.io.Serializable;
import java.util.ArrayList;

public class Post implements Serializable{
	private String text;
	private int numOfLikes;
	private int numOfComments;
	private ArrayList<String> comments = new ArrayList<String>();
	private java.util.Date dateOfCreation;
	
	/** constructor */
	public Post(String text) {
		dateOfCreation = new java.util.Date();
		this.text = text;
	}
	
	/** Getter of text */
	public void getText() {
		System.out.println(this.text);
	}
	
	/** date of creation for the post to string */
	public String showDateOfCreation() {
		return dateOfCreation.toString();
	}
	
	/** Getters and Setters for number of likes and number of comments */
	public int getNumberOfLikes() {
		return numOfLikes;
	}
	
	public int getNumberOfComments() {
		return numOfComments;
	}
	
	// commentOnPost method work as Setter method. if called this method it will increase number of comments
	// one and add the string that you will passed it to list of comments.
	public void commentOnPost(String text) {
		comments.add(text);
		numOfComments++;
	}
	
	// likePost method work as Setter method.
	public void likePost() {
		numOfLikes++; 
	}
	
	// getter for comments list 
	public ArrayList<String> getCommentsList() {
		return comments;
	}
}