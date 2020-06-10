package com.bksoftwarevn.itstudent.view;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import com.bksoftwarevn.itstudent.model.MyConnection;
public class Main {
    public static void main(String[] args) {
        MyConnection myConnection = new MyConnection();
        try{

            String sql = "insert into product (name, price, create_date, deleted) value (?,?,?,?)";
            Connection myConnect = myConnection.connectDB();
            PreparedStatement preparedStatement = myConnect.prepareStatement(sql);
            preparedStatement.setString(1, "iphone");
            preparedStatement.setDouble(2, 2000);
            preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));
            preparedStatement.setBoolean(4, false);
            int rs= preparedStatement.executeUpdate();
            if(rs > 0) System.out.println("insert successlly");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
