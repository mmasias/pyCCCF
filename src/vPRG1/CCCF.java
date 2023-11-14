package vPRG1;

import java.util.Scanner;

class CCCF {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final double OPENING_TIME = 9.0;
        final double CLOSING_TIME = 21.0;
        final double MINUTE = 1.0 / 60.0;
        double currentTime = OPENING_TIME;
        boolean isWorking = true;

        int line = 0;
        final double PROBABILITY_ARRIVAL = 0.6;

        int customerService1 = 0, customerService2 = 0, customerService3 = 0, customerService4 = 0;
        final int ITEM_MINIMUM = 5;
        final int ITEM_MAXIMUM = 15;
        final int DECIMAL_PLACES = 100;

        do {
            currentTime = currentTime + MINUTE;
            isWorking = currentTime < CLOSING_TIME;

            line = line + (Math.random() < PROBABILITY_ARRIVAL ? 1 : 0);
            System.out.println("\nESTADO " + "-=".repeat(10));
            System.out.println("HORA: " + (double) Math.round(currentTime * DECIMAL_PLACES) / DECIMAL_PLACES);
            System.out.print("> COLA DE " + line + " | ");

            if (line >0 && customerService1 <= 0) {
                line = line - 1;
                customerService1 = (int) (Math.random() * (ITEM_MAXIMUM - ITEM_MINIMUM)) + ITEM_MINIMUM;
                System.out.print("Cliente a caja 1, con [" + customerService1 + "] pack de items | ");
            } 
            
            if (line >0 && customerService2 <= 0) {
                line = line - 1;
                customerService2 = (int) (Math.random() * (ITEM_MAXIMUM - ITEM_MINIMUM)) + ITEM_MINIMUM;
                System.out.print("Cliente a caja 2, con [" + customerService2 + "] pack de items | ");
            } 
            
            if (line >0 && customerService3 <= 0) {
                line = line - 1;
                customerService3 = (int) (Math.random() * (ITEM_MAXIMUM - ITEM_MINIMUM)) + ITEM_MINIMUM;
                System.out.print("Cliente a caja 3, con [" + customerService3 + "] pack de items | ");
            } 
            
            if (line >0 && customerService4 <= 0) {
                line = line - 1;
                customerService4 = (int) (Math.random() * (ITEM_MAXIMUM - ITEM_MINIMUM)) + ITEM_MINIMUM;
                System.out.print("Cliente a caja 4, con [" + customerService4 + "] pack de items | ");
            }

            System.out.println("\nLINEA DE CAJAS " + "-=".repeat(10));

            if (customerService1 > 0) {
                customerService1 = customerService1 - 1;
                System.out.println("> Caja 1 atiende al cliente. Le quedan [" + customerService1 + "] pack de items.");
            } else {
                System.out.println("> Caja 1 libre.");
            }
            
            if (customerService2 > 0) {
                customerService2 = customerService2 - 1;
                System.out.println("> Caja 2 atiende al cliente. Le quedan [" + customerService2 + "] pack de items.");
            } else {
                System.out.println("> Caja 2 libre.");
            }
            
            if (customerService3 > 0) {
                customerService3 = customerService3 - 1;
                System.out.println("> Caja 3 atiende al cliente. Le quedan [" + customerService3 + "] pack de items.");
            } else {
                System.out.println("> Caja 3 libre.");
            }
            
            if (customerService4 > 0) {
                customerService4 = customerService4 - 1;
                System.out.println("> Caja 4 atiende al cliente. Le quedan [" + customerService4 + "] pack de items.");
            } else {
                System.out.println("> Caja 4 libre.");
            } 

            String userInput = scanner.nextLine();
        } while (isWorking);
    }
}
