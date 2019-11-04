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
public class Ln extends EscOne{
    
    public Ln() {
        super(1.0);
    }

    public Ln(double esc) {
        super(esc);
    }
    
    @Override
    public boolean[] escape() {
        boolean[] ret = {super.escape()[0]};
        if(this.children.size() > 0)
            ret[0] = ret[0] || this.children.get(0).aval() <= 0;
                    
        return ret;
    }
        
    @Override
    public double aval() {
        
        if(escape()[0])
            return super.aval();
        
        return Math.log(this.children.get(0).aval());
        
    }

    @Override
    public Op getCopy() {
        return new Ln(esc);
    }
        
    @Override
    public String toString() {
        
        if(escape()[0])
            return super.toString(); 

        return "log(" + this.children.get(0).toString() + ")";
        
    }
    
}
