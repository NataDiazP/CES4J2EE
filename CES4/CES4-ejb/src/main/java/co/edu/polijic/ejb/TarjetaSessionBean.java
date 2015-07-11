/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.ejb;

import co.edu.polijic.pagos.controllers.TarjetaJpaController;
import co.edu.polijic.ejb.interfaces.TarjetaSessionBeanRemote;
import co.edu.polijic.pagos.controllers.exceptions.PreexistingEntityException;

import javax.ejb.Stateless;
import co.edu.polijic.pagos.modelos.Tarjeta;
import javax.persistence.Persistence;

/**
 *
 * @author Natalia
 */
@Stateless(name = "ejb/Tarjeta")
public class TarjetaSessionBean implements TarjetaSessionBeanRemote {

    @Override
    public boolean createTarjeta(Tarjeta tarjeta) throws PreexistingEntityException, Exception {
        TarjetaJpaController tarjetaJpaController = new TarjetaJpaController(Persistence.createEntityManagerFactory("appPagos_PU"));
        return tarjetaJpaController.create(tarjeta);
    }

}
