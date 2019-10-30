/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution.genetic;

import com.jrmouro.genetic.chromosome.ChromosomeAbstract;
import com.jrmouro.genetic.fitnessfunction.FitnessFunction;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.genetics.AbstractListChromosome;
import org.apache.commons.math3.genetics.InvalidRepresentationException;

/**
 *
 * @author ronaldo
 */
public class GeneIntegerChromosome extends ChromosomeAbstract<GeneInteger>{
    
    final private FitnessFunction<GeneInteger> fitnessFunction;
    final private int leftBound, rightBound, mz;
    final private double mutateRate;

    public GeneIntegerChromosome(FitnessFunction<GeneInteger> fitnessFunction, int leftBound, int rightBound, int mz, double mutateRate, List<GeneInteger> representation) throws InvalidRepresentationException {
        super(representation);
        this.fitnessFunction = fitnessFunction;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.mz = mz;
        this.mutateRate = mutateRate;
    }

    public GeneIntegerChromosome(FitnessFunction<GeneInteger> fitnessFunction, int leftBound, int rightBound, int mz, double mutateRate, GeneInteger[] representation) throws InvalidRepresentationException {
        super(representation);
        this.fitnessFunction = fitnessFunction;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.mz = mz;
        this.mutateRate = mutateRate;
    }

    public GeneIntegerChromosome(FitnessFunction<GeneInteger> fitnessFunction, int leftBound, int rightBound, int mz, double mutateRate, List<GeneInteger> representation, boolean copyList) {
        super(representation, copyList);
        this.fitnessFunction = fitnessFunction;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.mz = mz;
        this.mutateRate = mutateRate;
    }
    
    public static GeneIntegerChromosome getRandom(FitnessFunction fitnessFunction, int size, int leftBound, int rightBound, int sizeGene, double mutateRate){
        List<GeneInteger> ret = new ArrayList();
        
        for (int i = 0; i < size; i++) {
            ret.add(GeneInteger.random(sizeGene, leftBound, rightBound, mutateRate));
        }
        return new GeneIntegerChromosome(fitnessFunction, leftBound, rightBound, sizeGene, mutateRate, ret);
    }
    
    @Override
    public ChromosomeAbstract<GeneInteger> getRandom() {
        return GeneIntegerChromosome.getRandom(fitnessFunction, this.getRepresentation().size(), leftBound, leftBound, rightBound, mutateRate);
    }

    @Override
    protected void checkValidity(List<GeneInteger> chromosomeRepresentation) throws InvalidRepresentationException {
        
    }

    @Override
    public AbstractListChromosome<GeneInteger> newFixedLengthChromosome(List<GeneInteger> representation) {
        return new  GeneIntegerChromosome(fitnessFunction, leftBound, rightBound, mz, mutateRate, representation);
    }

    @Override
    public double fitness() {
        return this.fitnessFunction.fitness(this);
    }

    @Override
    public ChromosomeAbstract evolve(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ChromosomeAbstract<GeneInteger> normalize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public FitnessFunction<GeneInteger> getFitnessFunction() {
        return fitnessFunction;
    }

    public int getLeftBound() {
        return leftBound;
    }

    public int getRightBound() {
        return rightBound;
    }

    public int getMz() {
        return mz;
    }

    public double getMutateRate() {
        return mutateRate;
    }
    
    
    
}
