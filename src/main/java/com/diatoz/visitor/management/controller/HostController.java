package com.diatoz.visitor.management.controller;

import com.diatoz.visitor.management.entity.Host;
import com.diatoz.visitor.management.model.HostModel;
import com.diatoz.visitor.management.service.HostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HostController {

    @Autowired
    HostService hostService;


    @GetMapping("/allHost")
    @ApiOperation(value="It Is finding all Host ")
    public List<Host> getAll(){
        return hostService.getAll();
    }

    @PostMapping("/host")
    @ApiOperation(value="It Is creating new Host ")
    public ResponseEntity<HostModel> CreateHost(@RequestBody Host host) {
        HostModel model = new HostModel();
        try {
            if (model != null) {
                model = (HostModel) hostService.saveHost(host);
                return new ResponseEntity<>(model, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(model, HttpStatus.valueOf(500));
        }

    }




    @GetMapping("/host/{hostId}")
    @ApiOperation(value="It Is finding new Host By hostId ")
    public ResponseEntity<HostModel> getById(@PathVariable Long hostId) {
        HostModel outputModel = new HostModel();
        try {
            outputModel = this.hostService.findById(hostId);
            if (outputModel.getErrorMessage().equals("")) {
                return new ResponseEntity<>(outputModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(outputModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(outputModel, HttpStatus.valueOf(500));
        }


    }

    @DeleteMapping("/host/{id}")
    @ApiOperation(value="It Is deleting new Host b hostId ")
    public ResponseEntity<HostModel> deleteHost(@PathVariable("id") Long hostId) {
        HostModel outputModel1 = new HostModel();
        outputModel1 = (HostModel) this.hostService.deleteById(hostId);
        return new ResponseEntity<>(outputModel1, HttpStatus.OK);

    }
}
