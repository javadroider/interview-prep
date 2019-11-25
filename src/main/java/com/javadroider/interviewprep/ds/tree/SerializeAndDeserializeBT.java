package com.javadroider.interviewprep.ds.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class SerializeAndDeserializeBT {


    public static String serialize(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                list.add(null);
            } else {
                list.add(temp.toString().trim());
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }

        //System.out.println(list);
        return list.stream().collect(Collectors.joining(","));
    }

    //10,null,8,12,null,7,9,11,13,null
    public static void deserialize(String serializedString) {
        String tokens[] = serializedString.split(",");

        Node[] nodeArray = new Node[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            String data = tokens[i];
            if (data.equalsIgnoreCase("null")) {
                nodeArray[i] = null;
            } else {
                nodeArray[i] = Node.newNode(Integer.parseInt(tokens[i]));
            }
        }
        int i = 0;
        int j = i + 2;
        int size = tokens.length;
        while (i < size && j < size) {
            if (!tokens[i].equalsIgnoreCase("null")) {
                nodeArray[i].left = nodeArray[j++];
                nodeArray[i].right = nodeArray[j++];
            } else {
                j++;
            }
            i++;
        }
        new Traversals().inOrder(nodeArray[0]);
    }

    /*
          10
        /   \
       8     12
      / \   /  \
     7  9  11  13

    */
    public static void main(String[] args) {
        String str = serialize(BinaryTree.sample());
        System.out.println(str);
        deserialize(str);
    }
}
