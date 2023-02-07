package org.springframework.guru.msscbreweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.guru.msscbreweryclient.web.model.BeerDto;
import org.springframework.guru.msscbreweryclient.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Orhan Polat
 */
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;
    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById(){
        CustomerDto customerDto = client.getCustomer(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer(){
        CustomerDto customerDto = CustomerDto.builder().customerName("Polatski").build();
        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateCustomer(){
        CustomerDto customerDto = CustomerDto.builder().customerName("Polatski").build();
        client.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void deleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }
}