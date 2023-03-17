package panels;

import assets.ComponentBuilder;
import assets.time.ExecutionTime;
import datastructures.BinaryTree.BinaryTree;

import javax.swing.*;
import java.awt.*;

import static panels.PanelOne.isParsable;

public class PanelThree extends Panel  {

    private BinaryTree tree;
    private String nodeLayout;

    public PanelThree(){
        this.tree = new BinaryTree();
        this.dataSetString = this.tree.getDataset().toString();
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
        this.build.addActionListener(event -> buildBinaryTreeList());

        this.search.addActionListener(event -> linearSearchEventListener());
        this.sortAge.addActionListener(event -> bubbleSortEventListener("age", 600));
        this.sortName.addActionListener(event -> bubbleSortEventListener("name", 650));

        this.panel.add(this.build);
        this.panel.add(this.search);
        this.panel.add(this.sortAge);
        this.panel.add(this.sortName);
    }

    private void bubbleSortEventListener(String parameter, int height) {
        if (this.tree.getRoot() == null) {
            JOptionPane.showMessageDialog(null, "Please build the tree first!");
            return;
        }
        this.updateComponent(this.executionTime, false);
        this.buildExecutionTimeField(ExecutionTime.calculateSortTime(this.tree, parameter));
        this.updateComponent(this.executionTime, true);
        this.nodeLayout = this.tree.getTreeLayout();
        this.updateComponent(ComponentBuilder.buildParagraph(this.nodeLayout, new Rectangle(40, height, 1000,50)), true);
    }

    private void linearSearchEventListener() {
        String searchValue = this.inputBox.getText();
        Object searchTerm;

        if (isParsable(searchValue)){
            searchTerm = Integer.parseInt(searchValue);
        } else {
            searchTerm = searchValue;
        }

        this.updateComponent(this.executionTime, false);
        this.buildExecutionTimeField(ExecutionTime.calculateSearchTime(this.tree, searchTerm));
        this.updateComponent(this.executionTime, true);

    }

    /**
     * build all headers for panel one
     */
    private void buildHeaders(){
        this.panel.add(ComponentBuilder.buildHeader("Binary tree demo", new Rectangle(30, 20, 200, 20)));
    }

    /**
     * build all buttons for panel one
     */
    private void buildButtons(){
        build = ComponentBuilder.buildButton("Build binary tree", new Rectangle(400, 20, 325, 30));
        sortAge = ComponentBuilder.buildButton("Sort by name", new Rectangle(400, 60, 150, 30));
        sortName = ComponentBuilder.buildButton("Sort by age", new Rectangle(575, 60, 150, 30));
        search = ComponentBuilder.buildButton("Depth first search", new Rectangle(400, 140, 325, 30));
    }

    /**
     * build all paragraphs for panel one
     */
    private void buildParagraphs(){
        this.panel.add(ComponentBuilder.buildParagraph("""
                                                                <html>
                                                                    <p> 
                                                                    In order to make use of the binary tree demo page, use the following step by step plan
                                                                    <br>
                                                                    <br>
                                                                        <ol>
                                                                            <li> Generate the dataset (automatically) </li>
                                                                            <li> Build the binary tree </li>
                                                                            <li> Binary search tree sort by name </li>
                                                                            <li> Binary search tree sort by age </li>
                                                                            <li> Search through the binary tree by name or age </li>                                                                                                                                                      
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
        this.inputBox = ComponentBuilder.buildInputField("Search...", new Rectangle(400, 180, 325, 20));
        this.panel.add(this.inputBox);
    }

    /**
     * build the execution time for the application
     * @param data
     */
    private void buildExecutionTimeField(double data){
        this.executionTime = ComponentBuilder.buildParagraph(String.format("Execution time : %,.1f MS (%f nanoseconds)", data / 1000000, data), new Rectangle(400, 220, 400,50));
        this.panel.add(executionTime);
    }

    private void buildBinaryTreeList(){
        if (this.tree.getRoot() == null) {
            this.updateComponent(this.executionTime, false);
            this.buildExecutionTimeField(ExecutionTime.build(this.tree));
            this.updateComponent(this.executionTime, true);
            this.nodeLayout = this.tree.getTreeLayout();
            this.updateComponent(ComponentBuilder.buildParagraph(this.nodeLayout, new Rectangle(40, 550, 1000,50)), true);
            JOptionPane.showMessageDialog(null,"Binary Tree is build!");
        } else {
            JOptionPane.showMessageDialog(null,"Binary Tree is already build, cannot build again!");
        }
    }
}