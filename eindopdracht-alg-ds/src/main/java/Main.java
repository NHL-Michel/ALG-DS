import menu.MenuController;

import javax.swing.*;

public class Main {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Algorithm en datastructures - Michel & Steffan");

        // build the menu controller, update frame with info
        new MenuController(frame);

        // set styling of the JFrame
        frame.setSize(800, 800);

        // set frame visible
        frame.setVisible(true);
    }
}