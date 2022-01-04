package teko7a.Models;

/**
 * 用户实体类
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
public class Usr extends Person {
   public final String className = "usr";

   public Usr() {
      super();
   }

   public Usr(String name, String password) {
      this.setName(name);
      this.setPassword(password);
   }

   public Usr(int id, String name, String password, String realName, String idc, String tel) {
      super(id, name, password, realName, idc, tel);
   }

   public Usr(String name, String password, String rName, String idc, String tel) {
      this.setName(name);
      this.setPassword(password);
      this.setRealName(rName);
      this.setIdc(idc);
      this.setTel(tel);
   }

   // ==== Override ====
   @Override public String toString() {
      return "Usr" + super.toString();
   }
}
