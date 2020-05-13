package com.servlet.dao;

import com.servlet.dto.TicketDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class TicketDAO {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/parking_system?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    String id = "user";
    String pw = "wltn9662";

    public TicketDAO() {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TicketDTO> ticketList() {
        ArrayList<TicketDTO> list = new ArrayList<TicketDTO>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String sql = "SELECT ticket_name, ticket_valid, ticket_start, ticket_end, season_ticket.car_number, car_kind, member_name, member_contact FROM season_ticket " +
                    "INNER JOIN car ON season_ticket.car_number = car.car_number";
            pstmt = con.prepareStatement(sql);
            res = pstmt.executeQuery();

            while (res.next()) {
                String ticket_name = res.getString("ticket_name");
                Boolean ticket_valid = res.getBoolean("ticket_valid");
                LocalDate ticket_start = LocalDate.parse(res.getString("ticket_start"));
                LocalDate ticket_end = LocalDate.parse(res.getString("ticket_end"));
                String car_number = res.getString("car_number");
                String car_kind = res.getString("car_kind");
                String member_name = res.getString("member_name");
                String member_contact = res.getString("member_contact");

                TicketDTO ticketDTO = new TicketDTO(ticket_name, ticket_valid, ticket_start, ticket_end, car_number, car_kind, member_name, member_contact);
                list.add(ticketDTO);
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

    public int join(TicketDTO dto) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String inCheck_sql = "SELECT car_number FROM log_inout WHERE car_number = ? AND NOT in_date IS NULL";
            pstmt = con.prepareStatement(inCheck_sql);
            pstmt.setString(1, dto.getCar_number());
            res = pstmt.executeQuery();
            pstmt.clearParameters();

            if(res.next()) {
                String check_sql = "SELECT car_number FROM season_ticket WHERE car_number = ?";
                pstmt = con.prepareStatement(check_sql);
                pstmt.setString(1, dto.getCar_number());
                res = pstmt.executeQuery();
                pstmt.clearParameters();

                if (res.next()) {
                    return 4;           // 이미 등록되어 있는 정기권 차량 번호.
                } else {
                    String sql = "INSERT INTO season_ticket(ticket_name, ticket_valid, ticket_start, ticket_end, car_number, member_name, member_contact) VALUES(?, ?, ?, ?, ?, ?, ?)";
                    pstmt = con.prepareStatement(sql);

                    pstmt.setString(1, dto.getTicket_name());
                    pstmt.setBoolean(2, dto.isTicket_valid());
                    pstmt.setObject(3, dto.getTicket_start());
                    pstmt.setObject(4, dto.getTicket_end());
                    pstmt.setString(5, dto.getCar_number());
                    pstmt.setString(6, dto.getMember_name());
                    pstmt.setString(7, dto.getMember_contact());
                    int result = pstmt.executeUpdate();

                    if (result == 1) {
                        return 3;       // 성공적으로 등록.
                    } else {
                        return 0;
                    }
                }
            } else {
                return 5;       // 입차되어 있지 않음.
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

    public int extend(TicketDTO dto) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String sql = "UPDATE season_ticket SET ticket_end = DATE_ADD(ticket_end, INTERVAL ? MONTH) WHERE car_number = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getMonth());
            pstmt.setString(2, dto.getCar_number());
            int result = pstmt.executeUpdate();

            if (result == 1) {
                return 6;           // 성공적으로 연장.
            } else {
                return 7;           // 정기권 등록 안되어 있음.
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
    /*
        ticketOut - 출차 전 정기권 유무 체크.
        return 1 : 정기권 차량으로 바로 출차.
        return 2 : 정기권 차량이지만, 만료일 지남.
        return 3 : 정기권 차량 아님.
        return 4 : 이미 출차된 차량임.
        return 5 : 입차된 차량이 아님.
        return 0 : 에러.
    */
    public int ticketOut(TicketDTO dto) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String inCheck_sql = "SELECT car_number FROM log_inout WHERE car_number = ? AND NOT in_date IS NULL";
            pstmt = con.prepareStatement(inCheck_sql);
            pstmt.setString(1, dto.getCar_number());
            res = pstmt.executeQuery();
            pstmt.clearParameters(); // 입차되어 있는 상태의 차량인지 체크.

            if(res.next()) {
                String outCheck_sql = "SELECT car_number FROM log_inout WHERE car_number = ? AND out_date IS NULL";
                pstmt = con.prepareStatement(outCheck_sql);
                pstmt.setString(1, dto.getCar_number());
                res = pstmt.executeQuery();
                pstmt.clearParameters(); // 출차되지 않은 차량인지 체크.

                if(res.next()) {
                    String ticket_sql = "SELECT car_number FROM season_ticket WHERE car_number = ?";
                    pstmt = con.prepareStatement(ticket_sql);
                    pstmt.setString(1, dto.getCar_number());
                    res = pstmt.executeQuery();
                    pstmt.clearParameters(); // 정기권 등록 차량인지 체크.

                    if(res.next()) {
                        String sql = "SELECT car_number FROM season_ticket WHERE car_number = ? AND ticket_end > NOW()";
                        pstmt = con.prepareStatement(sql);
                        pstmt.setString(1, dto.getCar_number());
                        res = pstmt.executeQuery();
                        pstmt.clearParameters(); // 정기권 유효한지 체크.

                        if(res.next()) {
                            String out_sql = "UPDATE log_inout SET out_date = NOW() WHERE car_number = ? AND out_date IS NULL";
                            pstmt = con.prepareStatement(out_sql);
                            pstmt.setString(1, dto.getCar_number());
                            int result = pstmt.executeUpdate();
                            pstmt.clearParameters(); // 정기권이 유효한 상태.

                            if(result == 1) {
                                return 1;
                            }
                        } else {
                            String end_check_sql = "SELECT car_number FROM season_ticket WHERE car_number = ? AND NOW() > ticket_end";
                            pstmt = con.prepareStatement(end_check_sql);
                            pstmt.setString(1, dto.getCar_number());
                            res = pstmt.executeQuery();
                            pstmt.clearParameters(); // 정기권 만료인지 체크.

                            if(res.next()) {
                                return 2;
                            }
                        }
                    } else {
                        return 3;
                    }
                } else {
                    return 4;
                }
            } else {
                return 5;
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

    public int out(TicketDTO dto) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String sql = "UPDATE log_inout SET out_date = NOW() WHERE car_number = ? AND out_date IS NULL";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getCar_number());
            int result = pstmt.executeUpdate();

            if (result == 1) {
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
