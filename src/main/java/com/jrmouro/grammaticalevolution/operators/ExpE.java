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
public class ExpE  extends ExpB{

    public ExpE() {
        super(2.718281828);
    }
    
    @Override
    public Op getCopy() {
        return new ExpE();
    }
    
     @Override
    public String toString() {
        
        if (this.children.size() < 1 || Double.isNaN(this.children.get(0).aval())) {
            return "1.0";
        }

        //if(this.children.get(0).term())
            //return "exp_e(" + this.children.get(0).toString() + ")";
        return "exp(" + this.children.get(0).toString() + ")";
        //return "exp_e " + this.children.get(0).toString();
    }
}
