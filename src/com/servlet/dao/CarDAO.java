package com.servlet.dao;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.servlet.dto.CarDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarDAO {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/parking_system?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    String id = "user";
    String pw = "wltn9662";

    public CarDAO() {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<CarDTO> inList() {
        ArrayList<CarDTO> list = new ArrayList<CarDTO>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String sql = "SELECT log_inout.car_number, car_kind, date_format(in_date, '%Y-%m-%d %H:%i') AS in_date, ROUND(TIMESTAMPDIFF(MINUTE, in_date, NOW())) AS parking_time, ticket_valid, ticket_end FROM log_inout " +
                    "INNER JOIN car ON log_inout.car_number = car.car_number LEFT JOIN season_ticket ON log_inout.car_number = season_ticket.car_number " +
                    "WHERE out_date IS NULL ORDER BY in_date";
            pstmt = con.prepareStatement(sql);
            res = pstmt.executeQuery();

            while (res.next()) {
                String car_number = res.getString("car_number");
                String car_kind = res.getString("car_kind");
                String car_in_date = res.getString("in_date");
                String parking_time = res.getString("parking_time");
                String ticket_valid = res.getString("ticket_valid");
                String ticket_end = res.getString("ticket_end");

                CarDTO carDTO = new CarDTO(car_number, car_kind, car_in_date, parking_time, ticket_valid, ticket_end);
                list.add(carDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (res != null) {
                    res.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return list;
    }

    public int insert(CarDTO dto) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            int already = 0;
            String check_sql = "SELECT car_number FROM log_inout WHERE car_number = ? AND out_date IS NULL";
            pstmt = con.prepareStatement(check_sql);
            pstmt.setString(1, dto.getCar_number());
            res = pstmt.executeQuery();
            pstmt.clearParameters();

            if(res.next()) {
                already = 1;
            }

            if(already == 1) {
                return 2;
            } else {
                String sql = "INSERT INTO car(car_number, car_kind) VALUES(?, ?)";
                pstmt = con.prepareStatement(sql);

                String car_number = dto.getCar_number();
                String car_kind = dto.getCar_kind();

                if(dto.getCar_number().length() == 0) {
                    return 0;
                }

                pstmt.setString(1, car_number);
                pstmt.setString(2, car_kind);

                try {
                    int result = pstmt.executeUpdate();
                    pstmt.clearParameters();

                    if (result != 1) {
                        return 0;
                    }
                } catch (MySQLIntegrityConstraintViolationException e) {
                    e.printStackTrace();
                } finally {
                    String log_sql = "INSERT INTO log_inout(car_number) VALUES(?)";
                    pstmt = con.prepareStatement(log_sql);
                    pstmt.setString(1, car_number);
                    pstmt.executeUpdate();

                    return 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(res != null) {
                    res.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return 0;
    }

    public ArrayList<CarDTO> outList() {
        ArrayList<CarDTO> list = new ArrayList<CarDTO>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String sql = "SELECT log_inout.car_number, car.car_kind, date_format(in_date, '%Y-%m-%d %H:%i') AS in_date, date_format(out_date, '%Y-%m-%d %H:%i') AS out_date, " +
                    "ROUND(TIMESTAMPDIFF(MINUTE, in_date, NOW())) AS parking_time, ticket_valid, ticket_end, FORMAT(pay_price, 0) AS pay_price, pay_kind FROM log_inout " +
                    "INNER JOIN car ON log_inout.car_number = car.car_number LEFT JOIN season_ticket ON log_inout.car_number = season_ticket.car_number LEFT JOIN log_payment ON log_inout.car_number = log_payment.car_number " +
                    "WHERE NOT out_date IS NULL ORDER BY out_date";
            pstmt = con.prepareStatement(sql);
            res = pstmt.executeQuery();

            while (res.next()) {
                String car_number = res.getString("car_number");
                String car_kind = res.getString("car_kind");
                String car_in_date = res.getString("in_date");
                String car_out_date = res.getString("out_date");
                String parking_time = res.getString("parking_time");
                String ticket_valid = res.getString("ticket_valid");
                String ticket_end = res.getString("ticket_end");
                String pay_price = res.getString("pay_price");
                String pay_kind = res.getString("pay_kind");

                CarDTO carDTO = new CarDTO(car_number, car_kind, car_in_date, car_out_date, parking_time, ticket_valid, ticket_end, pay_price, pay_kind);
                list.add(carDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (res != null) {
                    res.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return list;
    }
}
