/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution.genetic;

/**
 *
 * @author ronaldo
 * @param <T>
 */
public interface Gene<T>{
    public int size();
    public int maxSize();
    public void add(T i);
    public T get(Integer index);  
    public void set(T allele, Integer index);  
    public Gene<T> get(T[] alleles);
    public Gene<T> copy();
    public Gene<T> mutate();
}
