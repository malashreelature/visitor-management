package com.diatoz.visitor.management.controller;

import com.diatoz.visitor.management.model.VisitorModel;
import com.diatoz.visitor.management.entity.Visitor;
import com.diatoz.visitor.management.service.VisitorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitorController {
    @Autowired
    VisitorService visitorService;


    @GetMapping("/allvisitor")
    @ApiOperation(value="It Is finding all Visitor Data")
    public ResponseEntity<List<Visitor>> getAll() {

        List<Visitor> listOfAllVisitor = visitorService.getAll();
        return new ResponseEntity<List<Visitor>>(listOfAllVisitor, HttpStatus.OK);
    }

    @PostMapping("/visitor")
    @ApiOperation(value="It Is creating new Visitor Data")

    public ResponseEntity<VisitorModel> CreateVisitor(@RequestBody Visitor visitor) {
        VisitorModel model = new VisitorModel();
        try {
            if (model != null) {
                model = (VisitorModel) visitorService.saveVisitor(visitor);
                return new ResponseEntity<>(model, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(model, HttpStatus.valueOf(500));
        }

    }


    @GetMapping("/visitor/{visitorId}")
    @ApiOperation(value="It Is finding Visitor By visitorId Data")
    public ResponseEntity<VisitorModel> getBId(@PathVariable Long visitorId) {
        VisitorModel outputModel = new VisitorModel();
        try {
            outputModel = this.visitorService.findById(visitorId);
            if (outputModel.getErrorMessage().equals("")) {
                return new ResponseEntity<>(outputModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(outputModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(outputModel, HttpStatus.valueOf(500));
        }


    }

    @DeleteMapping("/visitor/{id}")
    @ApiOperation(value="It Is deleting  Visitor By visitorId Data")

    public ResponseEntity<VisitorModel> deleteVisitor(@PathVariable("id") Long visitorId) {
        VisitorModel outputModel1 = new VisitorModel();
        outputModel1 = (VisitorModel) this.visitorService.deleteById(visitorId);
        return new ResponseEntity<>(outputModel1, HttpStatus.OK);

    }
}
