/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorharborcruise;

import java.util.Date;

/**
 *
 * @author Ayush Malik
 */
class Captain extends Sailor {
    
    public Captain(int sailorId, String sailorName, String dob, String nationality, int isSuper) {
        super(sailorId, sailorName, dob, nationality, isSuper);
        setSalary(isSuper);
    }
    
    @Override
    public void setSalary(int isSuper){
        salary=100000;
        if(isSuper==1)
        salary+=salary*0.2; 
    }
    
}
