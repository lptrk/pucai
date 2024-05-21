package dev.lptrk.pucai.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class PucaiEty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEty user;

}
