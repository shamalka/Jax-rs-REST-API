package server.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.persistence.annotations.ReturnUpdate;
import server.models.Bus;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("school")
@Produces(MediaType.APPLICATION_JSON)
public class Hello {

    public BusService busService;

    public Hello(){
        busService = new BusService();
    }

    @GET
    @Path("bus")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bus> sayHello() {

        List<Bus> bus_list = new ArrayList<>();
        busService.getAll(bus_list);
        System.out.println("Size"+bus_list.size());

        for(int i=0; i<bus_list.size(); i++){
            System.out.println(bus_list.get(i).getDriver_name());
        }
        return bus_list;
    }

    @GET
    @Path("bus/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bus getBus(@PathParam("param") int BusId){
     //   BusService busService = new BusService();
        return busService.getBusById(BusId);
    }

    @POST
    @Path("bus/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Bus addBus(Bus bus) {
        try{
         //   BusService busService = new BusService();
            busService.addBus(bus);
        }catch (Exception e){
            e.printStackTrace();
        }

        return bus;
    }

    @DELETE
    @Path("bus/delete/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteBus(@PathParam("param") int BusId){
     //   BusService busService = new BusService();
        return busService.deleteBus(BusId);
    }

    @PUT
    @Path("bus/update/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Bus updateBus(Bus bus, @PathParam("param") int BusId){
        try{
      //
            //      BusService busService = new BusService();
            busService.updateBus(bus, BusId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return bus;
    }

}
