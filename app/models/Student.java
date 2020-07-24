/*
  Author: Dr. Rodrigo Garcia Carmona
  Code Editor: Jenipher Gonzalez Aponte
  Course: MAIS 810
  
  File: Student.java 
  Functions:
   -> 
 */

package models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student { //Class Name: Professor

    @Id //To determine that is the Primary Key
   // @GeneratedValue(strategy=GenerationType.AUTO)
   //id -> PrimaryKey
    public String id; //The ID_PROFESSOR is added by the user
    //Professor  Attribute
    public String firstName; // firstName -> contains the first name of the professor
    public String lastName; // lastName -> contains the last name of the professor
    public String studentEmail; // professorEmail -> contains the email of the professor


    //@OneToMany(mappedBy="professors")
    //@JsonIgnore
    
   // @ManyToMany(mappedBy="authors") 
    //@JsonIgnore
    //public List<Publication> publications; //List of publications called publications
}
