package com.example.demo.service;

import com.example.demo.model.AvisoModel;
import com.example.demo.repository.AvisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisoService {
    @Autowired
    private AvisoRepository repository;

    public List<AvisoModel> findAll(){
        return this.repository.findAll();
    }

    public AvisoModel save(AvisoModel aviso){
        return this.repository.save(aviso);
    }
}
