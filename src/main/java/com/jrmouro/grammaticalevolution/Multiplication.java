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
public class Multiplication extends Nop {

    @Override
    public double aval() {
        if (this.children.size() < 1) {
            return 0.0;
        } else if (this.children.size() < 2) {
            return this.children.get(0).aval();
        }
        return this.children.get(0).aval() * this.children.get(1).aval();
    }

    @Override
    public boolean term() {
        return false;
    }

    @Override
    public String toString() {
        if (this.children.size() < 1) {
            return "";
        } else if (this.children.size() < 2) {
            return this.children.get(0).toString();
        }

        return "(" + this.children.get(0).toString() + " * " + this.children.get(1).toString() + ")";
    }

    @Override
    public int nrOp() {
        return 2;
    }
    @Override
    public Op getCopy(){
        return new Multiplication();
    }
}
