package com.task.task.services;

import com.task.task.entities.Customer;
import com.task.task.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices {

   @Autowired
    private  CustomerRepo customerRepo;

    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }
    public Customer addNewCustomer(@RequestBody Customer customer){
        customerRepo.save(customer);
        return customer;
    }
    public String deleteCustomer(@RequestParam Long id){

        customerRepo.deleteById(id);
        return "deleted" + id;
    }
    public Optional<Customer> updateCustomer(@RequestParam Long id, @RequestBody Customer newCustomer){
        return customerRepo.findById(id)
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setAddress(newCustomer.getAddress() != null ? newCustomer.getAddress(): customer.getAddress());
                    customer.setNationalID(newCustomer.getNationalID());
                    customer.setPhoneNumber(newCustomer.getPhoneNumber());
                    return customerRepo.save(customer);
                });

    }
}
