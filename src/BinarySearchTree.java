public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(String key, String value) {
        TreeNode newNode = new TreeNode(key, value);

        if (this.root == null) {
            this.root = newNode;
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
            System.out.println("Clave: " + actualNode.Key + ", Valor: " + actualNode.Value);
            if (actualNode.Left != null) {
                System.out.println("Relación con nodo izquierdo: Clave: " + actualNode.Left.Key + ", Valor: " + actualNode.Left.Value);
            }
            if (actualNode.Right != null) {
                System.out.println("Relación con nodo derecho: Clave: " + actualNode.Right.Key + ", Valor: " + actualNode.Right.Value);
            }
            printAsociacionesInternas(actualNode.Left);
            printAsociacionesInternas(actualNode.Right);
        }
    }
}