import javax.swing.*;

import menu.MenuController;
import style.Styling;

public class Main {
    public static void main(String args[]){
        JFrame frame = new JFrame(Styling.FRAMENAME);

        // build the menu controller, update frame with info
        new MenuController(frame);

        // set styling of the JFrame
        frame.setSize(Styling.WIDTH,Styling.HEIGHT);

        // set frame visible
        frame.setVisible(true);
    }
}