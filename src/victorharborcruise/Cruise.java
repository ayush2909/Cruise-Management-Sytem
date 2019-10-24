/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorharborcruise;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import static victorharborcruise.Port.PORT_FILE_PATH;

/**
 * This class is used to create a cruise. Cruise has a ship. Cruise has 
 * passengers. Cruise has ports of call.
 * 
 * @author Ayush Malik
 */
class Cruise {

    // cruise parameters declared as private
    private int cruiseNumber;
    private String sailingDate;
    private String returnDate;
    private Port departurePort;
    private ArrayList<Port> portsOfCall = new ArrayList();
    private Ship shipInvolved = new Ship();
    private ArrayList<Passenger> passengersTravelled = new ArrayList();
    public final String PASSENGER_FILE_PATH = "E:\\CMU\\semester1\\JAVA OOP\\Assignment 3\\VictorHarborCruise\\src\\Passenger.csv";
    public final String CRUISE_FILE_PATH = "E:\\CMU\\semester1\\JAVA OOP\\Assignment 3\\VictorHarborCruise\\src\\Cruise.csv";

    // default constructor
    public Cruise() {
    }
    
    // overloaded constructor
    public Cruise(int cruiseNumber, String sailingDate, String returnDate) {
        this.cruiseNumber = cruiseNumber;
        this.returnDate = returnDate;
        this.sailingDate = sailingDate;
    }
    
    public int getCruiseNumber() {
        return cruiseNumber;
    }
   
    public void setCruiseNumber(int num) {
        cruiseNumber = num;
    }

