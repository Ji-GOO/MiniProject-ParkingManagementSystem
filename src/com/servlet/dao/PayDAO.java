package com.servlet.dao;

import com.servlet.dto.PayDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PayDAO {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/parking_system?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    String id = "user";
    String pw = "wltn9662";

    public PayDAO() {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PayDTO> checkPay(String car_number) {
        ArrayList<PayDTO> list = new ArrayList<PayDTO>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String sql = "SELECT car_number, date_format(in_date, '%Y-%m-%d %H:%i') AS in_date, ROUND(TIMESTAMPDIFF(MINUTE, in_date, NOW())) AS parking_time, " +
                    "ROUND(TIMESTAMPDIFF(MINUTE, in_date, NOW())) * 500 AS pay_price FROM log_inout WHERE car_number = ? ORDER BY -in_date limit 1";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, car_number);
            res = pstmt.executeQuery();

            while (res.next()) {
                car_number = res.getString("car_number");
                String in_date = res.getString("in_date");
                String parking_time = res.getString("parking_time");
                int pay_price = res.getInt("pay_price");

                PayDTO payDTO = new PayDTO(car_number, in_date, parking_time, pay_price);
                list.add(payDTO);
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            try {
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

    public int pay(PayDTO dto) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String log_sql = "INSERT INTO log_payment(car_number, pay_price, pay_kind) VALUES(?, ?, ?)";
            pstmt = con.prepareStatement(log_sql);
            pstmt.setString(1, (dto.getCar_number()));
            pstmt.setInt(2, dto.getPay_price());
            pstmt.setString(3, dto.getPay_kind());
            int result = pstmt.executeUpdate();
            pstmt.clearParameters();

            if (result == 1) {
                String sql = "UPDATE log_inout SET out_date = NOW() WHERE car_number = ? AND out_date IS NULL";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, dto.getCar_number());
                pstmt.executeUpdate();

                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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
}
