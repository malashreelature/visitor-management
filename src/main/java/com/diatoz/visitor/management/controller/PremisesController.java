package com.diatoz.visitor.management.controller;
import com.diatoz.visitor.management.entity.Premises;
import com.diatoz.visitor.management.service.PremisesService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearerAuth")
public class PremisesController {

    @Autowired
    PremisesService premisesService;

    @GetMapping("/premises/all")
    public List<Premises> getAll(){
        return premisesService.getAll();
    }

    @PostMapping("/premises")
    public ResponseEntity<?> createPremises(@RequestBody Premises premises){
        premisesService.savePremises(premises);
        return new ResponseEntity<>("Premises entity created successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/premises/{id}")
    public ResponseEntity<Premises> getPremiseById(@PathVariable("id") Long id){
        return ResponseEntity.ok(premisesService.getPremiseById(id));
    }

    @DeleteMapping("/premises/{id}")
    public ResponseEntity<String> deletePremises(@PathVariable("id") Long id){
        premisesService.deletePremisesById(id);
        return new ResponseEntity<>("premises entity deleted successfully.", HttpStatus.OK);
    }
}

