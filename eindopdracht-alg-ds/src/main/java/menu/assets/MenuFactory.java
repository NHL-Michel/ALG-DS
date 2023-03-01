package menu.assets;

import menu.MenuController;

import javax.swing.*;

public class MenuFactory {
    public static JMenu createMenu(String name){
        return new JMenu(name);
    }

    public static JMenuItem createMenuItem(String name){
        return new JMenuItem(name);
    }

}