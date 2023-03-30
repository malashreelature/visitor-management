package com.diatoz.visitor.management.controller;
import com.diatoz.visitor.management.dtomodel.VisitorDto;
import com.diatoz.visitor.management.entity.Visitor;
import com.diatoz.visitor.management.service.VisitorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "VisitorController", description = "The VisitorController API. Contains all the operations that can be performed on a VisitorController.")
public class VisitorController {


    @Autowired
    private ModelMapper modelMapper;

    private VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        super();
        this.visitorService = visitorService;
    }

    @GetMapping("/visitor/all")
    public List<VisitorDto> getAllVisitor() {
        return visitorService.getAll().stream().map(visitor -> modelMapper.map(visitor, VisitorDto.class))
            .collect(Collectors.toList());
}

    @PostMapping("/visitor")
    public ResponseEntity<VisitorDto> createVisitor(@RequestBody Visitor visitor){
        VisitorDto vResponse = modelMapper.map(visitor, VisitorDto.class);
        return new ResponseEntity<VisitorDto>(vResponse, HttpStatus.CREATED);
    }


    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<VisitorDto> getVisitorById(@PathVariable("visitorId") Long visitorId){
        Visitor v=visitorService.getVisitorById(visitorId);
        // convert entity to DTO
         VisitorDto visitorResponse=modelMapper.map(v,VisitorDto.class);
        return ResponseEntity.ok().body(visitorResponse);
    }


    @DeleteMapping("/visitor/{visitorId}")
    public ResponseEntity<String> deleteVisitor(@PathVariable("visitorId") Long visitorId){
        visitorService.deleteVisitorById(visitorId);
        return new ResponseEntity<>("Visitor entity deleted successfully.", HttpStatus.OK);
    }
}




