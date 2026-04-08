package com.example.demo.controller;

import com.example.demo.model.AvisoModel;
import com.example.demo.model.QuadroModel;
import com.example.demo.service.QuadroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/quadro")
public class QuadroController {
    @Autowired
    private QuadroService quadroService;

    @PostMapping
    @Operation
    public ResponseEntity<?> criarQuadro(@RequestBody QuadroModel quadro){
        quadro.setAvisos(List.of());
        var response = this.quadroService.save(quadro);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(this.quadroService.findAll());
    }

    @PostMapping("/{id}")
    @Operation
    public ResponseEntity<?> criarAviso(@PathVariable("id") Long id, @RequestBody AvisoModel aviso){
        var response = this.quadroService.salvarAviso(id, aviso);
        return ResponseEntity.ok(response);
    }






}
