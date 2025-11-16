package com.example.arbitrosapi.service

import com.example.arbitrosapi.domain.Equipo
import com.example.arbitrosapi.repository.EquipoRepository
import org.springframework.stereotype.Service

@Service
class EquipoService(
    private val equipoRepository: EquipoRepository
) {

    fun listarTodos(): List<Equipo> = equipoRepository.findAll()

    fun buscarPorId(id: Long): Equipo? = equipoRepository.findById(id).orElse(null)

    fun guardar(equipo: Equipo): Equipo = equipoRepository.save(equipo)

    fun borrar(id: Long) = equipoRepository.deleteById(id)
}
