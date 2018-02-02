package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

class Node
{
    final int value;
    Node parent = null;
    Node leftChild = null;
    Node rightChild = null;
    int balanceFactor = 0;

    Node(int v)
    {
        value=v;
    }
}

class AVLTree
{
    protected Node root = null;
    private int numLeftRotations = 0;
    private int numRightRotations = 0;

    public int  getNumLeftRotations() { return numLeftRotations; }
    public int  getNumRightRotations() { return numRightRotations; }

    // PLEASE DO NOT EDIT LINES ABOVE THIS POINT








    /** Performs a left rotation using node @param pivot as the pivot **/
    private void leftRotation(Node v)
    {
        numLeftRotations++; //Counts the number of left rotations. Do not edit/remove this lines.

        Node pivot = v.rightChild;

        if(v == root) {
            root = pivot;
            pivot.parent = null;
        }
        else {
            if(v == v.parent.leftChild) {
                v.parent.leftChild = pivot;
            }
            else {
                v.parent.rightChild = pivot;
            }

            pivot.parent = v.parent;
        }

        v.rightChild = pivot.leftChild;

        if(v.rightChild != null) {
            v.rightChild.parent = v;
        }

        v.parent = pivot;
        pivot.leftChild = v;
    }

    /** Performs a right rotation using node @param pivot as the pivot **/
    private void rightRotation(Node v)
    {
        numRightRotations++; //Counts the number of right rotations. Do not edit/remove this lines.

        Node pivot = v.leftChild;

        if(v == root) {
            root = pivot;
            pivot.parent = null;
        }
        else {
            if(v == v.parent.rightChild) {
                v.parent.rightChild = pivot;
            }
            else {
                v.parent.leftChild = pivot;
            }

            pivot.parent = v.parent;
        }

        v.leftChild = pivot.rightChild;

        if(v.leftChild != null) {
            v.leftChild.parent = v;
        }

        v.parent = pivot;
        pivot.rightChild = v;
    }







    // PLEASE DO NOT EDIT LINES BEYOND THIS POINT

    /** Performs the correct rotations to rebalance any unbalanced node in the path from
     * the root to the leaf @param leaf in the current tree **/
    private void rebalance(Node leaf)
    {
        int steps = 50; //Prevents infinite loops if rotations do not update the tree structure correctly
        //The height is less than 50 for trees that contain up to 12 billion nodes

        Node node = leaf.parent;  //Current node
        Node child = leaf; //Children of node on the path to leaf
        for(;node!=null && steps>0;child=node,node=node.parent,steps--)
        {
            if(node.rightChild==child)
            {
                if(node.balanceFactor==-1)
                {
                    node.balanceFactor=0;
                    break; //Height does not change. We are done.
                }

                if(node.balanceFactor==0)
                {
                    node.balanceFactor=1;
                    continue; //Height increases
                }

                //Here node.imbalance==1. Node becomes temporarily not balanced after insertion.
                assert child.balanceFactor!=0;

                if(child.balanceFactor > 0) //Right-Right case
                {
                    leftRotation(node);
                    node.balanceFactor=0;
                    child.balanceFactor=0;
                    node = child;
                    break; //Height does not change.
                }

                //Right-Left Case
                Node rlchild = child.leftChild;
                assert rlchild.balanceFactor!=0 || (rlchild.leftChild==null && rlchild.rightChild==null);

                rightRotation(child);
                leftRotation(node);

                if(rlchild.balanceFactor==0)
                {
                    rlchild.balanceFactor=0;
                    child.balanceFactor=0;
                    node.balanceFactor=0;
                    break; //Height does not change.
                }

                if(rlchild.balanceFactor==-1)
                {
                    rlchild.balanceFactor=0;
                    child.balanceFactor=1;
                    node.balanceFactor=0;
                    break; //Height does not change.
                }

                //Here rlchild.balanceFactor==1
                rlchild.balanceFactor=0;
                child.balanceFactor=0;
                node.balanceFactor=-1;
                break; //Height does not change.

            }
            else
            {
                if(node.balanceFactor==1)
                {
                    node.balanceFactor=0;
                    break; //Height does not change. We are done.
                }

                if(node.balanceFactor==0)
                {
                    node.balanceFactor=-1;
                    continue; //Height increases
                }

                //Here node.imbalance==1. Node becomes temporarily not balanced after insertion.
                assert child.balanceFactor!=0;

                if(child.balanceFactor < 0) //Left-Left case
                {
                    rightRotation(node);
                    node.balanceFactor=0;
                    child.balanceFactor=0;
                    node = child;
                    break; //Height does not change.
                }

                //Left-Right case
                Node lrchild = child.rightChild;
                assert lrchild.balanceFactor!=0 || (lrchild.leftChild==null && lrchild.rightChild==null);

                leftRotation(child);
                rightRotation(node);

                if(lrchild.balanceFactor==0)
                {
                    lrchild.balanceFactor=0;
                    child.balanceFactor=0;
                    node.balanceFactor=0;
                    break; //Height does not change.
                }

                if(lrchild.balanceFactor==1)
                {
                    lrchild.balanceFactor=0;
                    child.balanceFactor=-1;
                    node.balanceFactor=0;
                    break; //Height does not change.
                }

                //Here rlchild.balanceFactor==-1
                lrchild.balanceFactor=0;
                child.balanceFactor=0;
                node.balanceFactor=1;
                break; //Height does not change.

            }
        }

        if(steps==0)
            throw new RuntimeException("This exception just prevented an infinite loop (a rotation operation left the tree in an invalid state)");
    }

    /** Adds one leaf having value @param newValue in the correct position of the current tree **/
    private Node addLeaf(int newValue)
    {
        //Traverse the tree and find the parent node for the new value
        Node parent = null;
        Node current = root;
        while(current!=null)
        {
            parent=current;

            if( newValue < current.value )
                current = current.leftChild;
            else
                current = current.rightChild;
        }

        //Create a new leaf for the new value
        Node newLeaf = new Node(newValue);
        newLeaf.parent = parent;

        if(parent==null) //If the tree was empty the new node becomes the root
            root = newLeaf;
        else if(newValue < parent.value)
            parent.leftChild = newLeaf;
        else
            parent.rightChild = newLeaf;

        return newLeaf;
    }

    /** Inserts a new value @param newValue in the correct position of the current tree **/
    public void insert(int newValue)
    {
        Node newLeaf = addLeaf(newValue);

        //Check (and fix) for nodes on the path from the root to the new leaf that are not balanced.
        rebalance(newLeaf);
    }

    /** Creates a new empty AVL tree **/
    public AVLTree() {}
}


public class TreeRotations {

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        int ntestcases= scanner.nextInt();

        for(int i=0; i<ntestcases; i++)
        {
            AVLTree tree = new AVLTree();

            int num_ops = scanner.nextInt();
            for(int j=0; j<num_ops; j++)
                tree.insert(scanner.nextInt());

            out.println(tree.getNumLeftRotations() + " " + tree.getNumRightRotations());
        }

        scanner.close();
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
