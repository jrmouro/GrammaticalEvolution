/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution.operators;

import com.jrmouro.grammaticalevolution.genetic.GeneInteger;

/**
 *
 * @author ronaldo
 */
public interface Op extends Cloneable {

    public double aval();

    public boolean term();

    public Op get(int i);

    public Op getCopy();

    public void add(Op o);

    public int nrOp();
   

}
