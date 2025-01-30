package com.tpe.controller;

import com.tpe.domain.Customer;
import com.tpe.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock //CustomerService tipinde mock bir obje oluşturulmasını sağlar
    private CustomerService customerService;

    @InjectMocks //içine gerçek bağımlılığı değil mock(vekil) enjekte et
    private CustomerController customerController;

    @Test
    void testGetCustomer(){

        //verilen
        Customer customer=new Customer(1L,"Ali","Can","user");

        when(customerService.getCustomerById(1L)).thenReturn(customer);

        //işlem
        ResponseEntity<Customer> response =customerController.getCustomer(1L);

        //beklenen
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(customer,response.getBody());
        verify(customerService).getCustomerById(1L);
    }

}