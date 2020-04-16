package com.baden.demo.service;

import com.baden.demo.model.Owner;
import com.baden.demo.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;


import java.util.List;



@Component
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public OwnerRepository getOwnerRepository() {
        return ownerRepository;
    }

    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }



    public OwnerServiceImpl() {
        super();
    }

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> findAllOwners() throws OwnerServiceException {
        try {
            return ownerRepository.findAll();
        } catch (DataAccessException e) {
            throw new OwnerServiceException("Exception finding owners", e);
        }
    }


}
