import java.sql.*;		//DB�� ������ �Է�
class JDBCExample4 {
    public static void main(String args[]) {
        if (args.length != 4) {
            System.out.println(
                "Usage: java JDBCExample4 ��ǰ�ڵ� ��ǰ�� ���� ������");
            return;
        }
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/malldb", "root", "wltn1242");
            stmt = conn.createStatement();
            int rowNum = stmt.executeUpdate(
                "insert into goodsinfo (code, name, price, maker) values('" +
                    toLatin1(args[0]) + "', '" + 
                    toLatin1(args[1]) + "', " + 
                    toLatin1(args[2]) + ", '" +  
                    toLatin1(args[3]) + "');");
            System.out.println(rowNum + "���� �߰��Ǿ����ϴ�.");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." +
                cnfe.getMessage());
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        finally {
            try {
                stmt.close();
            }
            catch (Exception ignored) {
            }
            try {
                conn.close();
            }
            catch (Exception ignored) {
            }
        }
    }
    private static String toLatin1(String str) {    
        try {
            byte[] b = str.getBytes();
            return new String(b, "ISO-8859-1");
        }
        catch (java.io.UnsupportedEncodingException uee) {
            System.out.println(uee.getMessage());
            return null;
        }
    }
}

