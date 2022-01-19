package teko7a.Models;

/**
 * 管理员实体类
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/30
 * <p>
 * +----------+-------------+------+-----+---------+----------------+
 * | Field    | Type        | Null | Key | Default | Extra          |
 * +----------+-------------+------+-----+---------+----------------+
 * | id       | int(11)     | NO   | PRI | NULL    | auto_increment |
 * | name     | varchar(30) | YES  |     | NULL    |                |
 * | password | varchar(20) | YES  |     | NULL    |                |
 * | realName | varchar(20) | YES  |     | NULL    |                |
 * | idc      | varchar(18) | YES  |     | NULL    |                |
 * | tel      | varchar(11) | YES  |     | NULL    |                |
 * +----------+-------------+------+-----+---------+----------------+
 */
public class Admin extends Person {
   public final String className = "admin";

   public Admin() {
      super();
   }

   public Admin(String name, String password) {
      this.setName(name);
      this.setPassword(password);
   }

   public Admin(int id, String name, String password, String realName, String idc, String tel) {
      super(id, name, password, realName, idc, tel);
   }

   // ==== Override ====
   @Override
   public String toString() {
      return "Admin" + super.toString();
   }
}
