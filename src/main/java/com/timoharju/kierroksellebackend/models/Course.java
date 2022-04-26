package com.timoharju.kierroksellebackend.models;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String courseName;
    @Min(0)
    @Max(1000)
    private int holeCount;
    @Min(-90)
    @Max(90)
    @Column(nullable = false)
    private double lat;
    @Min(-180)
    @Max(180)
    @Column(nullable = false)
    private double lon;
    private String courseDifficulty;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
