/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.ejb;

import co.edu.polijic.ejb.interfaces.TransaccionesSessionBeanRemote;
import co.edu.polijic.pagos.controllers.TransaccionJpaController;
import co.edu.polijic.pagos.controllers.exceptions.PreexistingEntityException;
import co.edu.polijic.pagos.modelos.Tarjeta;
import co.edu.polijic.pagos.modelos.Transaccion;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Persistence;

/**
 *
 * @author Natalia
 */
@Stateless
public class TransaccionesSessionBean implements TransaccionesSessionBeanRemote {

    TransaccionJpaController transaccionJpaController = new TransaccionJpaController(Persistence.createEntityManagerFactory("appPagos_PU"));
    
    @Override
    public boolean createTransaccion(Transaccion transaccion) throws PreexistingEntityException, Exception {        
        return transaccionJpaController.create(transaccion);
    }

    @Override
    public int getTransactionCount() {
        return transaccionJpaController.getTransaccionCount();
    }

    @Override
    public List<Tarjeta> getTransaccionesTarjetaOrigen(int nmTarjeta) {
        return transaccionJpaController.getTransaccionesTarjetaOrigen(nmTarjeta);
    }

    @Override
    public List<Tarjeta> getTransaccionesRealizadasCuentaOrigenCuentaDestino(int nmCuentaOrigen, int nmCuentaDestino) {
        return transaccionJpaController.getTransaccionesRealizadasCuentaOrigenCuentaDestino(nmCuentaOrigen, nmCuentaDestino);
    }

    @Override
    public List<Transaccion> getTransaccionByEstado(String estado) {
        return transaccionJpaController.getTransaccionByEstado(estado);
    }

    @Override
    public List<Transaccion> getTransaccionByFecha(Date fecha) {
        return transaccionJpaController.getTransaccionByFecha(fecha);
    }
}
