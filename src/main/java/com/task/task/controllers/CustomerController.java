package com.task.task.controllers;

import com.task.task.entities.Customer;
import com.task.task.repos.CustomerRepo;
import com.task.task.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @GetMapping(path= "/allCustomers")
    public List<Customer> getAllCustomers(){
        return customerServices.getAllCustomers();
    }

    @PostMapping(path="/newCustomer")
    public Customer addNewCustomer(@RequestBody Customer customer){
        customerServices.addNewCustomer(customer);
        return customer;
    }
    @DeleteMapping(path="deleteCustomer")
    public String deleteCustomer(@RequestParam Long id){
         return customerServices.deleteCustomer(id);
    }
    @PutMapping(path="updateCustomer")
    public Optional<Customer> updateCustomer(@RequestParam Long id, @RequestBody Customer newCustomer){
        return customerServices.updateCustomer(id, newCustomer);

    }


}
