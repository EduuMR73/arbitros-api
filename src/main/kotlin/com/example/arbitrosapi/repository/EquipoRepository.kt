package com.example.arbitrosapi.repository

import com.example.arbitrosapi.domain.Equipo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EquipoRepository : JpaRepository<Equipo, Long>
