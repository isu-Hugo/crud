package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_avisos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvisoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "quadro_id")
    private QuadroModel quadro;



}
