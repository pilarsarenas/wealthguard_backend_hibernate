package wealthguard.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import wealthguard.entity.PresupuestoEntity;
import wealthguard.service.IPresupuestoService;

public class PresupuestoServiceImpl implements IPresupuestoService {

    @Override
    public boolean crearPresupuesto(int idUsuario, int idCategoria, double limite, LocalDateTime fechaInicio,
            LocalDateTime fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearPresupuesto'");
    }

    @Override
    public boolean eliminarPresupuesto(int idPresupuesto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPresupuesto'");
    }

    @Override
    public boolean editarPresupuesto(int idPresupuesto, int idCategoria, double limite, LocalDateTime fechaInicio,
            LocalDateTime fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editarPresupuesto'");
    }

    @Override
    public List<PresupuestoEntity> obtenerPresupuestos(int idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPresupuestos'");
    }

}

