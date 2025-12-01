import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static DBConnection instance;

    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "agrop053jdbc";
    private Connection conn;
    private Statement st;

    private DBConnection() throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
        st = conn.createStatement();
        createDatabase();
        createTableUsers();
    };

    private void createDatabase() throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
        st.executeUpdate(sql);
        System.out.println("DB " + dbName + " connect!");
        // EFFETTUO LO USE DEL DB
        conn = DriverManager.getConnection(url+dbName, user, pass);
        // AGGIORNO LO STATEMENT
        st = conn.createStatement();
    }

    private void createTableUsers() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Users (" +
                "user_id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(40) NOT NULL," +
                "lastname VARCHAR(40) NOT NULL," +
                "age INT UNSIGNED NULL DEFAULT 18," +
                "city VARCHAR(50) NULL," +
                "fiscal_code CHAR(16) NOT NULL UNIQUE," +
                "email VARCHAR(40) NOT NULL UNIQUE" +
                ");";
        st.executeUpdate(sql);
        System.out.println("Table users created!");
    }

    // CRUD -> CREATE - READ - UPDATE - DELETE
    public void createUser(User user) throws SQLException {
//        String sql = "INSERT INTO users (name, lastname, age, city, fiscal_code, email)" +
//                " VALUES (" +
//                "'" + user.getName() + "', " +
//                "'"+ user.getLastname() + "', " +
//                ""+ user.getAge() +", " +
//                "'"+ user.getCity() +"', " +
//                "'"+ user.getFiscal_code() +"', " +
//                "'"+ user.getEmail() +"') ";
//        st.executeUpdate(sql);
        String sql = "INSERT INTO users (name, lastname, age, city, fiscal_code, email)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getLastname());
        ps.setInt(3, user.getAge());
        ps.setString(4, user.getCity());
        ps.setString(5, user.getFiscal_code());
        ps.setString(6, user.getEmail());
        ps.executeUpdate();
        System.out.println(user.getName() + "  " + user.getLastname() + " created!");

    };

    public User findUser(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = " + id;
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()) {
            int user_id = rs.getInt("user_id");
            String name = rs.getString("name");
            String lastname = rs.getString("lastname");
            int age = rs.getInt("age");
            String city = rs.getString("city");
            String fiscal_code = rs.getString("fiscal_code");
            String email = rs.getString("email");

            User u = new User(user_id, name, lastname, age, city, fiscal_code, email);
            return u;
        } else {
            return null;
        }
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET " +
                "name=?, lastname=?, age=?, city=?," +
                "fiscal_code=?, email=?" +
                "WHERE user_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getLastname());
        ps.setInt(3, user.getAge());
        ps.setString(4, user.getCity());
        ps.setString(5, user.getFiscal_code());
        ps.setString(6, user.getEmail());
        ps.setLong(7, user.getUser_id());
        ps.executeUpdate();
        System.out.println(user.getName() + " " + user.getLastname() + " modified!");
    };

    public void removeUser(User user) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, user.getUser_id());
        ps.executeUpdate();
        System.out.println(user.getName() + " " + user.getLastname() + " deleted!");
    };

    public List<User> findAllUsers() throws SQLException {
        String sql = "SELECT * FROM users";
        ResultSet rs = st.executeQuery(sql);
        List<User> userList = new ArrayList<>();
        while(rs.next()) {
            int user_id = rs.getInt("user_id");
            String name = rs.getString("name");
            String lastname = rs.getString("lastname");
            int age = rs.getInt("age");
            String city = rs.getString("city");
            String fiscal_code = rs.getString("fiscal_code");
            String email = rs.getString("email");

            User u = new User(user_id, name, lastname, age, city, fiscal_code, email);
            userList.add(u);
        }
        return userList;
    };

    public static DBConnection getInstance() throws SQLException {
        if(instance == null) {
            instance = new DBConnection();
        }
        return instance;
    };
}
