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
public class Student { //Class Name: Student

    @Id //To determine that is the Primary Key
   // @GeneratedValue(strategy=GenerationType.AUTO)
   //id -> PrimaryKey
    public String id; //The ID_PROFESSOR is added by the user
    //Student  Attribute
    public String firstName; // firstName -> contains the first name of the student
    public String lastName; // lastName -> contains the last name of the student
    public String studentEmail; // studentEmail -> contains the email of the student


    //@OneToMany(mappedBy="students")
    //@JsonIgnore

   // @ManyToMany(mappedBy="authors")
    //@JsonIgnore
    //public List<Publication> publications; //List of publications called publications
}
