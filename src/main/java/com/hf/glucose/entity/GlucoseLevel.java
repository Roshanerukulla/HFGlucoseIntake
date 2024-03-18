package com.hf.glucose.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "glucose")
public class GlucoseLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Date date;
    private int bloodGlucose;
    private int insulinUnits;
    private int carbsGrams;
    private String mealDescription;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBloodGlucose() {
        return bloodGlucose;
    }

    public void setBloodGlucose(int bloodGlucose) {
        this.bloodGlucose = bloodGlucose;
    }

    public int getInsulinUnits() {
        return insulinUnits;
    }

    public void setInsulinUnits(int insulinUnits) {
        this.insulinUnits = insulinUnits;
    }

    public int getCarbsGrams() {
        return carbsGrams;
    }

    public void setCarbsGrams(int carbsGrams) {
        this.carbsGrams = carbsGrams;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public void setMealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
    }
}
