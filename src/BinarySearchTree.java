public class BinarySearchTree {

    /*
     * Estructura general del BST obtenida de ChatGPT
     * Alterada y simplificada para los propósitos de la hoja de trabajo
     *
     */

    TreeNode root;
    boolean isEmpty;

    public BinarySearchTree() {
        this.root = null;
        isEmpty = true;
    }

    public void insert(String key, String value) {
        TreeNode newNode = new TreeNode(key, value);

        if (this.root == null) {
            this.root = newNode;
            isEmpty=false;
        } else {
            internalInsert(this.root, newNode);
        }
    }

    private void internalInsert(TreeNode actualNode, TreeNode newNode) {
        if (actualNode.Key.compareTo(newNode.Key) > 0) {
            if (actualNode.Left == null) {
                actualNode.Left = newNode;
            } else {
                internalInsert(actualNode.Left, newNode);
            }
        } else if (actualNode.Key.compareTo(newNode.Key) < 0) {
            if (actualNode.Right == null) {
                actualNode.Right = newNode;
            } else {
                internalInsert(actualNode.Right, newNode);
            }
        } else {
            actualNode.Value = newNode.Value;
        }
    }

    public String search(String key) {
        TreeNode actualNode = this.root;

        while (actualNode != null) {
            if (actualNode.Key.compareTo(key) > 0) {
                actualNode = actualNode.Left;
            } else if (actualNode.Key.compareTo(key) < 0) {
                actualNode = actualNode.Right;
            } else {
                return actualNode.Value;
            }
        }

        return null;
    }

    public void printAsociaciones() {
        printAsociacionesInternas(this.root);
    }

    private void printAsociacionesInternas(TreeNode actualNode) {
        if (actualNode != null) {
            System.out.println("(" + actualNode.Key + "," + actualNode.Value+")");
            printAsociacionesInternas(actualNode.Left);
            printAsociacionesInternas(actualNode.Right);
        }
    }
}