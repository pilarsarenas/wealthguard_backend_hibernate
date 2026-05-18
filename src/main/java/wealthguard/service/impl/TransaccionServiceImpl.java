package wealthguard.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import wealthguard.dto.TransaccionRequestDTO;
import wealthguard.dto.TransaccionResponseDTO;
import wealthguard.service.ITransaccionService;

public class TransaccionServiceImpl implements ITransaccionService{

    @Override
    public List<TransaccionResponseDTO> listarTransacciones(Integer idUsuario, LocalDateTime fechaInicio,
            LocalDateTime fechaFin, Integer idCategoria, Boolean tipo, Double cantidad, String descripcion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTransacciones'");
    }

    @Override
    public TransaccionResponseDTO crearTransaccion(TransaccionRequestDTO transaccionRequestDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearTransaccion'");
    }

    @Override
    public TransaccionResponseDTO editarTransaccion(Integer idTransaccion,
            TransaccionRequestDTO transaccionRequestDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editarTransaccion'");
    }

    @Override
    public void eliminarTransaccion(Integer idTransaccion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarTransaccion'");
    }

    @Override
    public double obtenerTendencia(int idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTendencia'");
    }

    @Override
    public String[] obtenerCategoriaPrincipal(int idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCategoriaPrincipal'");
    }

    @Override
    public double[] obtenerMeta(int idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerMeta'");
    }

}

