/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.ejb;

import co.edu.polijic.entities.Customer;
import co.edu.polijic.entities.exceptions.PreexistingEntityException;
import javax.ejb.Local;

/**
 *
 * @author AddaxT
 */
@Local
public interface CustomerSessionBeanLocal {

    void createCustomer(Customer customer) throws PreexistingEntityException, Exception;
    
}
