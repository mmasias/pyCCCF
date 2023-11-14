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

        do {
            currentTime = currentTime + MINUTE;
            isWorking = currentTime < CLOSING_TIME;

            line = line + (Math.random() < PROBABILITY_ARRIVAL ? 1 : 0);
            showHeader(currentTime, line);

            if (line > 0 && customerService1 <= 0) {
                line = line - 1;
                customerService1 = (int) (Math.random() * (ITEM_MAXIMUM - ITEM_MINIMUM)) + ITEM_MINIMUM;
                describeArrival(customerService1, 1);
            }

            if (line > 0 && customerService2 <= 0) {
                line = line - 1;
                customerService2 = (int) (Math.random() * (ITEM_MAXIMUM - ITEM_MINIMUM)) + ITEM_MINIMUM;
                describeArrival(customerService2, 2);
            }

            if (line > 0 && customerService3 <= 0) {
                line = line - 1;
                customerService3 = (int) (Math.random() * (ITEM_MAXIMUM - ITEM_MINIMUM)) + ITEM_MINIMUM;
                describeArrival(customerService3, 3);
            }

            if (line > 0 && customerService4 <= 0) {
                line = line - 1;
                customerService4 = (int) (Math.random() * (ITEM_MAXIMUM - ITEM_MINIMUM)) + ITEM_MINIMUM;
                describeArrival(customerService3, 3);
            }

            System.out.println("\nLINEA DE CAJAS " + "-=".repeat(10));

            if (customerService1 > 0) {
                customerService1 = customerService1 - 1;
            }
            describeCustomerService(customerService1, 1);

            if (customerService2 > 0) {
                customerService2 = customerService2 - 1;
            }
            describeCustomerService(customerService2, 2);

            if (customerService3 > 0) {
                customerService3 = customerService3 - 1;
            }
            describeCustomerService(customerService3, 3);

            if (customerService4 > 0) {
                customerService4 = customerService4 - 1;
            }
            describeCustomerService(customerService4, 4);

            String userInput = scanner.nextLine();
        } while (isWorking);
    }

    private static void describeCustomerService(int customerService, int customerServiceNumber) {
        if (customerService > 0) {
            System.out.println(
                    "> Caja " + customerServiceNumber + " atiende al cliente. Le quedan [" + customerService
                            + "] pack de items.");
        } else {
            System.out.println("> Caja " + customerServiceNumber + " libre.");
        }
    }

    private static void describeArrival(int customerService, int customerServiceNumber) {
        System.out
                .print("Cliente a caja " + customerServiceNumber + ", con [" + customerService + "] pack de items | ");
    }

    private static void showHeader(double currentTime, int line) {
        final int DECIMAL_PLACES = 100;
        System.out.println("\nESTADO " + "-=".repeat(10));
        System.out.println("HORA: " + (double) Math.round(currentTime * DECIMAL_PLACES) / DECIMAL_PLACES);
        System.out.print("> COLA DE " + line + " | ");
    }
}
