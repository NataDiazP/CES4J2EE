/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.pagos.negocio;

import co.edu.polijic.pagos.controllers.RegistroTransaccionJpaController;
import co.edu.polijic.pagos.controllers.TarjetaJpaController;
import co.edu.polijic.pagos.controllers.TransaccionJpaController;
//import co.edu.polijic.app_pagos.model.RegistroTransaccion;
//import co.edu.polijic.app_pagos.model.Tarjeta;
//import co.edu.polijic.app_pagos.model.TipoPago;
//import co.edu.polijic.app_pagos.model.Transaccion;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Casa
 */
public class MgrTransaccion {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("APP_PagosPU");
        TransaccionJpaController transaccionJpaController = new TransaccionJpaController(emf);
        RegistroTransaccionJpaController regTransJpaController = new RegistroTransaccionJpaController(emf);
        
//    public boolean registrarTransaccion(Transaccion transaccion) throws Exception {
//        boolean ban = false;
//
//        Tarjeta tarj = new Tarjeta();
//        tarj.setCdtarjeta(1);
//        TipoPago tipoPago = new TipoPago();
//        tipoPago.setCdtipopago(2);
//        BigDecimal val = new BigDecimal("200000.00");
//        transaccion.setCdtransaccion(5);
//        transaccion.setCdtarjetaorigen(tarj);
//        transaccion.setCdtarjetadestino(23423423);
//        transaccion.setCdtipopago(tipoPago);
//        transaccion.setNmcuotaspago(1);
//        transaccion.setVltransaccion(val);
//        try {
//            ban = transaccionJpaController.create(transaccion);
//        } catch (Exception ex) {
//            throw new Exception("Error al procesas la solicitud");
//        }
//        return ban;
//    }
//
//    public boolean registrarDetalleTransaccion() throws ParseException, Exception {
//        boolean ban=false;
//        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println("Ingresar registro transacción");
//        RegistroTransaccion regTransaccion = new RegistroTransaccion();
//        Transaccion trans = new Transaccion();
//        trans.setCdtransaccion(4);
//        String strFecha = "2015-03-04";
//        Date fecha = null;
//        fecha = formatoDelTexto.parse(strFecha);
//        regTransaccion.setCdregistro(4);
//        regTransaccion.setCdtransaccion(trans);
//        regTransaccion.setOpestado("ACEPTADA");
//        regTransaccion.setFefechatransaccion(fecha);
//        regTransaccion.setDsobservaciones("Transacción Exitosa");
//        regTransJpaController.create(regTransaccion);
//        return ban;
//    }
}
