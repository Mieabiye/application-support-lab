package com.mieabiye.applicationsupport

import org.springframework.data.jpa.repository.JpaRepository

interface IncidentRepository: JpaRepository<Incident, Long>