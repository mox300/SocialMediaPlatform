import java.io.Serializable;
import java.util.ArrayList;

public class Page implements Serializable {
	private String pageName, pageDescription, admin;
	private int numberOfFollowers, numOfRecommendations;
	private java.util.Date dateOfCreation;
	private ArrayList<Post> posts = new ArrayList<Post>();
	
	/** constructor */
	public Page(String pageName, String pageDescription, String firstName, String lastName) {
		dateOfCreation = new java.util.Date();
		this.pageName = pageName;
		this.pageDescription = pageDescription;
		this.admin = firstName + " " + lastName;
	}
	
	/** Getters and Setters for page name and page description */
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String name) {
		pageName = name;
	}
	
	public String getPageDescription() {
		return pageDescription;
	}
	public void setPageDescription(String description) {
		pageDescription = description;
	}
	
	/** Getter and add one follower methods */
	public int getNumberOfFollower() {
		return numberOfFollowers;
	}
	public void addFollower() {
		numberOfFollowers++;
	}
	
	/** Getter and add one recommendation methods */
	public int getNumberOfRecommendation() {
		return numOfRecommendations;
	}
	
	public void addRecommedation() {
		numOfRecommendations++;
	}
	
	/** Getter for page posts to use it in pagesView show method*/
	public ArrayList<Post> getPagePosts() {
		return posts;
	}
	
	public void addNewPostToPagePostsList(Post post) {
		posts.add(post);
	}
}
