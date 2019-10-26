/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jrmouro.grammaticalevolution.*;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class TestJUnitTest {

    public TestJUnitTest() {
    }

    
    

    @Test
    public void test() {
        
        Var var = new Var("X", 1);
        
        Op[] ops = {new Sum(), new ConstOne(), new Sin(), new VarOp(var)};
        
        int[] v = {0, 3, 2, 4, 5, 7};
        
        Op op = Op.ger(v, 0, ops);
        
                
        
        
        System.out.println(op);
        System.out.println(op.aval());
        

    }
}
