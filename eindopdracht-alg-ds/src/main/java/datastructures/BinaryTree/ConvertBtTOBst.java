package datastructures.BinaryTree;

import assets.dataset.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertBtTOBst extends BinaryTree{
    public static String convertBtToBstForNumbers(Node root) {
        List<Person> values = new ArrayList<>();
        storeInorderValues(root, values);
        int n = values.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (values.get(j).getAge() < values.get(minIndex).getAge()) {
                    minIndex = j;
                }
            }
            int tempAge = values.get(minIndex).getAge();
            String tempName = values.get(minIndex).getName();

            values.get(minIndex).setAge(values.get(i).getAge());
            values.get(minIndex).setName(values.get(i).getName());

            values.get(i).setAge(tempAge);
            values.get(i).setName(tempName);
        }
        replaceNodeValues(root, values);
        String layout = printInorder(root, "", true);
        System.out.println(layout);

        return layout;
    }

    public static String convertBtToBstForName(Node root) {
        List<Person> values = new ArrayList<>();
        storeInorderValues(root, values);
        int n = values.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (values.get(j).getName().compareTo(values.get(minIndex).getName()) < 0) {
                    minIndex = j;
                }
            }

            int tempAge = values.get(minIndex).getAge();
            String tempName = values.get(minIndex).getName();

            values.get(minIndex).setAge(values.get(i).getAge());
            values.get(minIndex).setName(values.get(i).getName());

            values.get(i).setAge(tempAge);
            values.get(i).setName(tempName);
        }
        replaceNodeValues(root, values);
        String layout = printInorder(root, "", true);
        System.out.println(layout);

        return layout;
    }

    public static void storeInorderValues(Node root, List<Person> values) {
        if (root == null) {
            return;
        }
        storeInorderValues(root.getLeft(), values);
        values.add(root.getData());
        storeInorderValues(root.getRight(), values);
    }

    public static void replaceNodeValues(Node root, List<Person> values) {
        if (root == null) {
            return;
        }
        replaceNodeValues(root.getLeft(), values);
        root.setData(values.remove(0));
        replaceNodeValues(root.getRight(), values);

    }

}