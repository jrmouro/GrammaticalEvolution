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
public class ExpB extends Nop{
    
    private final double base;

    public ExpB(double base) {
        this.base = base;
    }

    @Override
    public double aval() {
        
        if(this.children.size() < 1 || Double.isNaN(this.children.get(0).aval())){
            return 1.0;
        }
        
        double ret = Math.pow(base, this.children.get(0).aval());
        
        if(Double.isNaN(ret))
            return 1.0;
        
        return ret;
    }
    
    @Override
    public Op getCopy() {
        return new ExpB(this.base);
    }

    @Override
    public int nrOp() {
        return 1;
    }
    
     @Override
    public String toString() {
        
        if (this.children.size() < 1 || Double.isNaN(this.children.get(0).aval())) {
            return "1.0";
        }

        //if(this.children.get(0).term())
            //return "exp_"+String.valueOf(this.base)+"(" + this.children.get(0).toString() + ")";
        return String.valueOf(this.base)+ "^" + this.children.get(0).toString();
        //return "exp_"+String.valueOf(this.base)+ " " + this.children.get(0).toString();
    }
}
