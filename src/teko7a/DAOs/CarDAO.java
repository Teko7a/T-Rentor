package teko7a.DAOs;

import com.sun.tools.javac.Main;
import teko7a.Models.Admin;
import teko7a.Models.Car;
import teko7a.Models.Maintain;
import teko7a.Models.Usr;
import teko7a.Utils.DateUtil;
import teko7a.Utils.OrdersEnum;
import teko7a.Utils.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: tekola (teko7a@github.io)
 * @create 2021/9/1
 */
public class CarDAO {
   MaintainDAO maintainDao = new MaintainDAO();

   public CarDAO() {
      super();
   }

   public int add(Connection con, Car car) throws Exception {
      String sql = "INSERT INTO t_car VALUES(NULL,?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement pstmt = con.prepareStatement(sql);
      set_10_data(pstmt, car);
      return pstmt.executeUpdate();
   }

   /**
    * 用于在数据库中进行查询。
    *
    * @param con  连接
    * @param car  查询项
    * @param low  最低价格
    * @param high 最高价格
    * @return 查到的数据项_
    * @throws SQLException 数据库异常
    */
   public ResultSet query(Connection con, Car car, int low, int high) throws SQLException {
      assert car != null;
      StringBuilder sb = new StringBuilder("SELECT * FROM t_car");
      if (StringUtil.isNotEmpty(car.getType()))
         sb.append(" AND type = '").append(car.getType()).append("'");
      if (StringUtil.isNotEmpty(car.getLicense()))
         sb.append(" AND license = '").append(car.getLicense()).append("'");
      if (StringUtil.isNotEmpty(car.getSize()))
         sb.append(" AND size = '").append(car.getSize()).append("'");
      if (StringUtil.isNotEmpty(car.getTons()))
         sb.append(" AND tons = '").append(car.getTons()).append("'");
      if (StringUtil.isNotEmpty(car.getColor()))
         sb.append(" AND color = '").append(car.getColor()).append("'");
      if (car.getSeatNum() != -1)
         sb.append(" AND seatNum = '").append(car.getSeatNum()).append("'");

      sb.append(" AND isAuto = '").append(car.getIsAuto() == 1 ? '1' : '0').append("'");
      sb.append(" AND cost BETWEEN ").append(low).append(" AND ").append(high);
      sb.append(" AND status = '").append(car.getStatus()).append("'");

      // TODO : 模糊查询失败 (08-26-21)
//       System.out.println(sb.toString().replaceFirst("AND", "WHERE"));
      return con.prepareStatement(sb.toString().replaceFirst("AND", "WHERE")).executeQuery();
   }

   public ResultSet query(Connection con, Car car, OrdersEnum order) throws SQLException {
      if (order != OrdersEnum.QUERY) return null;
      assert car != null;
      StringBuilder sb = new StringBuilder("SELECT * FROM t_car");

      if (car.getId() != -1) sb.append(" AND id = ").append(car.getId());
      if (car.getSeatNum() != -1) sb.append(" AND seatNum = ").append(car.getSeatNum());
      if (car.getIsAuto() != -1) sb.append(" AND isAuto = ").append(car.getIsAuto());
      if (car.getCost() != -1) sb.append(" AND cost = ").append(car.getCost());
      if (car.getStatus() != -2) sb.append(" AND status = ").append(car.getStatus());

      if (StringUtil.isNotEmpty( car.getType()) ) sb.append(" AND type = '").append(car.getType()).append("'");
      if (StringUtil.isNotEmpty( car.getLicense()) ) sb.append(" AND license = '").append(car.getLicense()).append("'");
      if (StringUtil.isNotEmpty( car.getBrand()) ) sb.append(" AND brand = '").append(car.getBrand()).append("'");
      if (StringUtil.isNotEmpty( car.getSize()) ) sb.append(" AND size = '").append(car.getSize()).append("'");
      if (StringUtil.isNotEmpty( car.getTons()) ) sb.append(" AND tons = '").append(car.getTons()).append("'");
      if (StringUtil.isNotEmpty( car.getColor()) ) sb.append(" AND color = '").append(car.getColor()).append("'");
//        System.out.println(sb.toString().replaceFirst("AND", "WHERE"));
      return con.prepareStatement(sb.toString().replaceFirst("AND", "WHERE")).executeQuery();
   }

   /**
    * list 方法， 作用是得到表中所有「可租的车」的数据条
    *
    * @param con 连接
    * @param car 实体
    * @return 所有的数据， 在表中可以使用 {@code Vector<Object> 接受}。
    * @throws Exception 可能出现的异常。
    */
   public ResultSet list(Connection con, Car car) throws Exception {
      String sql = "SELECT * FROM t_car WHERE status = '1'";
      return con.prepareStatement(sql).executeQuery();
   }

   public ResultSet list_all(Connection con, Car car) throws Exception {
      String sql = "SELECT * FROM t_car";
      return con.prepareStatement(sql).executeQuery();
   }

   public int remove(Connection con, Car car) throws Exception {
      con.prepareStatement("SET FOREIGN_KEY_CHECKS = 0").executeQuery();
      String sql = "DELETE FROM t_car WHERE id = '" + car.getId() + "'";
      con.prepareStatement("SET FOREIGN_KEY_CHECKS = 1").executeQuery();
      return con.prepareStatement(sql).executeUpdate();
   }

   public int update(Connection con, Car car, Admin admin) throws Exception {
      this.update(con, car);
      Maintain maintain = new Maintain(-1, car.getId(), admin.getId(), null, DateUtil.getToday(), null, 0);
      return maintainDao.fix(con, maintain);
   }

   public int update(Connection con, Car car) throws Exception {
      String sql = "UPDATE t_car SET "
            + "type = ?, license = ?, brand = ?, size = ?, seatNum = ?, "
            + "isAuto = ?, tons = ?, color = ?, cost = ?, status = ? "
            + "WHERE id = ?";
      PreparedStatement pstmt = con.prepareStatement(sql);
      set_10_data(pstmt, car);
      pstmt.setInt(11, car.getId());
      return pstmt.executeUpdate();
   }

   public Car detail(Connection con, int carID) throws Exception {
      String sql = "SELECT * FROM t_car WHERE id = ?";
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, carID);
      ResultSet rs = pstmt.executeQuery();

      Car car = null;
      while (rs.next()) {
         int id = rs.getInt("id");
         String type = rs.getString("type");
         String license = rs.getString("license");
         String brand = rs.getString("brand");
         String size = rs.getString("size");
         int seatNum = rs.getInt("seatNum");
         int isAuto = rs.getInt("isAuto");
         String tons = rs.getString("tons");
         String color = rs.getString("color");
         int cost = rs.getInt("cost");
         int status = rs.getInt("status");
         car = new Car(id, type, license, brand, size, seatNum, isAuto, tons, color, cost, status);
      }
      return car;
   }

   private void set_10_data(PreparedStatement pstmt, Car car) throws SQLException {
      pstmt.setString(1, car.getType());
      pstmt.setString(2, car.getLicense());
      pstmt.setString(3, car.getBrand());
      pstmt.setString(4, car.getSize());
      pstmt.setInt(5, car.getSeatNum());
      pstmt.setInt(6, car.getIsAuto());
      pstmt.setString(7, car.getTons());
      pstmt.setString(8, car.getColor());
      pstmt.setInt(9, car.getCost());
      pstmt.setInt(10, car.getStatus());
   }
}
