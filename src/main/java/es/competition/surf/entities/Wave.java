package es.competition.surf.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "wave")
public class Wave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "height", nullable = false)
    private Double height;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "dates", nullable = false)
    private LocalDateTime dates;

    @ManyToOne
    @JoinColumn(name = "spot_id")
    private Spot spot;

    @OneToOne
    @JoinColumn(name = "surfer_id")
    private Surfer surfer;


}