/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution.operators;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public class MatrixGenerator  implements Generator{
    
    final Op[] ops;
    final Integer height;
    final Var var;

    public MatrixGenerator(Op[] ops, Integer height, Var var) {
        this.ops = ops;
        this.height = height;
        this.var = var;
    }
    
    

    @Override
    public Op generate(Integer[] vector) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private List<Op> list(Integer[] vector){
        
        List<Op> ret = new ArrayList();
        
        Boolean[][] matrix = MatrixGenerator.matrix(vector, 3, this.ops.length);
        
        if(vector.length > 3){
        
            int l1 = vector[0] % this.ops.length;
            int c1 = vector[1] % this.ops.length;
            int l2 = l1;
            int c2 = c1;
            
            ret.add(this.ops[l1].getCopy());
            
            boolean flag = vector[1] % 2 == 0;
            
            for (int i = 0; i < 10; i++) {
                
                if(flag){
                    
                    
                    
                }else{
                    
                    
                    
                }
                
            }
        
        }
        
        
        
        return ret;
    }
    
    
    private static Boolean[][] matrix(Integer[] vector, Integer first, Integer size){
        
        Boolean[][] ret = new Boolean[size][size];
        
        int a = first;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(a < vector.length)
                    ret[i][j] = vector[a++]%2 == 1;
                else
                    ret[i][j] = false;
            }
        }
        
        
        return ret;
        
    }
    
}
