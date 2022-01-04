package teko7a.Models;

/**
 * 租车信息条实体类
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/30
 * <p>
 * +--------+-------------+------+-----+---------+----------------+
 * | Field  | Type        | Null | Key | Default | Extra          |
 * +--------+-------------+------+-----+---------+----------------+
 * | id     | int(11)     | NO   | PRI | NULL    | auto_increment |
 * | usrID  | int(11)     | YES  | MUL | NULL    |                |
 * | carID  | int(11)     | YES  | MUL | NULL    |                |
 * | stDate | varchar(20) | YES  |     | NULL    |                |
 * | edDate | varchar(20) | YES  |     | NULL    |                |
 * | dates  | int(11)     | YES  |     | NULL    |                |
 * | cost   | int(11)     | YES  |     | NULL    |                |
 * +--------+-------------+------+-----+---------+----------------+
 */
public class Rented {
   // ==== Data ====
   private int id;
   private int usrID;
   private int carID;
   private String stDate;
   private String edDate;
   private int dates;
   private int cost;


   // ==== Constructors ====
   public Rented() {
      super();
   }

   public Rented(int id, int usrID, int carID, String stDate, String edDate, int dates, int cost) {
      this.id = id;
      this.usrID = usrID;
      this.carID = carID;
      this.stDate = stDate;
      this.edDate = edDate;
      this.dates = dates;
      this.cost = cost;
   }

   // ==== Getter and Setter ====

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getUsrID() {
      return usrID;
   }

   public void setUsrID(int usrID) {
      this.usrID = usrID;
   }

   public int getCarID() {
      return carID;
   }

   public void setCarID(int carID) {
      this.carID = carID;
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

   public int getDates() {
      return dates;
   }

   public void setDates(int dates) {
      this.dates = dates;
   }

   public int getCost() {
      return cost;
   }

   public void setCost(int cost) {
      this.cost = cost;
   }


   // ==== Override ====

}
