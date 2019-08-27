package server.models;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Bus")
public class Bus {

    public int id;
    public int seats;
    public String driver_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bus(){

    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }
}
