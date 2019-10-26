/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public interface Op extends Cloneable {

    public double aval();

    public boolean term();

    public Op get(int i);

    public Op getCopy();

    public void add(Op o);

    public int nrOp();

    static Op ger(int[] v, int n, Op[] ops) {

        Op aux = null;

        if (n < v.length && ops.length > 0) {

            int r = v[n] % ops.length;

            aux = ops[r].getCopy();

            for (int i = 0, u = n + 1; i < aux.nrOp() && u < v.length; i++, u++) {
                aux.add(ger(v, u, ops));
            }

        }

        return aux;
    }

}
