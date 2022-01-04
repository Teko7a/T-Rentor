package teko7a.Models;

/**
 * 用户与管理员的公共父类。 不难发现两者的数据库是基本一致的，因此不妨将两者作为一个父类下的两个派生类。
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/30
 */
public class Person {
   // ==== Data ====
   private int id;
   private String name;
   private String password;
   private String realName;
   private String idc;
   private String tel;

   public final String className = "person";

   // ==== Constructors ====

   public Person() {
      super();
   }

   public Person(int id, String name, String password, String realName, String idc, String tel) {
      this.id = id;
      this.name = name;
      this.password = password;
      this.realName = realName;
      this.idc = idc;
      this.tel = tel;
   }

   // ==== Getter and Setter ====

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getRealName() {
      return realName;
   }

   public void setRealName(String realName) {
      this.realName = realName;
   }

   public String getIdc() {
      return idc;
   }

   public void setIdc(String idc) {
      this.idc = idc;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   // ==== Override ====

   @Override public String toString() {
      return "{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", realName='" + realName + '\'' +
            ", idc='" + idc + '\'' +
            ", tel='" + tel + '\'' +
            '}';
   }
}
