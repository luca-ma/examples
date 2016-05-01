package com.mondora.quiz;
 
public final class Carolina {
    private static final int MAX = 100;
 
    private int velocitaAttuale = 0;
 
    public synchronized void accelerate(int acceleration) {
        velocitaAttuale += acceleration;
        if (velocitaAttuale > MAX)
            reset();
    }
 
    public synchronized void reset() {
        velocitaAttuale = 0;
    }
 
    public synchronized void boost() {
        if (velocitaAttuale > MAX * 10) {
            // The goal is to reach this line
            System.out.println("Boost!");
        }
    }
}