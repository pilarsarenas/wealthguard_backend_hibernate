package wealthguard.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import wealthguard.dto.TransaccionRequestDTO;
import wealthguard.dto.TransaccionResponseDTO;
import wealthguard.service.ITransaccionService;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

    @Autowired
    private ITransaccionService transaccionService;

    @GetMapping("/listar/{idUsuario}")
    public List<TransaccionResponseDTO> listarTransacciones(
            @PathVariable Integer idUsuario,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin,
            @RequestParam(required = false) Integer idCategoria,
            @RequestParam(required = false) Boolean tipo,
            @RequestParam(required = false) Double cantidad,
            @RequestParam(required = false) String descripcion) {
        return transaccionService.listarTransacciones(idUsuario, fechaInicio, fechaFin, idCategoria, tipo, cantidad, descripcion);
    }

    @GetMapping("/listar-todas/{idUsuario}")
    public List<TransaccionResponseDTO> listarTodasPorUsuario(@PathVariable Integer idUsuario) {
        return transaccionService.listarTodasPorUsuario(idUsuario);
    }

    @PostMapping("/crear")
    public TransaccionResponseDTO crearTransaccion(@RequestBody TransaccionRequestDTO transaccionRequestDTO) {
        return transaccionService.crearTransaccion(transaccionRequestDTO);
    }

    @PutMapping("/editar/{id}")
    public TransaccionResponseDTO editarTransaccion(@PathVariable Integer id, @RequestBody TransaccionRequestDTO transaccionRequestDTO) {
        return transaccionService.editarTransaccion(id, transaccionRequestDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarTransaccion(@PathVariable Integer id) {
        transaccionService.eliminarTransaccion(id);
    }

    @GetMapping("/tendencia/{idUsuario}")
    public double obtenerTendencia(@PathVariable Integer idUsuario) {
        return transaccionService.obtenerTendencia(idUsuario);
    }

    @GetMapping("/categoria-principal/{idUsuario}")
    public String[] categoriaPrincipal(@PathVariable Integer idUsuario) {
        return transaccionService.obtenerCategoriaPrincipal(idUsuario);
    }

    @GetMapping("/meta/{idUsuario}")
    public double[] obtenerMeta(@PathVariable Integer idUsuario) {
        return transaccionService.obtenerMeta(idUsuario);
    }

}

