/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorharborcruise;

/**
 *
 * @author Ayush Malik
 */
class Port {

    private String portName;
    private String country;
    private int population;
    private String isPassportRequired;
    private Ship ship;
    public static final String PORT_FILE_PATH = "E:\\CMU\\semester1\\JAVA OOP\\Assignment 3\\VictorHarborCruise\\src\\Port.csv";

    public Port() {
    }

    public Port(String portName, String country, int population, String isPassportRequired) {
        this.portName = portName;
        this.country = country;
        this.population = population;
        this.isPassportRequired = isPassportRequired;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getIsPassportRequired() {
        return isPassportRequired;
    }

    public void setIsPassportRequired(String isPassportRequired) {
        this.isPassportRequired = isPassportRequired;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

}
