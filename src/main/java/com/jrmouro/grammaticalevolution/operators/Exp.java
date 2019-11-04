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
public class Exp extends EscTwo{

    public Exp() {
        super(1.0);
    }
    
    public Exp(double esc) {
        super(esc);
    }
        
    @Override
    public double aval() {
        
        if(this.escape()[0])        
            return super.aval();
        else if(this.escape()[1])
            return this.children.get(0).aval();
        
        return Math.pow(this.children.get(0).aval(), this.children.get(1).aval());
        
    }
    
    @Override
    public Op getCopy() {
        return new Exp(esc);
    }
    
     @Override
    public String toString() {
        
         if (this.escape()[0]) {
            return super.toString();
        } else if (this.escape()[1]) {
            return "("+ this.children.get(0).toString()+")";
        } 
        return "(" + this.children.get(0).toString() + " ** " + this.children.get(1).toString() + ")"; 
        
    }
}
