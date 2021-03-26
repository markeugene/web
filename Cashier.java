package com.company;

public class Cashier implements  Runnable{

    private double serviceSpeed;
    private int amountOfPeople=0;
    private  double workingTime=0;

    public Cashier(double serviceSpeed, double workingTime) {
        if(serviceSpeed<0|| workingTime<0)throw new IllegalArgumentException("(Service speed)or(Working Time) cannot be less than 0");

        this.workingTime=workingTime;
        this.serviceSpeed=serviceSpeed;
    }
    public int getAmountOfPeople(){
        return this.amountOfPeople;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        while(workingTime>0){
            try{
                amountOfPeople++;
                Thread.sleep((long) serviceSpeed);
                workingTime-=serviceSpeed;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
