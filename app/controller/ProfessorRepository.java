/************************************************
  Author: Prof. Rodrigo Garcia Carmona
  Editor: Jenipher D. González Aponte
  Project: UAGM Professor Grade Application

  File: ProfessorRepository.java
  Functions:
    ->
    ->
************************************************/
package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPAProfessorRepository.class)
public interface ProfessorRepository {

    CompletionStage<Author> add(Author author);

    CompletionStage<Stream<Author>> list();

    CompletionStage<Stream<Author>> get(Long id);

    CompletionStage<Stream<Author>> searchByName(String name);
}
