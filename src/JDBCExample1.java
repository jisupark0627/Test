import java.sql.*;
class JDBCExample1 {
    public static void main(String args[]) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb",
                    "root", "wltn1242");
            System.out.println("�����ͺ��̽��� �����߽��ϴ�.");
            conn.close();
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}
