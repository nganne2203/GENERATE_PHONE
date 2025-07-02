package com.phonenumber.generator.service.impl;

import com.phonenumber.generator.model.PhoneNumber;
import com.phonenumber.generator.repository.PhoneNumberRepository;
import com.phonenumber.generator.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

    private static final String[] VIETNAMESE_MOBILE_PREFIXES = {
            "086", "096", "097", "098", "032", "033", "034", "035", "036", "037", "038", "039", // Viettel
            "070", "079", "077", "076", "078", "089", // Mobifone
            "081", "082", "083", "084", "085", "088", // Vinaphone
            "056", "058", "059", // Vietnamobile
            "052", "099" // Gmobile
    };

    private final PhoneNumberRepository phoneNumberRepository;
    private final Random random = new Random();

    @Autowired
    public PhoneNumberServiceImpl(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Override
    @Transactional
    public List<String> generatePhoneNumbers(Integer quantity) {
        List<String> generatedNumbers = new ArrayList<>();
        int attempts = 0;
        int maxAttempts = quantity * 10; // Setting a limit to avoid infinite loop

        while (generatedNumbers.size() < quantity && attempts < maxAttempts) {
            String phoneNumber = generateRandomVietnamesePhoneNumber();
            if (!phoneNumberRepository.existsByNumber(phoneNumber)) {
                PhoneNumber newNumber = new PhoneNumber();
                newNumber.setNumber(phoneNumber);
                newNumber.setCreatedAt(LocalDateTime.now());
                phoneNumberRepository.save(newNumber);
                generatedNumbers.add(phoneNumber);
            }
            attempts++;
        }

        return generatedNumbers;
    }

    /**
     * Generates a random Vietnamese mobile phone number
     * 
     * @return A valid Vietnamese phone number
     */
    private String generateRandomVietnamesePhoneNumber() {
        // Select a random Vietnamese mobile prefix
        String prefix = VIETNAMESE_MOBILE_PREFIXES[random.nextInt(VIETNAMESE_MOBILE_PREFIXES.length)];
        
        // Generate the remaining 7 digits
        StringBuilder remaining = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            remaining.append(random.nextInt(10));
        }
        
        return prefix + remaining.toString();
    }
} 