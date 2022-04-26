package com.timoharju.kierroksellebackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
