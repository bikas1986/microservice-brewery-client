package com.bikas.breweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bikas.breweryclient.web.model.BeerDto;
import com.bikas.breweryclient.web.model.CustomerDto;

@SpringBootTest
class BreweryClientTest {

	@Autowired
	BreweryClient client;
	
	@Test
	void testGetBeerById() {
		BeerDto beerDto = client.getBeerById(UUID.randomUUID());
		
		assertNotNull(beerDto);
	}

	@Test
	void testSaveNewBeer() {
		//given
		BeerDto beerDto = BeerDto.builder().beerName("Some beer").build();
		
		URI uri = client.saveNewBeer(beerDto);
		
		assertNotNull(uri);
		
		System.out.println(uri);
	}
	
	@Test
	void testUpdateBeer() {
		//given
		BeerDto beerDto = BeerDto.builder().beerName("Some beer").build();
		
		client.updateBeer(UUID.randomUUID(), beerDto);
		
	}
	
	@Test
	void testDeleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}
	
	@Test
	void testGetCustomerId() {
		CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
		
		assertNotNull(customerDto);
	}
	
	@Test
	void testSaveNewCustomer() {
		CustomerDto customerDto = CustomerDto.builder().name("Bikas").build();
		
		URI uri = client.saveNewCustomer(customerDto);
		
		assertNotNull(uri);
		
		System.out.println(uri);
	}
	
	@Test
	void testUpdateCustomer() {
		//given
		CustomerDto customerDto = CustomerDto.builder().name("Bikas").build();
		
		client.updateCustomer(UUID.randomUUID(), customerDto);
	}
	
	@Test
	void testDeleteCustomer() {
		client.deleteCustomer(UUID.randomUUID());
	}
}
