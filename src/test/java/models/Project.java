package models;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@Setter
public class Project {
    @EqualsAndHashCode.Exclude
    private int id;
    private String name;
    private String projectKey;
    private String description;


}