/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution.genetic;

import com.jrmouro.genetic.fitnessfunction.FitnessFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.genetics.Chromosome;
import org.apache.commons.math3.genetics.ListPopulation;
import org.apache.commons.math3.genetics.Population;

/**
 *
 * @author ronaldo
 */
public class GeneIntegerPopulation  extends ListPopulation{

    public GeneIntegerPopulation(int populationLimit) throws NotPositiveException {
        super(populationLimit);
    }

    public GeneIntegerPopulation(List<Chromosome> chromosomes, int populationLimit) throws NullArgumentException, NotPositiveException, NumberIsTooLargeException {
        super(chromosomes, populationLimit);
    }
    
    @Override
    public Population nextGeneration() {
        Population ret = new GeneIntegerPopulation(this.getPopulationLimit());
        ret.addChromosome(this.getFittestChromosome());
        return ret;
    }
    
    public static GeneIntegerPopulation getRandom(  int size, 
                                                    int populationLimit, 
                                                    FitnessFunction<GeneInteger> fitnessFunction, 
                                                    int sizeChromosome, 
                                                    int leftBound, 
                                                    int rightBound, 
                                                    int mz,
                                                    double mutateRate){
        List<Chromosome> ret = new ArrayList();
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            ret.add(GeneIntegerChromosome.getRandom(fitnessFunction, sizeChromosome, leftBound, rightBound, mz, mutateRate));
        }
        return new GeneIntegerPopulation(ret, populationLimit);
    }
    
}
