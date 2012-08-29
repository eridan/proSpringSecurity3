/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.bim.spring.security.prospring3.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.memory.InMemoryDaoImpl;

public class InMemoryChangePasswordDaoImpl extends InMemoryDaoImpl implements IChangePassword {

    @Override
    public void changePassword(String userName, String password) {
        User userDetails = (User) getUserMap().getUser(userName);
        User newUserDetails = new User(
                userDetails.getUsername(),
                password,
                userDetails.isEnabled(),
                userDetails.isAccountNonExpired(),
                userDetails.isCredentialsNonExpired(),
                userDetails.isAccountNonLocked(),
                userDetails.getAuthorities());
        
        getUserMap().addUser(newUserDetails);
    }
}
