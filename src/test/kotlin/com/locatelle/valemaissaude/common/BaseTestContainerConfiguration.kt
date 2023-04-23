package com.locatelle.valemaissaude.common

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.utility.DockerImageName

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Suppress("UnnecessaryAbstractClass", "UtilityClassWithPublicConstructor")
abstract class BaseTestContainerConfiguration {

    companion object {

        @Container
        private val postgreSQLContainer = PostgreSQLContainer(
            DockerImageName.parse("debezium/postgres:14-alpine")
                .asCompatibleSubstituteFor("postgres")
        ).apply { withExposedPorts(5432) }

        @JvmStatic
        @DynamicPropertySource
        fun applicationProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl)
            registry.add("spring.datasource.username", postgreSQLContainer::getUsername)
            registry.add("spring.datasource.password", postgreSQLContainer::getPassword)
        }
    }
}
