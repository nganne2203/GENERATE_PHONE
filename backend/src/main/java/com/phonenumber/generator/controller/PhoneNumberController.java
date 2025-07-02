package com.phonenumber.generator.controller;

import com.phonenumber.generator.dto.PhoneNumberRequestDTO;
import com.phonenumber.generator.service.PhoneNumberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phone-numbers")
@CrossOrigin(origins = "*")
public class PhoneNumberController {

    private final PhoneNumberService phoneNumberService;

    @Autowired
    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }

    @PostMapping("/generate")
    public ResponseEntity<List<String>> generatePhoneNumbers(@Valid @RequestBody PhoneNumberRequestDTO request) {
        List<String> generatedNumbers = phoneNumberService.generatePhoneNumbers(request.getQuantity());
        
        if (generatedNumbers.isEmpty() || generatedNumbers.size() < request.getQuantity()) {
            return ResponseEntity.badRequest().body(generatedNumbers);
        }
        
        return ResponseEntity.ok(generatedNumbers);
    }
} 