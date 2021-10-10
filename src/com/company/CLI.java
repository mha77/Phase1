package com.company;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CLI {

    private static final String FILEFOLDER = "files/";

    void options() {
        boolean exit = false;
        do {
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

            switch (option) {
                case 1:
                    break;
                case 2:
                    addfiles();
                    break;
                case 3:
                    deleteFile();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("No valid option given");
            }
        }while(exit == false);
    }

    void addfiles(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Name path and file you want to add to the app:");
        String fileName = keyboard.nextLine();
        File sourceFile = new File(fileName);
        if (sourceFile.exists()){
            fileName = sourceFile.getName();
            File fileFolder = new File(FILEFOLDER + fileName);
            try {
                FileUtils.copyFile(sourceFile, fileFolder);
                System.out.println("File copied");
            } catch (IOException e) {
                System.out.println("Error copying file: " + e);
                e.printStackTrace();
            }
        }else{
            System.out.println("File " + fileName + " doesn't exist");
        }
    }

    void deleteFile(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Name path and file you want to add to the app:");
        String fileName = keyboard.nextLine();
        File file = new File(FILEFOLDER + fileName);

        if(file.exists()){
            try {
                FileUtils.delete(file);
                System.out.println("File deleted");
            }catch(IOException e){
                System.out.println("Error delete the file: " + e);
                e.printStackTrace();
            }
        }else{
            System.out.println("File " + fileName + " doesn't exist");
        }
    }
}
