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
public class ConstPi extends Const{

    public ConstPi(double c) {
        super(3.14159265359);
    }

    @Override
    public String toString() {
        return "PI";
    }

}
