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
public class Cos extends EscOne {

    public Cos() {
        super(1.0);
    }
    
    public Cos(double esc) {
        super(esc);
    }

    @Override
    public double aval() {
        
        if(escape()[0])
            return super.aval();       

        return Math.cos(this.children.get(0).aval());
    }
    
    @Override
    public String toString() {
        
        if(escape()[0])
            return super.toString(); 

        return "cos(" + this.children.get(0).toString() + ")";
    }
        
    @Override
    public Op getCopy(){
        return new Cos(esc);
    }
    
}
