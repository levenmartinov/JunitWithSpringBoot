package com.tpe.service;

import com.tpe.domain.Customer;
import com.tpe.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock//burada gerçek obje değil vekilini oluştur
    private CustomerRepository customerRepository;

    @InjectMocks//içine gerçek bağımlılığı değil mock(vekil) enjekte et
    private CustomerService customerService; //bean

    @Test
    void testGetCustomerById() {

        //verilen
        Customer customer = new Customer(1L, "Ali", "Can", "user");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(customerRepository.findById(99L)).thenReturn(Optional.empty());

        //işlem
        Customer found = customerService.getCustomerById(1L);

        //beklenen
        assertEquals(1L, found.getId());
        assertThrows(RuntimeException.class, () -> {
            customerService.getCustomerById(99L);
        });
        verify(customerRepository).findById(1L);
        verify(customerRepository).findById(99L);
    }

    @Test
    void deleteCustomer(){

        //verilen
        Customer customer=new Customer(1L,"Ali","Can","user");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(customerRepository.findById(99L)).thenReturn(Optional.empty());


        //işlem
        customerService.deleteCustomer(1L);
        verify(customerRepository,times(1)).deleteById(1L);

        assertThrows(RuntimeException.class,()->{
            customerService.deleteCustomer(99L);
        });
    }


}