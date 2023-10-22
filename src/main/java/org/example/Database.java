package org.example;

import java.sql.*;

public class Database {


    private Connection con;

    public Database(){
        try {

            con = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement stmt = con.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS cars (" +
                    "id INTEGER PRIMARY KEY," +
                    "brand TEXT NOT NULL," +
                    "model TEXT NOT NULL," +
                    "year INTEGER NOT NULL)";

            stmt.execute(sql);

            stmt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean saveCar(Car car){

        String sql = "INSERT INTO cars (brand, model, year) VALUES (?, ?, ?)";
        //String sql = "INSERT INTO cars (brand, model, year) VALUES (?, ?, ?)";
        boolean result;

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, car.getBrand());
            stmt.setString(2, car.getModel());
            stmt.setInt(3, car.getYear());

            result = stmt.executeUpdate() > 0;
            stmt.close();

        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return result;
    }

    public boolean removeCar(int id){
        String sql = "DELETE FROM cars WHERE id = ?";
        boolean result;

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            result = stmt.executeUpdate() > 0;
            stmt.close();

        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return result;
    }

}
