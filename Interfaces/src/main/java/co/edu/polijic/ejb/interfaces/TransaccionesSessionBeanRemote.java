/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.ejb.interfaces;

import co.edu.polijic.pagos.controllers.exceptions.PreexistingEntityException;
import co.edu.polijic.pagos.modelos.Tarjeta;
import co.edu.polijic.pagos.modelos.Transaccion;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Natalia
 */
@Remote
public interface TransaccionesSessionBeanRemote {

    boolean createTransaccion(Transaccion transaccion) throws PreexistingEntityException, Exception;
    
    int getTransactionCount();
    
    List<Tarjeta> getTransaccionesTarjetaOrigen(int nmTarjeta);
    
    List<Tarjeta> getTransaccionesRealizadasCuentaOrigenCuentaDestino(int nmCuentaOrigen, int nmCuentaDestino);
    
    List<Transaccion> getTransaccionByEstado(String estado);
    
    List<Transaccion> getTransaccionByFecha(Date fecha);
}
