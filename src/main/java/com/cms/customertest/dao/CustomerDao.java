package com.cms.customertest.dao;

import com.cms.customertest.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

    @Override
    Iterable<Customer> findAll();
}
