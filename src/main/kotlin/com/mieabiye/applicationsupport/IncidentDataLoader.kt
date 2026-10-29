package com.mieabiye.applicationsupport

import org.springframework.boot.CommandLineRunner

import org.springframework.context.annotation.Bean

import org.springframework.context.annotation.Configuration

@Configuration
class IncidentDataLoader {

    @Bean
    fun loadIncidents(
        incidentRepository: IncidentRepository
    ): CommandLineRunner {
        return CommandLineRunner {
            if (incidentRepository.count() == 0L) {
                incidentRepository.saveAll(
                    listOf(
                        Incident(
                            title = "Unable to log in",
                            description = "User cannot access the application",
                            priority = "HIGH",
                            status = "OPEN"
                        ),
                        Incident(
                            title = "Application running slowly",
                            description = "User reports slow response times",
                            priority = "MEDIUM",
                            status = "IN_PROGRESS",
                        ),
                        Incident(
                            title = "Password reset request",
                            description = "User needs assistance resetting a password",
                            priority = "LOW",
                            status = "RESOLVED",

                            )
                    )
                )

            }
        }

    }

}
