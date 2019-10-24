/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorharborcruise;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * This is the class where main function is defined.
 * 
 * @author Ayush Malik
 */
public class VictorHarborCruise {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IOException, ParseException {
        //declaring an array list of Cruise objects for multiple cruise creation
        ArrayList<Cruise> cruise = new ArrayList();
        
        Menu menu = new Menu();
        //calling the main menu function to generate menu.
        menu.mainMenu(cruise);
    }
}