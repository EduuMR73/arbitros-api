package com.example.arbitrosapi.repository

import com.example.arbitrosapi.domain.Arbitro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArbitroRepository : JpaRepository<Arbitro, Long>
