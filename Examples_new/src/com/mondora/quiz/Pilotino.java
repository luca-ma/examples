package com.mondora.quiz;

import java.lang.reflect.Field;

public class Pilotino {
    public static void main(String args[]) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        // TODO break the speed limit
        Carolina carolina = new Carolina();
        //carolina.accelerate(1001);
        //carolina.boost();
        
        Field velAtt = carolina.getClass().getDeclaredField("velocitaAttuale");
        velAtt.setAccessible(true);velAtt.setInt(carolina,100000000) ;
        
        carolina.boost();
        
    }
}