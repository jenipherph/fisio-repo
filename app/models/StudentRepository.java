/*
  Author: Dr. Rodrigo Garcia Carmona
  Code Editor: Jenipher Gonzalez Aponte
  Course: MAIS 810

  File: StudentRepository.java
  Functions:
   -> add(Student student);
   -> list();
   -> get(String id);
   -> searchByName(String name);
 */

package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 *
 * Interface -> a contract that must be followed through
 */
@ImplementedBy(JPAStudentRepository.class)
public interface StudentRepository { //The things that could be done to Authors


    CompletionStage<Student> add(Student student); //Add a new Student

    CompletionStage<Stream<Student>> list(); // Show all the Students

    CompletionStage<Stream<Student>> get(String id); //Shows a single Student by ID

    CompletionStage<Stream<Student>> searchByName(String name); // Shows Student based on the Name


}

 /*CompletionStage<Author> add(Author author); // Add a new Author

    CompletionStage<Stream<Author>> list(); //Shows all the Authors

    CompletionStage<Stream<Author>> get(Long id); //Shows a single Author by ID

    CompletionStage<Stream<Author>> searchByName(String name); // Shows Authors based on the Name*/
