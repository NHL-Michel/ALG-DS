package panels;

import dataset.data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Panel {
    protected JPanel panel;
    protected ArrayList<Integer> dataset;
    protected JButton build, sort1, sort2, search1, search2;
    protected JTextArea inputBox;
    protected String dataSetString;

    public Panel(){
        this.panel = new JPanel(null);
        this.dataset = data.generateRandomDataset(10, 500);
        this.panel.setBackground(new Color(255, 255, 255));
    }
    public abstract void buildPanel();

    /**
     * update a component in the JPanel
     * @param c component to add or remove
     * @param addComponent tells if the component should be added or removed
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

    /**
     * @return return the JPanel object
     */
    public JPanel getPanel(){
        return this.panel;
    }
}
