/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cadastroclient.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Maiara
 */
public class MovimentacaoTest {
    
    public MovimentacaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getIdMovimento method, of class Movimentacao.
     */
    @Test
    public void testGetIdMovimento() {
        System.out.println("getIdMovimento");
        Movimentacao instance = new Movimentacao();
        Integer expResult = null;
        Integer result = instance.getIdMovimento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdMovimento method, of class Movimentacao.
     */
    @Test
    public void testSetIdMovimento() {
        System.out.println("setIdMovimento");
        Integer idMovimento = null;
        Movimentacao instance = new Movimentacao();
        instance.setIdMovimento(idMovimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantidade method, of class Movimentacao.
     */
    @Test
    public void testGetQuantidade() {
        System.out.println("getQuantidade");
        Movimentacao instance = new Movimentacao();
        int expResult = 0;
        int result = instance.getQuantidade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantidade method, of class Movimentacao.
     */
    @Test
    public void testSetQuantidade() {
        System.out.println("setQuantidade");
        int quantidade = 0;
        Movimentacao instance = new Movimentacao();
        instance.setQuantidade(quantidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Movimentacao.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Movimentacao instance = new Movimentacao();
        Character expResult = null;
        Character result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo method, of class Movimentacao.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        Character tipo = null;
        Movimentacao instance = new Movimentacao();
        instance.setTipo(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorUnitario method, of class Movimentacao.
     */
    @Test
    public void testGetValorUnitario() {
        System.out.println("getValorUnitario");
        Movimentacao instance = new Movimentacao();
        Double expResult = null;
        Double result = instance.getValorUnitario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorUnitario method, of class Movimentacao.
     */
    @Test
    public void testSetValorUnitario() {
        System.out.println("setValorUnitario");
        Double valorUnitario = null;
        Movimentacao instance = new Movimentacao();
        instance.setValorUnitario(valorUnitario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdPessoa method, of class Movimentacao.
     */
    @Test
    public void testGetIdPessoa() {
        System.out.println("getIdPessoa");
        Movimentacao instance = new Movimentacao();
        Pessoa expResult = null;
        Pessoa result = instance.getIdPessoa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdPessoa method, of class Movimentacao.
     */
    @Test
    public void testSetIdPessoa() {
        System.out.println("setIdPessoa");
        Pessoa idPessoa = null;
        Movimentacao instance = new Movimentacao();
        instance.setIdPessoa(idPessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdProduto method, of class Movimentacao.
     */
    @Test
    public void testGetIdProduto() {
        System.out.println("getIdProduto");
        Movimentacao instance = new Movimentacao();
        Produto expResult = null;
        Produto result = instance.getIdProduto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdProduto method, of class Movimentacao.
     */
    @Test
    public void testSetIdProduto() {
        System.out.println("setIdProduto");
        Produto idProduto = null;
        Movimentacao instance = new Movimentacao();
        instance.setIdProduto(idProduto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdUsuario method, of class Movimentacao.
     */
    @Test
    public void testGetIdUsuario() {
        System.out.println("getIdUsuario");
        Movimentacao instance = new Movimentacao();
        Usuario expResult = null;
        Usuario result = instance.getIdUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdUsuario method, of class Movimentacao.
     */
    @Test
    public void testSetIdUsuario() {
        System.out.println("setIdUsuario");
        Usuario idUsuario = null;
        Movimentacao instance = new Movimentacao();
        instance.setIdUsuario(idUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Movimentacao.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Movimentacao instance = new Movimentacao();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Movimentacao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Movimentacao instance = new Movimentacao();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Movimentacao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Movimentacao instance = new Movimentacao();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
