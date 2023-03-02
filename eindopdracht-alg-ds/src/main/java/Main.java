import javax.swing.*;

import menu.MenuController;
import assets.FrameStyling;

public class Main {
    public static void main(String args[]){
        JFrame frame = new JFrame(FrameStyling.FRAMENAME);

        // build the menu controller, update frame with info
        new MenuController(frame);

        // set styling of the JFrame
        frame.setSize(FrameStyling.WIDTH, FrameStyling.HEIGHT);

        // set frame visible
        frame.setVisible(true);
    }
}