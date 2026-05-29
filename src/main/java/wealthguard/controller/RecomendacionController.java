package wealthguard.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wealthguard.dto.RecomendacionRequestDTO;
import wealthguard.dto.RecomendacionResponseDTO;
import wealthguard.service.IRecomendacionService;

@RestController
@RequestMapping("/api/recomendaciones")
public class RecomendacionController {

    @Autowired
    private IRecomendacionService recomendacionService;

    @PostMapping
    public ResponseEntity<RecomendacionResponseDTO> crearRecomendacion(@RequestBody RecomendacionRequestDTO recomendacionRequest) {
        RecomendacionResponseDTO response = recomendacionService.crearRecomendacion(recomendacionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{idRecomendacion}")
    public ResponseEntity<Void> eliminarRecomendacion(@PathVariable int idRecomendacion) {
        recomendacionService.eliminarRecomendacion(idRecomendacion);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<RecomendacionResponseDTO>> obtenerRecomendaciones(@PathVariable int idUsuario) {
        return ResponseEntity.ok(recomendacionService.obtenerRecomendaciones(idUsuario));
    }

    @GetMapping("/tipo/{idTipo}")
    public ResponseEntity<List<RecomendacionResponseDTO>> obtenerPorTipo(@PathVariable int idTipo) {
        return ResponseEntity.ok(recomendacionService.obtenerPorTipo(idTipo));
    }

    @GetMapping("/usuario/{idUsuario}/tipo/{idTipo}")
    public ResponseEntity<List<RecomendacionResponseDTO>> obtenerPorUsuarioYTipo(
            @PathVariable int idUsuario,
            @PathVariable int idTipo) {
        return ResponseEntity.ok(recomendacionService.obtenerPorUsuarioYTipo(idUsuario, idTipo));
    }

    @GetMapping("/usuario/{idUsuario}/recientes")
    public ResponseEntity<List<RecomendacionResponseDTO>> obtenerRecientes(@PathVariable int idUsuario) {
        return ResponseEntity.ok(recomendacionService.obtenerRecomendacionesRecientes(idUsuario));
    }

    @GetMapping("/usuario/{idUsuario}/rango")
    public ResponseEntity<List<RecomendacionResponseDTO>> obtenerPorRango(
            @PathVariable int idUsuario,
            @RequestParam LocalDateTime desde,
            @RequestParam LocalDateTime hasta) {
        return ResponseEntity.ok(recomendacionService.obtenerPorRangoDeFechas(idUsuario, desde, hasta));
    }

    // Nuevo: filtro dinámico, ambos parámetros son opcionales PREGUNTAR COMPIS
    @GetMapping("/filtro")
    public ResponseEntity<List<RecomendacionResponseDTO>> buscarConFiltro(
            @RequestParam(required = false) Integer idUsuario,
            @RequestParam(required = false) Integer idTipoRecomendacion) {
        return ResponseEntity.ok(recomendacionService.buscarConFiltro(idUsuario, idTipoRecomendacion));
    }

}