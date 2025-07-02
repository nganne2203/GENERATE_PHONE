package com.phonenumber.generator.service;

import java.util.List;

public interface PhoneNumberService {
    
    /**
     * Generates a specified number of unique Vietnamese phone numbers
     * 
     * @param quantity The number of phone numbers to generate
     * @return List of generated phone numbers
     */
    List<String> generatePhoneNumbers(Integer quantity);
} 