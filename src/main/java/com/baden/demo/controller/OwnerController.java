package com.baden.demo.controller;

import com.baden.demo.model.Owner;
import com.baden.demo.service.OwnerException;
import com.baden.demo.service.OwnerService;
import com.baden.demo.service.OwnerServiceException;
import com.baden.demo.service.OwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;


    @GetMapping("/owners")
    public List<Owner> findAllOwners() throws OwnerServiceException {
        return ownerService.findAllOwners();
    }
}
