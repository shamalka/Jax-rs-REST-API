package server.service;

import server.connection.DbConnection;
import server.models.Bus;

import javax.validation.constraints.NotNull;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class BusService {

    DbConnection connection = new DbConnection();
    Connection con = connection.connection;

    public BusService(){

    }

    public List<Bus> getAll(List<Bus> bus_list){
        try{
            PreparedStatement statement = con.prepareStatement("SELECT * FROM bus");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Bus bus = new Bus();
                bus.setId(rs.getInt(1));
                bus.setSeats(rs.getInt(2));
                bus.setDriver_name(rs.getString(3));
                System.out.println(rs.getInt(2));
                bus_list.add(bus);

            }
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return bus_list;
    }

    public Bus getBusById(int BusId){
        Bus bus = null;
        try{
            PreparedStatement statement = con.prepareStatement("SELECT * FROM bus WHERE id=?");
            statement.setInt(1,BusId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                bus = new Bus();
                bus.setId(rs.getInt(1));
                bus.setSeats(rs.getInt(2));
                bus.setDriver_name(rs.getString(3));
                System.out.println(rs.getInt(2));
            }
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return bus;
    }

    public Bus addBus(@NotNull Bus bus)  {
        try{
            PreparedStatement statement = con.prepareStatement("INSERT INTO bus(seats,driver_name) VALUES (?,?)");
            statement.setInt(1,bus.getSeats());
            statement.setString(2,bus.getDriver_name());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return bus;
    }

    public String deleteBus(int BusId){
        try{
            PreparedStatement statement = con.prepareStatement("DELETE FROM bus WHERE id=?");
            statement.setInt(1,BusId);
            statement.executeUpdate();
        }catch(SQLException e){

        }
        return "Bus Number: " + BusId + " Deleted";
    }

    public Bus updateBus(@NotNull Bus bus , int BusId){
        try{
            PreparedStatement statement = con.prepareStatement("UPDATE bus SET seats=?,driver_name=? WHERE id=?");
            statement.setInt(1,bus.getSeats());
            statement.setString(2,bus.getDriver_name());
            statement.setInt(3,BusId);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bus;
    }
}
