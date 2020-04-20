package binarytree;

public class Node {
    private int key;
    private String value;
    private Node left;
    private Node right;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
        left=null;
        right=null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void addChild(Node node){
        if(this.key == node.key){
            this.value= node.value;
        }
        else if(this.key>node.key){
            if(this.left==null)
                left = node;
            else
                left.addChild(node);
        }
        else if(this.key<node.key){
            if(this.right==null)
                right=node;
            else
                this.right.addChild(node);
        }
    }

    public void inorder(){
        if(this.left!=null)
            left.inorder();
        System.out.println("("+this.key+"): "+ this.value+" ");
        if(this.right!=null)
            right.inorder();
    }

}
