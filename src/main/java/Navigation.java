import java.util.Stack;

public class Navigation {

    //create stack to hold name of previous page
    private static Stack<String> stack = new Stack<String>();

    //method to move to previous page
    public static void back(){
        //store GUI at the top of the page, i.e previous page
        String page = stack.pop();

        //visit that page
        switch (page) {
            //if page is index
            case "index":
                new GUIIndexPage().create();
                break;
            //if page is login
            case "login":
                new GUILogin().create();
                break;
            //otherwise break
            default:
                break;
        }
    }

    //method to move forward -- adds current page to the stack
    public static void forward(String currentPage){
        stack.add(currentPage);
    }

    //method to check what is currently at the top of the stack
    public static String top(){
        return stack.peek();
    }

}
