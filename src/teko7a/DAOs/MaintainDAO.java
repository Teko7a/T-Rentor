package teko7a.DAOs;

import com.sun.tools.javac.Main;
import teko7a.Models.Car;
import teko7a.Models.Maintain;
import teko7a.Utils.OrdersEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author: tekola (teko7a@github.io)
 * @create 2021/9/1
 */
public class MaintainDAO {
   public int fix(Connection con, Maintain maintain) throws SQLException {
      String sql = "INSERT INTO t_maintain VALUES(NULL,?,?,?,?,?,?)";
      PreparedStatement pstmt = con.prepareStatement(sql);
      set_6_data(pstmt, maintain);
      return pstmt.executeUpdate();
   }

   public int update(Connection con, Maintain maintain) throws Exception {
      String sql = "UPDATE t_maintain SET "
            + "errorDesc = ?, edDate = ?, cost = ? "
            + "WHERE id = ?";
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, maintain.getErrorDesc());
      pstmt.setString(2, maintain.getEdDate());
      pstmt.setInt(3, maintain.getCost());
      pstmt.setInt(4, maintain.getId());
      return pstmt.executeUpdate();
   }

   public ResultSet list(Connection con, OrdersEnum order) throws SQLException {
      StringBuilder sql = new StringBuilder("SELECT * FROM t_maintain");
      if (order == OrdersEnum.ADD) sql.append(" WHERE edDate IS NULL");
      return con.prepareStatement(sql.toString()).executeQuery();
   }

   private void set_6_data(PreparedStatement pstmt, Maintain maintain) throws SQLException {
      pstmt.setInt(1, maintain.getCarID());
      pstmt.setInt(2, maintain.getAdminID());
      pstmt.setString(3, maintain.getErrorDesc());
      pstmt.setString(4, maintain.getStDate());
      pstmt.setString(5, maintain.getEdDate());
      pstmt.setInt(6, maintain.getCost());
   }

   public String[] cnt(Connection con, Car car) throws SQLException {
      String[] ans = new String[2];
      String sql1 = "SELECT COUNT(1) FROM t_maintain WHERE carID = '" + car.getId() + "'";
      PreparedStatement pstmt1 = con.prepareStatement(sql1);
      ResultSet rs1 = pstmt1.executeQuery();
      while (rs1.next()) ans[0] = rs1.getString("COUNT(1)");

      String sql2 = "SELECT COUNT(1) FROM t_rented WHERE carID = '" + car.getId() + "'";
      PreparedStatement pstmt2 = con.prepareStatement(sql2);
      ResultSet rs2 = pstmt2.executeQuery();
      while (rs2.next()) ans[1] = rs2.getString("COUNT(1)");

      return ans;
   }

   /**
    * 用于填充四个信息的 DAO <br>
    * {@code res[0] --> totRentedCarsJTF } <br>
    * {@code res[1] --> totFixedCarsNumJTF } <br>
    * {@code res[2] --> totCostJTF } <br>
    * {@code res[3] --> totProfitJTF } <br>
    *
    * @param con 连接
    * @param st  起始日期, 默认为 1970 - 01 - 01
    * @param ed  终止日期, 默认为 DateUtil.getToday()
    * @return 四个信息, 分别表示
    */
   public int[] calcProfit(Connection con, String st, String ed) throws SQLException {
      int[] res = new int[4];
      ResultSet rs_1 = con.prepareStatement("SELECT COUNT(1) FROM t_rented").executeQuery();
      while (rs_1.next()) res[0] = rs_1.getInt("COUNT(1)");
      ResultSet rs_2 = con.prepareStatement("SELECT COUNT(1) FROM t_maintain").executeQuery();
      while (rs_2.next()) res[1] = rs_2.getInt("COUNT(1)");
      int res1 = 0, res2 = 0;

      ResultSet rs1 = con.prepareStatement("SELECT cost FROM t_maintain WHERE stDate >= '" + st + "' AND edDate IS NOT NULL AND edDate <= '" + ed + "'").executeQuery();
      while (rs1.next())
         res1 += rs1.getInt("cost");
      res[2] = res1;

      ResultSet rs2 = con.prepareStatement("SELECT cost FROM t_rented WHERE stDate >= '" + st + "' AND edDate IS NOT NULL AND edDate <= '" + ed + "'").executeQuery();
      while (rs2.next()) res2 += rs2.getInt("cost");
      res[3] = res2 - res1;

      // System.out.println(Arrays.toString(res));

      return res;
   }
}
