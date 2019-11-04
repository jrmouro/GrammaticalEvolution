/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution.operators;

/**
 *
 * @author ronaldo
 */
public abstract class EscOne extends Esc{

    public EscOne(double esc) {
        super(esc);
    }

    @Override
    public boolean[] escape() {
        boolean[] ret = {this.children.size() < 1 || 
                !Double.isFinite(this.children.get(0).aval())};
        return ret;
    }        

    @Override
    public double aval() {
        return esc;
    }
    
    @Override
    public int nrOp() {
        return 1;
    }
    
}
