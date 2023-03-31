package com.example.restassignmentsdj.api.model;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Animal {

    private LocalDate arrivingDate;
    private double weight;
    private long regNumber;
    private String origin;

    public Animal(LocalDate arrivingDate, double weight, long regNumber, String origin) {
        this.arrivingDate = arrivingDate;
        this.weight = weight;
        this.regNumber = regNumber;
        this.origin = origin;
    }

    public void setArrivingDate(LocalDate arrivingDate) {
        this.arrivingDate = arrivingDate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setRegNumber(long regNumber) {
        this.regNumber = regNumber;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDate getArrivingDate() {
        return arrivingDate;
    }

    public double getWeight() {
        return weight;
    }

    public long getRegNumber() {
        return regNumber;
    }

    public String getOrigin() {
        return origin;
    }
}
