/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution.genetic;

import com.jrmouro.genetic.fitnessfunction.FitnessFunction;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.genetics.CrossoverPolicy;
import org.apache.commons.math3.genetics.GeneticAlgorithm;
import org.apache.commons.math3.genetics.Population;
import org.apache.commons.math3.genetics.SelectionPolicy;
import org.apache.commons.math3.genetics.StoppingCondition;

/**
 *
 * @author ronaldo
 */
public class GeneIntegerGeneticAlgorithm extends GeneticAlgorithm{
    
    private Population initialPolulation = null;
    private StoppingCondition stoppingCondition = null;
    
    public GeneIntegerGeneticAlgorithm( StoppingCondition stoppingCondition,
                                        CrossoverPolicy crossoverPolicy, 
                                        SelectionPolicy selectionPolicy,
                                        FitnessFunction<GeneInteger> fitnessFunction, 
                                        int populationSize, 
                                        int populationLimit,
                                        int sizeChromosome,
                                        int leftBound,
                                        int rightBound,
                                        int mz,
                                        double crossoverRate,  
                                        double mutationRate, 
                                        double mutationRateGene) throws OutOfRangeException {
        
        super(crossoverPolicy, crossoverRate, new GeneIntegerMutation(mutationRateGene), mutationRate, selectionPolicy);
        
        this.stoppingCondition = stoppingCondition;
        
        this.initialPolulation = GeneIntegerPopulation.getRandom( 
                populationSize, 
                populationLimit, 
                fitnessFunction, 
                sizeChromosome, 
                leftBound, 
                rightBound,
                mz,
                mutationRateGene);
        
    }
    
    public GeneIntegerChromosome run() {
        return (GeneIntegerChromosome)this.evolve(initialPolulation, stoppingCondition).getFittestChromosome();
    }
    
}
