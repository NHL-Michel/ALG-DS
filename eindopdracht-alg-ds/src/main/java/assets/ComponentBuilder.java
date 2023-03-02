package assets;

import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import java.awt.*;

public class ComponentBuilder {

    /**
     * build a header - uses standard styling
     * @param content name of the header
     * @param r rectange
     * @return JLabel
     */
    public static JLabel buildHeader(String content, Rectangle r){
        JLabel l = new JLabel(content);
        l.setFont(new Font("Serif", Font.ITALIC, 24));
        l.setBounds(r.x, r.y, r.width, r.height);
        return l;
    }

    /**
     * build a paragraph - uses standard styling
     * @param content content of the paragraph
     * @param r recntangle
     * @return the paragraph
     */
    public static JLabel buildParagraph(String content, Rectangle r){
        JLabel l = new JLabel(content);
        l.setFont(new Font("Serif", Font.PLAIN, 13));
        l.setBounds(r.x, r.y, r.width, r.height);
        return l;
    }

    /**
     * build a JButton
     * @param content name of the JButton (which is visible on the button)
     * @param r rectangle
     * @return JButton
     */
    public static JButton buildButton(String content, Rectangle r){
        JButton b = new JButton(content);
        b.setBounds(r.x, r.y, r.width, r.height);
        return b;
    }

    /**
     * build a textarea with a placeholder
     * @param content placeholder content of the inputfield
     * @param r rectangle
     * @return the textarea
     */
    public static JTextArea buildInputField(String content, Rectangle r){
        JTextArea j = new JTextArea();
        j.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j.setBounds(r.x, r.y, r.width, r.height);
        PromptSupport.setPrompt(content, j);
        return j;
    }
}
