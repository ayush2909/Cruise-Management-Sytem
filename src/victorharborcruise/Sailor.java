/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorharborcruise;

import java.util.*;

/**
 *
 * @author Ayush Malik
 */
class Sailor {

    private int sailorId;
    private String sailorName;
    private String dateOfBirth;
    protected double salary;
    private String nationality;
    private int isSupervisor;

    public Sailor() {
    }

    public Sailor(int sailorId, String sailorName, String dob, String nationality, int isSuper) {
        this.sailorId = sailorId;
        this.sailorName = sailorName;
        this.nationality = nationality;
        dateOfBirth = dob;
        isSupervisor = isSuper;
        setSalary(isSuper);
    }

    public void setSalary(int isSuper) {
        salary = 50000;
        if (isSuper == 1) {
            salary += salary * 0.2;
        }
    }

    public double getSalary() {
        return salary;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getSailorId() {
        return sailorId;
    }

    public String getSailorName() {
        return sailorName;
    }

    public void setSailorName(String sailorName) {
        this.sailorName = sailorName;
    }

    public int getIsSupervisor() {
        return isSupervisor;
    }

    public void setIsSupervisor(int isSupervisor) {
        this.isSupervisor = isSupervisor;
    }

    public void setSailorId(int sailorId) {
        this.sailorId = sailorId;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return padRight(Integer.toString(this.getSailorId()),30) + padRight(this.getSailorName(),30) 
                + padRight(this.getDateOfBirth(),30) + padRight(this.getNationality(),30) 
                +  padRight(Double.toString(this.getSalary()),30) + padRight(Integer.toString(this.getIsSupervisor()),30);
    }
    
    public String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

}
