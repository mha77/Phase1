package com.company;

import java.util.Scanner;

public class CLI {

    void options() {
        System.out.println("Which operation you would like to do?");
        System.out.println("(1) Retrieve files");
        System.out.println("(2) Add a file");
        System.out.println("(3) Delete a file");
        System.out.println("(4) Search for a file");
        System.out.println("(5) View a file");
        System.out.println("(6) Quit");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an Integer");
        int option = keyboard.nextInt();

        switch (option){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("No valid option given");
        }
    }
}
