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
    private final StudentRepository studentRepository; //Link to the ProfessorRepository
    private final HttpExecutionContext ec;
   
    /*
    @Inject
    public AuthorController(FormFactory formFactory, AuthorRepository authorRepository, HttpExecutionContext ec) {
        this.formFactory = formFactory;
        this.authorRepository = authorRepository;
        this.ec = ec;
    }*/
    
    @Inject
    public ProfessorController(FormFactory formFactory, ProfessorRepository professorRepository, HttpExecutionContext ec){
        this.formFactory = formFactory;
        this.professorRepository = professorRepository;
        this.ec = ec;
    }
    
    /*
    public Result index() {
        return ok(views.html.author.render());
    }*/
    
     public Result index() {
        return ok(views.html.professor.render());
    }

    /*public CompletionStage<Result> getAuthor(Long id) {
        return authorRepository.get(id).thenApplyAsync(authorStream -> {
            return ok(views.html.singleauthor.render(authorStream.collect(Collectors.toList()).get(0)));
        }, ec.current());
    }*/

    public CompletionStage<Result> getProfessor(String id) {
        return professorRepository.get(id).thenApplyAsync(professorStream -> {
            return ok(views.html.singleprofessor.render(professorStream.collect(Collectors.toList()).get(0)));
        }, ec.current());
    }
    
    /*public CompletionStage<Result> addAuthor() { //Function when "POST /author"
        Author author = formFactory.form(Author.class).bindFromRequest().get();
        return authorRepository.add(author).thenApplyAsync(p -> {
            return redirect(routes.AuthorController.index());
        }, ec.current());
    }*/
    
    public CompletionStage<Result> addProfessor() { //Function when "POST /author"
        Professor professor = formFactory.form(Professor.class).bindFromRequest().get();
        return professorRepository.add(professor).thenApplyAsync(p -> {
            return redirect(routes.ProfessorController.index());
        }, ec.current());
    }

    /*public CompletionStage<Result> getAuthorsJson() { // Function when "GET /authorsJSON"
        return authorRepository.list().thenApplyAsync(authorStream -> {
            return ok(toJson(authorStream.collect(Collectors.toList())));
        }, ec.current());
    }*/

    public CompletionStage<Result> getProfessorJson() { // Function when "GET /authorsJSON"
        return professorRepository.list().thenApplyAsync(professorStream -> {
            return ok(toJson(professorStream.collect(Collectors.toList())));
        }, ec.current());
    }

    /*public CompletionStage<Result> getAuthors() {
        return authorRepository.list().thenApplyAsync(authorStream -> {
            return ok(views.html.listauthors.render(authorStream.collect(Collectors.toList())));
        }, ec.current());
    }*/
    
    public CompletionStage<Result> getProfessors() {
        return professorRepository.list().thenApplyAsync(professorStream -> {
            return ok(views.html.listprofessors.render(professorStream.collect(Collectors.toList())));
        }, ec.current());
    }

    /*public CompletionStage<Result> searchAuthors(String name) { // Function when "GET /author"
        return authorRepository.searchByName(name).thenApplyAsync(authorStream -> {
            return ok(views.html.listauthors.render(authorStream.collect(Collectors.toList())));
        }, ec.current());
    }*/
    
    public CompletionStage<Result> searchProfessors(String name) { // Function when "GET /professor"
        return professorRepository.searchByName(name).thenApplyAsync(professorStream -> {
            return ok(views.html.listprofessors.render(professorStream.collect(Collectors.toList())));
        }, ec.current());
    }
    
    
}
