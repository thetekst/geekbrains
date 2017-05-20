import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 5/17/17
 */
public class Task2 {

    private static Connection conn;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    private static Properties prop = new Properties();
    private static boolean isContinue = true;

    public static void main(String[] args) {

        try {
            connect();
            dropTableEx();
            createTableEx();
            batchExecutionEx();

            do {
                System.out.println("Your query:");

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = br.readLine();

                if (line.matches("^/ценатовар\\d+$")) {
                    String digit = line.replaceAll("^/цена", "");
                    selectEx(digit);
                } else if (line.matches("^/сменитьцену\\sтовар\\d+\\s\\d+$")) {

                    String[] array = line.split(" ");

                    if (3 == array.length) {
                        String title = array[1];
                        int newCost = Integer.parseInt(array[2]);

                        updateCost(title, newCost);
                    }
                } else if (line.matches("^/товарыпоцене\\d+\\s\\d+$")) {

                    String[] array = line.split(" ");

                    if (2 == array.length) {
                        int from = Integer.parseInt(array[0].replaceAll("[^0-9]", ""));
                        int to = Integer.parseInt(array[1]);
                        selectPriceRange(from, to);
                    }
                }
                if ("q".equals(line)) {
                    isContinue = false;
                }

            } while (isContinue);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void connect() throws Exception {
        try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "/java3-task2/src/main/resources/config.properties")) {
            prop.load(input);

            Class.forName(prop.getProperty("jdbc-driver"));
            conn = DriverManager.getConnection(prop.getProperty("jdbc-url"));
            stmt = conn.createStatement();
        }
    }

    private static void dropTableEx() throws SQLException {
        stmt.execute("DROP TABLE IF EXISTS store");
    }

    private static void createTableEx() throws SQLException {

        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS store (\n");
        sb.append("                                id       INTEGER     PRIMARY KEY AUTOINCREMENT,\n");
        sb.append("                                prodid   INTEGER     NOT NULL UNIQUE,\n");
        sb.append("                                title    TEXT        NOT NULL,\n");
        sb.append("                                cost     INTEGER\n");
        sb.append(");");

        stmt.execute(sb.toString());
    }

    private static void batchExecutionEx() throws SQLException {
        pstmt = conn.prepareStatement("INSERT INTO store (prodid, title, cost) VALUES (?, ?, ?);");

        conn.setAutoCommit(false);
        int index;

        for (int i = 0; i < 10000; i++) {
            index = i + 1;
            pstmt.setInt(1, index);
            pstmt.setString(2, "товар" + index);
            pstmt.setInt(3, index * 10);
            pstmt.addBatch();
        }

        pstmt.executeBatch();
        conn.commit();

        conn.setAutoCommit(true);
    }

    private static void selectEx(String title) throws SQLException {

        String selectSQL = "SELECT * FROM store WHERE title = ?";
        pstmt = conn.prepareStatement(selectSQL);
        pstmt.setString(1, title);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println(rs.getInt(1)
                    + " " + rs.getInt(2)
                    + " " + rs.getString("title")
                    + " " + rs.getInt(4));
        } else {
            System.out.println("Такого товара нет");
        }
    }

    private static void updateCost(String title, int newCost) throws SQLException {
        String query = "UPDATE store SET cost = ? WHERE title = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, newCost);
        pstmt.setString(2, title);
        pstmt.executeUpdate();
    }

    private static void selectPriceRange(int from, int to) throws SQLException {

        String selectSQL = "SELECT * FROM store WHERE cost >= ? AND cost <= ?";
        pstmt = conn.prepareStatement(selectSQL);
        pstmt.setInt(1, from);
        pstmt.setInt(2, to);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt(1)
                    + " " + rs.getInt(2)
                    + " " + rs.getString("title")
                    + " " + rs.getInt(4));
        }
    }

    private static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
