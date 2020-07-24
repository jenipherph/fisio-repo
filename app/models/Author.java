package models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Author { //Class Name: Author

    @Id //To determine that is the Primary Key
    @GeneratedValue(strategy=GenerationType.AUTO)
   //id -> PrimaryKey
    public Long id;
    //Author Attribute
    public String name;
    public String email;
    public String affiliation;

    @ManyToMany(mappedBy="authors") 
    @JsonIgnore
    public List<Publication> publications; //List of publications called publications
}
