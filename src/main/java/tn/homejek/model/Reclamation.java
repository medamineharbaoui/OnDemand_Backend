package tn.homejek.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "reclamation_")
@Entity
public class Reclamation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.ORDINAL)
    private ReclamationStatus status;

    private String object;

    private String description;

    @ManyToOne
    private Client reporter;

    @ManyToOne
    private Admin assignee;
}
