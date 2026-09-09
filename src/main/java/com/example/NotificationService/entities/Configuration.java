package com.example.NotificationService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "configuration")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Configuration {
    @Id
    private int id;

    @Column(name = "topic")
    private String topic;

    @ManyToOne
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    private Tipo tipo;

    @Column(name = "properties")
    private String properties;

    @Column(name = "values")
    private String values;


}
