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
public abstract class EscTwo extends EscOne{
    
    public EscTwo(double esc) {
        super(esc);
    }

    @Override
    public boolean[] escape() {
        
        boolean[] ret = { super.escape()[0], false};
        
        if(this.children.size() < 2 || !Double.isFinite(this.children.get(1).aval()))
            ret[1] = true;
        
        return ret;
        
    }
               
    @Override
    public int nrOp() {
        return 2;
    }
}
