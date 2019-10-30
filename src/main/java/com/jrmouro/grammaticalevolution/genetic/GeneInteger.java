/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution.genetic;

import java.util.Random;

/**
 *
 * @author ronaldo
 */
public class GeneInteger extends GeneList<Integer>{
    
    final int mz, leftBound, rightBound;
    final double mutateRate;

    public GeneInteger(int mz, int leftBound, int rightBound, double mutateRate) {
        this.mz = mz;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.mutateRate = mutateRate;
    }

    @Override
    public Gene<Integer> get(Integer[] alleles) {
        Gene<Integer> ret = new GeneInteger(this.mz, this.leftBound, this.rightBound, this.mutateRate);
        for (Integer allele : alleles) {
            ret.add(allele);
        }
        return ret;
    }
   

    @Override
    public int maxSize() {
        return mz;
    }
    
    public static GeneInteger random(int mz, int leftBound, int rightBound, double mutateRate){
        
        Random rnd = new Random();
        
        GeneInteger ret = new GeneInteger(mz, leftBound, rightBound, mutateRate);
        
        for (int i = 0; i < mz; i++) {
            ret.add(rnd.nextInt((rightBound - leftBound) + 1) + leftBound);
        }
        
        return ret;
    }

    @Override
    public Gene<Integer> mutate() {
        Random rnd = new Random();
        int r = rnd.nextInt(3);
        switch(r){
            case 0:
                return this.mutate0();
            case 1:
                return this.mutate1();
        }
        return this.mutate2();
    }
    
    private Gene<Integer> mutate0() {
        
        return GeneInteger.random(mz, leftBound, rightBound, mutateRate);
        
    }
    
    private Gene<Integer> mutate1() {
        
        GeneInteger ret = new GeneInteger(mz, leftBound, rightBound, mutateRate);
        
        for (int i = this.size() - 1; i >= 0; i--) {
            ret.add(this.get(i));
        }
        
        return ret;
    }    
    
    private Gene<Integer> mutate2() {
        
        Random rnd = new Random();
        GeneInteger ret = new GeneInteger(mz, leftBound, rightBound, mutateRate);
        
        for (int i = this.size() - 1; i >= 0; i--) {
            if(rnd.nextDouble() < this.mutateRate)
                ret.add(rnd.nextInt((rightBound - leftBound) + 1) + leftBound);
            else
                ret.add(this.get(i));
        }
        
        return ret;
    }

    @Override
    public Gene<Integer> copy() {
        GeneInteger ret = new GeneInteger(mz, leftBound, rightBound, mutateRate);
        for (int i = this.size() - 1; i >= 0; i--) {
            ret.add(this.get(i));
        }
        return ret;        
    }
    
    
    
    
}
