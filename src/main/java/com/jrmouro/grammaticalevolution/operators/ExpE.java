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
    
    public ExpE(double esc) {
        super(2.718281828, esc);
    }

    public ExpE() {
        super(2.718281828);
    }
    
    @Override
    public Op getCopy() {
        return new ExpE(esc);
    }
    
     @Override
    public String toString() {
        
        if(escape()[0])
            return super.toString(); 
        
        return "exp(" + this.children.get(0).toString() + ")";
        
    }
}
