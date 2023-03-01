package panels.assets;

import panels.PanelOne;
import panels.PanelThree;
import panels.PanelTwo;

import javax.swing.*;

public class PanelFactory {
    public static JPanel createPanel(int panel){
        return switch (panel){
            case 1 -> new PanelOne().getPanel();
            case 2 -> new PanelTwo().getPanel();
            case 3 -> new PanelThree().getPanel();
            default -> null;
        };
    }
}
