package pl.sda.hibernate.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Ocena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable=false)
private double wartosc;
// insert into ocena values(1, 4.5, now())
    @CreationTimestamp // odpowiednik sql funkcja now()
private LocalDateTime dataCzasDodania;


    // RELACJE
    @ManyToOne
    private Student uczen; //kolumna student_id
}
