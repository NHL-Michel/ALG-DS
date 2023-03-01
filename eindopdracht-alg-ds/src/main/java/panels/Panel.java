package panels;

import javax.swing.*;
import java.awt.*;

public abstract class Panel {

    protected JPanel panel;
    public Panel(){
        this.panel = new JPanel();
        this.panel.setBackground(new Color(255,255,255));
        this.buildPanel();
    }
    public abstract void buildPanel();

    /**
     * update a component in the JPanel
     * @param c
     * @param addComponent
     */
    public void updateComponent(Component c, Boolean addComponent){
        if (addComponent) {
            this.panel.add(c);
        } else {
            this.panel.remove(c);
        }
        this.panel.revalidate();
        this.panel.repaint();
    }

    public JPanel getPanel(){
        return this.panel;
    }
}
