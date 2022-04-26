package com;

import com.Handler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Handler handler= new Handler();



    }

    public static int readUserMod() {
        Scanner scanner = new Scanner(System.in);
        int modNumber = 0;
        System.out.println("please chose mod:");
        try {
            modNumber = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Input error chose mod, please repeat");
            readUserMod();
        }
        return modNumber;
    }
}

