/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution.operators;

import java.util.Random;

/**
 *
 * @author ronaldo
 */
public class Rnd  extends Cons{
    
    public Rnd() {
        super(new Random().nextDouble());
    }
    
}
