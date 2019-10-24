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
/**
 *
 * @author Ayush Malik
 */
class Ship {
    private int shipNumber;
    private String shipName;
    private double shipWeight;
    private int yearBuilt;
    private int passengerCapacity;
    private ArrayList<Sailor> sailorPresent= new ArrayList();
    private double dockingFee;
    public final String SHIP_FILE_PATH = "E:\\CMU\\semester1\\JAVA OOP\\Assignment 3\\VictorHarborCruise\\src\\Ship.csv";
    public final String SAILOR_FILE_PATH = "E:\\CMU\\semester1\\JAVA OOP\\Assignment 3\\VictorHarborCruise\\src\\Sailor.csv";

    public Ship () {}
    
    public Ship(int shipNumber, String shipName, double shipWeight, int yearBuilt, int passengerCapacity) {
        this.shipNumber = shipNumber;
        this.shipName = shipName;
        this.shipWeight = shipWeight;
        this.yearBuilt = yearBuilt;
        this.passengerCapacity = passengerCapacity;
    }

    public int getShipNumber() {
        return shipNumber;
    }

    public void setShipNumber(int shipNumber) {
        this.shipNumber = shipNumber;
    }

    public String getShipName() {
        return shipName;
    }

    public double getDockingFee() {
        return dockingFee;
    }

    public void setDockingFee() {
        if (shipWeight < 30000)
            dockingFee = 20000;
        else if (shipWeight >= 30000 && shipWeight<=50000)
            dockingFee = 50000;
        else if (shipWeight > 50000)
            dockingFee = 100000;  
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public double getShipWeight() {
        return shipWeight;
    }

    public void setShipWeight(double shipWeight) {
        this.shipWeight = shipWeight;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public ArrayList<Sailor> getSailor() {
        return sailorPresent;
    }

    public void setSailor(Sailor sailor) {
        sailorPresent.add(sailor);
    }
    
    public Ship assignShipAttributes(String[] shipAttributes, Ship s){
        shipNumber= Integer.parseInt(shipAttributes[0]);
        shipName = shipAttributes[1];
        shipWeight = Integer.parseInt(shipAttributes[2]);
        yearBuilt = Integer.parseInt(shipAttributes[3]);
        passengerCapacity = Integer.parseInt(shipAttributes[4]);
        
        return s;
    }
    
    public void addShip() throws IOException{
        int rand = (int)(Math.random()*1000)+1;
        Path pathToFile = Paths.get(SHIP_FILE_PATH);
        BufferedReader br = Files.newBufferedReader(pathToFile);
        String line = new String();
        while ((line = br.readLine()) != null){
            String[] shipAttributes = line.split(",");
            if (Integer.parseInt(shipAttributes[0]) == rand){
                setShipNumber(Integer.parseInt(shipAttributes[1]));
                setShipName(shipAttributes[2]);
                setShipWeight(Integer.parseInt(shipAttributes[3]));
                setYearBuilt(Integer.parseInt(shipAttributes[4]));
                setPassengerCapacity(Integer.parseInt(shipAttributes[5]));
                setDockingFee();
                break;
            }
        }
    }
    
    
    public void addSailor() throws IOException {
        int rand = (int) (Math.random() * 51) + 50;
        Path pathToFile = Paths.get(SAILOR_FILE_PATH);

        /************************************************************/
        /* Creates a random array of 500 numbers                    */
        Integer[] intArray = new Integer[500];

        for (int i = 0; i < 500; i++) {
            intArray[i] = i+1;
        }

        List<Integer> intList = Arrays.asList(intArray);

        Collections.shuffle(intList);

        intList.toArray(intArray);

        //System.out.println(Arrays.toString(intArray));
        /***********************************************************/
         
        for (int i = 0; i < rand; i++) {
            
            BufferedReader br = Files.newBufferedReader(pathToFile);
            String line = new String();
            while ((line = br.readLine()) != null) {
                String[] sailorAttributes = line.split(",");
                if (Integer.parseInt(sailorAttributes[0]) == intArray[i]) {
                    Sailor sailor = new Sailor(Integer.parseInt(sailorAttributes[1]),sailorAttributes[2],sailorAttributes[3],sailorAttributes[4],Integer.parseInt(sailorAttributes[5]));
                    setSailor(sailor);
                    break;
                }
            }
            br.close();
        }
        
        
        int randEngineer = (int) (Math.random() * 6) + 5;
        for (int i = rand; i < (rand + randEngineer); i++) {
            BufferedReader br1 = Files.newBufferedReader(pathToFile);
            String line1 = new String();
            while ((line1 = br1.readLine()) != null) {
                String[] engineerAttributes = line1.split(",");
                if (Integer.parseInt(engineerAttributes[0]) == intArray[i]) {
                    Engineer engineer= new Engineer(Integer.parseInt(engineerAttributes[1]),engineerAttributes[2],engineerAttributes[3],engineerAttributes[4],Integer.parseInt(engineerAttributes[5]));
                    setSailor(engineer);
                    break;
                }
            }
            br1.close();
        }
        
        int randCook = (int) (Math.random() * 6) + 5;
        for (int i = (rand + randEngineer); i < (rand + randEngineer + randCook); i++) {
            BufferedReader br2 = Files.newBufferedReader(pathToFile);
            String line2 = new String();
            while ((line2 = br2.readLine()) != null) {
                String[] cookAttributes = line2.split(",");
                if (Integer.parseInt(cookAttributes[0]) == intArray[i]) {
                    Cook cook= new Cook(Integer.parseInt(cookAttributes[1]),cookAttributes[2],cookAttributes[3],cookAttributes[4],Integer.parseInt(cookAttributes[5]));
                    setSailor(cook);
                    break;
                }
            }
            br2.close();
        }
        
        
        int randDoctor= (int) (Math.random() * 6) + 5;
        for (int i = (rand + randEngineer + randCook); i < (rand + randEngineer + randCook + randDoctor); i++) {
            BufferedReader br3 = Files.newBufferedReader(pathToFile);
            String line3 = new String();
            while ((line3 = br3.readLine()) != null) {
                String[] doctorAttributes = line3.split(",");
                if (Integer.parseInt(doctorAttributes[0]) == intArray[i]) {
                    Doctor doctor= new Doctor(Integer.parseInt(doctorAttributes[1]),doctorAttributes[2],doctorAttributes[3],doctorAttributes[4],Integer.parseInt(doctorAttributes[5]));
                    setSailor(doctor);
                    break;
                }
            }
            br3.close();
        }
        
        BufferedReader br4 = Files.newBufferedReader(pathToFile);
        String line4 = new String();
        while ((line4 = br4.readLine()) != null) {
            String[] captainAttributes = line4.split(",");
            if (Integer.parseInt(captainAttributes[0]) == intArray[rand + randEngineer + randCook + randDoctor]) {
                Captain captain = new Captain(Integer.parseInt(captainAttributes[1]), captainAttributes[2], captainAttributes[3], captainAttributes[4], Integer.parseInt(captainAttributes[5]));
                setSailor(captain);
                break;
            }
        }
        br4.close();
    }
}
