/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.grammaticalevolution.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public abstract class Nop implements Op, Iterable<Op> {

    List<Op> children = new ArrayList();

    @Override
    public void add(Op o) {
        if (!this.term() && this.nrOp() > this.children.size()) {
            if(o == null || Double.isNaN(o.aval()))
                this.children.add(new Nil());
            else
                this.children.add(o);
        }
    }

    @Override
    public Op get(int i) {
        if (this.children.size() > i) {
            return this.children.get(i);
        }
        return null;
    }

    @Override
    public Iterator<Op> iterator() {
        return this.children.iterator();
    }

    @Override
    public boolean term() {
        //return false;
        return this.nrOp() == 0;
    }

    
}
