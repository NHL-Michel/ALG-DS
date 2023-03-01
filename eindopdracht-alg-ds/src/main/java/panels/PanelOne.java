package panels;

import javax.swing.*;

public class PanelOne extends Panel {

    @Override
    public void buildPanel(){
        JButton b = new JButton("test panel one");
        b.addActionListener(event -> testActionListener());
        this.panel.add(b);
    }

    public void testActionListener(){
        this.updateComponent(new JButton("test panel one ACTION"), true);
    }
}
