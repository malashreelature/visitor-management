package com.diatoz.visitor.management.controller;

import com.diatoz.visitor.management.entity.Host;
import com.diatoz.visitor.management.service.HostService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "HostController", description = "The HostController API. Contains all the operations that can be performed on a HostController.")
public class HostController {

    @Autowired
    HostService hostService;


    @GetMapping("/host/all")
    public List<Host> getAll(){
        return hostService.getAll();
    }

    @PostMapping("/host")
    public ResponseEntity<?> createHost(@RequestBody Host host){
        hostService.saveHost(host);
        return new ResponseEntity<>("Host entity created successfully.", HttpStatus.CREATED);    }

    @GetMapping("/host/{hostId}")
    public ResponseEntity<Host> getHostById(@PathVariable("hostId") Long hostId){

        return ResponseEntity.ok(hostService.getHostById(hostId));
    }

    @DeleteMapping("/host/{hostId}")
    public ResponseEntity<String> deleteUser(@PathVariable("hostId") Long hostId){

        hostService.deleteHostById(hostId);

        return new ResponseEntity<>("Host entity deleted successfully.", HttpStatus.OK);
    }
}

