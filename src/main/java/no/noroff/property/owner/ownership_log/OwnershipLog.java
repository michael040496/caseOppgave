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

    @Column
    private int ownership_log_id;

    @Column
    private LocalDateTime date_acquired;

    @Column
    private LocalDateTime date_sold;

    @Column
    private LocalDateTime created_at;

    @Column
    private int property_id;

    @Column
    private int owner_id;

    public OwnershipLog(){

    }
}
