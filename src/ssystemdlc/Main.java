package ssystemdlc;

import ssystemdlc.panels.Login;

public class Main {
    private static User user;
    
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
    
    public static void setUser(User user){
        Main.user = user;
        
        new PermissionManager();
    }
    
    public static User getUser(){
        return Main.user;
    }
    
    public static void resetUser(){
        Main.user = null;
    }
}
