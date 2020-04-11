package com.baden.demo.controller;

import com.baden.demo.model.Owner;
import com.baden.demo.service.OwnerService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OwnerController.class)
public class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerService ownerService;

    @Test
    public void testSimple() throws Exception {
        when(ownerService.findAllOwners())
                .thenReturn(Arrays.asList(new Owner(1,"Gareth","Badenhorst")));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/owners")
                .accept(MediaType.APPLICATION_JSON);

        assertEquals (ownerService.findAllOwners().size(),1);
        assertEquals(ownerService.findAllOwners().get(0), new Owner(1,"Gareth","Badenhorst"));
        List<Owner> owners = ownerService.findAllOwners();

        MvcResult result = mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1, firstName : Gareth, lastName: Badenhorst}]"))
                .andReturn();


    }
}
