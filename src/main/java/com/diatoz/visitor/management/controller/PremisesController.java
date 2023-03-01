package com.diatoz.visitor.management.controller;

import com.diatoz.visitor.management.entity.AcessControl;
import com.diatoz.visitor.management.entity.Premises;
import com.diatoz.visitor.management.model.AcessModel;
import com.diatoz.visitor.management.model.PremisesModel;
import com.diatoz.visitor.management.service.PremisesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PremisesController {

    @Autowired
    PremisesService premisesService;


    @GetMapping("/allpremises")
    @ApiOperation(value="It Is finding new all Premises Data")

    public List<Premises> getAll(){
        return premisesService.getAll();
    }


    @PostMapping("/premises")
    @ApiOperation(value="It Is creating new Premises Data")

    public ResponseEntity<PremisesModel> CreatePremises(@RequestBody Premises premises) {
        PremisesModel model = new PremisesModel();
        try {
            if (model != null) {
                model = (PremisesModel) premisesService.savePremises(premises);
                return new ResponseEntity<>(model, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(model, HttpStatus.valueOf(500));
        }

    }




    @GetMapping("/premises/{id}")
    @ApiOperation(value="It Is finding Premises By premiseId Data")
    public ResponseEntity<PremisesModel> getById(@PathVariable Long id) {
        PremisesModel outputModel = new PremisesModel();
        try {
            outputModel = this.premisesService.findById(id);
            if (outputModel.getErrorMessage().equals("")) {
                return new ResponseEntity<>(outputModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(outputModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(outputModel, HttpStatus.valueOf(500));
        }


    }

    @DeleteMapping("/premises/{id}")
    @ApiOperation(value="It Is deleting new  Premises By premiseId Data")
    public ResponseEntity<PremisesModel> deleteAcess(@PathVariable("id") Long id) {
        PremisesModel model = new PremisesModel();
        model = (PremisesModel) this.premisesService.deleteById(id);
        return new ResponseEntity<>(model, HttpStatus.OK);

    }
}

