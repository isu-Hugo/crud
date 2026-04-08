package com.example.demo.service;

import com.example.demo.model.AvisoModel;
import com.example.demo.model.QuadroModel;
import com.example.demo.repository.AvisoRepository;
import com.example.demo.repository.QuadroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuadroService {
    @Autowired
    private QuadroRepository repository;
    @Autowired
    private AvisoRepository avisoRepository;

    public List<QuadroModel> findAll(){
        return this.repository.findAll();
    }

    public QuadroModel save(QuadroModel quadroModel){
        return this.repository.save(quadroModel);
    }

    public QuadroModel salvarAviso(Long idQuadro, AvisoModel aviso){
        var quadro = repository.findById(idQuadro).orElseThrow();
        quadro.addAviso(aviso);
        return repository.save(quadro);
    }

    public QuadroModel removerAviso(Long idQuadro, Long idAviso){
        var quadro = repository.findById(idQuadro).orElseThrow();
        var aviso = avisoRepository.findById(idAviso).orElseThrow();

        quadro.removerAviso(aviso);

        return this.repository.save(quadro);
    }

}
