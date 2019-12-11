package com.example.fraud

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
class FraudControllerV2Spec extends Specification {

    @Autowired
    MockMvc mockMvc

    def "should have a post message"() {
        when:
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/message"))

        then:
        resultActions.andExpect(status().is(200))
        .andDo(document("message"))
    }

}
