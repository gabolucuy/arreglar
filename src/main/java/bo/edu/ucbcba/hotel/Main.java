package bo.edu.ucbcba.hotel;

import bo.edu.ucbcba.hotel.view.HotelForm;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        HotelForm form = new HotelForm();
        form.setVisible(true);
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
