/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution.genetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.genetics.Chromosome;
import org.apache.commons.math3.genetics.MutationPolicy;

/**
 *
 * @author ronaldo
 */
public class GeneIntegerMutation implements MutationPolicy{
    
    final double rate;

    public GeneIntegerMutation(double rate) {
        this.rate = rate;
    }
    

    @Override
    public Chromosome mutate(Chromosome original) throws MathIllegalArgumentException {
        
        if (!(original instanceof GeneIntegerChromosome)) {
            try {
                throw new Exception("GeneIntegerMutation works only with GeneIntegerChromosome");
            } catch (Exception ex) {
                Logger.getLogger(GeneIntegerMutation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Random rand = new Random();
        
        List<GeneInteger> list = new ArrayList();
        
        for (GeneInteger gene : ((GeneIntegerChromosome)original).getRepresentation()) {
            if(rand.nextDouble() < this.rate)
                list.add((GeneInteger) gene.mutate());
            else
                list.add((GeneInteger) gene.copy());
        }        
        
        return new GeneIntegerChromosome(((
                GeneIntegerChromosome)original).getFitnessFunction(),
                ((GeneIntegerChromosome)original).getLeftBound(),
                ((GeneIntegerChromosome)original).getRightBound(),
                ((GeneIntegerChromosome)original).getMz(),
                ((GeneIntegerChromosome)original).getMutateRate(),
                list);
        
    }
    
}
