package com.javaPlayground.javaBatch.config;

import com.javaPlayground.javaBatch.entity.Customer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer item) throws Exception {
        return item;
    }
}
