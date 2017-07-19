/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anisol.springframework.dao.impl;

import com.anisol.springframework.dao.CustomerDAO;
import com.anisol.springframework.entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pradeep
 */
@Repository(value = "customerDAO")
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM customer";
        System.out.println("gako xa?");
        return jdbcTemplate.query(sql, new RowMapper<Customer>() {

            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                Customer c = new Customer();
                c.setId(rs.getInt("user_id"));
                c.setFirstName(rs.getString("first_name"));
                c.setEmail(rs.getString("email"));
                c.setLastName(rs.getString("last_name"));
                c.setContactNo(rs.getString("contact_no"));

                System.out.println(c.getFirstName());
                return c;
            }
        });
    }

    @Override
    public Customer getById(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Customer c) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO customers(first_name,last_name,email,contact_no) VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{c.getFirstName(), c.getLastName(), c.getId(), c.getContactNo(), c.getEmail()});
    }

    @Override
    public int update(Customer c) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
