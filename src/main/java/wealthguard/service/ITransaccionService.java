package wealthguard.service;

import java.time.LocalDateTime;
import java.util.List;

import wealthguard.dto.TransaccionRequestDTO;
import wealthguard.dto.TransaccionResponseDTO;

public interface ITransaccionService {

    List<TransaccionResponseDTO> listarTransacciones(Integer idUsuario, LocalDateTime fechaInicio, LocalDateTime fechaFin, Integer idCategoria, Boolean tipo, Double cantidad, String descripcion);
    List<TransaccionResponseDTO> listarTodasPorUsuario(Integer idUsuario);
    TransaccionResponseDTO crearTransaccion(TransaccionRequestDTO transaccionRequestDTO);
    TransaccionResponseDTO editarTransaccion(Integer idTransaccion, TransaccionRequestDTO transaccionRequestDTO);
    void eliminarTransaccion(Integer idTransaccion);

    double obtenerTendencia(int idUsuario);
    String[] obtenerCategoriaPrincipal(int idUsuario);
    double[] obtenerMeta(int idUsuario);
    



}

