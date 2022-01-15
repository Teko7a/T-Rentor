package teko7a.DAOs;

import teko7a.Models.Rented;
import teko7a.Models.Usr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: tekola (teko7a@github.io)
 * @create 2021/9/1
 */
public class RentedDAO {
   public RentedDAO() {
      super();
   }

   public int add(Connection con, Rented rented) throws Exception {
      String sql = "INSERT INTO t_rented VALUES(NULL,?,?,?,?,?,?)";
      PreparedStatement pstmt = con.prepareStatement(sql);
      set_6_data(pstmt, rented);
      return pstmt.executeUpdate();
   }

   public int remove(Connection con, Rented rented) throws Exception {
      String sql = "DELETE from t_rented WHERE id = '" + rented.getId() + "'";
      return con.prepareStatement(sql).executeUpdate();
   }

   public ResultSet list(Connection con, Usr usr) throws SQLException {
      String sql = "SELECT tc.id, tc.type, tc.brand, tc.seatNum, tc.license, tc.color, tr.stDate, tr.edDate, tr.dates, tr.cost " +
            "FROM t_rented tr, t_car tc WHERE tr.carID = tc.id AND usrID = '" + usr.getId() + "' AND edDate IS NOT NULL";
      return con.prepareStatement(sql).executeQuery();
   }

   public ResultSet countLines(Connection con, Usr usr) throws SQLException {
      String sql = "SELECT COUNT(1) FROM t_rented WHERE usrID = '" + usr.getId() + "'";
      return con.prepareStatement(sql).executeQuery();
   }

   public ResultSet list(Connection con) throws SQLException {
      String sql = "SELECT tu.id, tu.name, tc.id, tc.type, tc.brand, tc.seatNum, tc.license, tc.color, tr.stDate, tr.edDate, tr.dates, tr.cost " +
            "FROM t_rented tr, t_car tc, t_usr tu WHERE tr.carID = tc.id AND tr.usrID = tu.id " +
            "ORDER BY tr.edDate";
      return con.prepareStatement(sql).executeQuery();
   }

   public ResultSet listUnreturned(Connection con, Usr usr) throws SQLException {
      String sql = "SELECT tc.id, tc.type, tc.brand, tc.seatNum, tc.license, tc.color, tr.stDate, tr.edDate, tr.dates, tr.cost, tr.id, tr.usrID " +
            "FROM t_rented tr, t_car tc WHERE tr.carID = tc.id AND usrID = '" + usr.getId() + "' AND edDate IS NULL";
      return con.prepareStatement(sql).executeQuery();
   }

   public int update(Connection con, Rented rented) throws Exception {
      String sql = "UPDATE t_rented SET "
            + "carID = ?, usrID = ?, stDate = ?, edDate = ?, dates = ?, cost = ? "
            + "WHERE id = ?";
      PreparedStatement pstmt = con.prepareStatement(sql);
      set_6_data(pstmt, rented);
      pstmt.setInt(7, rented.getId());
      return pstmt.executeUpdate();
   }

   public boolean hasUnreturned(Connection con, Usr usr) throws SQLException {
      String sql = "SELECT * FROM t_rented WHERE usrID = '" + usr.getId() + "' AND edDate IS NULL";
      return con.prepareStatement(sql).executeQuery().next();
   }

   private void set_6_data(PreparedStatement pstmt, Rented rented) throws SQLException {
      pstmt.setInt(1, rented.getCarID());
      pstmt.setInt(2, rented.getUsrID());
      pstmt.setString(3, rented.getStDate());
      pstmt.setString(4, rented.getEdDate());
      pstmt.setInt(5, rented.getDates());
      pstmt.setInt(6, rented.getCost());
   }

}