    public String getSailingDate() {
        return sailingDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setSailingDate(String date) {
        sailingDate = date;
    }

    public void setReturnDate(String date) {
        returnDate = date;
    }

    public void setDeparturePort(Port departurePort) {
        this.departurePort = departurePort;
    }

    public Port getDeparturePort() {
        return departurePort;
    }

    public ArrayList<Port> getPortsOfCall() {
        return portsOfCall;
    }

    public void setPortsOfCall(Port port) {
        portsOfCall.add(port);
    }

    public Ship getShipInvolved() {
        return shipInvolved;
    }

    public void setShipInvolved(Ship shipInvolved) {
        this.shipInvolved = shipInvolved;
    }

    public ArrayList<Passenger> getPassengersTravelled() {
        return passengersTravelled;
    }

    public void setPassengersTravelled(Passenger passengers) {
        passengersTravelled.add(passengers);
    }
   
    /**************************************************************************/
    /* This method creates a random cruise from Cruise.csv file and adds ship */
    /* adds ports of calls, and adds sailors in the ship.                     */
    /**************************************************************************/
    
    public void createCruise() throws IOException {
        System.out.println("\nCreating a cruise.............\n");
        int randCruise = (int) (Math.random() * 100) + 1;           // generate random number between 1-100
        // read Cruise.csv file 
        Path pathToFile = Paths.get(CRUISE_FILE_PATH);
        BufferedReader br = Files.newBufferedReader(pathToFile);
        String line = new String();
        while ((line = br.readLine()) != null) {
            String[] cruiseAttributes = line.split(",");
            //select a random cruise from the file having 100 cruises
            if (Integer.parseInt(cruiseAttributes[0]) == randCruise) {
                setCruiseNumber(Integer.parseInt(cruiseAttributes[1]));
                setSailingDate(cruiseAttributes[2]);
                setReturnDate(cruiseAttributes[3]);
                break;
            }
        }
        br.close();
        System.out.println("Cruise created with Cruise Number : " + getCruiseNumber());
        addPort();
        shipInvolved.addShip();
        shipInvolved.addSailor();
        
    }
    
    /**
     * this method helps in adding the departure port and ports of call of the 
     * ship randomly while reading the Port.csv file.
     * @throws IOException 
     */
    public void addPort() throws IOException {
        int rand = (int) (Math.random() * 9) + 2;
       
        /* Creates a random array of 100 numbers                    */
        Integer[] intArray = new Integer[100];
        for (int i = 0; i < 100; i++) {
            intArray[i] = i+1;
        }
        List<Integer> intList = Arrays.asList(intArray);
        Collections.shuffle(intList);
        intList.toArray(intArray);
        
        /*  First port is always added as departure port and rest of the ports 
            are ports of call */
        for (int i = 0; i <=rand; i++) {
            Path pathToFile = Paths.get(PORT_FILE_PATH);
            BufferedReader br = Files.newBufferedReader(pathToFile);
            String line = new String();
            while ((line = br.readLine()) != null) {
                String[] portAttributes = line.split(",");
                if (i == 0) {
                    if (Integer.parseInt(portAttributes[0]) == intArray[i]) {
                        Port port = new Port(portAttributes[1], portAttributes[2], Integer.parseInt(portAttributes[3]),portAttributes[4]);
                        setDeparturePort(port);
                        break;
                    }
                } 
                else {
                    if (Integer.parseInt(portAttributes[0]) == intArray[i]) {
                        Port port = new Port(portAttributes[1], portAttributes[2], Integer.parseInt(portAttributes[3]), portAttributes[4]);
                        setPortsOfCall(port);
                        break;
                    }
                }
            }
            br.close();
        }
    }
    
    /**
     * This function adds passengers randomly in the passenger array list.
     * @throws IOException 
     */
    public void addPassengersRandomly() throws IOException {
        // check if the passesngers can be added to the ship or not depending on ship capacity
        if (passengersTravelled.size() == shipInvolved.getPassengerCapacity()) {
            System.out.println("Cruise is already full. Cannot add new passengers...\n");
        } else {
            int newPassengersLimit = shipInvolved.getPassengerCapacity() - passengersTravelled.size();
            
            /**** Creates a random array of 1000 numbers***/
            Integer[] intArray = new Integer[1000];
            for (int i = 0; i < 1000; i++) {
                intArray[i] = i + 1;
            }
            List<Integer> intList = Arrays.asList(intArray);
            Collections.shuffle(intList);
            intList.toArray(intArray);
            

            /******************************************************************/
            /* Selecting values from random array and reading those values    */
            /* from the Passengers.csv file to create random passengers       */
            /* dependingon ship capacity                                      */
            /******************************************************************/
            for (int i = 0; i < newPassengersLimit; i++) {
                Path pathToFile = Paths.get(PASSENGER_FILE_PATH);
                BufferedReader br = Files.newBufferedReader(pathToFile);
                String line = new String();
                while ((line = br.readLine()) != null) {
                    String[] passengerAttributes = line.split(",");
                    if (Integer.parseInt(passengerAttributes[0]) == intArray[i]) {
                        Passenger passengers = new Passenger(Long.parseLong(passengerAttributes[1]), passengerAttributes[2], passengerAttributes[3], passengerAttributes[4], passengerAttributes[5], Integer.parseInt(passengerAttributes[6]), Integer.parseInt(passengerAttributes[7]));
                        passengers.setCruiseEvaluation();
                        setPassengersTravelled(passengers);
                        break;
                    }
                }
                br.close();
            }
        }
    }
    
    /**
     * This method is used to take input from the user to add passengers 
     * manually one by one.
     * 
     */
    public void addPassengersManually() {
        Scanner in = new Scanner(System.in);
        if (passengersTravelled.size() == shipInvolved.getPassengerCapacity()) {
            System.out.println("Cruise is already full. Cannot add new passengers...\n");
        } else {
            while (passengersTravelled.size() != shipInvolved.getPassengerCapacity()) {
                Passenger p = new Passenger();
                System.out.print("\nEnter the passenger number : ");
                p.setPassengerNumber(Integer.parseInt(in.nextLine()));
                System.out.print("\nEnter the passenger name : ");
                p.setName(in.nextLine());
                System.out.print("\nEnter passenger's date of birth : ");
                p.setDateOfBirth(in.nextLine());
                System.out.print("\nEnter the passenger's nationality : ");
                p.setNationality(in.nextLine());
                System.out.print("\nEnter the passenger home address : ");
                p.setHomeAddress(in.nextLine());
                System.out.print("\nEnter the passenger joining fees : ");
                p.setJoiningFees(Double.parseDouble(in.nextLine()));
                p.setMoneySpentOnCruise((Math.random()*200)+300);
                setPassengersTravelled(p);
                System.out.println("\nDo you want to add more passengers manually ? (Y/N)");
                String s = new String();
                s = in.nextLine();
                if (s.equals("Y") || s.equals("y")){}
                    else
                    break;
            }
        }
    }
}
