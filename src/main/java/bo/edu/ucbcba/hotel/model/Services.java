package bo.edu.ucbcba.hotel.model;

/**
 * Created by Alejandra on 17/05/2016.
 */
import javax.persistence.*;
@Entity
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomNumber; // Primary Key, and Auto Generated

    @Column(length = 100)
    private String name;
    private String description;
    private int cost;


    public Services() {
        this.cost = 0;
        this.description = "";
        this.name = "";
    }
    //getter

    public int getRoomNumber() {return roomNumber;}

    public String getName() {return name;}

    public String getDescription() {return description;}

    public int getCost() {return cost;}

    //setter
    public void setRoomNumber(int roomNumber) {this.roomNumber = roomNumber;}

    public void setCost(int cost) {this.cost = cost;}

    public void setDescription(String description) {this.description = description;}

    public void setName(String name) {this.name = name;}
}
