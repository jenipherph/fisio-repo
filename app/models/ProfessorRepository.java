/*
  Author: Dr. Rodrigo Garcia Carmona
  Code Editor: Jenipher Gonzalez Aponte
  Course: MAIS 810
  
  File: ProfessorRepository.java 
  Functions:
   -> add(Professor professor);
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
@ImplementedBy(JPAProfessorRepository.class)
public interface ProfessorRepository { //The things that could be done to Authors

    
    CompletionStage<Professor> add(Professor professor); //Add a new Professor
    
    CompletionStage<Stream<Professor>> list(); // Show all the Professors
    
    CompletionStage<Stream<Professor>> get(String id); //Shows a single Professor by ID

    CompletionStage<Stream<Professor>> searchByName(String name); // Shows Professor based on the Name

    
}

 /*CompletionStage<Author> add(Author author); // Add a new Author

    CompletionStage<Stream<Author>> list(); //Shows all the Authors

    CompletionStage<Stream<Author>> get(Long id); //Shows a single Author by ID

    CompletionStage<Stream<Author>> searchByName(String name); // Shows Authors based on the Name*/