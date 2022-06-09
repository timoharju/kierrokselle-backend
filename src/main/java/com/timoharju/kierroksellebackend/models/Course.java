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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String courseName;
    @NotBlank
    private String city;
    @NotBlank
    private String address;
    private String description;
    @Min(0)
    @Max(1000)
    private int holeCount;
    @Min(1)
    @Max(5)
    @Column(columnDefinition = "double default 3.0")
    private double rating;
    @Min(-90)
    @Max(90)
    @Column(nullable = false)
    private double lat = 1.0;
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
