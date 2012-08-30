/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.bim.spring.security.prospring3.jdbc;

import com.ibm.bim.spring.security.prospring3.security.IChangePassword;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class CustomJdbcDaoImpl extends JdbcDaoImpl implements IChangePassword {

    @Override
    public void changePassword(String userName, String password) {
        System.out.println("Change the pw method");
        getJdbcTemplate().update(
                "UPDATE USERS SET PASSWORD = ? WHERE USERNAME = ?", password, userName);
    }
}
