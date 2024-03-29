package com.diatoz.visitor.management.controller;
import com.diatoz.visitor.management.entity.VisitorLog;
import com.diatoz.visitor.management.service.VisitorLogService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "VisitorLogController", description = "The VisitorLogController API. Contains all the operations that can be performed on a VisitorLogController.")
public class VisitorLogController {


    @Autowired
    VisitorLogService visitorLogService;

    @GetMapping("/visitorLog/all")
    public List<VisitorLog> getAll() {
        return visitorLogService.getAll();
    }

    @PostMapping("/visitorLog")
    public ResponseEntity<?> createVisitorLog(@RequestBody VisitorLog visitor){
        visitorLogService.saveVisitorLog(visitor);
        return new ResponseEntity<>("VisitorLog entity created successfully.", HttpStatus.CREATED);

    }
    @GetMapping("/visitorLog/{id}")
    public ResponseEntity<VisitorLog> getVisitorLogById(@PathVariable("id") Long id){
        return ResponseEntity.ok(visitorLogService.getVisitorLogById(id));
    }

    @DeleteMapping("/visitorLog/{id}")
    public ResponseEntity<String> deleteVisitorLog(@PathVariable("id") Long id){
        visitorLogService.deleteVisitorLogById(id);
        return new ResponseEntity<>("VisitorLog entity deleted successfully.", HttpStatus.OK);
    }
}
