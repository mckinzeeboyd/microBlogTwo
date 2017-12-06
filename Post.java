import java.util.Scanner;


public class Post
{
    private String post;
    private int postOrder;
    private  String addLink;
    private String username;

    Scanner keyboard = new Scanner (System.in);

    public Post(String username, int postOrder, String post, String addLink) {
        this.postOrder=postOrder;
        this.post=post;
        this.addLink=addLink;
        this.username=username;
    }




    public String getUsername (){

        return username;
}



    public String toString() {
        return  "Post #" + postOrder + ": " + username + "\n" + post + "\n"+ "Additional links : " + addLink + "\n";
    }


}

