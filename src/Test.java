import static org.junit.Assert.assertEquals;

public class Test {
    @org.junit.jupiter.api.Test
    void Insertar() {
        BinarySearchTree prueba = new BinarySearchTree();
        assertEquals(null,prueba.root);
        assertEquals(true,prueba.isEmpty);
        prueba.insert("1","uno");
        assertEquals("1",prueba.root.Key);
        assertEquals(false,prueba.isEmpty);

        // Al insertar, compara el unicode de los Strings, por lo que numeros más grandes
        // iran a la derecha y más pequeños a la izquierda
        prueba.insert("2","dos");
        assertEquals("2",prueba.root.Right.Key);
        prueba.insert("0","cero");
        assertEquals("0",prueba.root.Left.Key);
    }
    @org.junit.jupiter.api.Test
    void Buscar() {
        BinarySearchTree prueba = new BinarySearchTree();
        assertEquals(null,prueba.search("1"));
        prueba.insert("1","uno");
        assertEquals("uno",prueba.search("1"));
        prueba.insert("2","dos");
        assertEquals("dos",prueba.search("2"));
    }
}
