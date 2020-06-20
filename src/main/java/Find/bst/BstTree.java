package Find.bst;

import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/19
 * \* Time: 19:58
 * \* Description:
 * \
 */
public class BstTree {


    BstNode root;

    boolean insert(BstNode node, int key) {

        BstNode f = null, p = node;

        while ( p != null) {
            if (p.key == key) {
                return false;
            }
            f = p;
            if (key < p.key) {
                p = p.left;
            } else {
                p = p.right;
            }
        }


        p = new BstNode();

        p.key = key;

        p.left = p.right = null;

        if (node == null) {
            node = p;
            System.out.println(node.toString());
        } else if (key < f.key) {
            f.left = p;
        } else {
            f.right = p;
        }

        return true;
    }

    void create(BstNode node, int[] d, int n) {
        node = null;

        int i = 0;

        while (i < n) {
            insert(node, d[i]);
            i++;
        }
    }

    void display(BstNode node) {
        if (node != null) {

            System.out.println(node.key);
            if (node.left != null || node.right != null) {
                System.out.println("(");
                display(node.left);
                if (node.right != null) {
                    System.out.println(",");
                }
                display(node.right);
                System.out.println(")");
            }
        }
    }

    public static void main(String[] args) {

        Random random = new Random();

        int[] s = new int[10];

        for (int i = 0; i < s.length; i++) {
            s[i] = random.nextInt(100);
        }

        BstTree tree = new BstTree();

        BstNode node = null;
        tree.create(tree.root, s, s.length);

        tree.display(tree.root);
        System.out.println(tree.root);
    }
}
