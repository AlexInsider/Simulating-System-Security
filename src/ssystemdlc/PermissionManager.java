package ssystemdlc;

import ssystemdlc.panels.Home;

import javax.swing.JOptionPane;

public class PermissionManager {
    public PermissionManager(){
        String role = Main.getUser().getRole();
        Home home;
        
        boolean intrusionDetected = new SecurityLayer().checkIntrution();
        
        if(intrusionDetected) System.exit(0);
        
        switch(role){
            case "Student":
                home = new Home("VIEW ONLY");
                home.setVisible(true);
                break;
            case "Teacher":
                home = new Home("VIEW + EDIT");
                home.setVisible(true);
                break;
            case "Admin":
                home = new Home("FULL ACCESS");
                home.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Role", "An error occured", JOptionPane.ERROR_MESSAGE);
        }
    }
}
