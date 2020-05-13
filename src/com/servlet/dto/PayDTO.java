package com.servlet.dto;

import java.time.LocalDate;

public class PayDTO {
    int pay_id;
    String car_number;
    int pay_price;
    String pay_kind;
    LocalDate pay_time;
    String in_date;
    String parking_time;

    public PayDTO(int pay_id, String car_number, int pay_price, String pay_kind, LocalDate pay_time) {
        this.pay_id = pay_id;
        this.car_number = car_number;
        this.pay_price = pay_price;
        this.pay_kind = pay_kind;
        this.pay_time = pay_time;
    }

    public PayDTO(String car_number, String in_date, String parking_time, int pay_price) {
        this.car_number = car_number;
        this.in_date = in_date;
        this.parking_time = parking_time;
        this.pay_price = pay_price;
    }

    public PayDTO(String car_number, int pay_price, String pay_kind) {
        this.car_number = car_number;
        this.pay_price = pay_price;
        this.pay_kind = pay_kind;
    }

    public int getPay_id() { return pay_id; }

    public String getCar_number() { return car_number; }

    public int getPay_price() { return pay_price; }

    public String getPay_kind() { return pay_kind; }

    public LocalDate getPay_time() { return pay_time; }

    public String getIn_date() { return in_date; }

    public String getParking_time() { return parking_time; }
}
