package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 * 
 * Interface -> a contract that must be followed through 
 */
@ImplementedBy(JPAAuthorRepository.class)
public interface AuthorRepository { //The things that could be done to Authors

    CompletionStage<Author> add(Author author); // Add a new Author

    CompletionStage<Stream<Author>> list(); //Shows all the Authors

    CompletionStage<Stream<Author>> get(Long id); //Shows a single Author by ID

    CompletionStage<Stream<Author>> searchByName(String name); // Shows Authors based on the Name
}