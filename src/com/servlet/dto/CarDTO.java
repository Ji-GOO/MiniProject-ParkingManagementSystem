package com.servlet.dto;

public class CarDTO {
    int car_id;
    String car_number;
    String car_kind;
    String car_in_date;
    String parking_time;
    String car_out_date;
    String ticket_valid;
    String ticket_end;
    String pay_price;
    String pay_kind;

    public CarDTO(String car_number, String car_kind) {
        this.car_number = car_number;
        this.car_kind = car_kind;
    }

    public CarDTO(String car_number, String car_kind, String car_in_date, String parking_time, String ticket_valid, String ticket_end) {
        this.car_number = car_number;
        this.car_kind = car_kind;
        this.car_in_date = car_in_date;
        this.parking_time = parking_time;
        this.ticket_valid = ticket_valid;
        this.ticket_end = ticket_end;
    }

    public CarDTO(String car_number, String car_kind, String car_in_date, String car_out_date, String parking_time, String ticket_valid, String ticket_end, String pay_price, String pay_kind) {
        this.car_number = car_number;
        this.car_kind = car_kind;
        this.car_in_date = car_in_date;
        this.car_out_date = car_out_date;
        this.parking_time = parking_time;
        this.ticket_valid = ticket_valid;
        this.ticket_end = ticket_end;
        this.pay_price = pay_price;
        this.pay_kind = pay_kind;
    }

    public int getCar_id() { return car_id; }

    public String getCar_number() {
        return car_number;
    }

    public String getCar_kind() {
        return car_kind;
    }

    public String getCar_in_date() { return car_in_date; }

    public String getParking_time() { return parking_time; }

    public String getCar_out_date() { return car_out_date; }

    public String getTicket_valid() { return ticket_valid; }

    public String getTicket_end() { return ticket_end; }

    public String getPay_price() { return pay_price; }

    public String getPay_kind() { return pay_kind; }
}
