package com.test.service;

import com.test.domain.dto.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IAddressServiceTest {
    @Autowired
    private IAddressService addressService;
    @Test
    void testLogicDelete(){
        addressService.removeById(60L);
        Address address=addressService.getById(60L);
        System.out.println(address);
    }
}