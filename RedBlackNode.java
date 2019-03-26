/***************************************************************
* file: RedBlackNode.java
* author: N.Tran
* class: CS 241 – Data Structure and Algorithms 2
*
* assignment: program 3
* date last modified: 11/15/2017
*
* purpose: add color to the nodes of RBTree class
****************************************************************/ 

public class RedBlackNode

{   

    RedBlackNode left, right;

    int element;

    int color;
    
    //Constructors
    public RedBlackNode(int theElement)

    {

        this( theElement, null, null );

    }

    public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt)

    {
        left = lt;

        right = rt;

        element = theElement;

        color = 1;
    }   
}