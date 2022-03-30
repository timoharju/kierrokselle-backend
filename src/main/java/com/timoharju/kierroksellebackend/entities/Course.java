package com.timoharju.kierroksellebackend.entities;

import javax.persistence.Entity;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course extends AbstractPersistable<Long> {

    private String courseName;
    private int holeCount;
    private double lat;
    private double lon;

}
