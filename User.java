import java.io.Serializable;
import java.util.*;

public class User extends Systems implements Serializable {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private String gender;
	private ArrayList<User> friends = new ArrayList<User>();
	private int numOfFriends = 0;
	private ArrayList<Groups> groups = new ArrayList<Groups>();
	private ArrayList<Page> pages = new ArrayList<Page>();
	private ArrayList<User> privateListMembers = new ArrayList<User>();
	private ArrayList<Post> userPosts = new ArrayList<Post>();
	
	/** constructor take first name, last name, email, password, phone number and gender from user
	 *  and create new user and add this user to the database of application users */
	public User(String firstName, String lastName, String email, String password, String phoneNumber, String gender) {
		//dateOfCreation = new Date();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}
	
	/** search method take name of Object (first and last name) as parameter and search in the database
	 *  about this name . if User found then the method will  print information 
	 *  (first and last name of User and about of User) then will prompt user to send friend request if user send
	 *  friend request to the User that he search for then User search for will added to list of users that you 
	 *  send friend request for if user do not want to send friend request to the User that search for then
	 *  will be have another  option to follow it.
	 *  if the name that user entered not found in the database then the method will return nameOfObject + "is not found" */
	public void search(String firstName, String lastName) {
		Scanner console = new Scanner(System.in);
		boolean found = false;
		
		for(int i = 0; i < super.getAllUsers().size(); i++) {
			if(firstName.equalsIgnoreCase(super.getAllUsers().get(i).getFirstName()) && lastName.equalsIgnoreCase(super.getAllUsers().get(i).getLastName())) { //&&
					//(!(this.firstName.equalsIgnoreCase(super.getAllUsers().get(i).getFirstName()) && !(this.lastName.equals(super.getAllUsers().get(i).getFirstName()))))) {
				
				System.out.println(super.getAllUsers().get(i).getFirstName() + " " + super.getAllUsers().get(i).getLastName());
				if(!(super.getAboutUsers().get(i).getWorkExperience().equals(""))) {
					System.out.println(super.getAboutUsers().get(i).aboutToString());
				}
				/** the method will prompt user to send friend request  this user that search for if and only if
				 *  user doesn't found in your friends list else method will ask if you want to unfriend this friend*/
				if(!friends.contains(super.getAllUsers().get(i))) {
					System.out.print("Do you want to add "+super.getAllUsers().get(i).getFirstName() +
							" " + super.getAllUsers().get(i).getLastName()+ " to your friends list (Yes or No):- ");
					String choose1 = console.next();
					if(choose1.equalsIgnoreCase("yes")) {
						addFriendToListOfFriends(super.getAllUsers().get(i));
						super.getAllUsers().get(i).addFriendToListOfFriends(me(this.email));
					} else { 
						System.out.print("Do you want to unfreind (Yes or no):- ");
						String choose3 = console.next();
						if(choose3.equalsIgnoreCase("yes")) {
							friends.remove(super.getAllUsers().get(i));
							super.getAllUsers().get(i).removeFriendFromListOfFriends(me(this.email));
						}
					}
				System.out.println();
				found = true;
				}
			}
		}
		if(found == false) {	
			System.out.println();
			System.out.println("    *"+ firstName + " " + lastName + " not found*");
			System.out.println();
		}
	}
	
	public void searchForGroup (String nameOfGroup) {
		Scanner console = new Scanner(System.in);
		
		boolean found = false;
		for(int i = 0; i < super.getAllGroups().size(); i++ ) {
			if(nameOfGroup.equalsIgnoreCase(super.getAllGroups().get(i).getNameOfGroup())) {
				System.out.println("Group name is " + super.getAllGroups().get(i).getNameOfGroup());
				System.out.println(super.getAllGroups().get(i).getGroupDescription());
			//	System.out.println("Number of members is " + super.getAllGroups().get(i).getNumberOfMembers());
				System.out.println("Number of recommendation is " + super.getAllGroups().get(i).getNumberOfRecommedations());
				// prompt the user if you want to joint to this group or not
				System.out.print("Do you want to joint "+super.getAllGroups().get(i).getNameOfGroup() + " (Yes or No):- ");
				String choose = console.next();
				if(choose.equalsIgnoreCase("yes")) {
					groups.add(super.getAllGroups().get(i));
					super.getAllGroups().get(i).addMember(me(this.email));
				}
				found = true;
				System.out.println();
			}
		}
	}
	
	public void searchForPage(String nameOfPage) {
		Scanner console = new Scanner(System.in);
		boolean found = false;
		
		for(int i = 0; i < super.getAllPages().size(); i++) {
			if(nameOfPage.equalsIgnoreCase(super.getAllPages().get(i).getPageName())) {
				System.out.println("Page name is " + super.getAllPages().get(i).getPageName());
				System.out.println(super.getAllPages().get(i).getPageDescription());
				System.out.println("Number of follower is " + super.getAllPages().get(i).getNumberOfFollower());
				System.out.println("Number of recommendation is " + super.getAllPages().get(i).getNumberOfRecommendation());
				// prompt the user if you want to follow this page or not
				System.out.print("Do you want follow "+super.getAllPages().get(i).getPageName() + " (Yes or No):- ");
				String choice = console.next();
				if(choice.equalsIgnoreCase("yes")) {
					pages.add(super.getAllPages().get(i));
					super.getAllGroups().get(i).addMember(me(this.email));
				}
				found = true;
				System.out.println();
			}
		}
		if(found == false) {
			System.out.println();
			System.out.println("    *"+ nameOfPage + " not found*");
			System.out.println();
		}
	}
	/** jointToGroup method take Group Object then the Group Object will add to the list of Groups Objects */ 
	public void jointToGroup(Groups group) {
		groups.add(group);
	}
	
	/** leaveTheGroup method take Group Object then the Group Object will remove from the list of Groups Objects */
	public void leaveTheGroup(Groups group) {
		groups.remove(group);
		}
	
	/** addToPrivateList method take User Object as parameter and check if his user is in friends list and if it
	 * 	in friends list then the method will add to private friend list else the method will ask user to confirm */
	public void addToPrivateList(User user) {
		privateListMembers.add(user);
	}
	
	public void removeUserFromPrivateList(User user) {
		privateListMembers.remove(user);
	}
	
	// Getter method for privateListMembers
	public ArrayList<User> getPrivateList() {
		return privateListMembers;
	}
	
	/** sendMessage method take User Object as parameter and check if this User Object found the Application 
	 *  users database or not then if user founded then the method will add this messages to the list of messages */
	public void sendMessage(String receiverEmail, String senderEmail) {
		Scanner console = new Scanner(System.in);
		while(true) {
			System.out.print("Enter a new Message: ");
			String text = console.nextLine();
			if(text.equalsIgnoreCase("Exit"))
				break;
			Message message = new Message(senderEmail, receiverEmail, text);
			super.addMessageToMessagesDataBase(message);
		}
	}
	
	public void receiveMessage(String senderEmail) {
		System.out.println("  From " + senderEmail);
		System.out.println();
		for(int i = 0; i < super.getAllMessages().size(); i++) {
			if(super.getAllMessages().get(i).getFrom().equals(senderEmail) &&
					super.getAllMessages().get(i).getTo().equals(this.email)) {
				System.out.println(super.getAllMessages().get(i).getText());
				System.out.println(super.getAllMessages().get(i).getTime().toString());
				System.out.println();
			}
		}
	}

	/** Show User posts */
	public void showUserPosts() throws java.lang.IndexOutOfBoundsException {
		Scanner console = new Scanner(System.in);
		
		for(int i = 0; i < userPosts.size(); i++) {
			System.out.println(getFirstName() + " " + getLastName());
			System.out.println(userPosts.get(i).showDateOfCreation());
			userPosts.get(i).getText();
			System.out.println("Number of likes:- " + userPosts.get(i).getNumberOfLikes() +
			" Number of comments:- " + userPosts.get(i).getNumberOfComments());
			// user able to like its post or comment on it or see the comments on your post
			System.out.print("1)Like  2)Comment 3)Show comments(Enter 1, 2, 3, both 1 & 2 or nothing): ");
			String choice = console.next();
			
			if(choice.equals("1")) {
				userPosts.get(i).likePost();
			} else if(choice.equals("2")) {
				System.out.print("Enter the comment:- ");
				String text = console.next();
				userPosts.get(i).commentOnPost(text);
			} else if(choice.equalsIgnoreCase("both") || choice.equalsIgnoreCase("both 1 & 2")) {
				userPosts.get(i).likePost();
				System.out.print("Enter the comment:- ");
				String text = console.next();
				userPosts.get(i).commentOnPost(text);
			} else if(choice.equals("3")) {
				for(int j = 0 ; j < userPosts.get(i).getCommentsList().size(); j++) {
					System.out.println((j+1)+ "- " + userPosts.get(i).getCommentsList().get(j));
					System.out.println();
				}
			}
			
			System.out.println();
		}
	}
	
	/** createNewPost method */
	public void createNewPost() {
		Scanner console = new Scanner(System.in);
		String text = console.next();
		addPostToUserPostsList(new Post(text));
	}
	
	/** Getters and Setters Methods for First name and the last Name */
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String name) {
		lastName = name;
	}
	
