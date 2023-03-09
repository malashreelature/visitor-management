package com.diatoz.visitor.management.controller;

import com.diatoz.visitor.management.entity.AccessControl;

import com.diatoz.visitor.management.service.AccessControlService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccessController {


    @Autowired
    AccessControlService accessControlService;



    @GetMapping("/access/all")
    @ApiOperation(value="It Is finding all access Data")
    public List<AccessControl> getAll(){
        return accessControlService.getAll();
    }


    @PostMapping("/access")
    public ResponseEntity<?> createUser(@RequestBody AccessControl acessControl){
        accessControlService.saveAcessControl(acessControl);
        return new ResponseEntity<>("Access entity created successfully.", HttpStatus.CREATED);    }

    @GetMapping("/access/{accessId}")
    public ResponseEntity<AccessControl> getUserById(@PathVariable("accessId") Long accessId){
        return ResponseEntity.ok(accessControlService.getAccessById(accessId));
    }



    @DeleteMapping("/access/{accessId}")
    public ResponseEntity<String> deleteUser(@PathVariable("accessId") Long accessId){

        accessControlService.deleteAccessById(accessId);

        return new ResponseEntity<>("Access entity deleted successfully.", HttpStatus.OK);
    }
}