package com.diatoz.visitor.management.controller;

import com.diatoz.visitor.management.entity.Badges;
import com.diatoz.visitor.management.service.BadgesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BadgesController {

    @Autowired
    BadgesService badgesService;

    @GetMapping("/badges/all")
    @ApiOperation(value="It Is finding all Badges Data")
    public List<Badges> getAll(){
        return badgesService.getAll();
    }

    @PostMapping("/badges")
    public ResponseEntity<?> createBadges(@RequestBody Badges badges){
        badgesService.saveBadges(badges);
        return new ResponseEntity<>("Badges entity created successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/badges/{id}")
    public ResponseEntity<Badges> getBadgesById(@PathVariable("id") Long id){
        return ResponseEntity.ok(badgesService.getBadgesById(id));
    }

    @DeleteMapping("/badges/{id}")
    public ResponseEntity<String> deleteBadges(@PathVariable("id") Long id){
        badgesService.deleteBadgesById(id);
        return new ResponseEntity<>("Badges entity deleted successfully.", HttpStatus.OK);
    }
}