/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade01;

import java.util.ArrayList;

/**
 *
 * @author Elaine
 */
public class CircularBuffer {
    private ArrayList<Integer> buffer;
    private int first;
    private int last;
    private int size;
    
    public CircularBuffer(int size) {
        this.size = size;
        first = 0;
        last = 0;
        buffer = new ArrayList<Integer>();
    }
    
    public void insert(int value) {
        buffer.add(last++, value);
    }
    
    public int remove() {
        int pos = first;
        buffer.remove(first);
        return pos;
    }
    
    public boolean isEmpty() {
        return first == last;
    }
    
    public boolean isBufferFull() {
        if ((last + 1) % size == first) {
            return true;
        }
        return false;
    }
}
