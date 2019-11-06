/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jrmouro.grammaticalevolution.operators.Div;
import com.jrmouro.grammaticalevolution.operators.Sub;
import com.jrmouro.grammaticalevolution.operators.Op;
import com.jrmouro.grammaticalevolution.operators.Cos;
import com.jrmouro.grammaticalevolution.operators.Sin;
import com.jrmouro.grammaticalevolution.operators.Var;
import com.jrmouro.grammaticalevolution.operators.One;
import com.jrmouro.grammaticalevolution.operators.Sum;
import com.jrmouro.grammaticalevolution.operators.Mult;
import com.jrmouro.grammaticalevolution.operators.Less;
import com.jrmouro.grammaticalevolution.operators.Ln;
import com.jrmouro.grammaticalevolution.operators.VarOp;
import com.jrmouro.grammaticalevolution.operators.ExpE;
import com.jrmouro.grammaticalevolution.operators.OpGenerator;
import com.jrmouro.grammaticalevolution.operators.Pi;
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
        
        
        
        Var var = new Var("x", 1);
        
        Op[] ops = {
            new Sum(), 
            new Sub(),
            new One(), 
            new Pi(),
            new ExpE(),
            new Less(), 
            new Sin(), 
            new Cos(),
            new VarOp(var), 
            new VarOp(var), 
            new VarOp(var), 
            new Mult(), 
            new Div(),
            new Ln()};
        
        Integer[] v = {123, 59, 125, 15, 38, 83, 43, 66, 76, 67};
        
        
        OpGenerator g = new OpGenerator(ops, var);
        
        Op op = g.generate(v);
        
                
        
        
        System.out.println(op);
        System.out.println(op.aval());
        

    }
}
