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
public class Cos extends Nop {

    @Override
    public double aval() {
        
        if (this.children.size() < 1 || Double.isNaN(this.children.get(0).aval())) {
            return 1.0;
        }

        return Math.cos(this.children.get(0).aval());
    }
    
    @Override
    public String toString() {
        
        if (this.children.size() < 1 || Double.isNaN(this.children.get(0).aval())) {
            return "1.0";
        }

        //if(this.children.get(0).term())
            return "cos(" + this.children.get(0).toString() + ")";
        
        //return "cos " + this.children.get(0).toString();
    }

    @Override
    public int nrOp() {
        return 1;
    }
    
    @Override
    public Op getCopy(){
        return new Cos();
    }
    
}
