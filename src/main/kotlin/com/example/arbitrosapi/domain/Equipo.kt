package com.example.arbitrosapi.domain

import jakarta.persistence.*

@Entity
@Table(name = "Equipos")
data class Equipo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nombre: String,

    @Column(nullable = false)
    val ciudad: String
)
