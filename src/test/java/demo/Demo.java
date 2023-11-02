package demo;

import java.util.Arrays;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import projectSpecific.base.ProjectSpecificMethods;


public class Demo extends ProjectSpecificMethods {
    
    public Demo() {
        System.err.println('l');
    }

    public static void main(String[] args) {
        Random ran = new Random();
        int nextInt = ran.nextInt(7, 10);
        System.out.println(nextInt);
        int[] numbers = new int[3];
        numbers[1] = 2;
        numbers[2] = 45;
        numbers[0] = 3;
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < numbers.length; i++) {
            buf.append(numbers[i]);
        }
        String string = buf.toString();
        System.out.println(string);
        int in = Integer.parseInt(string);
        System.out.println(ran.nextInt(in));
    }
}
