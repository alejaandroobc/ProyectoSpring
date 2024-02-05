package es.competition.surf.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "surfboard")
public class SurfBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "sbsize",nullable = false)
    private Double sbsize;

    @Column(name = "maker",nullable = false)
    private String maker;

    @Column(name = "sbyear", nullable = false)
    private Integer sbyear;

    @OneToMany(mappedBy = "surfBoard")
    private List<Surfer> surfers = new ArrayList<>();


}