import java.sql.*; // DB���� �о���� Ŭ����
class JDBCExample3 {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: java JDBCExample3 ��ǰ��");
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
            System.out.println("��ǰ�ڵ� ��ǰ�� \t\t���� ������");
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




