package models;

import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Provide JPA operations running inside of a thread pool sized to the connection pool
 *
 * Makes sure to follow through the contract
 */
public class JPAStudentRepository implements StudentRepository{

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPAStudentRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    /*// Implementation of Repository methods
    @Override // Function <add> ->> adds to the DB a new author
    public CompletionStage<Author> add(Author author) {
        return supplyAsync(() -> wrap(em -> insert(em, author)), executionContext);
    }*/

    @Override // Function <add> ->> adds to the DB a new author
    public CompletionStage<Student> add(Student student) {
        return supplyAsync(() -> wrap(em -> insert(em, student)), executionContext);
    }

    /*@Override // Creates a query
    public CompletionStage<Stream<Author>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executionContext);
    }*/
    @Override // Creates a query
    public CompletionStage<Stream<Student>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executionContext);
    }

    /*@Override
    public CompletionStage<Stream<Author>> get(Long id) {
        return supplyAsync(() -> wrap(em -> get(em, id)), executionContext);
    }*/
    @Override
    public CompletionStage<Stream<Student>> get(String id) {
        return supplyAsync(() -> wrap(em -> get(em, id)), executionContext);
    }


    /*@Override
    public CompletionStage<Stream<Author>> searchByName(String name) {
        return supplyAsync(() -> wrap(em -> searchByName(em, name)), executionContext);
    }*/

    @Override
    public CompletionStage<Stream<Student>> searchByName(String name) {
        return supplyAsync(() -> wrap(em -> searchByName(em, name)), executionContext);
    }

    // JPA methods
    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    /*private Author insert(EntityManager em, Author author) {
        em.persist(author);
        return author;
    }*/

    private Student insert(EntityManager em, Student student) {
        em.persist(student);
        return student;
    }

    /*private Stream<Author> list(EntityManager em) {
        List<Author> authors = em.createQuery("select a from Author a", Author.class).getResultList();
        return authors.stream();
    }*/

    private Stream<Student> list(EntityManager em) {
        List<Student> student = em.createQuery("select a from Student a", Student.class).getResultList();
        return student.stream();
    }

    /*private Stream<Author> get(EntityManager em, Long id) {
        List<Author> authors = em.createQuery("select a from Author a where id=" + id, Author.class).getResultList();
        return authors.stream();
    }*/

    private Stream<Student> get(EntityManager em, String id) {
        List<Student> student = em.createQuery("select a from Student a where id=" + id, Student.class).getResultList();
        return student.stream();
    }

    /*private Stream<Author> searchByName(EntityManager em, String name) {
        List<Author> authors = em.createQuery("select a from Author a where a.name LIKE '%" + name + "%'", Author.class).getResultList();
        return authors.stream();
    }*/

    private Stream<Student> searchByName(EntityManager em, String name) {
        List<Student> student = em.createQuery("select a from Student a where a.name LIKE '%" + name + "%'", Student.class).getResultList();
        return student.stream();
    }
}
