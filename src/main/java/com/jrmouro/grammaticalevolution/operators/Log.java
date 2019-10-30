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
public class Log extends Nop{
    
    
    @Override
    public double aval() {
        
        if (this.children.size() < 1 || Double.isNaN(this.children.get(0).aval())) {
            return 1.0;
        }else if (this.children.size() < 2 || this.children.get(1).aval() < 0 || this.children.get(1).aval() == 0.0 || Double.isNaN(this.children.get(1).aval())) {
            return this.children.get(0).aval();
        }
                
        return Math.log(this.children.get(1).aval())/Math.log(this.children.get(0).aval());
        
    }
        
    @Override
    public Op getCopy() {
        return new Log();
    }

    @Override
    public int nrOp() {
        return 2;
    }
    
    @Override
    public String toString() {
        
        if (this.children.size() < 1 || Double.isNaN(this.children.get(0).aval())) {
            return "1.0";
        }else if (this.children.size() < 2 || this.children.get(1).aval() < 0 || this.children.get(1).aval() == 0.0 || Double.isNaN(this.children.get(1).aval())) {
            return this.children.get(0).toString();
        }
        
        return "log("+ this.children.get(0).toString() + ", " + this.children.get(1).toString() + ")";
        
    }
    
}
