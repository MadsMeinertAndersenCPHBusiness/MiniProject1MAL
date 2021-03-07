package dk.cphbusiness.mal.utils;

import java.util.ArrayList;
import java.util.List;

public class TrieSort {

    private Node rootNode;
    public ArrayList<String> arrayList = new ArrayList<>();

    TrieSort()
    {
        rootNode = null;
    }

    void insert(String key, int index)
    {

        if (rootNode == null)
        {
            rootNode = new Node();
        }

        Node currentNode = rootNode;

        for (int i = 0;i < key.length();i++)
        {
            char keyChar = key.charAt(i);
            try {
                if (currentNode.getChild(keyChar) == null) {
                    currentNode.addChild(keyChar);
                }
            }catch (Exception e){
                System.out.println(keyChar +"---"+ currentNode);
            }
            currentNode = currentNode.getChild(keyChar);
        }

        currentNode.addIndex(index);
    }

    void traversePreorder(String[] array)
    {
        traversePreorder(rootNode, array);
    }

    private void traversePreorder(Node node,
                                  String[] array)
    {
        if (node == null)
        {
            return;
        }

        if (node.getIndices().size() > 0)
        {
            for (int index : node.getIndices())
            {
                arrayList.add(array[index]);
            }
        }

        for (char index = 0; index <= 126;index++)
        {
            traversePreorder(node.getChild(index), array);
        }
    }


    public void sort(String[] arr) {
            printInSortedOrder(arr);
        }

    public static void printInSortedOrder(String[] array)
    {
        TrieSort trie = new TrieSort();

        for (int i = 0;i < array.length;i++)
        {
            trie.insert(array[i], i);
        }

        trie.traversePreorder(array);
    }

    private static class Node {

        private List<Integer> indices;
        private Node[] children;

        Node() {
            children = new Node[127];
            indices = new ArrayList<>(0);
        }

        Node getChild(char index) {
            return children[index];
        }

        void addChild(char index) {
            Node node = new Node();
            children[index] = node;
        }

        List<Integer> getIndices() {
            return indices;
        }

        void addIndex(int index) {
            indices.add(index);
        }
    }
}





