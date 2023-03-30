package com.diatoz.visitor.management.controller;
import com.diatoz.visitor.management.entity.AccessControl;
import com.diatoz.visitor.management.service.AccessControlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "AccessController", description = "The AccessController API. Contains all the operations that can be performed on a AccessController.")
public class AccessController {

    @Autowired
    AccessControlService accessControlService;

    @GetMapping("/access/all")
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