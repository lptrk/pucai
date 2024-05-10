package dev.lptrk.pucai.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "meals")
public class MealEty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mealId;
    private String mealName;
    private String mealDescription;
    @Temporal(TemporalType.TIMESTAMP)
    private Date mealTime = new Date();
    @ElementCollection
    private Set<String> ingredients = new HashSet<>();

}
