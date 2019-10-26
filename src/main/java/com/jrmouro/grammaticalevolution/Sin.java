/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution;

/**
 *
 * @author ronaldo
 */
public class Sin extends Nop {

    @Override
    public double aval() {
        if (this.children.size() < 1) {
            return 0.0;
        }

        return Math.sin(this.children.get(0).aval());
    }

    @Override
    public boolean term() {
        return false;
    }

    @Override
    public String toString() {
        
        if (this.children.size() < 1) {
            return "";
        }

        if(this.children.get(0).term())
            return "sin(" + this.children.get(0).toString() + ")";
        
        return "sin" + this.children.get(0).toString();
    }

    @Override
    public int nrOp() {
        return 1;
    }
    
    @Override
    public Op getCopy(){
        return new Sin();
    }
}
