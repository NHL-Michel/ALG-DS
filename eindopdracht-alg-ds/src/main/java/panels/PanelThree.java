package panels;

import javax.swing.*;

public class PanelThree extends Panel  {
    @Override
    public void buildPanel() {
        JButton b = new JButton("test panel three");
        this.panel.add(b);
    }
}
