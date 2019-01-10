/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isofact.java.logic;

import isofact.java.model.Person;
import java.util.List;

/**
 *
 * @author andreavecino
 */
public class Logic {
    private String value;
    private String option;
    private final String CITY_OPTION = "CITY";
    private final String ID_OPTION = "ID";

    public Logic(String value, String option) {
        this.value = value;
        this.option = option;
    }
    
    public void process(List<Person> people) throws Exception {
        Controller controller;
        if (option.equals(CITY_OPTION)) {
            controller = new CityController(value);
        } else if (option.equals(ID_OPTION)) {
            controller = new IDController(value);
        } else {
            throw new Exception("Opcion invalida!");
        }
        
        controller.showResults(people);
    }
}
