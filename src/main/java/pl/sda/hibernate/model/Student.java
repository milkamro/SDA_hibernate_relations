package pl.sda.hibernate.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imie;

    @Column(nullable = false)
    private String nazwisko;

    // @Column(nullable = false)
    private int rokRozpoczeciaStudiow;

    // nie chcemy aby byla to kolumna
    @Formula("(SELECT AVG(o.wartosc) FROM ocena o WHERE o.uczen_id=1)")
    private Double sredniaOcen;

    // RELACJE
@OneToMany(mappedBy = "uczen")
// @ToStringExclude opcjonalnie, nie musi byc z obu stron jak to nizej
@EqualsAndHashCode.Exclude

    private Set<Ocena> oceny;

}
