/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ibm.bim.spring.security.prospring3.security;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface IChangePassword extends UserDetailsService{
    
    void changePassword(String userName, String password);

}
