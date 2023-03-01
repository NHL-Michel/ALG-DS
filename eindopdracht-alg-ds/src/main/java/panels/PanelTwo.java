package panels;

import javax.swing.*;

public class PanelTwo extends Panel {
    @Override
    public void buildPanel() {
        JButton b = new JButton("test panel two");
        this.panel.add(b);
    }
}
