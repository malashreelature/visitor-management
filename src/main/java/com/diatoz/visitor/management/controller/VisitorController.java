package com.diatoz.visitor.management.controller;

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


    @GetMapping("/visitor/all")
    @ApiOperation(value = "It Is finding all Visitor Data")
    public ResponseEntity<List<Visitor>> getAll() {

        List<Visitor> listOfAllVisitor = visitorService.getAll();
        return new ResponseEntity<List<Visitor>>(listOfAllVisitor, HttpStatus.OK);
    }


    @PostMapping("/visitor")
    public ResponseEntity<?> createVisitor(@RequestBody Visitor visitor){
        visitorService.saveVisitor(visitor);
        return new ResponseEntity<>("Visitor entity created successfully.", HttpStatus.CREATED);

    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable("visitorId") Long visitorId){
        return ResponseEntity.ok(visitorService.getVisitorById(visitorId));
    }



    @DeleteMapping("/visitor/{visitorId}")
    public ResponseEntity<String> deleteVisitor(@PathVariable("visitorId") Long visitorId){

        visitorService.deleteVisitorById(visitorId);

        return new ResponseEntity<>("Visitor entity deleted successfully.", HttpStatus.OK);
    }
}




