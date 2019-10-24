/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorharborcruise;

import java.util.*;
import java.lang.*;
/*
 *
 * @author Ayush Malik
 */
class Passenger implements Comparable<Passenger>{
    private long passengerNumber;
    private String name;
    private String homeAddress;
    private String nationality;
    private String dateOfBirth;
    private double joiningFees;
    private double moneySpentOnCruise;
    private int[] cruiseEvaluation=new int[5];
    public Passenger (){}

    public Passenger(long passengerNumber, String name, String homeAddress, String nationality, String dateOfBirth, double joiningFees, double moneySpentOnCruise) {
        this.passengerNumber = passengerNumber;
        this.name = name;
        this.homeAddress = homeAddress;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.joiningFees = joiningFees;
        this.moneySpentOnCruise = moneySpentOnCruise;
    }

    public long getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(long passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getJoiningFees() {
        return joiningFees;
    }

    public void setJoiningFees(double joiningFees) {
        this.joiningFees = joiningFees;
    }

    public double getMoneySpentOnCruise() {
        return moneySpentOnCruise;
    }

    public void setMoneySpentOnCruise(double moneySpentOnCruise) {
        this.moneySpentOnCruise = moneySpentOnCruise;
    }

    public int[] getCruiseEvaluation() {
        return cruiseEvaluation;
    }

    public void setCruiseEvaluation() {
      for (int i = 0; i < cruiseEvaluation.length; i++) {
          cruiseEvaluation[i]= (int) (Math.random() * 5) + 1;
      }
    }
    
    @Override
    public String toString(){
        return  padRight(Long.toString(this.getPassengerNumber()),30) + padRight(this.getName(),30) + 
                padRight(this.getHomeAddress(),30) +  padRight(this.getNationality(),30) + 
                padRight(this.getDateOfBirth(),30) +  padRight(Double.toString(this.getJoiningFees()),30) + 
                padRight(Double.toString(this.getMoneySpentOnCruise()),30);
    }
    
    /*** implement comparable interface to sort passengers on the basis of money spent on cruise. ***/ 
    @Override
    public int compareTo(Passenger p) {
        int compareQuantity = (int)((Passenger)p).getMoneySpentOnCruise();
        //ascending order
        return (int)this.getMoneySpentOnCruise() - compareQuantity;
    }
    
     public String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}