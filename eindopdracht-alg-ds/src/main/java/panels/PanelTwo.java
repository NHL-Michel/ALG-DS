package panels;

import assets.ComponentBuilder;
import datastructures.linkedlist.LinkedL;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelTwo extends Panel {
    private datastructures.doublyLinkedList.DoublyLinkedList dll;
    private String nodeLayout;

    public PanelTwo(){
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

    private void addActionListeners(){
        this.panel.add(this.build);
        this.panel.add(this.search);
        this.panel.add(this.sortAge);
        this.panel.add(this.sortName);
    }

    /**
     * build all headers for panel one
     */
    private void buildHeaders(){
        this.panel.add(ComponentBuilder.buildHeader("Doubly Linked list demo", new Rectangle(30, 20, 200, 20)));
    }

    /**
     * build all buttons for panel one
     */
    private void buildButtons(){
        build = ComponentBuilder.buildButton("Build doubly Linked list", new Rectangle(400, 20, 325, 30));
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
                                                                    In order to make use of the doubly linked list demo page, use the following step by step plan
                                                                    <br>
                                                                    <br>
                                                                        <ol>
                                                                            <li> Generate the dataset (automatically) </li>
                                                                            <li> Build the doubly linked list </li>
                                                                            <li> Sort the doubly linked list by name </li>
                                                                            <li> Sort the doubly linked list by age </li>
                                                                            <li> Search through the doubly linked list by name or age </li>                                                                                                                                                      
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
}
