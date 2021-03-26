package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        double serviceSpeed;
        int commonAmount;
        Scanner scn=new Scanner(System.in);

        System.out.println("Enter speed for first cashier:");
        serviceSpeed=scn.nextDouble();
        Cashier cshOne= new Cashier(serviceSpeed,60);

        System.out.println("Enter speed for second cashier:");
        serviceSpeed=scn.nextDouble();
        Cashier cshTwo=new Cashier(serviceSpeed,60);


        System.out.println("Enter speed for third cashier:");
        serviceSpeed=scn.nextDouble();
        Cashier cshThree=new Cashier(serviceSpeed,60);

        Thread cash1=new Thread(cshOne);
        Thread cash2=new Thread(cshTwo);
        Thread cash3=new Thread(cshThree);

        cash1.start();
        cash2.start();
        cash3.start();

        try{
            cash1.join();
            cash2.join();
            cash3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(("Kolvo pokupatelei dlya kajdogo kassira za 60 minut : "));
        System.out.println("AmountOfPeople (1):"+cshOne.getAmountOfPeople());
        System.out.println("AmountOfPeople (2):"+cshTwo.getAmountOfPeople());
        System.out.println("AmountOfPeople (2):"+cshThree.getAmountOfPeople());
        commonAmount=cshOne.getAmountOfPeople()+cshThree.getAmountOfPeople()+cshTwo.getAmountOfPeople();
        System.out.println("Obshee colvo pokupatelei za 60 minut: "+commonAmount);

    }
}
