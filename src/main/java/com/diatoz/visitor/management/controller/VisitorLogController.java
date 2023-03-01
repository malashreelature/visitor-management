package com.diatoz.visitor.management.controller;

import com.diatoz.visitor.management.entity.VisitorLog;
import com.diatoz.visitor.management.model.VisitorLogModel;
import com.diatoz.visitor.management.service.VisitorLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitorLogController {


    @Autowired
    VisitorLogService visitorLogService;

    @GetMapping("/allvisitorLog")
    @ApiOperation(value = "It Is finding all VisitorLog data")

    public List<VisitorLog> getAll() {
        return visitorLogService.getAll();
    }


    @PostMapping("/visitorLog")
    @ApiOperation(value = "It Is creating  VisitorLog Data")

    public ResponseEntity<VisitorLogModel> CreateVisitorLog(@RequestBody VisitorLog visitor) {
        VisitorLogModel model = new VisitorLogModel();
        try {
            if (model != null) {
                model = (VisitorLogModel) visitorLogService.saveVisitorLog(visitor);
                return new ResponseEntity<>(model, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(model, HttpStatus.valueOf(500));
        }

    }


    @GetMapping("/visitorLog/{visitorId}")
    @ApiOperation(value = "It Is finding  VisitorLog By id Data")

    public ResponseEntity<VisitorLogModel> getById(@PathVariable Long id) {
        VisitorLogModel outputModel = new VisitorLogModel();
        try {
            outputModel = this.visitorLogService.findById(id);
            if (outputModel.getErrorMessage().equals("")) {
                return new ResponseEntity<>(outputModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(outputModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(outputModel, HttpStatus.valueOf(500));
        }


    }

    @DeleteMapping("/visitorLog/{id}")
    @ApiOperation(value = "It Is deleting  VisitorLog By id Data")
    public ResponseEntity<VisitorLogModel> deleteVisitor(@PathVariable("id") Long id) {
        VisitorLogModel outputModel1 = new VisitorLogModel();
        outputModel1 = (VisitorLogModel) this.visitorLogService.deleteById(id);
        return new ResponseEntity<>(outputModel1, HttpStatus.OK);

    }
}



