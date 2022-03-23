package com.example.delivery.controller;

import com.example.delivery.exception.InvalidRequestParameterException;
import com.example.delivery.service.DeliveryService;
import com.example.delivery.validator.DeliveryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/cost")
    public ResponseEntity calculateCost(HttpServletRequest req, @RequestParam Map<String, String> params) {
        if (DeliveryValidator.isValid(params)) {
            return new ResponseEntity(deliveryService.calculateCost(params), HttpStatus.OK);
        } else {
            throw new InvalidRequestParameterException("Invalid Parameter");
        }
    }
}
