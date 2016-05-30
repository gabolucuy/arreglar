package bo.edu.ucbcba.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by CésarIvan on 19/05/2016.
 */
@Entity
public class Clients {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int clientCi; // Primary Key, and Auto Generated

    @Column(length = 100)
    private String firstName;
    private String lastName;
    private int phone;

    public Clients(){
        this.firstName="";
        this.lastName="";
        this.phone=0;

    }

    //getter

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }


    //setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getClientCi() {
        return clientCi;
    }

    public void setClientCi(int clientCi) {
        this.clientCi = clientCi;
    }





}
