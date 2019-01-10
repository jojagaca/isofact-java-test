/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isofact.java;

import isofact.java.logic.FileProcessor;
import isofact.java.logic.Logic;
import isofact.java.model.Person;
import java.util.List;

/**
 *
 * @author johnjagarcia
 */
public class Main {

    public static void main(String[] args) {
        if (args != null && args.length > 0) {

            try {
                String fileName = args[0];
                String option = args[1];
                String valueOption = args[2];
                
                List<Person> people = new FileProcessor().getPeopleList(fileName);
                new Logic(valueOption, option).process(people);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Debe ingresar todos los parametros FILE OPTION OPTIONVALUE!");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("¡No se han recibido argumentos!");
        }
    }
}
