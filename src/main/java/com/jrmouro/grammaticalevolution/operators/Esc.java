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
public abstract class Esc extends Nop{
    
    final double esc;

    public Esc(double esc) {
        this.esc = esc;
    } 

    public abstract boolean[] escape();

    @Override
    public String toString() {
        if(esc < 0.0)
            return "("+String.valueOf(esc)+")";
        return String.valueOf(esc);
    }

}
