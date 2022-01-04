package teko7a.Models;

/**
 * 维修信息条实体类
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/30
 * <p>
 * +-----------+-------------+------+-----+---------+----------------+
 * | Field     | Type        | Null | Key | Default | Extra          |
 * +-----------+-------------+------+-----+---------+----------------+
 * | id        | int(11)     | NO   | PRI | NULL    | auto_increment |
 * | carID     | int(11)     | YES  | MUL | NULL    |                |
 * | adminID   | int(11)     | YES  | MUL | NULL    |                |
 * | errorDesc | varchar(50) | YES  |     | NULL    |                |
 * | stDate    | varchar(20) | YES  |     | NULL    |                |
 * | edDate    | varchar(20) | YES  |     | NULL    |                |
 * | cost      | int(11)     | YES  |     | NULL    |                |
 * +-----------+-------------+------+-----+---------+----------------+
 */
public class Maintain {
   // ==== Data ====
   private int id;
   private int carID;
   private int adminID;
   private String errorDesc;
   private String stDate;
   private String edDate;
   private int cost;

   // ==== Constructors ====

   public Maintain() {
      super();
   }

   public Maintain(int id, int carID, int adminID, String errorDesc, String stDate, String edDate, int cost) {
      this.id = id;
      this.carID = carID;
      this.adminID = adminID;
      this.errorDesc = errorDesc;
      this.stDate = stDate;
      this.edDate = edDate;
      this.cost = cost;
   }
   // ==== Getter and Setter ====

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getCarID() {
      return carID;
   }

   public void setCarID(int carID) {
      this.carID = carID;
   }

   public int getAdminID() {
      return adminID;
   }

   public void setAdminID(int adminID) {
      this.adminID = adminID;
   }

   public String getErrorDesc() {
      return errorDesc;
   }

   public void setErrorDesc(String errorDesc) {
      this.errorDesc = errorDesc;
   }

   public String getStDate() {
      return stDate;
   }

   public void setStDate(String stDate) {
      this.stDate = stDate;
   }

   public String getEdDate() {
      return edDate;
   }

   public void setEdDate(String edDate) {
      this.edDate = edDate;
   }

   public int getCost() {
      return cost;
   }

   public void setCost(int cost) {
      this.cost = cost;
   }


   // ==== Override ====

}
