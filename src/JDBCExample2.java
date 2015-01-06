import java.sql.*;
class JDBCExample2 {
    public static void main(String args[]) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/malldb", "root", "wltn1242");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                "select code, name, price, maker from goodsinfo;");
            System.out.println("상품코드 상품명 \t\t가격 제조사");
            System.out.println(
                "----------------------------------------------");
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String maker = rs.getString("maker");
                System.out.printf("%8s %s \t%12d %s%n", code, 
                    toUnicode(name), price, toUnicode(maker));
            }
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스를 찾을 수 없습니다." + 
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
    private static String toUnicode(String str) {    
        try {
            byte[] b = str.getBytes("ISO-8859-1");
            return new String(b);
        }
        catch (java.io.UnsupportedEncodingException uee) {
            System.out.println(uee.getMessage());
            return null;
        }
    }
}


