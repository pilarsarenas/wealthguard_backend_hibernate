package wealthguard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wealthguard.dto.PresupuestoRequestDTO;
import wealthguard.dto.PresupuestoResponseDTO;
import wealthguard.service.IPresupuestoService;

@RestController
@RequestMapping("/api/presupuestos")
public class PresupuestoController {

    @Autowired
    private IPresupuestoService presupuestoService;

    @PostMapping
    public ResponseEntity<PresupuestoResponseDTO> crearPresupuesto(@RequestBody PresupuestoRequestDTO presupuestoRequest) {
        PresupuestoResponseDTO response = presupuestoService.crearPresupuesto(presupuestoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{idPresupuesto}")
    public ResponseEntity<Void> eliminarPresupuesto(@PathVariable int idPresupuesto) {
        presupuestoService.eliminarPresupuesto(idPresupuesto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idPresupuesto}")
    public ResponseEntity<PresupuestoResponseDTO> editarPresupuesto(
            @PathVariable int idPresupuesto,
            @RequestBody PresupuestoRequestDTO presupuestoRequest) {
        PresupuestoResponseDTO response = presupuestoService.editarPresupuesto(idPresupuesto, presupuestoRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<PresupuestoResponseDTO>> obtenerPresupuestos(@PathVariable int idUsuario) {
        List<PresupuestoResponseDTO> presupuestos = presupuestoService.obtenerPresupuestos(idUsuario);
        return ResponseEntity.ok(presupuestos);
    }

}