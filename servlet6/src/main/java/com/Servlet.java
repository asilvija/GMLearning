package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.app.controller.Context;
import com.app.controller.Controller;

public class Servlet extends HttpServlet {

	
//	private SQLiteConnectionPoolDataSource _ds;
//	_ds = new SQLiteConnectionPoolDataSource();
//	_ds.setUrl("jdbc:sqlite:/path");
	
//	private HikariDataSource _ds;
//  _ds = new HikariDataSource();
//	_ds.setJdbcUrl("jdbc:sqlite:/path");
	
	private DataSource _ds;
	
	@Override
	public void init() throws ServletException {
		try {
			_ds = (DataSource)new InitialContext().lookup("java:/comp/env/jdbc/ds");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
		for(Controller c : new ControllerFactory().create()){
			if(c.handles(req.getRequestURI())){
			    Connection connection = null;
				try {
				    connection = _ds.getConnection();
					connection.setAutoCommit(false);
					c.execute(new Context(req, resp, connection));
					connection.commit();
					close(connection);
					return;
				} catch (Exception e) {
				    rollback(connection);
					resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					throw new RuntimeException(e);
				} finally {
				    close(connection);
				}
			}
		}
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

    private void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            //log
            throw new RuntimeException(e);
        }
    }

    private void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            //log
            throw new RuntimeException(e);
        }
    }
}
