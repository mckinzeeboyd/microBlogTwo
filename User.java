import java.util.Scanner;


public class User{
    private String username;
    private int id;
    private String name;
    private String avatar;
    private String email;
    private int hasPosted;



    Scanner keyboard = new Scanner (System.in);


    public User ( String username, int userID, String name, String avatar, String email, int hasPosted){

        this.username=username;
        this.id=userID;
        this.name=name;
        this.avatar=avatar;
        this.email=email;
        this.hasPosted=hasPosted;

    }

    public String getUsername () {


        return username;
    }

    public void setHasPosted (int hasPostedd){

        hasPosted=hasPostedd;
    }

    public int getHasPosted() {
        return hasPosted;
    }

    public String toString() {
        return  "User ID: " + (id+ 1) +"\n" + username +"\n" + name + "\n" + avatar + "\n" + email +"\n";
    }

    public String getDirections(){
        return "You are logged in as: " + username + "\nWhat would you like to do?\n";
    }


}
