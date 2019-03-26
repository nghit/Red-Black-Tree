/***************************************************************
* file: RBTree.java
* author: N.Tran
* class: CS 241 – Data Structure and Algorithms 2
*
* assignment: program 3
* date last modified: 11/15/2017
*
* purpose: red black tree class and its methods.
****************************************************************/ 
public class RBTree

{

    private RedBlackNode current;

    private RedBlackNode parent;

    private RedBlackNode grand;

    private RedBlackNode great;

    private RedBlackNode header;   

    private static RedBlackNode nullNode;

    static

    {

        nullNode = new RedBlackNode(0);

        nullNode.left = nullNode;

        nullNode.right = nullNode;

    }

    static final int BLACK = 1;   

    static final int RED   = 0;
    
    //Constructors
    public RBTree(int negInf)

    {

        header = new RedBlackNode(negInf);

        header.left = nullNode;

        header.right = nullNode;

    }
    
    //check if the tree is empty
    public boolean isEmpty()

    {

        return header.right == nullNode;

    }
    
    //clear the tree
    public void makeEmpty()

    {

        header.right = nullNode;

    }

    // insert nodes
    public void insert(int item )

    {

        current = parent = grand = header;

        nullNode.element = item;

        while (current.element != item)

        {            

            great = grand;

            grand = parent;

            parent = current;

            current = item < current.element ? current.left : current.right;

            if (current.left.color == RED && current.right.color == RED)

                handleReorient( item );

        }

        if (current != nullNode)

            return;

        current = new RedBlackNode(item, nullNode, nullNode);

        if (item < parent.element)

            parent.left = current;

        else

            parent.right = current;       

        handleReorient( item );

    }

    private void handleReorient(int item)

    {

        current.color = RED;

        current.left.color = BLACK;

        current.right.color = BLACK;

        if (parent.color == RED)  

        {

            grand.color = RED;

            if (item < grand.element != item < parent.element)

                parent = rotate( item, grand ); // Start dbl rotate

            current = rotate(item, great );

            current.color = BLACK;

        }

        header.right.color = BLACK;

    }     
    
    private RedBlackNode rotate(int item, RedBlackNode parent)

    {

        if(item < parent.element)

            return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;

            else

                return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);

    }

    //rotate with the left child
    private RedBlackNode rotateWithLeftChild(RedBlackNode k2)

    {

        RedBlackNode k1 = k2.left;

        k2.left = k1.right;

        k1.right = k2;

        return k1;

    }
    
    //rotate with the right child
    private RedBlackNode rotateWithRightChild(RedBlackNode k1)

    {

        RedBlackNode k2 = k1.right;

        k1.right = k2.left;

        k2.left = k1;

        return k2;

    }

    public int countNodes()

    {

        return countNodes(header.right);

    }
    
    //count how many nodes are there
    private int countNodes(RedBlackNode r)

    {

        if (r == nullNode)

            return 0;

        else

        {

            int l = 1;

            l += countNodes(r.left);

            l += countNodes(r.right);

            return l;

        }

    }

    public boolean search(int val)

    {

        return search(header.right, val);

    }
    
    //Search of the element
    private boolean search(RedBlackNode r, int val)

    {

        boolean found = false;

        while ((r != nullNode) && !found)

        {

            int rval = r.element;

            if (val < rval)

                r = r.left;

            else if (val > rval)

                r = r.right;

            else

            {

                found = true;

                break;

            }

            found = search(r, val);

        }

        return found;

    }

    public void inorder()

    {

        inorder(header.right);

    }
    
    //Traverse the tree inorder
    private void inorder(RedBlackNode r)

    {

        if (r != nullNode)

        {

            inorder(r.left);

            char c = 'B';

            if (r.color == 0)

                c = 'R';

            System.out.print(r.element +""+c+" ");

            inorder(r.right);

        }

    }

    public void preorder()

    {

        preorder(header.right);

    }
    
    //Traverse the tree preorder
    private void preorder(RedBlackNode r)

    {

        if (r != nullNode)

        {

            char c = 'B';

            if (r.color == 0)

                c = 'R';

            System.out.print(r.element +""+c+" ");

            preorder(r.left);            

            preorder(r.right);

        }

    }

    public void postorder()

    {

        postorder(header.right);

    }
    
    //Traverse the tree postorder
    private void postorder(RedBlackNode r)

    {

        if (r != nullNode)

        {

            postorder(r.left);            

            postorder(r.right);

            char c = 'B';

            if (r.color == 0)

                c = 'R';

            System.out.print(r.element +""+c+" ");

        }
    }    
}