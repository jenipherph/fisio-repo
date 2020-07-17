package models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Professor {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    public String id;

    public String FirstName;
    public String LastName;
    public String Email;

    @ManyToMany(mappedBy="professors")
    @JsonIgnore
    public List<Publication> publications;
}
