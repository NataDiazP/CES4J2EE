/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.ejb;

import co.edu.polijic.ejb.interfaces.TransaccionesSessionBeanRemote;
import co.edu.polijic.pagos.controllers.TransaccionJpaController;
import co.edu.polijic.pagos.controllers.exceptions.PreexistingEntityException;
import co.edu.polijic.pagos.modelos.Transaccion;
import javax.ejb.Stateless;
import javax.persistence.Persistence;

/**
 *
 * @author Natalia
 */
@Stateless
public class TransaccionesSessionBean implements TransaccionesSessionBeanRemote {

    @Override
    public boolean createTransaccion(Transaccion transaccion) throws PreexistingEntityException, Exception {
        TransaccionJpaController transaccionJpaController = new TransaccionJpaController(Persistence.createEntityManagerFactory("appPagos_PU"));
        return transaccionJpaController.create(transaccion);
    }

}
