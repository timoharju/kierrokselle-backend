package com.timoharju.kierroksellebackend.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String courseName;
    @NotBlank
    private int holeCount;
    @NotBlank
    @Column(nullable = false)
    private double lat;
    @NotBlank
    @Column(nullable = false)
    private double lon;

}
