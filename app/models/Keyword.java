package models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Keyword {

    @Id //Indication that is the primary key 
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id; // Primary Key
    //Attribute of Keyword
    public String name;

    @ManyToMany(mappedBy="keywords")
    @JsonIgnore
    public List<Publication> publications;
}
