package org.example;

import java.sql.*;
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
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("Insert Into owner values (default, ?, ?)");
            statement.setString(1, name);
            statement.setDate(2, sqlDate);
            statement.executeUpdate();
            connection.commit();
        }
        catch (Exception e){
            connection.rollback();
        }
    }

    public static int deleteOwner() throws SQLException{
        Connection connection=ConnectionToDB.getConnection();
        Statement statement= connection.createStatement();
        Scanner scanner =new Scanner(System.in);
        String columnName=null;
        boolean flag=false;
        while (!flag){
            System.out.println("Введите наименование параметра, который вы ходите удалить: ");
            columnName=scanner.nextLine().toLowerCase();
            ResultSet rs = statement.executeQuery("SELECT * FROM owner");
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i=1; i<=rsmd.getColumnCount(); i++){
                if (columnName.equals(rsmd.getColumnName(i).toLowerCase())){
                    flag=true;
                }
            }
        }
        while (true) {
            System.out.println("Введите значение параметра для удаления");
            String value = scanner.nextLine();
            try {
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement("delete from owner where " + columnName + " = ?");
                preparedStatement.setString(1, value);
                int changes = preparedStatement.executeUpdate();
                if (changes != 0) {
                    connection.commit();
                    return changes;
                }
            }
            catch (Exception e){
                connection.rollback();
            }
        }
    }

}
