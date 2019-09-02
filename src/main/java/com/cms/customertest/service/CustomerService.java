package com.cms.customertest.service;


import com.cms.customertest.dao.CustomerDao;
import com.cms.customertest.exception.CustomerNotFoundException;
import com.cms.customertest.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {


    @Autowired
    private CustomerDao customerDao;

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer){
//        customer.setCustomerId(customerIdCount);
//        customerList.add(customer);
//        customerIdCount++;
//
//        return customer;

        return customerDao.save(customer);
    }

    public List<Customer> getCustomers(){
//        return customerList;

        return (List<Customer>) customerDao.findAll();
    }

    public Customer getCustomer(int customerId){
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomerId() == customerId)
//                .findFirst()
//                .get();

        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw  new CustomerNotFoundException("Customer Record is not available....");
        return optionalCustomer.get();

    }

    public Customer updateCustomer(int customerId, Customer customer){
//        customerList
//                .stream()
//                .forEach(c -> {
//                    if(c.getCustomerId() == customerId){
//                        c.setCustomerName(customer.getCustomerName());
//                        c.setCustomerAddress(customer.getCustomerAddress());
//                        c.setCustomerEmail(customer.getCustomerEmail());
//                    }
//                });
//
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomerId() == customerId)
//                .findFirst()
//                .get();

        customer.setCustomerId(customerId);
        return customerDao.save(customer);
    }

    public void deleteCustomer(int customerId){
//        customerList
//                .stream()
//                .forEach(c -> {
//                    if(c.getCustomerId() == customerId){
//                        customerList.remove(c);
//                    }
//                });

        customerDao.deleteById(customerId);
    }
}
