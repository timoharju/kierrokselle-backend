package com.timoharju.kierroksellebackend;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@Entity     
@NoArgsConstructor
@AllArgsConstructor
public class Course extends AbstractPersistable<Long> {

    private String courseName;
    private int holeCount;
    private double yCoordinate;
    private double xCoordinate;

}
