package com.baden.demo.service;

import com.baden.demo.model.Owner;

import java.util.List;

public interface OwnerService {
    public List<Owner> findAllOwners() throws OwnerServiceException;
}
