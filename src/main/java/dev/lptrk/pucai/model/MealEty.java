package dev.lptrk.pucai.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "meal")
public class MealEty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mealId;
    private String mealName;
    private String mealDescription;
    @Timestamp
    private Date mealTime = new Date();
}
