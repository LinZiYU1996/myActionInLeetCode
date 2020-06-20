package Find.bst;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/19
 * \* Time: 19:57
 * \* Description:
 * \
 */
public class BstNode {

    int key;

    BstNode left, right;

    public BstNode() {
    }

    public BstNode(int key, BstNode left, BstNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public BstNode getLeft() {
        return left;
    }

    public void setLeft(BstNode left) {
        this.left = left;
    }

    public BstNode getRight() {
        return right;
    }

    public void setRight(BstNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BstNode{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
