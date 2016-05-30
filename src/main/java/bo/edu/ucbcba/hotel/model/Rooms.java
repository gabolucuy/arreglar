package bo.edu.ucbcba.hotel.model;


import javax.persistence.*;
@Entity
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomNumber; // Primary Key, and Auto Generated

    @Column(length = 100)
    private String type;
    private boolean availability;



    private String roomView;
    private boolean phone;
    private boolean living;
    private boolean kitchenAccesories;
    private boolean minibar;
    private boolean desk;
    private boolean ornaments;



    public Rooms() {
        type="Simple";
        availability=false;
        roomView="Mar";
        phone=false;
        living=false;
        kitchenAccesories=false;
        minibar=false;
        desk=false;
        ornaments=false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getRoomView() {
        return roomView;
    }

    public void setRoomView(String roomView) {
        this.roomView = roomView;
    }


    public boolean isPhone() {
        return phone;
    }

    public void setPhone(boolean phone) {
        this.phone = phone;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public boolean isKitchenAccesories() {
        return kitchenAccesories;
    }

    public void setKitchenAccesories(boolean kitchenAccesories) {
        this.kitchenAccesories = kitchenAccesories;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public boolean isDesk() {
        return desk;
    }

    public void setDesk(boolean desk) {
        this.desk = desk;
    }

    public boolean isOrnaments() {
        return ornaments;
    }

    public void setOrnaments(boolean ornaments) {
        this.ornaments = ornaments;
    }
    public void settype(String type) {
        this.type = type;
    }


}