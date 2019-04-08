package no.noroff.property.valuation;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "valuation")
public class Valuation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int valuation_id;
    private String comments;
    private int value;
    private LocalDateTime valuation_date;
    private int property_id;
}
