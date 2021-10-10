package com.company;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
                    retrieve();
                    break;
                case 2:
                    addfiles();
                    break;
                case 3:
                    deleteFile();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    view();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("No valid option given");
            }
        }while(exit == false);
    }

    void retrieve(){
        File folder = new File(FILEFOLDER);
        List<String> strList = new ArrayList<>();

        for (final File fileEntry : folder.listFiles()) {
            String fileEntryName = fileEntry.getName();
            strList.add(fileEntryName);
        }
        Collections.sort(strList);

        for(String str: strList){
            System.out.println(str);
        }
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
        System.out.println("Name file which you want to delete:");
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
    void search(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Name file which search:");
        String fileName = keyboard.nextLine();
        File file = new File(FILEFOLDER + fileName);

        if(file.exists()){
            System.out.println("File " + fileName + " exists");
        }else{
            System.out.println("File " + fileName + " doesn't exist");
        }
    }

    void view(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Name file which you want to view:");
        String fileName = keyboard.nextLine();
        File file = new File(FILEFOLDER + fileName);

        if(file.exists()){
            BufferedReader reader;
            try{
                reader = new BufferedReader(new FileReader(file));
                String line =reader.readLine();
                while(line != null){
                    System.out.println(line);
                    line = reader.readLine();
                }
                reader.close();
            }catch(FileNotFoundException ex){
                System.out.println("File not found " + ex);
            }catch (IOException ex) {
                System.out.println("IOException: " + ex);
            }
        }else{
            System.out.println("File doesn't exist");
        }
    }
}
