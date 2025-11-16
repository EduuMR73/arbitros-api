package com.example.arbitrosapi.service

import com.example.arbitrosapi.domain.Arbitro
import com.example.arbitrosapi.repository.ArbitroRepository
import org.springframework.stereotype.Service

@Service
class ArbitroService(
    private val arbitroRepository: ArbitroRepository
) {

    fun listarTodos(): List<Arbitro> = arbitroRepository.findAll()

    fun buscarPorId(id: Long): Arbitro? = arbitroRepository.findById(id).orElse(null)

    fun guardar(arbitro: Arbitro): Arbitro = arbitroRepository.save(arbitro)

    fun borrar(id: Long) = arbitroRepository.deleteById(id)
}
