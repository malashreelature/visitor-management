package com.diatoz.visitor.management.controller;

import com.diatoz.visitor.management.entity.AcessControl;
import com.diatoz.visitor.management.model.AcessModel;
import com.diatoz.visitor.management.service.AcessControlService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AcessController {


    @Autowired
    AcessControlService acessControlService;


    @GetMapping("/allAccess")
    @ApiOperation(value="It Is finding all access Data")
    public List<AcessControl> getAll(){
        return acessControlService.getAll();
    }


    @PostMapping("/access")
    @ApiOperation(value="It Is Creating New  ata")
    public ResponseEntity<AcessModel> CreateAcessControl(@RequestBody AcessControl acessControl) {
        AcessModel model = new AcessModel();
        try {
            if (model!= null) {
                model = (AcessModel) acessControlService.saveAcessControl(acessControl);
                return new ResponseEntity<>(model, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(model, HttpStatus.valueOf(500));
        }

    }




    @GetMapping("/access/{accessId}")
    @ApiOperation(value="It Is finding AccessControl by accessId ")
    public ResponseEntity<AcessModel> getById(@PathVariable Long acessId) {
        AcessModel outputModel = new AcessModel();
        try {
            outputModel = this.acessControlService.findById(acessId);
            if (outputModel.getErrorMessage().equals("")) {
                return new ResponseEntity<>(outputModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(outputModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(outputModel, HttpStatus.valueOf(500));
        }


    }

    @DeleteMapping("/access/{id}")
    @ApiOperation(value="It Is deleting AccessControl by accessId ")
    public ResponseEntity<AcessModel> deleteAcess(@PathVariable("id") Long acessId) {
        AcessModel outputModel1 = new AcessModel();
        outputModel1 = (AcessModel) this.acessControlService.deleteById(acessId);
        return new ResponseEntity<>(outputModel1, HttpStatus.OK);

    }
}
