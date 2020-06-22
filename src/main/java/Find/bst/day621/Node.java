package Find.bst.day621;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/21
 * \* Time: 20:22
 * \* Description:
 * \
 */
public class Node {
    public int id;
    public String name;
    public Node leftChild;
    public Node rightChild;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }
}