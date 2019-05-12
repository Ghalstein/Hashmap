package com.basics1;

import java.util.HashSet;

public class Main {

    private static HashSet<Integer> ids = new HashSet<>(); // Hash table keeps track of ids and set allows no duplicates
    private static boolean stop; // flag for finding a unique id number
    private static int hashCount = 0; // keeps tracked of saved ids

    // finds a number that is not assigned, mark it as assigned and return it
    public static int getNumber(){
        stop = false;
        int n = 0;
        if (hashCount == 99999999){
            System.out.println("System is full");
            return -1;
        }
        while(!stop){ // loops until a unique number is found
            n = (int)(Math.random()*100000000);
            if (requestNumber(n, ids)) {
                ids.add(n);
                hashCount++;
                stop = true;
            }
        }
        return n;
    }

    // for unit testing and to input a specified id number
    public static int getNumber(int n){
        if (hashCount == 99999999){
            System.out.println("System is full.");
            return -1;
        }
        if(n < 100000000 && n >= 0 && requestNumber(n, ids)){
            ids.add(n);
            hashCount++;
        } else {
            System.out.println("The number you entered may already exist or does not fit the parameters");
        }
        return n;
    }

    // checks if the number is assigned or not
    public static boolean requestNumber(int n, HashSet<Integer> hash){
        if(hash.contains(n)){ // checks if the number is in the set
            return false;
        }else
            return true;
    }
    public static void main(String[] args) {
        System.out.println("First number is " + getNumber(10));
        System.out.print("Duplicate Test Output: ");
        getNumber(10); // tests for only accepting unique ids
        System.out.print("Lower Bound Range Test Output: ");
        getNumber(-1); // tests if only accepts ids in range
        System.out.print("Upper Bound Range Test Output: ");
        getNumber(100000000);
        System.out.println("I will add 100 random and unique ID's:");
        int count = 1;
        while(count < 101){
            System.out.println(count + ": " + getNumber());
            count++;
        }

    }
}
