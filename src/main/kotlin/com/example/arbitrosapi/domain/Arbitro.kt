package com.example.arbitrosapi.domain

import jakarta.persistence.*

@Entity
@Table(name = "Arbitros")
data class Arbitro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nombre: String,

    @Column(nullable = false)
    val categoria: String
)
