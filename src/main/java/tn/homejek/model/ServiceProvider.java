package tn.homejek.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class ServiceProvider extends User implements Serializable {

//    private boolean isValidated;

    private String cin_recto_image;
    private String cin_verso_image;

    private String personal_image;

    @Enumerated(EnumType.ORDINAL)
    private ValidationStatus status;

    @ManyToOne
    private Category category;

}
