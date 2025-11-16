package com.example.arbitrosapi.web

import com.example.arbitrosapi.domain.Arbitro
import com.example.arbitrosapi.service.ArbitroService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/arbitros")
class ArbitroController(private val arbitroService: ArbitroService) {

    @GetMapping
    fun listarTodos(): List<Arbitro> = arbitroService.listarTodos()

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Arbitro> =
        arbitroService.buscarPorId(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    fun crear(@RequestBody arbitro: Arbitro): ResponseEntity<Arbitro> =
        ResponseEntity(arbitroService.guardar(arbitro), HttpStatus.CREATED)

    @PutMapping("/{id}")
    fun actualizar(@PathVariable id: Long, @RequestBody arbitro: Arbitro): ResponseEntity<Arbitro> {
        return if (arbitroService.buscarPorId(id) != null) {
            ResponseEntity(arbitroService.guardar(arbitro.copy(id = id)), HttpStatus.OK)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun borrar(@PathVariable id: Long): ResponseEntity<Void> {
        return if (arbitroService.buscarPorId(id) != null) {
            arbitroService.borrar(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
