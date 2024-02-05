package es.competition.surf.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "surfer")
public class Surfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "score", nullable = false)
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "surfboard_id")
    private SurfBoard surfBoard;


}