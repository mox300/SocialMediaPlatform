import java.io.Serializable;
import java.util.Scanner;

public class HomePage extends Systems implements Serializable {
	private User user;
	
	/** constructor */
	public HomePage(User user) {
		this.user = user;
	}
	
	public int getUserIndex() {
		int index = super.getAllUsers().indexOf(user);
		return index;
	}
	
	/** print information to the user. */
	public String toString() {
		if ((super.getAboutUsers().get(getUserIndex()).getWorkExperience().equals("") &&
				super.getAboutUsers().get(getUserIndex()).getEducation().equals("") &&
				super.getAboutUsers().get(getUserIndex()).getCity().equals("") && 
				super.getAboutUsers().get(getUserIndex()).getRelationShip().equals(""))) {
			return super.getAllUsers().get(getUserIndex()).getFirstName() + " " + super.getAllUsers().get(getUserIndex()).getLastName() +"\n"+
					super.getAllUsers().get(getUserIndex()).getEmail()+  "\nNumber of Friends is "+ super.getAllUsers().get(getUserIndex()).getNumberOfFriends();
		} else {
			return super.getAllUsers().get(getUserIndex()).getFirstName() + " " + super.getAllUsers().get(getUserIndex()).getLastName() + "\n" + super.getAboutUsers().get(getUserIndex()).aboutToString()
					+"\n"+super.getAllUsers().get(getUserIndex()).getEmail() +"\nNumber of Friends is " + super.getAllUsers().get(getUserIndex()).getNumberOfFriends();
		}
	}

	

	/** validation for new updates on name, phone number and email */
	public void setNewPhoneNumber(String phoneNumber) {
		if (isPhoneNumberFoundInDataBase(phoneNumber) == false) {
			super.getAllUsers().get(getUserIndex()).setPhoneNumber(phoneNumber);
		} else {
			System.out.println("This phone number is already used.");
		}
	}

	public void setNewEmail(String email) {
		if (isEmailFoundInDataBase(email) == false) {
			super.getAllUsers().get(getUserIndex()).setEmail(email);
		} else {
			System.out.println("This email is aready used.");
		}
	}

