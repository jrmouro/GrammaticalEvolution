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
public class Div extends EscTwo {

    public Div(double esc) {
        super(esc);
    }
    
    public Div() {
        super(1.0);
    }
    
    @Override
    public boolean[] escape() {
        boolean[] ret = {super.escape()[0], super.escape()[1]};
        if(this.children.size()>1)
            ret[1] = ret[1] || this.children.get(1).aval() == 0.0;
        return ret;
    }

    @Override
    public double aval() {
        
        if(this.escape()[0])        
            return super.aval();
        else if(this.escape()[1])
            return this.children.get(0).aval();
        
        return this.children.get(0).aval() / this.children.get(1).aval();
    }
    
    @Override
    public String toString() {

        if (this.escape()[0]) {
            return super.toString();
        } else if (this.escape()[1]) {
            return "("+ this.children.get(0).toString()+")";
        } 
        return "(" + this.children.get(0).toString() + " / " + this.children.get(1).toString() + ")";

    }

    
    @Override
    public Op getCopy(){
        return new Div(esc);
    }
}
