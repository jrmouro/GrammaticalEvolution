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
public class CartesianGenerator implements Generator {

    final Op[] ops;
    final Integer height;
    final Var var;

    public CartesianGenerator(Op[] ops, Var var, Integer height) {
        this.height = height;
        this.var = var;
        this.ops = ops;
    }

    @Override
    public Op generate(Integer[] vector) {
        
        return aux(vector, -1, 0);

    }

    private Op aux(Integer[] vector, int h, int n) {

        Op ret = new VarOp(this.var);
        //Op ret = new One();

        if (n < vector.length - 1 && h < this.height - 1) {
            
            int l = vector[n]%this.ops.length;
            
            int c = vector[n+1]%this.height;
            
            //if(c > h){
                
                ret = this.ops[l].getCopy();
                
                if(ret.nrOp()>0)
                    ret.add(aux(vector, h + 1, 2 * (n + 2) - 2));
                if(ret.nrOp()>1)
                    ret.add(aux(vector, h + 1, 2 * (n + 2)));
                
            //}
            
        }

        return ret;

    }

}
