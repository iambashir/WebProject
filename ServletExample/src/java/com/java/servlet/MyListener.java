package com.java.servlet;

import javax.servlet.*;
import java.sql.*;

public class MyListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent arg0) {
        Connection con = null;
        try {
            con = GetCon.getCon();

            PreparedStatement ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS `fa_uom` ("
                    + " `uom_id` int(10) unsigned NOT NULL auto_increment,"
                    + " `uom_name` varchar(45) NOT NULL,"
                    + " `uom_description` varchar(45) NOT NULL,"
                    + " PRIMARY KEY  (`uom_id`)) "
                    + " ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            ps.executeUpdate();

            ps = con.prepareStatement("INSERT INTO `fa_uom` (`uom_name`,`uom_description`) VALUES(?,?)");
            ps.setString(1, "Pcs");
            ps.setString(2, "Pieces");
            ps.executeUpdate();
            System.out.println("database created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("project undeployed");

    }
}
