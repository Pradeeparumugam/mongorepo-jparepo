package com.dxctraining.customermgt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dxctraining.customermgt.entities.Customer;
import com.dxctraining.customermgt.service.CustomerService;
import com.dxctraining.customermgt.service.CustomerServiceImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import({ CustomerServiceImpl.class })
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CustomerServiceImplTest {
	@Autowired
	private CustomerService service;
	@Autowired
	private EntityManager em;
	
	public void testAdd() {
	String name = "customer1";
	Customer customer = new Customer(name);
	customer = service.save(customer);
	TypedQuery<Customer> query = em.createQuery("from Customer", Customer.class);
	List<Customer> list = query.getResultList();
	Customer savedCustomer = list.get(0);
	Assertions.assertEquals(name, savedCustomer.getName());
	}
	public void testId() {
		Customer customer=new Customer("customer2");
		customer=em.merge(customer);
		Integer id=customer.getId();
		Customer savedcustomer=service.findById(id);
		Assertions.assertEquals(id, savedcustomer.getId());
		Assertions.assertEquals(customer.getName(),savedcustomer.getName());
	}
	public void testName() {
		Customer customer=new Customer("customer3");
		customer=em.merge(customer);
		String name=customer.getName();
		Customer savedcustomer=service.findByName(name);
		Assertions.assertEquals(name, savedcustomer.getName());
		
	}
}
