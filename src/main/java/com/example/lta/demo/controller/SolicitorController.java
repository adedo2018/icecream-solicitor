package com.example.lta.demo.controller;

import com.example.lta.demo.service.SolicitorDto;
import com.example.lta.demo.service.SolicitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sample controller to retrieve a user
 */
@RestController
@RequestMapping("/api")
public class SolicitorController {

    @Autowired
    SolicitorService solicitorService;

    public SolicitorController(SolicitorService solicitorService){
        this.solicitorService = solicitorService;
    }

    /**
     * retrieve a user provided the id
     * @param name to retrieve a user
     * @return a user whose id is provided
     */
    @GetMapping("/solicitors/{name}")
    public SolicitorDto getSolicitorContactByName(@PathVariable(value = "name") String name) {
        return solicitorService.getSocilitorContactByName(name);
    }
}
