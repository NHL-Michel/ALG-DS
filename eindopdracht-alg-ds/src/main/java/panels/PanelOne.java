package panels;

import assets.ComponentBuilder;
import assets.time.ExecutionTime;
import datastructures.linkedlist.LinkedL;

import javax.swing.*;
import java.awt.*;

public class PanelOne extends Panel {
    private LinkedL ll;
    private String nodeLayout;

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
        this.buildExecutionTimeField(0.0);
    }

    /**
     * build all headers for panel one
     */
    private void buildHeaders(){
        this.panel.add(ComponentBuilder.buildHeader("Linked list demo", new Rectangle(30, 20, 200, 20)));
    }

    /**
     * build all buttons for panel one
     */
    private void buildButtons(){
        build = ComponentBuilder.buildButton("Build Linked list", new Rectangle(400, 20, 325, 30));
        sortAge = ComponentBuilder.buildButton("Bubble sort age", new Rectangle(400, 60, 150, 30));
        sortName = ComponentBuilder.buildButton("Bubble sort name", new Rectangle(575, 60, 150, 30));
        search = ComponentBuilder.buildButton("Linear search", new Rectangle(400, 140, 325, 30));
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
                                                                            <li> Sort the linked list by name </li>
                                                                            <li> Sort the linked list by age </li>
                                                                            <li> Search through the linked list by name or age </li>                                                                                                                                                      
                                                                        </ol>
                                                                    </p>
                                                                </html>
                                                                """, new Rectangle(30, 60, 300, 180)));
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
     * build the execution time for the application
     * @param data
     */
    private void buildExecutionTimeField(double data){
        this.executionTime = ComponentBuilder.buildParagraph(String.format("Execution time : %,.2f (nanoseconds in terminal)", data), new Rectangle(400, 220, 400,50));
        this.panel.add(executionTime);
    }

    /**
     * give all JButtons an action listener
     */
    private void addActionListeners(){
        this.build.addActionListener(event -> buildLinkedList());
        this.search.addActionListener(event -> linearSearchEventListener());
        this.sortAge.addActionListener(event -> bubbleSortEventListener("age", 600));
        this.sortName.addActionListener(event -> bubbleSortEventListener("name", 650));

        this.panel.add(this.build);
        this.panel.add(this.search);
        this.panel.add(this.sortAge);
        this.panel.add(this.sortName);
    }


    /**
     * start action listeners
     */

    private void buildLinkedList(){
        if (this.ll.getSize() != this.ll.getDataset().size()) {
            this.updateComponent(this.executionTime, false);
            this.buildExecutionTimeField(ExecutionTime.build(this.ll));
            this.updateComponent(this.executionTime, true);
            this.nodeLayout = this.ll.getNodeLayout();
            this.updateComponent(ComponentBuilder.buildParagraph(this.nodeLayout, new Rectangle(40, 550, 1000,50)), true);
            JOptionPane.showMessageDialog(null,"Linked list build!");
        } else {
            JOptionPane.showMessageDialog(null,"Linked list already build, cannot build again!");
        }
    }

    private void linearSearchEventListener(){
        String searchValue = this.inputBox.getText();
        Object searchTerm;

        if (isParsable(searchValue)){
            searchTerm = Integer.parseInt(searchValue);
        } else {
            searchTerm = searchValue;
        }

        this.updateComponent(this.executionTime, false);
        this.buildExecutionTimeField(ExecutionTime.calculateSearchTime(this.ll, searchTerm));
        this.updateComponent(this.executionTime, true);
    }

    private void bubbleSortEventListener(String parameter, int height){
        this.updateComponent(this.executionTime, false);
        this.buildExecutionTimeField(ExecutionTime.calculateSortTime(this.ll, parameter));
        this.updateComponent(this.executionTime, true);
        this.nodeLayout = this.ll.getNodeLayout();
        this.updateComponent(ComponentBuilder.buildParagraph(this.nodeLayout, new Rectangle(40, height, 1000,50)), true);
    }

    /**
     * end action listeners
     */

    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}
