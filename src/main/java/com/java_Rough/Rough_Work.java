package com.java_Rough;

import java.util.Random;

public class Rough_Work {

   
    
    public static void main(String[] args) {
        Random ran = new Random();
        
        for(int i=0; i<100; i++) {
        System.out.println(ran.nextInt(0, 11));
        }
    }
}
