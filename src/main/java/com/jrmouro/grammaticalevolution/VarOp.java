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
public class VarOp implements Op{
    
    final Var var;

    public VarOp(Var var) {
        this.var = var;
    }
    
    @Override
    public double aval() {
        return this.var.value;
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
    public Op getCopy(){
        return new VarOp(var);
    }

    @Override
    public String toString() {
        return var.toString();
    }
    
    
    
}
