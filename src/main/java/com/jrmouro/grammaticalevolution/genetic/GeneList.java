/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution.genetic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ronaldo
 * @param <T>
 */
public abstract class GeneList<T> implements Gene<T>, Iterable<T>{
    
    private final List<T> alleles = new ArrayList();
    
    @Override
    public Iterator<T> iterator() {
        return this.alleles.iterator();
    }

    @Override
    public void add(T i) {
        if(this.alleles.size() < this.maxSize())
            this.alleles.add(i);
    }

    @Override
    public int size(){
        return this.alleles.size();
    }
    
    

    @Override
    public T get(Integer index) {
        if(index < this.alleles.size())
            return this.alleles.get(index);
        return null;
    }

    @Override
    public void set(T allele, Integer index) {
        if(index < this.alleles.size())
            this.alleles.set(index, allele);
    }
    
    
    
}
