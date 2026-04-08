package com.example.demo.controller;

import com.example.demo.model.AvisoModel;
import com.example.demo.service.AvisoService;
import com.example.demo.service.QuadroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/aviso")
public class AvisoController {
    @Autowired
    private AvisoService avisoService;
    @Autowired
    private QuadroService quadroService;

//    @GetMapping
//    @Operation(description = "Encontra todos os avisos")
//    public ResponseEntity<?> findAll(){
//        var response = this.service.findAll();
//        return ResponseEntity.ok(response);
//    }

    @PostMapping("/{id}")
    @Operation
    public ResponseEntity<?> save(@PathVariable("id") Long idQuadro, @RequestBody AvisoModel aviso){
        this.quadroService.salvarAviso(idQuadro, aviso);
        return ResponseEntity.ok(aviso);
    }
}
