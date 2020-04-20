package binarytree;

public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void addNode(Node node){
        if(node==null)
            return;
        root.addChild(node);
    }

    public void printInOrder()
    {
        if(root!=null)
            root.inorder();
    }
}
