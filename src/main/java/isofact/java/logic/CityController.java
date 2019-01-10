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
public class CityController implements Controller {

    private final String valueOption;

    public CityController(String valueOption) {
        this.valueOption = valueOption;
    }

    @Override
    public void showResults(List<Person> people) {
        people.stream()
                .filter(p -> p.getCity().equalsIgnoreCase(valueOption))
                .distinct()
                .forEach(System.out::println);
    }

}
