package tn.homejek.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "booking")
@Entity
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Service_ service;

    @ManyToOne
    private ServiceProvider serviceProvider;

    private Date date;

    private String payment_Id;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;

}
