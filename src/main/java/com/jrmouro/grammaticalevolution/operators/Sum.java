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
public class Sum extends Nop {

    @Override
    public double aval() {

        if (this.children.size() < 1 || Double.isNaN(this.children.get(0).aval())) {
            return 1.0;
        } else if (this.children.size() < 2 || Double.isNaN(this.children.get(1).aval())) {
            return this.children.get(0).aval();
        }

        return this.children.get(0).aval() + this.children.get(1).aval();

    }

    @Override
    public String toString() {

        if (this.children.size() < 1 || Double.isNaN(this.children.get(0).aval())) {
            return "1.0";
        } else if (this.children.size() < 2 || Double.isNaN(this.children.get(1).aval())) {
            return this.children.get(0).toString();
        }

        return "(" + this.children.get(0).toString() + " + " + this.children.get(1).toString() + ")";
    }

    @Override
    public int nrOp() {
        return 2;
    }

    @Override
    public Op getCopy(){
        return new Sum();
    }
    
    
}
