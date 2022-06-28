package Handlers;
/**
 * ConcreteHandler. Checks a user's role.
 */
public class PositionsCheckHandler extends HandlerRequest {
    public boolean check(String email, String password) {
        String adm = "@admin.com";
        String user = "@user.com";

        if (checkEmail(email,adm)) {
            System.out.println("Hello, admin!");
            return true;
        } else if (checkEmail(email,user)){
            System.out.println("Hello, user!");
            return true;
        }
        return checkNext(email, password);
    }

    private boolean checkEmail(String email, String position){
        if(email.contains(position)){
            return true;
        }
        return false;
    }
}
