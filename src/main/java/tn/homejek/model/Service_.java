package tn.homejek.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "service_")
@Entity
public class Service_ implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    private float price;

    @ManyToOne
    private Category category;

    @Enumerated(EnumType.ORDINAL)
    private ValidationStatus status;

    @ElementCollection
    private List<String> imagesUrl;

}
