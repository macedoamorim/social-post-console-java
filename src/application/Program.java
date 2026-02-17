package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

public class Program {

	public static void clearConsole() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}

	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	List<Post> posts = new ArrayList<>();
	int option = 0;
	int number = 0;
	
		while (option != 5) {
	
		System.out.println("1 - Create a post");
		System.out.println("2 - Add a comment");
		System.out.println("3 - Like");
		System.out.println("4 - Show Posts");
		System.out.println("5 - Exit");
		System.out.print("Choose an option: ");
		option = sc.nextInt();
		sc.nextLine();
		
			if (option < 1 || option > 5) {
				
				System.out.println();
				System.out.print("Choose a valid optiion: ");
				option = sc.nextInt();
				sc.nextLine();
				
			}
			
			if (option != 1 && option != 4 && posts.isEmpty()) {
				
				System.out.println();
				System.out.println("There are no posts yet. Create a post first");
				number = number + 1;
				System.out.print("Title: ");
				String title = sc.nextLine();
				int likes = 0;	
				System.out.print("Content: ");
				String content = sc.nextLine();
				
				Post p = new Post(null, new Date(), title, content, likes, number);
				posts.add(p);
				
				clearConsole();
				
			}
			
			switch (option) {
			
				case 1:
					
					System.out.println();
					System.out.println("Creating a post");
					number = number + 1;
					System.out.print("Title: ");
					String title = sc.nextLine();
					
					int likes = 0;	
					
					System.out.print("Content: ");
					String content = sc.nextLine();
					
					Post p = new Post(null, new Date(), title, content, likes, number);
					posts.add(p);
					
					clearConsole();
					break;
				
				case 2: 
					
					System.out.println();
					
					for (Post pst : posts) {
						
				        System.out.println(pst);
				        System.out.println();
				        
				    }

				    System.out.print("Enter the post number to comment: ");
				    int commentNumber = sc.nextInt();
				    sc.nextLine();

				    Post commentedPost = posts.stream()
				        .filter(x -> x.getNumber() == commentNumber)
				        .findFirst()
				        .orElse(null);

				    if (commentedPost != null) {
				    	
				        System.out.print("Comment: ");
				        String text = sc.nextLine();

				        Comment comment = new Comment(text);

				        commentedPost.addComment(comment);

				        System.out.println("Comment sent successfully!"); 
				        
				    } 
				    
				    else {
				    	
				        System.out.println("Post not found.");
				        
				    }

				    System.out.println("\nPress ENTER to continue...");
				    sc.nextLine();
				    clearConsole();

				    break; 
					
				case 3:

				    System.out.println();

				    for (Post pst : posts) {
				        System.out.println(pst);
				        System.out.println();
				    }

				    System.out.print("Enter the post number to like: ");
				    int likeNumber = sc.nextInt();
				    sc.nextLine();

				    Post likedPost = posts.stream()
				        .filter(x -> x.getNumber() == likeNumber)
				        .findFirst()
				        .orElse(null);

				    if (likedPost != null) {
				        likedPost.setLikes(likedPost.getLikes() + 1);
				        System.out.println("Post liked successfully!");
				    } else {
				        System.out.println("Post not found.");
				    }

				    System.out.println("\nPress ENTER to continue...");
				    sc.nextLine();
				    clearConsole();

				    break; 
					
				case 4:	
					
					System.out.println();
					
					for (Post pst : posts) {
						
						System.out.println(pst);
						System.out.println();
						
					}
					
					System.out.println("Press ENTER to continue...");
					sc.nextLine();
					
					clearConsole();

					break;
					
			}
		
		}
		
		System.out.println();
		System.out.println("Exiting program...");
		
	sc.close();
		
	}

}
