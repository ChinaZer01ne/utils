package com.github.reconstruction.movie;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // show fingures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        Enumeration<Rental> rentalEnumeration = _rentals.elements();
        String result = "<h1>Rental Records for " + getName() + "</h1>\n";
        result += "<table border='1'><tr><td>Movie Name</td><td>Charge</tr>\n";
        while (rentalEnumeration.hasMoreElements()) {
            Rental each = rentalEnumeration.nextElement();
            // show figures for this rental
            result += "\t<tr><td>" + each.getMovie().getTitle() + "</td><td>" + each.getCharge() + "</td></tr>\n";
        }

        // add footer lines
        result += "\t<tr><td colspan='2'>Total Charge:" + getTotalCharge() + "</td></tr>\n";
        result += "\t<tr><td colspan='2'>Total Pointers:" + getTotalFrequentRenterPoints() + "</td></tr>\n";
        result += "</table>";
        return result;
    }

    private double getTotalCharge(){
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private double getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
