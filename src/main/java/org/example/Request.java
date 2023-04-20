package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Request {
    public static void addOwner() throws SQLException {
        Connection connection=ConnectionToDB.getConnection();
        Scanner scanner=new Scanner(System.in);
        System.out.print("FIO: ");
        String name=scanner.nextLine();
        System.out.print("date in format dd-mm-yyyy: ");
        String date=scanner.nextLine();
        String[] dates=date.split("-");
        Calendar calendar=new GregorianCalendar(Integer.parseInt(dates[2]),
                Integer.parseInt(dates[1])-1,Integer.parseInt(dates[0]));
        Date d=new Date(calendar.getTimeInMillis());
        java.sql.Date sqlDate=new java.sql.Date(d.getTime());
        PreparedStatement statement=connection.prepareStatement("Insert Into owner values (default, ?, ?)");
        statement.setString(1,name);
        statement.setDate(2, sqlDate);
        statement.executeUpdate();
    }
}
