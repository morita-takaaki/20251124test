import java.sql.*;

public class SQLiteTest {
  public static void main(String[] args) {
    try {
      // JDBCドライバをロード
      Class.forName("org.sqlite.JDBC");

      // SQLiteデータベースに接続
      String url = "jdbc:sqlite:student.db";
      Connection conn = DriverManager.getConnection(url);
      System.out.println("SQLite接続成功！");

      // クエリ実行
      String sql = "SELECT student_id, name, email FROM students";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      System.out.println("学籍番号 | 名前 | メールアドレス");
      System.out.println("----------------------------------");

      while (rs.next()) {
        System.out.println(
          rs.getString("student_id") + " | " +
          rs.getString("name") + " | " +
          rs.getString("email")
        );
      }

      rs.close();
      stmt.close();
      conn.close();

    } catch (Exception e) {
      System.out.println("エラー: " + e.getMessage());
    }
  }
}
