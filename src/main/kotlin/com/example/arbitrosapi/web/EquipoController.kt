package com.example.arbitrosapi.web

import com.example.arbitrosapi.domain.Equipo
import com.example.arbitrosapi.service.EquipoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/equipos")
class EquipoController(private val equipoService: EquipoService) {

    @GetMapping
    fun listarTodos(): List<Equipo> = equipoService.listarTodos()

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Equipo> =
        equipoService.buscarPorId(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    fun crear(@RequestBody equipo: Equipo): ResponseEntity<Equipo> =
        ResponseEntity(equipoService.guardar(equipo), HttpStatus.CREATED)

    @PutMapping("/{id}")
    fun actualizar(@PathVariable id: Long, @RequestBody equipo: Equipo): ResponseEntity<Equipo> {
        return if (equipoService.buscarPorId(id) != null) {
            ResponseEntity(equipoService.guardar(equipo.copy(id = id)), HttpStatus.OK)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun borrar(@PathVariable id: Long): ResponseEntity<Void> {
        return if (equipoService.buscarPorId(id) != null) {
            equipoService.borrar(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
