import java.io.Serializable;
import java.util.ArrayList;

public class Groups implements Serializable {
	private String groupName;
	private String groupDescription;
	private java.util.Date dateOfCreation;
	private String admin;
	private int numOfRecommendions;
	private ArrayList<User> members = new ArrayList<User>();
	private ArrayList<Post> posts = new ArrayList<Post>();
	
	public Groups(String name, String description, String firstName, String lastName) {
		dateOfCreation = new java.util.Date();
		this.groupName = name;
		this.groupDescription = description;
		admin = firstName + " " + lastName;
	}
	
	/** Getter and add posts methods */
	public ArrayList<Post> getGroupPosts() {
		return posts;
	}
	public void addNewPostToGroupPostsList(Post post) {
		posts.add(post);
	}
	
	/** Getter and addMember and removeMember methods*/
	public ArrayList<User> getMembers() {
		return members;
	}
	public void addMember(User user) {
		members.add(user);
	}
	public void removeMember(User user) {
		members.remove(user);
	}
	
	/** show group members and group admin */
	public void showGroupMembers() {
		for(int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).getFirstName() + " " + members.get(i).getLastName());
			System.out.println("number of friends is "+ members.get(i).getNumberOfFriends());
			System.out.println();
		}
	}
	public String showGroupAdmin() {
		return admin;
	}
	
	/** Getters and Setters for name and description */
	public String getNameOfGroup() {
		return groupName;
	}
	public void setNameOfGroup(String name) {
		groupName = name;
	}
	
	public String getGroupDescription() {
		return groupDescription;
	}
	public void setGroupDescription(String description) {
		groupDescription = description;
	}

	/** Getter and Setter for numberOfRecommendations */
	public int getNumberOfRecommedations() {
		return numOfRecommendions;
	}
	
	public void addRecommendation() {
		numOfRecommendions++;
	}
}