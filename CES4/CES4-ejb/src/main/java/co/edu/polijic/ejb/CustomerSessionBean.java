/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.ejb;

import co.edu.polijic.controllers.CustomerJpaController;
import co.edu.polijic.ejb.interfaces.CustomerSessionBeanRemote;
import co.edu.polijic.entities.Customer;
import co.edu.polijic.entities.exceptions.PreexistingEntityException;
import javax.ejb.Stateless;
import javax.persistence.Persistence;

/**
 *
 * @author AddaxT
 */
@Stateless(name = "ejb/Customer")
public class CustomerSessionBean implements CustomerSessionBeanRemote, CustomerSessionBeanLocal {

    @Override
    public void createCustomer(Customer customer) throws PreexistingEntityException, Exception {
        CustomerJpaController customerJpaController = new CustomerJpaController(Persistence.createEntityManagerFactory("CES4PU"));
        customerJpaController.create(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        CustomerJpaController customerJpaController = new CustomerJpaController(Persistence.createEntityManagerFactory("CES4PU"));
        return customerJpaController.findCustomer(id);
    }
}
