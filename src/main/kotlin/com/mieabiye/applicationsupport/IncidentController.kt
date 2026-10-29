package com.mieabiye.applicationsupport

import org.springframework.http.HttpStatus

import org.springframework.web.bind.annotation.DeleteMapping

import org.springframework.web.bind.annotation.GetMapping

import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.bind.annotation.PostMapping

import org.springframework.web.bind.annotation.PutMapping

import org.springframework.web.bind.annotation.RequestBody

import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.web.bind.annotation.RequestParam

import org.springframework.web.bind.annotation.RestController

import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/api/incidents")
class IncidentController (
    private val incidentRepository: IncidentRepository
) {

    @GetMapping
    fun getIncidents(): List<Incident> =
        incidentRepository.findAll()


    @GetMapping("/{id}")
    fun getIncidentById(
        @PathVariable id: Long
    ): Incident {
        return incidentRepository.findById(id).orElseThrow {
            ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Incident with ID $id was not found"
            )
        }
    }

    @PostMapping
    fun createIncident(
        @RequestBody incident: Incident
    ): Incident {
        val newIncident = incident.copy(id = 0)
        return incidentRepository.save(newIncident)
    }

    @PutMapping("/{id}/status")
    fun updateIncidentStatus(
        @PathVariable id: Long,
        @RequestParam status: String
    ): Incident {
        val incident = incidentRepository.findById(id).orElseThrow {
            ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Incident with ID $id was not found"
            )
        }

        val updatedIncident = incident.copy(status = status)

        return incidentRepository.save(updatedIncident)
    }

        // Delete an incident by ID
        @DeleteMapping("/{id}")
        fun deleteIncident(
            @PathVariable id: Long
        ): Map<String, String> {

            if (!incidentRepository.existsById(id)) {
                throw ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Incident with ID $id was not found"
                )
            }

            incidentRepository.deleteById(id)

            return mapOf(
                "message" to "Incident $id deleted successfully"
            )
        }

    }

