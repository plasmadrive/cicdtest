package com.baden.demo.service;

import com.baden.demo.model.Owner;
import com.baden.demo.repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class OwnerServiceTest {


    @InjectMocks
    private OwnerService ownerService = new OwnerServiceImpl();
    @Mock
    private OwnerRepository ownerRepository;

    @Test
    void findAllOwners_manyOwners() throws OwnerServiceException {
        assertNotNull(ownerRepository);
        when(ownerRepository.findAll()).thenReturn(new ArrayList<Owner>(Arrays.asList(
                new Owner(1,"Gareth","Badenhorst"),
                new Owner(2,"Sandra","Bruyns")
        )));

        List<Owner> owners = ownerService.findAllOwners();
        assertEquals (2, owners.size());
        assertEquals(owners.get(0), new Owner(1,"Gareth","Badenhorst"));
    }

    @Test
    void findAllOwners_oneOwner() throws OwnerServiceException {
        when(ownerRepository.findAll()).thenReturn(new ArrayList<Owner>(Arrays.asList(
                new Owner(1,"Gareth","Badenhorst")
              )));

        List<Owner> owners = ownerService.findAllOwners();
        assertEquals (1,owners.size());
        assertEquals(owners.get(0), new Owner(1,"Gareth","Badenhorst"));
    }

    @Test
    void findAllOwners_noOwners() throws OwnerServiceException {
        when(ownerRepository.findAll()).thenReturn(new ArrayList<Owner>(Arrays.asList(
                      )));

        List<Owner> owners = ownerService.findAllOwners();
        assertEquals (0,owners.size());

    }
}