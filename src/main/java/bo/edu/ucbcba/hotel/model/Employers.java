package bo.edu.ucbcba.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Alejandra on 29/05/2016.
 */
@Entity
public class Employers {
    @Id
    private int Ci; // Primary Key
    @Column(length = 100)
    private String Name;
    private String lastName;
    private int phone;
    public Employers(){
        this.Name="";
        this.lastName="";
        this.phone=0;
    }
    public int getPhone() {
            return phone;
        }

        public void setPhone(int phone) {
            this.phone = phone;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public int getCi() {
            return Ci;
        }

        public void setCi(int ci) {
            Ci = ci;
        }
}

