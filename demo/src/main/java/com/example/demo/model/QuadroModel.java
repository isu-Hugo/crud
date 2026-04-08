package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tbl_quadro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuadroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "quadro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvisoModel> avisos;

    public void addAviso(AvisoModel aviso){
        this.avisos.add(aviso);
        aviso.setQuadro(this);
    }

    public void removerAviso(AvisoModel aviso){
        this.avisos.remove(aviso);
        aviso.setQuadro(null);
    }
}
