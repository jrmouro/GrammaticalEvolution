/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jrmouro.genetic.chromosome.ChromosomeAbstract;
import com.jrmouro.genetic.fitnessfunction.FitnessFunction;
import com.jrmouro.genetic.integer.IntegerChromosome;
import com.jrmouro.genetic.integer.IntegerGeneticAlgorithm;
import com.jrmouro.genetic.integer.VectorPointsIntegerCrossover;
import com.jrmouro.grammaticalevolution.genetic.CompositeStoppingCondition;
import com.jrmouro.grammaticalevolution.operators.CartesianGenerator;
import com.jrmouro.grammaticalevolution.operators.Cos;
import com.jrmouro.grammaticalevolution.operators.Div;
import com.jrmouro.grammaticalevolution.operators.Exp;
import com.jrmouro.grammaticalevolution.operators.ExpB;
import com.jrmouro.grammaticalevolution.operators.ExpE;
import com.jrmouro.grammaticalevolution.operators.Generator;
import com.jrmouro.grammaticalevolution.operators.Less;
import com.jrmouro.grammaticalevolution.operators.Ln;
import com.jrmouro.grammaticalevolution.operators.Log10;
import com.jrmouro.grammaticalevolution.operators.Mult;
import com.jrmouro.grammaticalevolution.operators.One;
import com.jrmouro.grammaticalevolution.operators.Op;
import com.jrmouro.grammaticalevolution.operators.Pi;
import com.jrmouro.grammaticalevolution.operators.Sin;
import com.jrmouro.grammaticalevolution.operators.Sub;
import com.jrmouro.grammaticalevolution.operators.Sum;
import com.jrmouro.grammaticalevolution.operators.Var;
import com.jrmouro.grammaticalevolution.operators.VarOp;
import com.jrmouro.plot.CanonicalPath;
import com.jrmouro.plot.FunctionPlottable;
import com.jrmouro.plot.Plottable;
import com.jrmouro.plot.PointsFunctionPlottable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    public void test() throws IOException {

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
            new Sum(),
            new Sum(),
            new Sum(),
            new Sub(),
            new Sub(),
            new Sub(),
            new Mult(),
            new Mult(),
            new Mult(),
            new Div(),
            new Div(),
            new Div(),
            new One(),
            new Pi(),
            new Exp(),
            new Less(),
            new Sin(),
            new Cos(),
            new Mult(),
            new Div(),
            new ExpE(),
            new ExpB(1.0),
            new Ln(),
            new Log10()
        };

        Generator generator = new CartesianGenerator(ops, var, 40);

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

                    if (Double.isNaN(ret)) {
                        return -Double.MAX_VALUE;
                    }
                }

                return ret;
            }

        };

        //Integer[] vectorCrossover = {1, 3, 6, 12, 18};
        IntegerGeneticAlgorithm ga = new IntegerGeneticAlgorithm(
                100, //population size
                5, // population reuse
                100, //population limit
                fitI, // fitness function
                100, //chromosome size
                0, // left bound chromosome
                Integer.MAX_VALUE - 1, // right bound chormosome
                new CompositeStoppingCondition(300, -0.1),
                new VectorPointsIntegerCrossover(100, 1),
                .5, // crossover rate
                .5, // mutation rate
                .3, // mutation rate2
                2); // selection arity

        IntegerChromosome c = ga.run();
        Integer[] v = new Integer[c.getRepresentation().size()];

        int i = 0;
        for (Integer integer : c.getRepresentation()) {
            v[i++] = integer;
        }

        Op op = generator.generate(v);
        System.out.println(c);
        System.out.println(op);

        List<String> sets = new ArrayList();

        sets.add("title 'Test'");
        sets.add("xlabel 'time'");
        sets.add("ylabel 'volume'");
        sets.add("grid");
        sets.add("xrange [0:100]");
        sets.add("yrange [0:20]");
        sets.add("style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2");

        Plottable p = new PointsFunctionPlottable(
                dados,
                op.toString(),
                sets,
                CanonicalPath.getPath("data.txt"),
                CanonicalPath.getPath("rep.plot"));

        p.plot();

        List<String> functions = new ArrayList();
        functions.add("log(x**3) + sin(x)");
        functions.add(op.toString());

        Plottable p2 = new FunctionPlottable(functions, sets, CanonicalPath.getPath("rep2.plot"));
        p2.plot();

    }

}
