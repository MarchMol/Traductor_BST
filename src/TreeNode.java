public class TreeNode {

    /*
     * Estructura general del TreeNode obtenida de ChatGPT
     * Alterada y simplificada para los propósitos de la hoja de trabajo
     *
     */

    String Key;
    String Value;

    TreeNode Left;
    TreeNode Right;

    public TreeNode(String Key, String Value) {
        this.Key = Key;
        this.Value = Value;
        this.Left = null;
        this.Right = null;
    }
}