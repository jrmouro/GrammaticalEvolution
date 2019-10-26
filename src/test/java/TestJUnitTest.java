/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class TestJUnitTest {

    public TestJUnitTest() {
    }

    public static interface op {

        public double aval();

        public boolean term();

        public op get(int i);

        public void add(op o);

    }

    public static abstract class Nop implements op, Iterable<op> {

        List<op> children = new ArrayList();

        @Override
        public void add(op o) {
            if (!this.term()) {
                this.children.add(o);
            }
        }

        @Override
        public op get(int i) {
            if (this.children.size() > i) {
                return this.children.get(i);
            }
            return null;
        }

        @Override
        public Iterator<op> iterator() {
            return this.children.iterator();
        }

    }

    public static class Um extends Nop {

        @Override
        public double aval() {
            return 1.0;
        }

        @Override
        public boolean term() {
            return true;
        }

        @Override
        public String toString() {
            return "1.0";
        }

    }

    public static class Md {

        public double d = 0;
    }

    public static class X extends Nop {

        public Md md;

        public X(Md md) {
            this.md = md;
        }

        @Override
        public double aval() {
            return md.d;
        }

        @Override
        public boolean term() {
            return true;
        }

        @Override
        public String toString() {
            return "X";
        }

    }

    public static class mais extends Nop {

        @Override
        public double aval() {
            
            if(this.children.size() < 1)
                return 0.0;
            else if(this.children.size() < 2)
                return this.children.get(0).aval();  
            
            return this.children.get(0).aval() + this.children.get(1).aval();
            
        }

        @Override
        public boolean term() {
            return false;
        }

        @Override
        public String toString() {
            
            if(this.children.size() < 1)
                return "";
            else if(this.children.size() < 2)
                return this.children.get(0).toString();  
            
            return "(" + this.children.get(0) + " + " + this.children.get(1) + ")";
        }

    }

    public static class menos extends Nop {

        @Override
        public double aval() {
            if(this.children.size() < 1)
                return 0.0;
            else if(this.children.size() < 2)
                return this.children.get(0).aval(); 
            return this.children.get(0).aval() - this.children.get(1).aval();
        }

        @Override
        public boolean term() {
            return false;
        }

        @Override
        public String toString() {
            
            if(this.children.size() < 1)
                return "";
            else if(this.children.size() < 2)
                return this.children.get(0).toString();  
            
            return "(" + this.children.get(0) + " - " + this.children.get(1) + ")";
        }

    }

    public static class vezes extends Nop {

        @Override
        public double aval() {
            if(this.children.size() < 1)
                return 0.0;
            else if(this.children.size() < 2)
                return this.children.get(0).aval(); 
            return this.children.get(0).aval() * this.children.get(1).aval();
        }

        @Override
        public boolean term() {
            return false;
        }

        @Override
        public String toString() {
            if(this.children.size() < 1)
                return "";
            else if(this.children.size() < 2)
                return this.children.get(0).toString();  
            
            return "(" + this.children.get(0) + " * " + this.children.get(1) + ")";
        }

    }

    public static class div extends Nop {

        @Override
        public double aval() {
            if(this.children.size() < 1)
                return 0.0;
            else if(this.children.size() < 2)
                return this.children.get(0).aval(); 
            return this.children.get(0).aval() / this.children.get(1).aval();
        }

        @Override
        public boolean term() {
            return false;
        }

        @Override
        public String toString() {
            
            if(this.children.size() < 1)
                return "";
            else if(this.children.size() < 2)
                return this.children.get(0).toString();            
            
            return "(" + this.children.get(0) + " / " + this.children.get(1) + ")";
            
        }

    }

    static op ger(int[] v, int n, Md md) {

        op aux = null;
        
        if (n < v.length) {           

            int r;

            if (n < v.length - 2) {
                r = v[n] % 6;
            } else {
                r = v[n] % 2;
            }

            switch (r) {
                case 0:
                    return new X(md);
                case 1:
                    return new Um();
                case 2:
                    aux = new mais();
                    break;
                case 3:
                    aux = new menos();
                    break;
                case 4:
                    aux = new vezes();
                    break;
                case 5:
                    aux = new div();
                    break;
            }
            
            aux.add(ger(v,n+1,md));
            aux.add(ger(v,n+2,md));
            
        }
        
        return aux;
        
    }

    

    @Test
    public void test() {
        
        Md md = new Md();
        
        int [] v = {8, 9, 1, 1, 0, 3};
        
        op o = ger(v, 0, md);

        System.out.println("= " + o.toString());
        
        System.out.println("f(x=0) = " + o.aval());

    }
}
