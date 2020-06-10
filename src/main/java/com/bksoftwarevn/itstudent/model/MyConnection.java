package com.bksoftwarevn.itstudent.model;
import com.bksoftwarevn.itstudent.common.AppConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection connection = null;
    //B1: kiem tra driver. B2 ket noi den db. B3 dong ket
    //kiem tra drive jdbc da TON TAI HAY CHUA
    public void driverTest() throws ClassNotFoundException {
        try{
            //connect to db
            Class.forName(AppConfig.DRIVER);
        } catch (ClassNotFoundException ex){
            throw new ClassNotFoundException("JDBC driver not found "+ ex.getMessage());
        }
    }
    public Connection connectDB() throws SQLException, ClassNotFoundException{
        driverTest();
        try{
            connection  = DriverManager.getConnection(AppConfig.URL_DATABASE, AppConfig.USERNAME, AppConfig.PASSWORD);
            if(connection!=null){
                System.out.println("connection successlly");
            }
        }
        catch (Exception ex){
            throw new SQLException("connect to DB failed"+ex.getMessage());
        }
        return connection;
    }
    //dong ket voi database
    public void closeConnection() throws SQLException{
        if (connection != null){
            connection.close();
            System.out.println("connection is close");
        }
    }
}
