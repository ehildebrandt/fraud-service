package com.example.fraud;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraudControllerV1 {

    @GetMapping("/fraud")
    public ResponseEntity<List<String>> fraud() {
        return ResponseEntity
            .status(201)
            .body(ImmutableList.of("Spock", "Kirk"));
    }

}
