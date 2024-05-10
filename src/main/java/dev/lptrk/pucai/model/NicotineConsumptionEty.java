package dev.lptrk.pucai.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "nicotine_consumption")
public class NicotineConsumptionEty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEty user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date consumptionDate;

    private Double amount;

    private String consumptionType;
}
