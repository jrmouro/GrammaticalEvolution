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
public class Ln extends Nop{

    @Override
    public double aval() {
        
        if (this.children.size() < 1 || this.children.get(0).aval() <= 0  || Double.isNaN(this.children.get(0).aval())){
            return 1.0;
        }
        
        return Math.log(this.children.get(0).aval());
    }

    @Override
    public Op getCopy() {
        return new Ln();
    }

    @Override
    public int nrOp() {
        return 1;
    }
        
    @Override
    public String toString() {
        
        if (this.children.size() < 1  || this.children.get(0).aval() <= 0) {
            return "1.0";
        }

        //if(this.children.get(0).term())
            //return "ln(" + this.children.get(0).toString() + ")";
        return "log(" + this.children.get(0).toString() + ")";
        //return "ln "+ this.children.get(0).toString();
    }
    
}
