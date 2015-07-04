/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.ejb;

import co.edu.polijic.ejb.interfaces.TransaccionesSessionBeanRemote;
import co.edu.polijic.entities.exceptions.PreexistingEntityException;
import co.edu.polijic.pagos.controllers.TransaccionJpaController;
import static co.edu.polijic.pagos.modelos.RegistroTransaccion_.transaccion;
import co.edu.polijic.pagos.modelos.Transaccion;
import javax.ejb.Stateless;
import javax.persistence.Persistence;

/**
 *
 * @author Natalia
 */
@Stateless
public class TransaccionesSessionBean implements TransaccionesSessionBeanRemote, TransaccionesSessionBeanLocal {

    @Override
    public void createTransaccion(Transaccion transaccion) throws Exception {
        TransaccionJpaController transaccionJpaController = new TransaccionJpaController(Persistence.createEntityManagerFactory("appPagos_PU"));
        transaccionJpaController.create(transaccion);
    }

}
