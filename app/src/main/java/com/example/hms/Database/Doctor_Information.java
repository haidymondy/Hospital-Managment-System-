package com.example.hms.Database;

public class Doctor_Information {
    String doctorName;
    int id,yearOfExp,fee;

    public Doctor_Information(int id, String doctorName, int yearOfExp, int fee) {
        this.id = id;
        this.doctorName = doctorName;
        this.yearOfExp = yearOfExp;
        this.fee = fee;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(int yearOfExp) {
        this.yearOfExp = yearOfExp;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
