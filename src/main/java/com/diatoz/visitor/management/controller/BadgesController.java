package com.diatoz.visitor.management.controller;

import com.diatoz.visitor.management.entity.Badges;
import com.diatoz.visitor.management.entity.Host;
import com.diatoz.visitor.management.model.BadgesModel;
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

    @GetMapping("/allbadges")
    @ApiOperation(value="It Is finding all Badges Data")
    public List<Badges> getAll(){
        return badgesService.getAll();
    }


    @PostMapping("/badges")
    @ApiOperation(value="It Is creating new  Badges  Data")
    public ResponseEntity<BadgesModel> CreateBadges(@RequestBody Badges badges) {
        BadgesModel model = new BadgesModel();
        try {
            if (model != null) {
                model = (BadgesModel) badgesService.saveBadges(badges);
                return new ResponseEntity<>(model, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(model, HttpStatus.valueOf(500));
        }

    }




    @GetMapping("/badges/{badgesId}")
    @ApiOperation(value="It Is finding  Badges by badgesId Data")
    public ResponseEntity<BadgesModel> getById(@PathVariable Long id) {
        BadgesModel model = new BadgesModel();
        try {
            model = this.badgesService.findById(id);
            if (model.getErrorMessage().equals("")) {
                return new ResponseEntity<>(model, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(model, HttpStatus.valueOf(500));
        }


    }

    @DeleteMapping("/badges/{id}")
    @ApiOperation(value="It Is deleting  Badges by badgesId Data")
    public ResponseEntity<BadgesModel> deleteAcess(@PathVariable("id") Long id) {
        BadgesModel outputModel1 = new BadgesModel();
        outputModel1 = (BadgesModel) this.badgesService.deleteById(id);
        return new ResponseEntity<>(outputModel1, HttpStatus.OK);

    }
}
