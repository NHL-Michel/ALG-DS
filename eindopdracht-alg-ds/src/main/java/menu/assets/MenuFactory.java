package menu.assets;

import javax.swing.*;

public class MenuFactory {
    /**
     * create a new menu
     * @param name name of menu
     * @return return new JMenu
     */
    public static JMenu createMenu(String name) {
        return new JMenu(name);
    }

    /**
     * create a new menu item
     * @param name name of the menuitem
     * @return new JMenuItem
     */
    public static JMenuItem createMenuItem(String name) {
        return new JMenuItem(name);
    }

}