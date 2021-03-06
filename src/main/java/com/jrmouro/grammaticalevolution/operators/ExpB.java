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
public class ExpB extends EscOne{
    
    private final double base;

    public ExpB(double base) {
        super(1.0);
        this.base = base;
    }
    
    public ExpB(double base, double esc) {
        super(esc);
        this.base = base;
    }

    @Override
    public double aval() {
        
        if(this.escape()[0])        
            return super.aval();
                
        return Math.pow(base, this.children.get(0).aval());       
        
    }
    
    @Override
    public Op getCopy() {
        return new ExpB(this.base, esc);
    }
    
     @Override
    public String toString() {
        
        if(escape()[0])
            return super.toString(); 

        return "("+ String.valueOf(this.base)+ "**" + this.children.get(0).toString()+ ")";
    }
}
