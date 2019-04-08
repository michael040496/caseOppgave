package no.noroff.property.owner.ownership_log;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ownership_log")
public class OwnershipLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownership_log_id;
    private LocalDateTime date_acquired;
    private LocalDateTime date_sold;
    private LocalDateTime created_at;
    private int property_id;
    private int owner_id;
}
