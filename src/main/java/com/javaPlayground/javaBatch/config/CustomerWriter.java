package com.javaPlayground.javaBatch.config;

import com.javaPlayground.javaBatch.entity.Customer;
import com.javaPlayground.javaBatch.repository.CustomerRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


@Component
public class CustomerWriter implements ItemWriter<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void write(@NonNull Chunk<? extends Customer> chunk) throws Exception {
        customerRepository.saveAll(chunk);
    }
}
