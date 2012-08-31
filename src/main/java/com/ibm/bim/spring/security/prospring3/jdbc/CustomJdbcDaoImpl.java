/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.bim.spring.security.prospring3.jdbc;

import com.ibm.bim.spring.security.prospring3.security.IChangePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class CustomJdbcDaoImpl extends JdbcDaoImpl implements IChangePassword {
    
    @Autowired
    private SaltSource saltSource;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void changePassword(String userName, String password) {
        UserDetails user = loadUserByUsername(userName);
        String encodedPw = passwordEncoder.encodePassword(password,saltSource.getSalt(user));
        getJdbcTemplate().update(
                "UPDATE USERS SET PASSWORD = ? WHERE USERNAME = ?", encodedPw, userName);
        System.out.println("Password was chenged for the user ["+userName+"] "+encodedPw);
    }
}
