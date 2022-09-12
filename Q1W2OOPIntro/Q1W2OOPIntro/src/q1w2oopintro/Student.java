package q1w2oopintro;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author MUON
 */
public class Student {
    // Static Attributes
    public static int curLastId = 0;
    
    // Attributes
    private String name;
    private int id;
    private double grade;
    private ArrayList<Student> friends;
    // TODO make student hashable
    
    // Constructor
    public Student(String a_name){
        name = a_name;
        
        curLastId++;
        id = curLastId;
    }
    
    // Accessors and Multipliers
    public int getId() {
        return id;
    }
    
    // Methods
    public void introduce() {
        System.out.printf("HOI!!! MOI NWAME IS %s, AND I AM A PUIMPKINMAN. DO YOU KNWOW PUIMPMAN???\n", name.toUpperCase());
    }
    
    public void Student() {
        System.out.println("WOI IS THWIS HWEWE?");
    }
    
    public void monologue(String msg) {
        System.out.printf("%s (Monologue): %s", name, msg);
    }
    
    public void addFriend(Student s) {
        friends.add(s);
    }
}
