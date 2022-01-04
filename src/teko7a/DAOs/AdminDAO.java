package teko7a.DAOs;

import teko7a.Models.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/30
 */
public class AdminDAO {
   /**
    * 管理员登录验证
    *
    * @param con   连接
    * @param admin 登入用户
    * @return 有效用户， 无效则返回 null
    * @throws Exception 中途可能出现的异常
    * @author: tekola (teko7a@github.io)
    */
   public Admin login(Connection con, Admin admin) throws Exception {
      Admin resultAdmin = null;
      String sql = "SELECT * FROM t_admin WHERE name = ? AND password = ?";
      // 使用预处理的方法以增强代码可读性。
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, admin.getName());
      pstmt.setString(2, admin.getPassword());

      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
         resultAdmin = new Admin();
         resultAdmin.setId(rs.getInt("id"));
         resultAdmin.setName(rs.getString("name"));
         resultAdmin.setPassword(rs.getString("password"));
      }
      return resultAdmin;
   }

   /**
    * 根据用户名查询管理员具体信息模块
    *
    * @param con       链接
    * @param adminName 管理员名， 注册时保证其唯一， 因此查询是安全的。
    * @return 该用户的信息
    * @throws Exception 异常
    */
   public Admin detail(Connection con, String adminName) throws Exception {
      String sql = "SELECT * FROM t_admin WHERE name = ?";
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setString(1, adminName);
      ResultSet rs = pstmt.executeQuery();

      boolean hasNext = rs.next();
      assert hasNext;

      int id = rs.getInt("id");
      String userPassword = rs.getString("password");
      String userRealName = rs.getString("realName");
      String userIDCN = rs.getString("idc");
      String userTel = rs.getString("tel");

      return new Admin(id, adminName, userPassword, userRealName, userIDCN, userTel);
   }
}
