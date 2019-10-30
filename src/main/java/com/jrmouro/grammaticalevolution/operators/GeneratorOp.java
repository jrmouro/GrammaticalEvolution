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
public class GeneratorOp {
    
    protected final Op[] ops;
    private Integer index = 0;
    private Integer height = Integer.MAX_VALUE;

    public GeneratorOp(Op[] ops) {
        this.ops = ops;
    }
    
    public GeneratorOp(Op[] ops, Integer height) {
        this.ops = ops;
        this.height = height;
    }
    
    
    public Op generate(Integer[] vector){
        this.index = 0;
        if (this.ops != null)
            return this.generateAux(vector, 0);
        return new Nil();
    }    
    
    private Op generateAux(Integer[] vector, Integer h){
        
        Op aux = new Nil();

        if (h <= this.height && this.index < vector.length && ops.length > 0) {

            int r = vector[this.index++] % ops.length;

            aux = ops[r].getCopy();

            for (int i = 0; i < aux.nrOp() && this.index < vector.length - 1; i++) {
                aux.add(generateAux(vector, h + 1));
            }

        }

        return aux;
    }
    
}