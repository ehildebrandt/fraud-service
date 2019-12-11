package com.example.fraud

import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier
import spock.lang.Specification

@SpringBootTest(classes = FraudApplication.class)
@AutoConfigureMessageVerifier
class BaseSpec extends Specification {

    @Autowired
    FraudControllerV1 fraudControllerV1

    @Autowired
    FraudControllerV2 fraudControllerV2

    def setup() {
        RestAssuredMockMvc.standaloneSetup(fraudControllerV1)
    }

    def triggerMessage() {
        fraudControllerV2.message()
    }

}
