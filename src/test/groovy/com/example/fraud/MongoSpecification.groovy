package com.example.fraud

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.containers.GenericContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
@ContextConfiguration(initializers = Initializer)
@SpringBootTest
@DirtiesContext
class MongoSpecification extends Specification {

    @Shared
    GenericContainer mongoContainer = new GenericContainer("mongo:latest")
            .withExposedPorts(27017)

    static GenericContainer staticContainerHandle

    def setupSpec() {
        staticContainerHandle = mongoContainer
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues values = TestPropertyValues.of(
                    "spring.data.mongodb.host=" + staticContainerHandle.containerIpAddress,
                    "spring.data.mongodb.port=" + staticContainerHandle.getMappedPort(27017),
            )
            values.applyTo(configurableApplicationContext)
        }
    }

    def "Mongo container should be running"() {
        expect:
        mongoContainer.isRunning()
    }

}
