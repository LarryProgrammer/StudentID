/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Larry Jackson
 */

public class Student {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<String>> student =
                new HashMap<Integer, ArrayList<String>>();
        String line;
        int studentID; /* integer for taking student id */
        String course; /* string for taking course name */
        Scanner keyboard = new Scanner(System.in); /* Scanner object for taking input */

        /* Prints the message for the user to take the next steps */
        System.out.println("Enter student ID followed by course number, -1 to exit.");
        do {
            line = keyboard.nextLine();
            line = line.trim(); /* remove any leading or trailing whitespace */
            if (!line.equals("-1")) {
                /* Extract the ID an the Class, separated by a space,
                   by using the split method, which creates an array of strings
                   delimited by the delimiter (specified as a space in this case)
                 */
                String[] parsedString = line.split(" ");
                studentID = Integer.parseInt(parsedString[0]);// the ID
                course = parsedString[1];
                /* Add to arraylist if student ID has been seen already */
                if (student.containsKey(studentID)) {
                    student.get(studentID).add(course);
                } else {
                    /* Add arraylist for the first time to the map */
                    ArrayList<String> courses = new ArrayList<String>();
                    courses.add(course);
                    student.put(studentID, courses);
                }
            }
        } while (!line.equals("-1"));

        /* Now iterate through the map and output the student ID and all course
        associated with the student */
        System.out.println();
        for (Integer key : student.keySet()) {
            System.out.println("For student: " + key);
            for (String cls : student.get(key)) {
                System.out.print(cls + " ");
            }
            System.out.println();
            System.out.println();
        }
    }
}
