/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.ejb.interfaces;

import co.edu.polijic.pagos.modelos.Transaccion;
import javax.ejb.Remote;

/**
 *
 * @author Natalia
 */
@Remote
public interface TransaccionesSessionBeanRemote {

    void createTransaccion(Transaccion transaccion) throws Exception;
    
}
