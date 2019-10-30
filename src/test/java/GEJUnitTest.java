/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jrmouro.genetic.chromosome.ChromosomeAbstract;
import com.jrmouro.genetic.fitnessfunction.FitnessFunction;
import com.jrmouro.genetic.integer.IntegerChromosome;
import com.jrmouro.genetic.integer.IntegerGeneticAlgorithm;
import com.jrmouro.genetic.integer.IntegerStoppingCondition;
import com.jrmouro.grammaticalevolution.operators.Cos;
import com.jrmouro.grammaticalevolution.operators.Div;
import com.jrmouro.grammaticalevolution.operators.Exp;
import com.jrmouro.grammaticalevolution.operators.ExpE;
import com.jrmouro.grammaticalevolution.operators.GeneratorOp;
import com.jrmouro.grammaticalevolution.operators.Less;
import com.jrmouro.grammaticalevolution.operators.Ln;
import com.jrmouro.grammaticalevolution.operators.Log;
import com.jrmouro.grammaticalevolution.operators.Mult;
import com.jrmouro.grammaticalevolution.operators.One;
import com.jrmouro.grammaticalevolution.operators.Op;
import com.jrmouro.grammaticalevolution.operators.Pi;
import com.jrmouro.grammaticalevolution.operators.Sin;
import com.jrmouro.grammaticalevolution.operators.Sub;
import com.jrmouro.grammaticalevolution.operators.Sum;
import com.jrmouro.grammaticalevolution.operators.Var;
import com.jrmouro.grammaticalevolution.operators.VarOp;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class GEJUnitTest {

    public GEJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test() {

        double[][] dados
                = {
                    {10, 6.36},
                    {20, 9.9},
                    {30, 9.22},
                    {40, 11.81},
                    {50, 11.47},
                    {60, 11.98},
                    {70, 13.52},
                    {80, 12.15},
                    {90, 14.39},
                    {100, 13.31}
                };

        Var var = new Var("x", 1);

        Op[] ops = {
            new VarOp(var), 
            //new VarOp(var), 
            //new VarOp(var), 
            //new Sum(), 
            //new Sum(), 
            new Sum(), 
            new Sub(),
            new One(), 
            new Pi(),
            new Exp(),
            new Less(), 
            new Sin(), 
            new Cos(),
            new Log(),
            new Mult(), 
            new Div(),
            new ExpE(),
            new Ln()};
        
        GeneratorOp generator = new GeneratorOp(ops, 4);

        FitnessFunction<Integer> fitI = new FitnessFunction<Integer>() {

            @Override
            public double fitness(ChromosomeAbstract<Integer> ca) {

                Integer[] v = new Integer[ca.getRepresentation().size()];

                int i = 0;
                for (Integer integer : ca.getRepresentation()) {
                    v[i++] = integer;
                }
                
                

                Op op = generator.generate(v);

                Double ret = 0.0;

                for (double[] dado : dados) {
                    var.value = dado[0];
                    double a = op.aval();
                    
                    ret -= ((a - dado[1]) * (a - dado[1]));
                    
                    if(Double.isNaN(ret))
                        return -Double.MAX_VALUE;
                }

                return ret;
            }

        };

        IntegerGeneticAlgorithm ga = new IntegerGeneticAlgorithm(50, //population size
                60, //population limit
                fitI, // fitness function
                20, //chromosome size
                0, // left bound chromosome
                140, // right bound chormosome
                new IntegerStoppingCondition(600),
                5, // crossover points
                .3, // crossover rate
                .3, // mutation rate
                .3, // mutation arity
                3); // selection arity

        IntegerChromosome c = ga.run();
        Integer[] v = new Integer[c.getRepresentation().size()];

        int i = 0;
        for (Integer integer : c.getRepresentation()) {
            v[i++] = integer;
        }

        Op op = generator.generate(v);
        System.out.println(c);
        System.out.println(op);
        var.value = 20.75;
        System.out.println(op.aval());
        
       
        
        

    }
    
    
    
}
