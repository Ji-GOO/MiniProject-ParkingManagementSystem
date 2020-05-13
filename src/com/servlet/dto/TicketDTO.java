package com.servlet.dto;

import java.time.LocalDate;

public class TicketDTO {
    int ticket_id;
    String ticket_name;
    boolean ticket_valid;
    LocalDate ticket_start;
    LocalDate ticket_end;
    String car_number;
    String car_kind;
    String member_name;
    String member_contact;
    String month;

    public TicketDTO(String ticket_name, boolean ticket_valid, LocalDate ticket_start, LocalDate ticket_end, String car_number, String member_name, String member_contact) {
        this.ticket_name = ticket_name;
        this.ticket_valid = ticket_valid;
        this.ticket_start = ticket_start;
        this.ticket_end = ticket_end;
        this.car_number = car_number;
        this.member_name = member_name;
        this.member_contact = member_contact;
    }

    public TicketDTO(String car_number) {
        this.car_number = car_number;
    }

    public TicketDTO(String car_number, String month) {
        this.car_number = car_number;
        this.month = month;
    }

    public TicketDTO(String ticket_name, Boolean ticket_valid, LocalDate ticket_start, LocalDate ticket_end, String car_number, String car_kind, String member_name, String member_contact) {
        this.ticket_name = ticket_name;
        this.ticket_valid = ticket_valid;
        this.ticket_start = ticket_start;
        this.ticket_end = ticket_end;
        this.car_number = car_number;
        this.car_kind = car_kind;
        this.member_name = member_name;
        this.member_contact = member_contact;
    }

    public int getTicket_id() { return ticket_id; }

    public String getTicket_name() {
        return ticket_name;
    }

    public boolean isTicket_valid() {
        return ticket_valid;
    }

    public LocalDate getTicket_start() {
        return ticket_start;
    }

    public LocalDate getTicket_end() {
        return ticket_end;
    }

    public String getCar_number() {
        return car_number;
    }

    public String getCar_kind() { return car_kind; }

    public String getMember_name() {
        return member_name;
    }

    public String getMember_contact() {
        return member_contact;
    }

    public String getMonth() { return month; }
}
