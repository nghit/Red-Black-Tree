/***************************************************************
* file: RedBlackTreeTest
* author: N.Tran
* class: CS 241 – Data Structure and Algorithms 2
*
* assignment: program 3
* date last modified: 11/15/2017
*
* purpose: main method. Let the users insert, search, count nodes, check empty, or clear the red black tree.
****************************************************************/ 
import java.util.*;

public class RedBlackTreeTest

{
    //main method
    public static void main(String[] args)

    { 
        Scanner scan = new Scanner(System.in);

        RBTree rbt = new RBTree(Integer.MIN_VALUE);

        System.out.println("Red Black Tree Test\n");         

        char ch;

        do   

        {

            System.out.println("\nRed Black Tree Operations\n");

            System.out.println("1. insert ");

            System.out.println("2. search");

            System.out.println("3. count nodes");

            System.out.println("4. check empty");

            System.out.println("5. clear tree");

            int choice = scan.nextInt();           

            switch (choice)

            {

            case 1 :

                System.out.println("Enter integer element to insert");

                rbt.insert( scan.nextInt() );                    

                break;                         

            case 2 :

                System.out.println("Enter integer element to search");

                System.out.println("Search result : "+ rbt.search( scan.nextInt() ));

                break;                                          

            case 3 :

                System.out.println("Nodes = "+ rbt.countNodes());

                break;    

            case 4 :

                System.out.println("Empty status = "+ rbt.isEmpty());

                break;    

            case 5 :

                System.out.println("\nTree Cleared");

                rbt.makeEmpty();

                break;        

            default :

                System.out.println("Wrong Entry \n ");

                break;   

            }

            System.out.print("\nPost order : ");

            rbt.postorder();

            System.out.print("\nPre order : ");

            rbt.preorder();

            System.out.print("\nIn order : ");

            rbt.inorder();

            System.out.println("\nDo you want to continue (Type y or n) \n");

            ch = scan.next().charAt(0);                       

        } while (ch == 'Y'|| ch == 'y');              
    }//end main method
}// end class RedBlackTreeTest