	/** Getters and Setters methods for email and password*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String newEmail) {
		email = newEmail;
	}
	
	/** Getter and Setter for phone number */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String newPassword) {
		password = newPassword;
	}
	
	/** Getters methods for gender and number of friends and friends list  and friends requests list*/
	public ArrayList<User> getFriendsList() {
		return friends;
	}
	public void addFriendToListOfFriends(User user) {
		friends.add(user);
		numOfFriends++;
	}
	
	public void removeFriendFromListOfFriends(User user) {
		friends.remove(user);
	}
	
	public String getGender() {
		return gender;
	}
	public int getNumberOfFriends() {
		return numOfFriends;
	}
	
	/** Getters and Setters for user posts */
	public ArrayList<Post> getUserPosts() {
		return userPosts;
	}
	public void addPostToUserPostsList(Post post) {
		userPosts.add(post);
	}
	
	/** Getter for Groups list */
	public ArrayList<Groups> getGroups() {
		return groups;
	}
	
	public void addToGroupsList(Groups group) {
		groups.add(group);
	}
	
	public void removeFromGroupsList(Groups group) {
		groups.remove(group);
	}
	
	/** Getter and Setter for Pages list */
	public ArrayList<Page> getPagesList() {
		return pages;
	}
	
	public void addToPagesList(Page page) {
		pages.add(page);
	}
	
	public void removeFromPageList(Page page) {
		pages.remove(page);
	}
	
	public User me(String email) {
		for(int i = 0; i< super.getAllUsers().size(); i++) {
			if(email.equals(super.getAllUsers().get(i).getEmail())) {
				return super.getAllUsers().get(i);
			}
		}
		return null;
	}
}