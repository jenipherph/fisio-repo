//Author: Dr. Rodrigo Garcia Carmona
//Code Editor: Jenipher Gonzalez Aponte
// Course: MAIS 810

package controllers;

import models.Student; // Student.java
import models.StudentRepository; // StudentRepository.java
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static play.libs.Json.toJson;

/**
 * The controller keeps all database operations behind the repository, and uses
 * {@link play.libs.concurrent.HttpExecutionContext} to provide access to the
 * {@link play.mvc.Http.Context} methods like {@code request()} and {@code flash()}.
 */
public class StudentController extends Controller {

   /* private final FormFactory formFactory;
    private final AuthorRepository authorRepository; // Verify this code
    private final HttpExecutionContext ec;
    */
    private final FormFactory formFactory;
    private final StudentRepository studentRepository; //Link to the StudentRepository
    private final HttpExecutionContext ec;

    /*
    @Inject
    public AuthorController(FormFactory formFactory, AuthorRepository authorRepository, HttpExecutionContext ec) {
        this.formFactory = formFactory;
        this.authorRepository = authorRepository;
        this.ec = ec;
    }*/

    @Inject
    public StudentController(FormFactory formFactory, StudentRepository studentRepository, HttpExecutionContext ec){
        this.formFactory = formFactory;
        this.studentRepository = studentRepository;
        this.ec = ec;
    }
    
    /*
    public Result index() {
        return ok(views.html.author.render());
    }*/
    
     public Result index() {
        return ok(views.html.student.render());
    }

    /*public CompletionStage<Result> getAuthor(Long id) {
        return authorRepository.get(id).thenApplyAsync(authorStream -> {
            return ok(views.html.singleauthor.render(authorStream.collect(Collectors.toList()).get(0)));
        }, ec.current());
    }*/

    public CompletionStage<Result> getStudent(String id) {
        return studentRepository.get(id).thenApplyAsync(studentStream -> {
            return ok(views.html.singlestudent.render(studentStream.collect(Collectors.toList()).get(0)));
        }, ec.current());
    }
    
    /*public CompletionStage<Result> addAuthor() { //Function when "POST /author"
        Author author = formFactory.form(Author.class).bindFromRequest().get();
        return authorRepository.add(author).thenApplyAsync(p -> {
            return redirect(routes.AuthorController.index());
        }, ec.current());
    }*/
    
    public CompletionStage<Result> addStudent() { //Function when "POST /author"
        Student student = formFactory.form(Student.class).bindFromRequest().get();
        return studentRepository.add(student).thenApplyAsync(p -> {
            return redirect(routes.StudentController.index());
        }, ec.current());
    }

    /*public CompletionStage<Result> getAuthorsJson() { // Function when "GET /authorsJSON"
        return authorRepository.list().thenApplyAsync(authorStream -> {
            return ok(toJson(authorStream.collect(Collectors.toList())));
        }, ec.current());
    }*/

    public CompletionStage<Result> getStudentJson() { // Function when "GET /authorsJSON"
        return studentRepository.list().thenApplyAsync(studentStream -> {
            return ok(toJson(studentStream.collect(Collectors.toList())));
        }, ec.current());
    }

    /*public CompletionStage<Result> getAuthors() {
        return authorRepository.list().thenApplyAsync(authorStream -> {
            return ok(views.html.listauthors.render(authorStream.collect(Collectors.toList())));
        }, ec.current());
    }*/
    
    public CompletionStage<Result> getStudents() {
        return studentRepository.list().thenApplyAsync(studentStream -> {
            return ok(views.html.liststudents.render(studentStream.collect(Collectors.toList())));
        }, ec.current());
    }

    /*public CompletionStage<Result> searchAuthors(String name) { // Function when "GET /author"
        return authorRepository.searchByName(name).thenApplyAsync(authorStream -> {
            return ok(views.html.listauthors.render(authorStream.collect(Collectors.toList())));
        }, ec.current());
    }*/
    
    public CompletionStage<Result> searchStudents(String name) { // Function when "GET /professor"
        return studentRepository.searchByName(name).thenApplyAsync(studentStream -> {
            return ok(views.html.liststudents.render(studentStream.collect(Collectors.toList())));
        }, ec.current());
    }
    
    
}
