/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorharborcruise;

import java.io.IOException;
import static java.lang.System.exit;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the menu class which helps in generating menu for each functionality
 * 
 * @author Ayush Malik
 */
public class Menu {
    
    /**
     * This method generates the main menu of the program
     * Calls subsequent menu's depending on users choice.
     * @param cruise
     * @throws IOException
     * @throws ParseException 
     */
    public void mainMenu(ArrayList<Cruise> cruise) throws IOException, ParseException{
        
        String input = new String();
        int i = 0;
        Reports report = new Reports();
        System.out.println("\n************************************WELCOME TO VICTOR HARBOUR CRUISE************************************\n");
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("\n------------------------Main Menu------------------------\n");
            System.out.println("1 : Create a Cruise randomly");
            System.out.println("2 : Add passengers");
            System.out.println("3 : Print Reports");
            System.out.println("4 : Generate Information of the Cruise");
            System.out.println("5 : Exit\n");
            System.out.print("Choose one of the above options :  ");
            input = in.nextLine();
            switch (input) {
                case "1":
                    cruise.add(new Cruise());
                    cruise.get(i).createCruise();
                    i++;
                    break;
                case "2":
                    if (cruise.size() < 1) {
                        System.out.println("\nSorry!!! Cruise does not exist... Please create a cruise and then add passengers.");
                        break;
                    }
                    passengerMenu(cruise);
                    break;
                case "3":
                    if (cruise.size() < 1) {
                        System.out.println("\nSorry!!! Cruise does not exist... Please create a cruise and then print reports.");
                        break;
                    }
                    reportsMenu(cruise,report);
                    break;
                case "4":
                    if (cruise.size() < 1) {
                        System.out.println("\nSorry!!! Cruise does not exist... Please create a cruise.");
                        break;
                    }
                    int cruiseSelected;
                    Scanner p1 = new Scanner(System.in);
                    System.out.println("\nSelect a cruise to print information : \n");
                    for (int j = 0; j < cruise.size(); j++) {
                        System.out.println((j + 1) + ". " + cruise.get(j).getCruiseNumber());
                    }
                    System.out.print("\nChoose one of the above options : ");
                    cruiseSelected = Integer.parseInt(p1.nextLine());
                    if (cruise.get(cruiseSelected-1).getPassengersTravelled().isEmpty()) {
                        System.out.println("\nOOPS... There are no passengers. Please add passengers first and then try to generate report !!!");
                        break;
                    }
                    report.generateCruiseInformation(cruise.get(cruiseSelected-1));
                    break;
                case "5":
                    exit(0);
                default:
                    break;
            }
            System.out.println("\n*************************************************************************************");
        }
    }
    
    // this method defines the Adding of passengers menu which is called form main menu
    public void passengerMenu(ArrayList<Cruise> cruise) throws IOException{
        Scanner p = new Scanner(System.in);
        int cruiseSelected;
        String a;
        System.out.println("\nSelect a cruise to add passengers : \n");
        for (int j = 0; j < cruise.size(); j++) {
            System.out.println((j + 1) + ". " + cruise.get(j).getCruiseNumber());
        }
        System.out.print("\nChoose one of the above options : ");
        cruiseSelected = Integer.parseInt(p.nextLine());
        
        System.out.print("\n\n------------------------Passengers Menu------------------------\n\n"
                + "1: Add passengers randomly\n2: Add passengers manually\n3: Return to Main menu\n4:"
                + " Exit the program\n\nChoose one of the above options : ");
        a = p.nextLine();
        switch (a) {
            case "1":
                cruise.get(cruiseSelected - 1).addPassengersRandomly();
                System.out.println("\n" + cruise.get(cruiseSelected - 1).getPassengersTravelled().size() + " Passengers added successfully...");
                break;
            case "2":
                cruise.get(cruiseSelected - 1).addPassengersManually();
                System.out.println("\n" + cruise.get(cruiseSelected - 1).getPassengersTravelled().size() + " Passengers added successfully...");
                break;
            case "4":
                exit(0);
            default:
                break;
        }
    }
    
    /**
     * this method defines the reports menu and is called from main menu 
     * 
     * @param cruise
     * @param report
     */
    public void reportsMenu(ArrayList<Cruise> cruise, Reports report) throws ParseException, IOException{
        Scanner p1 = new Scanner(System.in);
        int cruiseSelectedForReport;
        String b;
        System.out.println("\nSelect a cruise to generate reports : \n");
        for (int j = 0; j < cruise.size(); j++) {
            System.out.println((j + 1) + ". " + cruise.get(j).getCruiseNumber());
        }
        System.out.print("\nChoose one of the above options : ");
        cruiseSelectedForReport = Integer.parseInt(p1.nextLine());
        
        System.out.println("\n\n------------------------Reports Menu------------------------\n");
        System.out.println("1. Revenue generated from the cruise passengers by nationality and age.");
        System.out.println("2. Details of all Sailors that worked on a cruise and the total cost of "
                + "paying their salaries and the total cost of docking at different ports.");
        System.out.println("3. List of passengers with their details sorted by moneySpentOnCruise.");
        System.out.println("4. Cruise evaluation by passengers survey at the end of the cruise and generate/store random responses)");
        System.out.println("5. Did the ship make a profit?");
        System.out.println("6. Return to main menu");
        System.out.println("7. Exit");
        System.out.print("\nChoose one of the above options : ");
        b = p1.nextLine();
        switch (b) {
            case "1":
                if (cruise.get(cruiseSelectedForReport-1).getPassengersTravelled().isEmpty()){
                    System.out.println("\nOOPS... There are no passengers. Please add passengers first and then try to generate report !!!");
                    break;
                }   
                report.revenueGenerated(cruise.get(cruiseSelectedForReport - 1));
                System.out.println("\n\nReport generated in the Assignment 3 folder...");
                break;
            case "2":
                report.sailorDetails(cruise.get(cruiseSelectedForReport - 1));
                break;
            case "3":
                if (cruise.get(cruiseSelectedForReport-1).getPassengersTravelled().isEmpty()){
                    System.out.println("\nOOPS... There are no passengers. Please add passengers first and then try to generate report !!!");
                    break;
                } 
                report.passengerDetails(cruise.get(cruiseSelectedForReport - 1));
                break;
            case "4":
                if (cruise.get(cruiseSelectedForReport-1).getPassengersTravelled().isEmpty()){
                    System.out.println("\nOOPS... There are no passengers. Please add passengers first and then try to generate report !!!");
                    break;
                } 
                report.cruiseEvaluationReport(cruise.get(cruiseSelectedForReport - 1));
                break;
            case "5":
                if (cruise.get(cruiseSelectedForReport-1).getPassengersTravelled().isEmpty()){
                    System.out.println("\nOOPS... There are no passengers. Please add passengers first and then try to generate report !!!");
                    break;
                } 
                report.isShipMakingProfit(cruise.get(cruiseSelectedForReport - 1));
                break;
            case "7":
                exit(0);
            default:
                break;
        }
    }
}

 