package teko7a.Models;

/**
 * 车辆实体类
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/30
 * <p>
 * +---------+-------------+------+-----+---------+----------------+
 * | Field   | Type        | Null | Key | Default | Extra          |
 * +---------+-------------+------+-----+---------+----------------+
 * | id      | int(11)     | NO   | PRI | NULL    | auto_increment |
 * | type    | varchar(30) | YES  |     | NULL    |                |
 * | license | varchar(10) | YES  |     | NULL    |                |
 * | brand   | varchar(20) | YES  |     | NULL    |                |
 * | size    | varchar(20) | YES  |     | NULL    |                |
 * | seatNum | int(11)     | YES  |     | NULL    |                |
 * | isAuto  | int(11)     | YES  |     | 1       |                |
 * | cost    | int(11)     | YES  |     | NULL    |                |
 * | tons    | varchar(20) | YES  |     | NULL    |                |
 * | color   | varchar(20) | YES  |     | NULL    |                |
 * | status  | int(11)     | YES  |     | NULL    |                |
 * +---------+-------------+------+-----+---------+----------------+
 */
public class Car {
   // ==== Data ====
   private int id;
   private String type;
   private String license;
   private String brand;
   private String size;
   private int seatNum;
   private int isAuto;
   private int status;
   private String tons;
   private String color;
   private int cost;

   // ==== Constructors ====
   public Car() {
      super();
   }

   public Car(String type, String brand, String size, int seatNum, String tons, String color, int isAuto) {
      this.type = type;
      this.brand = brand;
      this.size = size;
      this.seatNum = seatNum;
      this.isAuto = isAuto;
      this.tons = tons;
      this.color = color;
   }

   public Car(int id, String type, String license, String brand, String size, int seatNum, int isAuto, String tons, String color, int cost, int status) {
      this.id = id;
      this.type = type;
      this.license = license;
      this.brand = brand;
      this.size = size;
      this.seatNum = seatNum;
      this.isAuto = isAuto;
      this.status = status;
      this.tons = tons;
      this.color = color;
      this.cost = cost;
   }
   // ==== Getter and Setter ====

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getLicense() {
      return license;
   }

   public void setLicense(String license) {
      this.license = license;
   }

   public String getBrand() {
      return brand;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public String getSize() {
      return size;
   }

   public void setSize(String size) {
      this.size = size;
   }

   public int getSeatNum() {
      return seatNum;
   }

   public void setSeatNum(int seatNum) {
      this.seatNum = seatNum;
   }

   public int getIsAuto() {
      return isAuto;
   }

   public void setIsAuto(int isAuto) {
      this.isAuto = isAuto;
   }

   public int getStatus() {
      return status;
   }

   public void setStatus(int status) {
      this.status = status;
   }

   public String getTons() {
      return tons;
   }

   public void setTons(String tons) {
      this.tons = tons;
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public int getCost() {
      return cost;
   }

   public void setCost(int cost) {
      this.cost = cost;
   }


   // ==== Override ====

   @Override public String toString() {
      return "Car{" +
            "id=" + id +
            ", type='" + type + '\'' +
            ", license='" + license + '\'' +
            ", brand='" + brand + '\'' +
            ", size='" + size + '\'' +
            ", seatNum=" + seatNum +
            ", isAuto=" + isAuto +
            ", status=" + status +
            ", tons='" + tons + '\'' +
            ", color='" + color + '\'' +
            ", cost=" + cost +
            '}';
   }
}
