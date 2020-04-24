package binarytree;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Tree myTree = new Tree(new Node(41, "HTTP protocol"));

        Node n1 = new Node(20, "JavaScript");
        myTree.addNode(n1);

        Node n2 = new Node(30, "HTML 5");
        myTree.addNode(n2);

        Node n3 = new Node(55, "MySQL server");
        myTree.addNode(n3);

        Node n4 = new Node(72, "Jazyk C");
        myTree.addNode(n4);

        Node n5 = new Node(8, "Java SE");
        myTree.addNode(n5);

        Node n6 = new Node(48, "SMTP");
        myTree.addNode(n6);

        Node n7 = new Node(21, "C#");
        myTree.addNode(n7);

        Node n8 = new Node(52, "PHP");
        myTree.addNode(n8);

        Node n9 = new Node(36, "Linux BASH");
        myTree.addNode(n9);

        Node n10 = new Node(44, "Node JS");
        myTree.addNode(n10);

        Node n11 = new Node(80, "CSS 3");
        myTree.addNode(n11);

        Node n12 = new Node(34, "Pascal");
        myTree.addNode(n12);

        Node n13 = new Node(74, "Python");
        myTree.addNode(n13);

        Node n14 = new Node(51, "Arduino");
        myTree.addNode(n14);

        Node n15 = new Node(81, "Javascript");
        myTree.addNode(n15);

        Node n16 = new Node(11, "Android");
        myTree.addNode(n16);

        /*Node n17= new Node(35,"Angular");
        myTree.addNode(n17);*/


        //myTree.printPreOrder();
        System.out.println(myTree.getValue(44));

        System.out.print("List of leafs: ");
        List<Node> result = myTree.getListOfLeafs();
        for (Node node : result)
            System.out.print(node.getKey() + " ");
        System.out.println();

        /*myTree.remove(n13);
        myTree.remove(n12);*/
        /*myTree.remove(n8);
        myTree.remove(n5);
        myTree.remove(n7);*/
        myTree.printInOrder();

        System.out.println("Height of the tree: " + myTree.getHeight());


    }
}
