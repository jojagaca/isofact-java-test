/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isofact.java.logic;

import isofact.java.model.Person;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author andreavecino
 */
public class FileProcessor {

    private final String FORMAT_ONE = "F1";
    private final String FORMAT_TWO = "F2";
    private final String DATA_LINE_FORMAT = "D";

    public List<Person> getPeopleList(String fileName) throws Exception {
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            String lastRowFormat = "";

            List<Person> people = new ArrayList<>();

            while ((line = br.readLine()) != null) {

                if (!lastRowFormat.isEmpty()) {
                    if (line.startsWith(DATA_LINE_FORMAT)) {
                        String data[] = getData(line.split("D ", 2)[1], lastRowFormat);
                        if (data.length > 0) {
                            people.add(getPerson(data, lastRowFormat));
                        }
                        continue;
                    }
                }

                lastRowFormat = line;
            }

            return people;
        } catch (IOException e) {
            throw new Exception("Error al leer el archivo!");
        }
    }

    private String[] getData(String line, String format) {
        if (format.equals(FORMAT_ONE)) {
            return line.split(",");
        } else if (format.equals(FORMAT_TWO)) {
            return line.split(" ; ");
        }

        return new String[]{};
    }

    private Person getPerson(String[] data, String format) {
        String id = data[2];

        if (format.equals(FORMAT_TWO)) {
            // Todos los formatos del ID son convertidos al F1
            String[] formatTwoId = id.split("-");
            id = formatTwoId[0] + formatTwoId[1];
        }

        String name = data[0];
        String city = data[1];
        return new Person(id, name, city);
    }
}
