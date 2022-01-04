package teko7a.Utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/24
 */
@SuppressWarnings("ALL")
public class DataBaseUtil {

   /**
    * 获取数据库连接
    *
    * @return {@code Connection} 类
    * @throws Exception 连接中的异常
    * @author: tekola (teko7a@github.io)
    */
   public Connection getCon() throws Exception {
      String jdbcName = "com.mysql.cj.jdbc.Driver";
      // 动态加载 ( 反射 )
      Class.forName(jdbcName);
      String dbPassword = "NoTXNorC!@oo77";
      String dbUserName = "root";
      String dbUrl = "jdbc:mysql://localhost:3306/db_RC";
      return DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
   }

   /**
    * 关闭数据库连接
    *
    * @param con 要关闭的 {@code Connection}
    * @throws Exception 关闭时的异常
    * @author: tekola (teko7a@github.io)
    */
   public void closeCon(Connection con) throws Exception {
      if (con != null) con.close();
   }

   /**
    * 这是一个 junit 的测试单元， 可以模拟 Main 的效用
    * 注意如果 {@code 连接失败}，需要将 jdbc 中的 jar 包 buildPATH
    * IDEA 操作步骤：{@code File -> Project Structure -> Libraries -> '+'}
    *
    * @author: tekola (teko7a@github.io)
    */
   @Test public void Test() {
      DataBaseUtil dataBaseUtil = new DataBaseUtil();
      Connection con = null;
      try {
         con = dataBaseUtil.getCon();
         System.out.println("Connect Success");
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("Connect Failed!");
      } finally {
         try {
            dataBaseUtil.closeCon(con);
            System.out.println("Close Success");
         } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Close Failed!");
         }
      }
   }

}
