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
public class LogB  extends Nop{
    
    private final double base;

    public LogB(double base) {
        this.base = base;
    }

    @Override
    public double aval() {
        
        if (this.children.size() < 1 || this.children.get(0).aval() < 0 || Double.isNaN(this.children.get(0).aval())) {
            return 1.0;
        }
        
        return Math.log(this.children.get(0).aval())/Math.log(base);
    }
        
    @Override
    public Op getCopy() {
        return new LogB(this.base);
    }

    @Override
    public int nrOp() {
        return 1;
    }
    
    @Override
    public String toString() {
        
        if (this.children.size() < 1 || this.children.get(0).aval() < 0 || Double.isNaN(this.children.get(0).aval())) {
            return "1.0";
        }

        //if(this.children.get(0).term())
            //return "log_"+String.valueOf(this.base)+"(" + this.children.get(0).toString() + ")";
        return "log("+String.valueOf(this.base)+", " + this.children.get(0).toString() + ")";
        //return "log_"+String.valueOf(this.base) +" "+ this.children.get(0).toString();
    }
    
    
}
