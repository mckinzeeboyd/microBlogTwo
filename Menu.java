import static java.lang.System.out;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {


    public static void main(String[] args) {

        String userName = "";
        int userID = 0;
        String name = "";
        String avatar = "";
        String email = "";
        int hasPosted=0;

        int currentUser=0;
        int tempUser=0;

        String post = "";
        int postOrder = 1;
        String addLink = "";


        ArrayList<User> allUsers = new ArrayList<User>();
        ArrayList<Post> allPosts = new ArrayList<Post>();


        menu();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please begin by logging in or creating a new user.");






        boolean keepGoing = true;

        while (keepGoing) {
            int selection = keyboard.nextInt();
            keyboard.nextLine();

            if (selection<1 || selection>6){
                out.println("Sorry, please enter a valid selection: \n");

            }

            if (selection == 1) {


                addUser(allUsers, userID, hasPosted);
                userID++;
                System.out.println("Your userID # is: " + userID);
                System.out.println("");

                System.out.println("Thanks for registering an account. Now please make a selection from the menu below:  \n ");
                menu();





            }
            if (selection == 2) {

                if (allUsers.size()<1)
                {

                    System.out.println("Sorry, there are no users to become. Please create a new user using the menu below \n");
                } else {


                    System.out.println("To login as a current user, please enter your assigned userID # from list below: ");

                    for (int i = 0; i < allUsers.size(); i++) {
                        System.out.println(allUsers.get(i));
                    }

                    System.out.println("");

                    tempUser = keyboard.nextInt();
                    currentUser = tempUser;

                    System.out.print("Welcome back, " + allUsers.get(currentUser-1).getUsername() +"\n");
                    System.out.println("What would you like to do?");

                    System.out.println("");
                }
                System.out.println("");
                menu();


            }

            if (selection == 3) {

                if(currentUser==0){

                    System.out.println("\n");
                    System.out.println("Please login as a user to make a post \n");


                } else{

                addPost(allPosts,allUsers, currentUser, postOrder++, userName, userID, post, addLink);}

                //postOrder++;

                out.println("");
                menu();
                out.println("");
            }

            if (selection == 4) {

                printPosts(allPosts);
                menu();

            }

            if (selection == 5) {

               printUsers(allUsers);
                menu();

            }


            if (selection == 6) {
                keepGoing = false;
            }



        }


        System.out.println("Until next time!");




    }



    public static void menu() {



        System.out.println("Main Menu");
        System.out.println("1). Create a new user");
        System.out.println("2). Become an existing user");
        System.out.println("3). Create a post as the current user");
        System.out.println("4). Print all posts");
        System.out.println("5). Print all users");
        System.out.println("6). Exit");



    }

    public static void addUser(ArrayList<User> allUsers, int userID, int hasPosted){

        Scanner keyboard = new Scanner (System.in);
        System.out.println("To create a new user, please provide the following fields:");
        System.out.print("Username: ");

       String userName = keyboard.nextLine();
        System.out.print("First and Last Name: ");
       String name = keyboard.nextLine();
        System.out.print("A link to image for your avatar (Optional): ");
       String avatar = keyboard.nextLine();
        System.out.print("An email address: ");
        String email = keyboard.nextLine();


        User newUser = new User(userName, userID , name, avatar, email, hasPosted);
        allUsers.add(newUser);


    }

    public static void printPosts(ArrayList<Post> allPosts){

        for(int i=0; i<allPosts.size(); i ++ ) {

            System.out.println(allPosts.get(i));
        }
    }

    public static void printUsers(ArrayList<User> allUsers){
        System.out.println("All users: ");

        for(int i=0; i<allUsers.size(); i++){
            System.out.println(allUsers.get(i));

    }

    }

    public static void addPost(ArrayList<Post> allPosts, ArrayList<User> allUsers, int currentUser, int postOrder, String userName, int userID, String post, String addLink ){

       Scanner keyboard = new Scanner(System.in);




            userName = allUsers.get(currentUser - 1).getUsername();

            userID = currentUser;


            if (allUsers.get(currentUser - 1).getHasPosted() == 0) {


                System.out.println("");
                System.out.println("No current posts");
                System.out.println("");

                System.out.println("Hi " + userName + ", please enter post: ");
                System.out.print(postOrder + " : ");
                post = keyboard.nextLine();


                System.out.println("Would you like to add any additional links?");
                addLink = keyboard.nextLine();

                Post newPost = new Post(userName, postOrder, post, addLink);
                allPosts.add(newPost);
                allUsers.get(currentUser - 1).setHasPosted(1);
                postOrder++;



            } else {

                int i = 0;
                for (i = (allPosts.size() - 1); i>=0; i--) {


                        if (userName.equals(allPosts.get(i).getUsername())) {
                            System.out.println(allPosts.get(i));
                            break;
                            }

                        }


                System.out.println("Hi " + userName + ", please enter post: ");
                System.out.print(postOrder + " : ");
                post = keyboard.nextLine();


                System.out.println("Would you like to add any additional links?");
                addLink = keyboard.nextLine();

                Post newPost = new Post(userName, postOrder, post, addLink);
                allPosts.add(newPost);
                postOrder++;

            }



        }

    }





