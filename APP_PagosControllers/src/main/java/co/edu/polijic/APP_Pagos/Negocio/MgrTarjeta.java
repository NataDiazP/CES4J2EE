/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.APP_Pagos.Negocio;

import co.edu.polijic.APP_Pagos.Controllers.TarjetaJpaController;
import co.edu.polijic.APP_Pagos.Controllers.TransaccionJpaController;
import co.edu.polijic.APP_Pagos.Controllers.exceptions.IllegalOrphanException;
import co.edu.polijic.APP_Pagos.Controllers.exceptions.NonexistentEntityException;
import co.edu.polijic.app_pagos.model.Tarjeta;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Casa
 */
public class MgrTarjeta {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("APP_PagosPU");
    private static TarjetaJpaController tarjetaJpaController = new TarjetaJpaController(emf);

    public boolean registrarTarjeta(Tarjeta tarjeta) {
        boolean ban = false;
        try {
            ban = tarjetaJpaController.create(tarjeta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ban;
    }

    public boolean eliminarTarjeta(int nmTarjeta) throws IllegalOrphanException, NonexistentEntityException {
        boolean ban = false;
        List<Tarjeta> tarjeta = tarjetaJpaController.getTarjetabyNmTarjeta(nmTarjeta);
        for (Tarjeta tar : tarjeta) {
            int cdtarjeta = tar.getCdtarjeta();
            ban = tarjetaJpaController.destroy(cdtarjeta);
        }
        return ban;
    }

    public boolean actualizarTarjeta(Tarjeta tarjeta) throws NonexistentEntityException, Exception {
        boolean ban = false;
        ban = tarjetaJpaController.edit(tarjeta);
        return ban;
    }

    public Tarjeta buscarTarjeta(int nmTarjeta) {
        boolean ban = false;
        List<Tarjeta> tarjeta = tarjetaJpaController.getTarjetabyNmTarjeta(nmTarjeta);
        for (Tarjeta tar : tarjeta) {
            return tar;
        }
        return null;
    }
}
