package Database;

import Configuration.Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    private static Connect connect = null;
    private static String url = Config.db_url;
    private static String username = Config.user_name;
    private static String password = Config.password;
    private Connect(){}

    public static Connection getConnection(){
        Connection connection =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connect successfully!");
        } catch (Exception e) {
            System.out.println("connect failure!");
            e.printStackTrace();
        } return connection;
    }
    public static Connect getInstance(){
        return connect == null? new Connect():connect;
    }

}
