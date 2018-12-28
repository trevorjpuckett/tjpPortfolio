package com.tjp;

import java.sql.*;

public class DatabaseConnection {

    private static String sqlUsername;
    private static String sqlPassword;

    private static String connectionString;
    private static Connection connection;
    private static Statement command;
    private static ResultSet data;

    public DatabaseConnection(){
        sqlUsername = "root";
        sqlPassword = "genericPassword";
        connectionString = "jdbc:mysql://localhost:3306/creekbank";
        try {
            connection = DriverManager.getConnection(connectionString, sqlUsername, sqlPassword);
            command = connection.createStatement();
        }catch(SQLException sqlE) {
           sqlE.printStackTrace();
        }
    }

    public boolean verifyUsername(String username, String columnName, String tableName) {
       boolean inTable = false;
       boolean moreLines = true;
       String print = "username not found.";
        try {
           data = command.executeQuery("SELECT " + columnName + " FROM " + tableName + ";");
           while(moreLines && !inTable) {
               if(data.next()){
                  //System.out.println(data.getString("username"));
               }else {
                  // System.out.println("No more lines.");
                   moreLines = false;
               }
               String test = data.getString("username");
               if(test.equals(username)){
                   inTable = true;
                   print = "username has been verified.";
               }
           }
       } catch(SQLException sqlE) {
          // sqlE.printStackTrace();
       }
       System.out.println(print);
       return inTable;
    }

    public boolean verifyPassword(String password, String username){
        boolean isPassword = false;

        try{
            data = command.executeQuery("SELECT user_password FROM accounts WHERE username = '"+username+"';");
            if(data.next() && password.equals(data.getString("user_password"))){
                isPassword = true;
            }
        }catch(SQLException sqlE){
            //sqlE.printStackTrace();
        }
        return isPassword;
    }

   public String getAuthorization(String username){
       String authorization = "";
        //TODO: TJP create a method to get the autorization level of the user signing in.
       try{
           data = command.executeQuery(
                   "SELECT username, admin_id FROM accounts ac JOIN admins ad ON ac.account_id = ad.account_id WHERE username = '"+username+"';"
                    );
           if(data.next()){
               if(data.getString("admin_id").toLowerCase().charAt(0) == 'a'){
                   System.out.println(data.getString("admin_id"));
                   authorization = "admin";
               }
           } else {
               data = command.executeQuery(
                       "SELECT username, teacher_id FROM accounts ac JOIN teachers tc ON ac.account_id = tc.account_id WHERE username = '"+username+"';"
                        );
               if(data.next()){
                   if(data.getString("teacher_id").toLowerCase().charAt(0) == 't'){
                       System.out.println(data.getString("teacher_id"));
                       authorization = "teacher";
                   }
               } else {
                   data = command.executeQuery(
                           "SELECT username, student_id FROM accounts ac JOIN students st ON ac.account_id = st.account_id WHERE username = '"+username+"';"
                            );
                   if(data.next()){
                       if(data.getString("student_id").toLowerCase().charAt(0) == 's'){
                           System.out.println(data.getString("student_id"));
                           authorization = "student";
                       }
                   }
               }
           }
       }catch(SQLException sqlE){
           //sqlE.printStackTrace();
       }

       return authorization;
   }

}
