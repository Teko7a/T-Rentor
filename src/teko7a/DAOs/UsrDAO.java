package teko7a.DAOs;

import teko7a.Models.Usr;
import teko7a.Utils.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/30
 */
public class UsrDAO {
    teko7a.DAOs.RentedDAO rentedDao = new teko7a.DAOs.RentedDAO();

    /**
     * 用户登录验证
     *
     * @param con  连接
     * @param user 登入用户
     * @return 有效用户， 无效则返回 null
     * @throws Exception 中途可能出现的异常
     * @author: tekola (teko7a@github.io)
     */
    public Usr login(Connection con, Usr user) throws Exception {
        Usr resultUser = null;
        String sql = "SELECT * FROM t_usr WHERE name = ? AND password = ?";
        // 使用预处理的方法以增强代码可读性。
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getPassword());

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            resultUser = new Usr();
            resultUser.setId(rs.getInt("id"));
            resultUser.setName(rs.getString("name"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }

    /**
     * 判断是否出现重复注册
     *
     * @param con     链接
     * @param usrName 要检查的用户名
     * @return 没有重复用户名出现
     * @throws Exception 异常
     */
    public boolean hasTwoSameNameUsr(Connection con, String usrName) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM t_usr WHERE name = '" + usrName + "'");
        return pstmt.executeQuery().next();
    }

    /**
     * 用户注册类
     *
     * @param con  连接
     * @param user 用户
     * @return 0 / 1 --> 0 表示注册失败， 1 表示注册成功
     * @throws Exception 可能出现的异常
     */
    public int register(Connection con, Usr user) throws Exception {
        String sql = "INSERT INTO t_usr VALUES(NULL,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getRealName());
        pstmt.setString(4, user.getIdc());
        pstmt.setString(5, user.getTel());
        return pstmt.executeUpdate();
    }

    /**
     * 根据用户名查询用户具体信息模块
     *
     * @param con     链接
     * @param usrName 用户名， 注册时保证其唯一， 因此查询是安全的。
     * @return 该用户的信息
     * @throws Exception 异常
     */
    public Usr detail(Connection con, String usrName) throws Exception {
        String sql = "SELECT * FROM t_usr WHERE name = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, usrName);
        ResultSet rs = pstmt.executeQuery();

        boolean hasNext = rs.next();
        assert hasNext;

        int id = rs.getInt("id");
        String userPassword = rs.getString("password");
        String userRealName = rs.getString("realName");
        String userIDCN = rs.getString("idc");
        String userTel = rs.getString("tel");

        return new Usr(id, usrName, userPassword, userRealName, userIDCN, userTel);
    }

    /**
     * 根据用户 id 查询用户具体信息模块
     *
     * @param con   链接
     * @param usrID 用户 id 唯一，查询是安全的。
     * @return 该用户的信息
     * @throws Exception 异常
     */
    public Usr detail(Connection con, int usrID) throws Exception {
        String sql = "SELECT * FROM t_usr WHERE id = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, usrID);
        ResultSet rs = pstmt.executeQuery();

        boolean hasNext = rs.next();
        assert hasNext;

        String usrName = rs.getString("name");
        String userPassword = rs.getString("password");
        String userRealName = rs.getString("realName");
        String userIDCN = rs.getString("idc");
        String userTel = rs.getString("tel");

        return new Usr(usrID, usrName, userPassword, userRealName, userIDCN, userTel);
    }

    public ResultSet detail(Connection con, Usr usr) throws Exception {
        assert usr != null;
        StringBuilder sb = new StringBuilder("SELECT * FROM t_usr");
        if (usr.getId() != -1) {
            sb.append(" AND id = '").append(usr.getId()).append("'");
        }
        if (StringUtil.isNotEmpty(usr.getName())) {
            sb.append(" AND name = '").append(usr.getName()).append("'");
        }
        if (StringUtil.isNotEmpty(usr.getPassword())) {
            sb.append(" AND password = '").append(usr.getPassword()).append("'");
        }
        if (StringUtil.isNotEmpty(usr.getRealName())) {
            sb.append(" AND realName = '").append(usr.getRealName()).append("'");
        }
        if (StringUtil.isNotEmpty(usr.getIdc())) {
            sb.append(" AND idc = '").append(usr.getIdc()).append("'");
        }
        if (StringUtil.isNotEmpty(usr.getTel())) {
            sb.append(" AND tel = '").append(usr.getTel()).append("'");
        }

        return con.prepareStatement(sb.toString().replaceFirst("AND", "WHERE")).executeQuery();
    }

    /**
     * 删除用户
     *
     * @param con 连接
     * @param usr 要删除的用户
     * @return 改变记录数
     * @throws SQLException 数据库异常
     */
    public int remove(Connection con, Usr usr) throws SQLException {
        con.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;").executeQuery();
        String sql = "DELETE FROM t_usr WHERE id = '" + usr.getId() + "'";
        con.prepareStatement("SET FOREIGN_KEY_CHECKS = 1;").executeQuery();
        return con.prepareStatement(sql).executeUpdate();
    }

    public ResultSet list(Connection con, Usr usr) throws SQLException {
        String sql = "SELECT id, name, password, realName, idc, tel " +
                "FROM t_usr";
        PreparedStatement pstmt = con.prepareStatement(sql);
        return pstmt.executeQuery();
    }

    public int modify(Connection con, Usr usr) throws SQLException {
        String sql = "UPDATE t_usr SET "
                + "name = ?, password = ?, realName = ?, idc = ?, tel = ?"
                + "WHERE id = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        set_5_data(pstmt, usr);
        pstmt.setInt(6, usr.getId());
        return pstmt.executeUpdate();
    }

    private void set_5_data(PreparedStatement pstmt, Usr usr) throws SQLException {
        pstmt.setString(1, usr.getName());
        pstmt.setString(2, usr.getPassword());
        pstmt.setString(3, usr.getRealName());
        pstmt.setString(4, usr.getIdc());
        pstmt.setString(5, usr.getTel());
    }
}
