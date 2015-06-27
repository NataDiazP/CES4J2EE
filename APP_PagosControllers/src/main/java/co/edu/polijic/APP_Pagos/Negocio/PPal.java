/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.APP_Pagos.Negocio;

import co.edu.polijic.APP_Pagos.Controllers.TarjetaJpaController;
import co.edu.polijic.APP_Pagos.Controllers.TransaccionJpaController;
import co.edu.polijic.app_pagos.model.RegistroTransaccion;
import co.edu.polijic.app_pagos.model.Tarjeta;
import co.edu.polijic.app_pagos.model.TipoPago;
import co.edu.polijic.app_pagos.model.Transaccion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author felipe
 */
public class PPal {

    public static void main(String[] args) throws Exception {
        /**
         * *********************************************
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("APP_PagosPU");

        TransaccionJpaController transaccionJpaController = new TransaccionJpaController(emf);
        
        System.out.println("Registrar Tarjeta");
        TarjetaJpaController tarjetaJpaController = new TarjetaJpaController(emf);
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setOpfranquicia("VISA");
        tarjeta.setOpestadotarjeta("Activa");
        tarjeta.setOptipotarjeta("Credito");
        tarjeta.setNmtarjeta(2323232);
        tarjeta.setDsmesvencimiento("1");
        tarjeta.setDsaniovencimiento("2015");
        tarjeta.setCdseguridad(23232323);
        tarjeta.setDsnombretitular("Johan Felipe");
        if(tarjetaJpaController.create(tarjeta)){
            System.out.println("Tarjeta Creada Exitosamente");
        }

        /*
        System.out.println("Transacciones por numero de tarjeta origen");
         int nmtarjeta = 4123123;
         for (Tarjeta tarjeta : transaccionJpaController.getTransaccionesTarjetaOrigen(nmtarjeta)) {
         System.out.println("Numero de cuenta --> " + tarjeta.getNmtarjeta());
         System.out.println("Titular de la cuenta -->" + tarjeta.getDsnombretitular());
         List<Transaccion> transacciones = tarjeta.getTransaccionList();
            
         for (Transaccion trans : transacciones) {
         System.out.println("*****Transacciones realizadas ********");
         System.out.println("Transaccion numero --> " + trans.getCdtransaccion());
         System.out.println("Cuenta origen --> " + trans.getCdtarjetaorigen());
         System.out.println("Cuenta destino --> " + trans.getCdtarjetadestino());
         System.out.println("Valor consignado --> " + trans.getVltransaccion() );
         System.out.println("Cuotas establecidas -->" + trans.getNmcuotaspago());
         System.out.println(trans.getCdtipopago().getDsdescripcion());
         List<RegistroTransaccion> registrotransaccion = trans.getRegistroTransaccionList();
         for(RegistroTransaccion regTransaccion : registrotransaccion){
         System.out.println("Fecha transaccion --> " + regTransaccion.getFefechatransaccion());
         System.out.println("Estado transaccion -->" + regTransaccion.getOpestado());
         }
         TipoPago tipopago = new TipoPago();
         tipopago = trans.getCdtipopago();
         System.out.println("Tipo de pago -->" + tipopago.getDsdescripcion());
                
         }
            
         }
        
        
        
        /*TransaccionJpaController transaccioJpaController = new TransaccionJpaController(emf);
         System.out.println("Transacciones por estado");
         for (Transaccion transaccion : transaccioJpaController.getTransaccionByEstado("Exitoso")) {
         System.out.println(transaccion.getCdtransaccion());
         }*/
        /*System.out.println("Transacciones realizadas por una cuenta origen a una cuenta destino");
         int nmtarjetaOrigen = 232323;
         int nmtarjetaDestino = 232324;
         for (Tarjeta tarjeta : transaccionJpaController.getTransaccionesRealizadasCuentaOrigenCuentaDestino(nmtarjetaOrigen,nmtarjetaDestino)) {
         System.out.println("Numero de cuenta origen --> " + tarjeta.getNmtarjeta());
         System.out.println("Titular de la cuenta -->" + tarjeta.getDsnombretitular());
         List<Transaccion> transacciones = tarjeta.getTransaccionList();
            
         for (Transaccion trans : transacciones) {
         System.out.println("*****Transacciones realizadas ********");
         System.out.println("Transaccion numero --> " + trans.getCdtransaccion());
         System.out.println("Cuenta destino --> " + trans.getCdtarjetadestino());
         System.out.println("Valor consignado --> " + trans.getVltransaccion() );
         System.out.println("Cuotas establecidas -->" + trans.getNmcuotaspago());
         System.out.println(trans.getCdtipopago().getDsdescripcion());
         List<RegistroTransaccion> registrotransaccion = trans.getRegistroTransaccionList();
         for(RegistroTransaccion regTransaccion : registrotransaccion){
         System.out.println("Fecha transaccion --> " + regTransaccion.getFefechatransaccion());
         System.out.println("Estado transaccion -->" + regTransaccion.getOpestado());
         }
         TipoPago tipopago = new TipoPago();
         tipopago = trans.getCdtipopago();
         System.out.println("Tipo de pago -->" + tipopago.getDsdescripcion());
                
         }
            
         }*/
        
        
        /*
        System.out.println("Transacciones por estado");
        for (Transaccion transaccion : transaccionJpaController.getTransaccionByEstado("ACEPTADA")) {

            System.out.println("****Transacción Número " + transaccion.getCdtransaccion() + "****");
            System.out.println("Tipo de Pago: " + transaccion.getCdtipopago().getDsdescripcion());
            System.out.println("Tarjeta Origen: " + transaccion.getCdtarjetaorigen().getNmtarjeta());
            System.out.println("Tarjeta Destino: " + transaccion.getCdtarjetadestino());
            System.out.println("Valor transaccion: " + transaccion.getVltransaccion());
            System.out.println("Cuotas de pago: " + transaccion.getNmcuotaspago());

            List<RegistroTransaccion> registroTrans = transaccion.getRegistroTransaccionList();
            for (RegistroTransaccion registroTransaccion : registroTrans) {
                System.out.println("Fecha Transacción: " + registroTransaccion.getFefechatransaccion());
                System.out.println("Estado Transacción: " + registroTransaccion.getOpestado());
            }
        }*/

        
        /*
        System.out.println("Transacciones por fecha");
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = "2015-03-04";
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        for (Transaccion transaccion : transaccionJpaController.getTransaccionByFecha(fecha)) {
            System.out.println("****Transacción realizada en la fecha: " + fecha + "****");
            System.out.println("Tipo de Pago: " + transaccion.getCdtipopago().getDsdescripcion());
            System.out.println("Tarjeta Origen: " + transaccion.getCdtarjetaorigen().getNmtarjeta());
            System.out.println("Tarjeta Destino: " + transaccion.getCdtarjetadestino());
            System.out.println("Valor transaccion: " + transaccion.getVltransaccion());
            System.out.println("Cuotas de pago: " + transaccion.getNmcuotaspago());
            System.out.println("Código transacción: " + transaccion.getCdtransaccion());

            List<RegistroTransaccion> registroTrans = transaccion.getRegistroTransaccionList();
            for (RegistroTransaccion registroTransaccion : registroTrans) {
                System.out.println("Estado Transaccion: " + registroTransaccion.getOpestado());
            }
        }*/
        
        /*
        System.out.println("Tarjetas por Número de tarjeta");
        for (Tarjeta tarjeta : tarjetaJpaController.getTarjetaByNmtarjeta("5532342")) {
            System.out.println("****Tarjeta número: 5532342 ****");
            System.out.println("Nombre titular: " + tarjeta.getDsnombretitular());
            System.out.println("TIpo tarjeta: " + tarjeta.getOptipotarjeta());
            System.out.println("Código de seguridad: " + tarjeta.getCdseguridad());
            System.out.println("Año de vencimiento: " + tarjeta.getDsaniovencimiento());
            System.out.println("Mes vencimiento: " + tarjeta.getDsmesvencimiento());
            System.out.println("Estado tarjeta: " + tarjeta.getOpestadotarjeta());
            System.out.println("Franquicia: " + tarjeta.getOpfranquicia());
        }
                */
    }
}
