package panels;

import assets.ComponentBuilder;
import datastructures.linkedlist.LinkedL;

import java.awt.*;

public class PanelOne extends Panel {
    private LinkedL ll;

    public PanelOne(){
        this.ll = new LinkedL();
        this.dataSetString = this.ll.getDataset().toString();
        this.buildPanel();
    }
    @Override
    public void buildPanel(){
        this.buildHeaders();
        this.buildButtons();
        this.addActionListeners();
        this.buildParagraphs();
        this.buildInputFields();
    }

    /**
     * build all headers for panel one
     */
    private void buildHeaders(){
        this.panel.add(ComponentBuilder.buildHeader("Linked list demo", new Rectangle(10, 20, 200, 20)));
    }

    /**
     * build all buttons for panel one
     */
    private void buildButtons(){
        build = ComponentBuilder.buildButton("Build Linked list", new Rectangle(400, 20, 325, 30));
        sort1 = ComponentBuilder.buildButton("sort 1", new Rectangle(400, 60, 150, 30));
        sort2 = ComponentBuilder.buildButton("sort 2", new Rectangle(575, 60, 150, 30));
        search1 = ComponentBuilder.buildButton("search 1", new Rectangle(400, 140, 150, 30));
        search2 = ComponentBuilder.buildButton("search 2", new Rectangle(575, 140, 150, 30));

        this.panel.add(build);
        this.panel.add(sort1);
        this.panel.add(sort2);
        this.panel.add(search1);
        this.panel.add(search2);
    }

    /**
     * build all paragraphs for panel one
     */
    private void buildParagraphs(){
        this.panel.add(ComponentBuilder.buildParagraph("""
                                                                <html>
                                                                    <p> 
                                                                    In order to make use of the linked list demo page, use the following step by step plan
                                                                    <br>
                                                                    <br>
                                                                        <ol>
                                                                            <li> Generate the dataset (automatically) </li>
                                                                            <li> Build the linked list </li>
                                                                            <li> Sort the linked list using ..... </li>
                                                                            <li> Sort the linked list using ..... </li>
                                                                            <li> Search through the linked list using ..... </li>                                                                            
                                                                            <li> Search through the linked list using ..... </li>                                                                            
                                                                        </ol>
                                                                    </p>
                                                                </html>
                                                                """, new Rectangle(10, 60, 300, 180)));
        this.panel.add(ComponentBuilder.buildParagraph("""
                                                                <html>
                                                                    <p>
                                                                        <strong> 
                                                                            Search
                                                                        </strong>
                                                                        by filling in the input field, and using a searching algorithm
                                                                    </p> 
                                                                </html>""", new Rectangle(400, 100, 400, 50)));
        this.panel.add(ComponentBuilder.buildParagraph( String.format("Dataset : %s", this.dataSetString), new Rectangle(400, 200, 300, 50)));
    }

    /**
     * build all input field for panel one
     */
    private void buildInputFields(){
        this.inputBox = ComponentBuilder.buildInputField("Search... (integers only)", new Rectangle(400, 180, 325, 20));
        this.panel.add(this.inputBox);
    }

    /**
     * give all JButtons an action listener
     */
    private void addActionListeners(){
        this.build.addActionListener(event -> buildLinkedList());
        this.sort1.addActionListener(event -> sortAlgorithmOne());
        this.sort2.addActionListener(event -> sortAlgorithmTwo());
        this.search1.addActionListener(event -> searchAlgorithmOne());
        this.search2.addActionListener(event -> searchAlgorithmTwo());
    }

    /**
     * start action listeners
     */

    private void buildLinkedList(){

    }

    private void sortAlgorithmOne(){

    }

    private void sortAlgorithmTwo(){

    }

    private void searchAlgorithmOne(){

    }
    private void searchAlgorithmTwo(){

    }

    /**
     * end action listeners
     */
}