	public boolean isEmailFoundInDataBase(String email) {
		boolean flag = false;
		for(int i = 0; i < allUsersInDataBase.size(); i++) {
			if(!(allUsersInDataBase.get(i).getEmail().equalsIgnoreCase(email))) {
				flag = false;
			} else {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public boolean isPhoneNumberFoundInDataBase(String phoneNumber) {
		boolean flag = false;
		for(int i = 0; i < allUsersInDataBase.size(); i++) {
			if(!(allUsersInDataBase.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber))) {
				flag = false;
			} else {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void showFriendsPosts() throws java.lang.IndexOutOfBoundsException {
		Scanner console = new Scanner(System.in);
		for (int i = 0; i < super.getAllUsers().get(getUserIndex()).getFriendsList().size(); i++) {
			for (int j = 0; j < super.getAllUsers().get(getUserIndex()).getUserPosts().size(); j++) {
				System.out.println(super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getFirstName() + " "
						+ super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getLastName());
				System.out.println(super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getUserPosts().get(j).showDateOfCreation());
				super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getUserPosts().get(j).getText();
				System.out.println("Number of likes:- " + super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getUserPosts().get(j).getNumberOfLikes()
								+ " Number of comments:- "
								+ super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getUserPosts().get(j).getNumberOfComments());
				// user able to like its post or comment on it or see the comments on your post
				System.out.print("1)Like  2)Comment 3)Show comments(Enter 1, 2, 3, both 1 & 2 or nothing): ");
				String choice = console.next();

				if (choice.equals("1")) {
					super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getUserPosts().get(j).likePost();
				} else if (choice.equals("2")) {
					System.out.print("Enter the comment:- ");
					String text = console.next();
					super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getUserPosts().get(j).commentOnPost(text);
				} else if (choice.equalsIgnoreCase("both") || choice.equalsIgnoreCase("both 1 & 2")) {
					super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getUserPosts().get(j).likePost();
					System.out.print("Enter the comment:- ");
					String text = console.next();
					super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getUserPosts().get(j).commentOnPost(text);
				} else if (choice.equals("3")) {
					for (int k = 0; k <super.getAllUsers().get(getUserIndex()).getUserPosts().get(i).getCommentsList().size(); k++) {
						System.out.println((k+1)+ "- " + super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getUserPosts().get(j).getCommentsList().get(k));
						System.out.println();
					}
				}
				System.out.println();
			}
		}
	}

	public void showGroupsPosts() throws java.lang.IndexOutOfBoundsException {
		Scanner console = new Scanner(System.in);
		
		for (int i = 0; i < super.getAllUsers().get(getUserIndex()).getGroups().size(); i++) {
			for (int j = 0; j < (super.getAllUsers().get(getUserIndex()).getGroups().get(i).getGroupPosts().size()); j++) {

				System.out.println(super.getAllUsers().get(getUserIndex()).getGroups().get(i).getNameOfGroup());
				System.out.println(super.getAllUsers().get(getUserIndex()).getGroups().get(i).getGroupPosts().get(j).showDateOfCreation());
				super.getAllUsers().get(getUserIndex()).getGroups().get(i).getGroupPosts().get(j).getText();
				System.out.println("Number of likes:- "
						+ super.getAllUsers().get(getUserIndex()).getGroups().get(i).getGroupPosts().get(j).getNumberOfLikes() + " Number of comments:- "
						+ super.getAllUsers().get(getUserIndex()).getGroups().get(i).getGroupPosts().get(j).getNumberOfComments());
				// user able to like its post or comment on it or see the comments on your post
				System.out.print("1)Like  2)Comment 3)Show comments(Enter 1, 2, 3, both 1 & 2 or nothing): ");
				String choice = console.next();

				if (choice.equals("1")) {
					super.getAllUsers().get(getUserIndex()).getGroups().get(i).getGroupPosts().get(j).likePost();
				} else if (choice.equals("2")) {
					System.out.print("Enter the comment:- ");
					String text = console.nextLine();
					super.getAllUsers().get(getUserIndex()).getGroups().get(i).getGroupPosts().get(j).commentOnPost(text);
				} else if (choice.equalsIgnoreCase("both") || choice.equalsIgnoreCase("both 1 & 2")) {
					super.getAllUsers().get(getUserIndex()).getGroups().get(i).getGroupPosts().get(j).likePost();
					System.out.print("Enter the comment:- ");
					String text = console.next();
					super.getAllUsers().get(getUserIndex()).getGroups().get(i).getGroupPosts().get(j).commentOnPost(text);
				} else if (choice.equals("3")) {
					for (int k = 0; k < super.getAllUsers().get(getUserIndex()).getGroups().get(i).getGroupPosts().get(j).getCommentsList().size(); k++) {
						System.out.println((k+1)+ "- " + super.getAllUsers().get(getUserIndex()).getGroups().get(i).getGroupPosts().get(j).getCommentsList().get(k));
						System.out.println();
					}
				}
				System.out.println();
			}
		}
	}

	public void showPagesPosts() throws java.lang.IndexOutOfBoundsException {
		Scanner console = new Scanner(System.in);
		
		for (int i = 0; i < super.getAllUsers().get(getUserIndex()).getPagesList().size(); i++) {
			for (int j = 0; j < super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPagePosts().size(); j++) {

				System.out.println(super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPageName());
				System.out.println(super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPagePosts().get(j).showDateOfCreation());
				super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPagePosts().get(j).getText();
				System.out.println("Number of likes:- " + super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPagePosts().get(j).getNumberOfLikes()
								+ " Number of comments:- "
								+ super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPagePosts().get(j).getNumberOfComments());
				// user able to like its post or comment on it or see the comments on your post
				System.out.print("1)Like  2)Comment 3)Show comments(Enter 1, 2, 3, both 1 & 2 or nothing): ");
				String choice = console.next();

				if (choice.equals("1")) {
					super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPagePosts().get(j).likePost();
				} else if (choice.equals("2")) {
					System.out.print("Enter the comment:- ");
					String text = console.nextLine();
					super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPagePosts().get(j).commentOnPost(text);
				} else if (choice.equalsIgnoreCase("both") || choice.equalsIgnoreCase("both 1 & 2")) {
					super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPagePosts().get(j).likePost();
					System.out.print("Enter the comment:- ");
					String text = console.next();
					super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPagePosts().get(j).commentOnPost(text);
				} else if (choice.equals("3")) {
					for (int k = 0; k < super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPagePosts().get(j).getCommentsList().size(); k++) {
						System.out.println((k+1)+ "- " + super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPagePosts().get(j).getCommentsList().get(k));
						System.out.println();
					}
				}
				System.out.println();
			}
		}
	}

	/** add members to privateList and remove members from privateList */
	public void addToPrivateList(String firstName, String lastName) {
		for (int i = 0; i < super.getAllUsers().get(getUserIndex()).getFriendsList().size(); i++) {
			if (super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getFirstName().equalsIgnoreCase(firstName)
					&& super.getAllUsers().get(getUserIndex()).getFriendsList().get(i).getLastName().equalsIgnoreCase(lastName)) {
				super.getAllUsers().get(getUserIndex()).addToPrivateList(super.getAllUsers().get(getUserIndex()).getFriendsList().get(i));
			} else {
				System.out.println("   *" + firstName + " " + lastName + " Not in you Fiends list.*   ");
			}

		}

	}

	public void removeFromPrivateList(String firstName, String lastName) {
		for (int i = 0; i < super.getAllUsers().get(getUserIndex()).getPrivateList().size(); i++) {
			if (super.getAllUsers().get(getUserIndex()).getPrivateList().get(i).getFirstName().equalsIgnoreCase(firstName)
					&& super.getAllUsers().get(getUserIndex()).getPrivateList().get(i).getLastName().equalsIgnoreCase(lastName)) {
				super.getAllUsers().get(getUserIndex()).removeUserFromPrivateList(super.getAllUsers().get(getUserIndex()).getPrivateList().get(i));
			} else {
				System.out.println("   *" + firstName + " " + lastName + " Not in you Private list.*   ");
			}
		}
	}

	public void homePageView() {
		Scanner console = new Scanner(System.in);
		System.out.println("------------------ Home Page ------------------");
		System.out.println("1) Search.");
		System.out.println("2) Create new post.");
		System.out.println("3) Show Posts.");
		System.out.println("4) Add Friend to Private List.");
		System.out.println("5) Remove Friend from Private List.");
		System.out.println("6) Groups. ");
		System.out.println("7) Pages. ");
		System.out.println("8) Profile Page.");
		System.out.println("9) Chats. ");
		System.out.println("10) Refresh Home Page.");
		System.out.println();
		System.out.print("Choose from 1 to 10: ");
		String choice = console.next();
		if (choice.equals("1")) {
			System.out.println();
			System.out.println("(1) Search for User.");
			System.out.println("(2) Search for Group.");
			System.out.println("(3) search for page. ");
			System.out.print("Choose 1 or 3: ");
			String searchChoice = console.next();
			if (searchChoice.equals("1")) {
				System.out.print("*Enter The First Name: ");
				String firstName = console.next();
				System.out.print("*Enter The Last Name: ");
				String lastName = console.next();
				super.getAllUsers().get(getUserIndex()).search(firstName, lastName);
			} else if (searchChoice.equals("2")) {
				System.out.print("*Enter The Name Of Group: ");
				String nameOfGroup = console.next();
				super.getAllUsers().get(getUserIndex()).searchForGroup(nameOfGroup);
			} else if(searchChoice.equals("3")){
				System.out.print("*Enter The Name of Page: ");
				String nameOfPage = console.next();
				super.getAllUsers().get(getUserIndex()).searchForPage(nameOfPage);
			} else {
				System.out.println("   **Invalid choice. So Please enter what you want to do again.");
				System.out.println();
				super.getHomePages().get(getUserIndex()).homePageView();
			}
			homePageView();
		} else if (choice.equals("2")) {
			
			System.out.print("What is on your mind? ");
			super.getAllUsers().get(getUserIndex()).createNewPost();
			super.getHomePages().get(getUserIndex()).homePageView();
			
		} else if (choice.equals("3")) {
			
			try {
				super.getAllUsers().get(getUserIndex()).showUserPosts();
				super.getHomePages().get(getUserIndex()).showFriendsPosts();
				super.getHomePages().get(getUserIndex()).homePageView();
			} catch(java.lang.IndexOutOfBoundsException ex) {
				super.getHomePages().get(getUserIndex()).homePageView();
			}
			
		} else if (choice.equals("4")) {
			System.out.print("   Enter The First Name Of Your Friend: ");
			String firstName = console.next();
			System.out.print("   Enter The Last Name Of Your Friend: ");
			String lastName = console.next();
			super.getHomePages().get(getUserIndex()).addToPrivateList(firstName, lastName);
			super.getHomePages().get(getUserIndex()).homePageView();
		} else if (choice.equals("5")) {
			System.out.print("   Enter The First Name Of Your Friend: ");
			String firstName = console.next();
			System.out.print("   Enter The Last Name Of Your Friend: ");
			String lastName = console.next();
			super.getHomePages().get(getUserIndex()).removeFromPrivateList(firstName, lastName);
			super.getHomePages().get(getUserIndex()).homePageView();
		} else if (choice.equals("6")) {
			super.getHomePages().get(getUserIndex()).groupsView();
			super.getHomePages().get(getUserIndex()).homePageView();
		} else if (choice.equals("7")) {
			super.getHomePages().get(getUserIndex()).pagesView();
			super.getHomePages().get(getUserIndex()).homePageView();
		} else if (choice.equals("8")) {
			super.getHomePages().get(getUserIndex()).profileView();
		} else if (choice.equals("9")) {
			super.getHomePages().get(getUserIndex()).chatView();
		} else if (choice.equals("10")) {
			super.getHomePages().get(getUserIndex()).homePageView();
		}
	}
	
	/** profile view method */
	public void profileView() {
		Scanner console = new Scanner(System.in);
		System.out.println("------------------ Profile ------------------");
		System.out.println(toString());
		System.out.println();
		System.out.println("1) Edit Your About.");
		System.out.println("2) Settings.");
		System.out.println("3) Create New Post.");
		System.out.println("4) Show Posts.");
		System.out.println("5) Home Page. ");
		System.out.println();
		System.out.print("Choose for 1  to 5: ");
		String choice = console.next();
		System.out.println();
		if (choice.equals("1")) {
			System.out.print("   Enter Your work experience: ");
			String workExperience = console.next();
			System.out.print("   Enter Your education: ");

			String education = console.next();
			System.out.print("   Enter Your relationship: ");
			String relationship = console.next();
			System.out.print("   Enter The City that you live in: ");
			String city = console.next();
			super.getAboutUsers().get(getUserIndex()).editWorkExperience(workExperience);
			super.getAboutUsers().get(getUserIndex()).editEducation(education);
			super.getAboutUsers().get(getUserIndex()).editRelationship(relationship);
			super.getAboutUsers().get(getUserIndex()).editCity(city);
			super.getHomePages().get(getUserIndex()).profileView();
		} else if (choice.equals("2")) {
			super.getHomePages().get(getUserIndex()).sittings();
		} else if (choice.equals("3")) {
			System.out.println("What is on your mind?");
			super.getAllUsers().get(getUserIndex()).createNewPost();
			super.getHomePages().get(getUserIndex()).profileView();
		} else if (choice.equals("4")) {
			
			try {
				super.getAllUsers().get(getUserIndex()).showUserPosts();
				super.getHomePages().get(getUserIndex()).profileView();
			} catch(java.lang.IndexOutOfBoundsException ex) {
				super.getHomePages().get(getUserIndex()).profileView();
			}
			
		} else if (choice.equals("5")) {
			for (int i = 0; i < super.getAllUsers().size(); i++) {
				if (super.getAllUsers().get(getUserIndex()).getEmail().equals(super.getAllUsers().get(i).getEmail())) {
					super.getHomePages().get(i).homePageView();
				}
			}
		} else {
			System.out.println("You entered wrong choice!");
			super.getHomePages().get(getUserIndex()).profileView();
		}

	}
	
	/** sittings method has no-args. In this method user can edit all User and
	 *` AboutUser data fields */
	public void sittings() {
		Scanner console = new Scanner(System.in);
		System.out.println("------------------ Sittings ------------------");
		System.out.println("1) Name.");
		System.out.println("2) Phone Number. ");
		System.out.println("3) Email. ");
		System.out.println("4) Password. ");
		System.out.println("5) Back. ");
		System.out.println("6) LogOut. ");
		System.out.println();
		System.out.print("Choose from 1 to 6 :- ");
		String choice = console.next();
		if (choice.equals("1")) {
			System.out.println("1) Edit First Name.");
			System.out.println("2) Edit Last Name. ");
			System.out.println();
			System.out.println("Choice from  1 to 2 :- ");
			String choice1 = console.next();
			if (choice1.equals("1")) {
				System.out.println("Enter The New Name: ");
				String newFirstName = super.nameValidation();
				super.getAllUsers().get(getUserIndex()).setFirstName(newFirstName);
				super.getHomePages().get(getUserIndex()).sittings();
			} else if (choice1.equals("2")) {
				System.out.println("Enter The New Name: ");
				String newLastName = super.nameValidation();
				super.getAllUsers().get(getUserIndex()).setLastName(newLastName);
				super.getHomePages().get(getUserIndex()).sittings();
			} else {
				System.out.println("You entered wrong choice!");
				super.getHomePages().get(getUserIndex()).sittings();
			}
		} else if (choice.equals("2")) {
			System.out.print("Enter Your New Phone Number: ");
			String newPhoneNumber = super.phoneNumberValidation();
			super.getHomePages().get(getUserIndex()).setNewPhoneNumber(newPhoneNumber);
			super.getHomePages().get(getUserIndex()).sittings();
		} else if (choice.equals("3")) {
			System.out.print("Enter Your New Email: ");
			String newEmail = super.emailValidation();
			super.getHomePages().get(getUserIndex()).setNewEmail(newEmail);
			super.getHomePages().get(getUserIndex()).sittings();
		} else if (choice.equals("4")) {
			System.out.print("Enter Your New Password: ");
			String newPassword = console.next();
			super.getAllUsers().get(getUserIndex()).setPassword(newPassword);
			super.getHomePages().get(getUserIndex()).sittings();
		} else if (choice.equals("6")) {
			super.logView();
		} else if (choice.equals("5")) {
			System.out.println();
			super.getHomePages().get(getUserIndex()).profileView();
			super.getHomePages().get(getUserIndex()).sittings();
		} else {
			System.out.println("You entered wrong choice!");
			System.out.println();
			super.getHomePages().get(getUserIndex()).sittings();
		}
	}
	
	// groups menu.
	public void groupsView() {
		Scanner console = new Scanner(System.in);
		
		System.out.println("------------------ Groups ------------------");
		System.out.println();
		System.out.println("1) Create new group.");
		System.out.println("2) Create new post in specified Group. ");
		System.out.println("3) Show groups postes.");
		System.out.println("4) Add recommendation to group. ");
		System.out.println("5) leave group.");
		System.out.println("6) Back to home page.");
		System.out.println();
		System.out.print("Choose from 1 to 6: ");
		String choice = console.next();
		
		if(choice.equals("1")) {
			System.out.print("  *Enter the name of the group: ");
			String name = console.next();
			System.out.print("  *Enter the description of the group: ");
			String description = console.next();
			Groups g = new Groups(name, description, super.getAllUsers().get(getUserIndex()).getFirstName(), super.getAllUsers().get(getUserIndex()).getLastName());
			super.AddGroupToDataBase(g);
			super.getAllUsers().get(getUserIndex()).addToGroupsList(g);
			super.getHomePages().get(getUserIndex()).groupsView();
		} else if(choice.equals("2")) {
			System.out.print("  *Enter the name of the group that you want to create post on it: ");
			String nameOfGroup = console.next();
			boolean flag = false;
			for(int i = 0; i < super.getAllUsers().get(getUserIndex()).getGroups().size(); i++) {
				if(nameOfGroup.equalsIgnoreCase(super.getAllUsers().get(getUserIndex()).getGroups().get(i).getNameOfGroup())) {
					System.out.print("  *What is on your mind? ");
					String text = console.next();
					Post groupPost = new Post(text);
					super.getAllUsers().get(getUserIndex()).getGroups().get(i).addNewPostToGroupPostsList(groupPost);
					flag = true;
					break;
				}
			}
			
			if(flag == false) {
				System.out.println("  *You are not in this Group*  ");
			}
			super.getHomePages().get(getUserIndex()).groupsView();
		} else if(choice.equals("3")) {
			
			try {
				super.getHomePages().get(getUserIndex()).showGroupsPosts();
				super.getHomePages().get(getUserIndex()).groupsView();
			} catch(java.lang.IndexOutOfBoundsException ex) {
				super.getHomePages().get(getUserIndex()).groupsView();
			}
			
		} else if(choice.equals("4")) {
			System.out.print("  *Enter the name of group that you want to recommend it: ");
			String name = console.next();
			boolean flag = false;
			for(int i = 0; i < super.getAllUsers().get(getUserIndex()).getGroups().size(); i++) {
				if(name.equalsIgnoreCase(super.getAllUsers().get(getUserIndex()).getGroups().get(i).getNameOfGroup())) {
					super.getAllUsers().get(getUserIndex()).getGroups().get(i).addRecommendation();
					flag = true;
					break;
				}
			}
			
			if(flag == false) {
				System.out.println("  *You are not in this Group*  ");
			}
			super.getHomePages().get(getUserIndex()).groupsView();
		} else if(choice.equals("5")) {
			System.out.print("  *Enter the name of the group that you want to leave it: ");
			String nameOfGroup = console.next();
			boolean flag = false;
			
			for(int i = 0; i < super.getAllUsers().get(getUserIndex()).getGroups().size(); i++)  {
				if(nameOfGroup.equalsIgnoreCase(super.getAllUsers().get(getUserIndex()).getGroups().get(i).getNameOfGroup())) {
					super.getAllUsers().get(getUserIndex()).leaveTheGroup(super.getAllUsers().get(getUserIndex()).getGroups().get(i));
					flag = true;
					break;
				}
			}
			
			if(flag == false) {
				System.out.println("  *You are not in this Group*  ");
			}
			super.getHomePages().get(getUserIndex()).groupsView();
		} else if(choice.equals("6")) {
			super.getHomePages().get(getUserIndex()).homePageView();
		} else {
			System.out.println("  **Invalid choice. So Please enter what you want to do again.");
			super.getHomePages().get(getUserIndex()).groupsView();
		}
	}
	
	// pages menu.
	public void pagesView() {
		Scanner console = new Scanner(System.in);
		
		System.out.println("------------------ Pages ------------------");
		System.out.println();
		System.out.println("1) Create new page.");
		System.out.println("2) Create new post in the page.");
		System.out.println("3) Show pages postes.");
		System.out.println("4) Add recommendation to pages. ");
		System.out.println("5) Unfollow page");
		System.out.println("6) Back to home page.");
		System.out.println();
		System.out.print("Choose from 1 to 6: ");
		String choice = console.next();
		
		if(choice.equals("1")) {
			System.out.print("  *Enter the name of the page: ");
			String name = console.next();
			System.out.print("  *Enter the description of the page: ");
			String description = console.next();
			Page page = new Page(name, description,super.getAllUsers().get(getUserIndex()).getFirstName(), super.getAllUsers().get(getUserIndex()).getLastName());
			super.getAllUsers().get(getUserIndex()).addToPagesList(page);
			super.AddToPagesDataBase(page);
			super.getHomePages().get(getUserIndex()).pagesView();
		} else if(choice.equals("2")) {
			System.out.print("  *Enter the name of the page that you want to create post on it: ");
			String nameOfPage = console.next();
			boolean flag = false;
			for(int i = 0; i < super.getAllUsers().get(getUserIndex()).getPagesList().size(); i++) {
				if(nameOfPage.equalsIgnoreCase(super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPageName())) {
					System.out.print("  *What is on your mind? ");
					String text = console.next();
					Post pagePost = new Post(text);
					super.getAllUsers().get(getUserIndex()).getGroups().get(i).addNewPostToGroupPostsList(pagePost);
					flag = true;
					break;
				}
			}
			
			if(flag == false) {
				System.out.println("  *Only Admin can create new post and add it to this page.*  ");
			}
			super.getHomePages().get(getUserIndex()).pagesView();
		} else if(choice.equals("3")) {
			
			try {
				super.getHomePages().get(getUserIndex()).showPagesPosts();
				super.getHomePages().get(getUserIndex()).pagesView();
			} catch(java.lang.IndexOutOfBoundsException ex) {
				super.getHomePages().get(getUserIndex()).pagesView();
			}
			
		} else if(choice.equals("4")) {
			System.out.print("  *Enter the name of page that you want to recommend it: ");
			String name = console.next();
			boolean flag = false;
			for(int i = 0; i < super.getAllUsers().get(getUserIndex()).getPagesList().size(); i++) {
				if(name.equalsIgnoreCase(super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPageName())) {
					super.getAllUsers().get(getUserIndex()).getPagesList().get(i).addRecommedation();
					flag = true;
					break;
				}
			}
			
			if(flag == false) {
				System.out.println("  *You are not follow this page*  ");
			}
			super.getHomePages().get(getUserIndex()).pagesView();
		} else if(choice.equals("5")) {
			System.out.print("  *Enter the name of the page that you want to unfollow it: ");
			String nameOfPage = console.next();
			boolean flag = false;
			
			for(int i = 0; i < super.getAllUsers().get(getUserIndex()).getPagesList().size(); i++)  {
				if(nameOfPage.equalsIgnoreCase(super.getAllUsers().get(getUserIndex()).getPagesList().get(i).getPageName())) {
					super.getAllUsers().get(getUserIndex()).removeFromPageList(super.getAllUsers().get(getUserIndex()).getPagesList().get(i));;
					flag = true;
					break;
				}
			}
			
			if(flag == false) {
				System.out.println("  *You are not follow this page*  ");
			}
			super.getHomePages().get(getUserIndex()).pagesView();
		} else if(choice.equals("6")) {
			super.getHomePages().get(getUserIndex()).homePageView();
		} else {
			System.out.println("  **Invalid choice. So Please enter what you want to do again.");
			super.getHomePages().get(getUserIndex()).pagesView();
		}
	}
	
	// chat view .
	public void chatView() {
		Scanner console = new Scanner(System.in);
		
		System.out.println("------------------ Chat ------------------");
		System.out.println();
		System.out.println("1) chat with friend.");
		System.out.println("2) Back to home page.");
		System.out.println();
		System.out.print("Enter 1 or 2: ");
		String choice = console.next();
		
		if(choice.equals("1")) {
			System.out.println("  (1) Send Message.");
			System.out.println("  (2) See Messages.");
			System.out.println();
			System.out.print("  Enter 1 or 2: ");
			String choice2 = console.next();
			if(choice2.equals("1")) {
				System.out.print("*Enter the email of your friend: ");
				String email = console.next();
				super.getAllUsers().get(getUserIndex()).sendMessage(email, super.getAllUsers().get(getUserIndex()).getEmail());
			} else if(choice2.equals("2")) {
				System.out.print("*Enter the email of your friend: ");
				String senderEmail = console.next();
				super.getAllUsers().get(getUserIndex()).receiveMessage(senderEmail);
			} else {
				 	System.out.println("**Invalid choice. So Please enter what you want to do again.");
			}
			super.getHomePages().get(getUserIndex()).chatView();
		} else if(choice.equals("2")) {
			super.getHomePages().get(getUserIndex()).homePageView();
		} else {
			System.out.println("  **Invalid choice. So Please enter what you want to do again.");
			super.getHomePages().get(getUserIndex()).chatView();
		}
	}
}