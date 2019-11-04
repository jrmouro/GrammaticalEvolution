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
public class Cons implements Op {

    double c;

    public Cons(double c) {
        this.c = c;
    }

    @Override
    public double aval() {
        return c;
    }

    @Override
    public String toString() {

        if (c < 0.0) {
            return "(" + String.valueOf(c) + ")";
        }
        
        return String.valueOf(c);
    }

    @Override
    public int nrOp() {
        return 0;
    }

    @Override
    public boolean term() {
        return true;
    }

    @Override
    public Op get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Op o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Op getCopy() {
        return new Cons(this.c);
    }

}
