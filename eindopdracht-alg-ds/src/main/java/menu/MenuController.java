package menu;

import menu.assets.MenuFactory;
import menu.assets.MenuBar;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import panels.assets.PanelFactory;

public class MenuController {
    private JFrame frame;
    private JMenuBar mb;
    private JMenu pageMenu, helpMenu;
    public MenuController(JFrame frame){
        this.frame = frame;
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mb = new JMenuBar();
        this.create();
    }

    /** create()
     * executes all the methods needed to create a new menu
     */
    private void create(){
        this.createMenus();
        this.createMenuItems();
        this.setMenuBar();
        this.pageListener(1);
    }

    private void createMenus(){
        this.pageMenu = MenuFactory.createMenu(MenuBar.PAGE);
        this.helpMenu = MenuFactory.createMenu(MenuBar.HELP);
    }

    private void createMenuItems(){
        this.pageMenu.add(this.createMenuItem(MenuBar.PAGE_ONE, event -> pageListener(1)));
        this.pageMenu.add(this.createMenuItem(MenuBar.PAGE_TWO, event -> pageListener(2)));
        this.pageMenu.add(this.createMenuItem(MenuBar.PAGE_THREE, event -> pageListener(3)));
        this.helpMenu.add(this.createMenuItem(MenuBar.HELP, event -> helpListener()));
    }

    public void setMenuBar(){
        this.mb.add(this.pageMenu);
        this.mb.add(this.helpMenu);
        this.frame.setJMenuBar(this.mb);
    }

    private JMenuItem createMenuItem(String name, ActionListener listener) {
        JMenuItem menuItem = MenuFactory.createMenuItem(name);
        menuItem.addActionListener(listener);
        return menuItem;
    }

    // start listener section
    private void pageListener(int page){
        this.updatePanel(PanelFactory.createPanel(page));
    }

    private void helpListener(){
        JOptionPane.showMessageDialog(null, "Send help");
    }

    // update panel to JFrame
    private void updatePanel(JPanel panel){
        this.frame.getContentPane().removeAll();
        this.frame.getContentPane().add(panel);
        this.frame.getContentPane().revalidate();
        this.frame.repaint();
    }


    // end listener section
}
