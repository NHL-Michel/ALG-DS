package assets;

import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import java.awt.*;

public class ComponentBuilder {
    public static JLabel buildHeader(String content, Rectangle r){
        JLabel l = new JLabel(content);
        l.setFont(new Font("Serif", Font.ITALIC, 24));
        l.setBounds(r.x, r.y, r.width, r.height);
        return l;
    }

    public static JLabel buildParagraph(String content, Rectangle r){
        JLabel l = new JLabel(content);
        l.setFont(new Font("Serif", Font.PLAIN, 13));
        l.setBounds(r.x, r.y, r.width, r.height);
        return l;
    }

    public static JButton buildButton(String content, Rectangle r){
        JButton b = new JButton(content);
        b.setBounds(r.x, r.y, r.width, r.height);
        return b;
    }

    public static JTextArea buildInputField(String content, Rectangle r){
        JTextArea j = new JTextArea();
        j.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j.setBounds(r.x, r.y, r.width, r.height);
        PromptSupport.setPrompt(content, j);
        return j;
    }
}
