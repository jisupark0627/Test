import java.sql.*; // DB에서 읽어오는 클래스
class JDBCExample3 {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: java JDBCExample3 상품명");
            return;
        }
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/malldb", "root", "wltn1242");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                "select code, name, price, maker " +
                "from goodsinfo where name='" +
                args[0] + "';");
            System.out.println("상품코드 상품명 \t\t가격 제조사");
            System.out.println(
                "----------------------------------------------");
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String maker = rs.getString("maker");
                System.out.printf("%8s %s \t%12d %s%n", code, 
                    name, price, maker);
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
//    private static String toUnicode(String str) {  
//        try {
//            byte[] b = str.getBytes("ISO-8859-1");
//            return new String(b);
//        }
//        catch (java.io.UnsupportedEncodingException uee) {
//            System.out.println(uee.getMessage());
//            return null;
//        }
//    }
//    private static String toLatin1(String str) {  
//        try {
//            byte[] b = str.getBytes();
//            return new String(b, "ISO-8859-1");
//        }
//        catch (java.io.UnsupportedEncodingException uee) {
//            System.out.println(uee.getMessage());
//            return null;
//        }
//    }
}




