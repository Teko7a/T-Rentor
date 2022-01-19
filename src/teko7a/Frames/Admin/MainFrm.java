package teko7a.Frames.Admin;

import teko7a.DAOs.CarDAO;
import teko7a.DAOs.MaintainDAO;
import teko7a.DAOs.RentedDAO;
import teko7a.DAOs.UsrDAO;
import teko7a.Frames.Welcome.LoginFrm;
import teko7a.Frames.Welcome.RegisterFrm;
import teko7a.Models.Admin;
import teko7a.Models.Car;
import teko7a.Models.Maintain;
import teko7a.Models.Usr;
import teko7a.Utils.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Vector;

/**
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/30
 */
public class MainFrm extends JFrame {
   private Admin curAdmin = null;

   DataBaseUtil dbUtil = new DataBaseUtil();
   CarDAO carDao = new CarDAO();
   RentedDAO rentedDao = new RentedDAO();
   UsrDAO usrDao = new UsrDAO();
   MaintainDAO maintainDao = new MaintainDAO();

   public MainFrm(Admin admin) {
      this();
      this.curAdmin = admin;
      this.name_idJL.setText("usrName(id : " + admin.getId() + ")");
      this.todayJL.setText("今天是:" + DateUtil.getToday());

      this.fillRentedHisJT();
      this.fillFixHisJT();
      this.updateProfitJBActionPerformed();

      this.fillUsrJT(new Usr());
      this.fillCarJT(new Car());
      this.fillFixJT();
   }

   private void fillFixJT() {
      Connection con = null;
      try {
         con = dbUtil.getCon();
         ResultSet rs = maintainDao.list(con, OrdersEnum.ADD);
         fillTableHelper4(rs, this.toFixJT);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private void fillTableHelper4(ResultSet rs, JTable toFixJT) throws SQLException {
      DefaultTableModel dtm = (DefaultTableModel) toFixJT.getModel();
      dtm.setRowCount(0);
      while (rs.next()) {
         Vector<String> v = new Vector<>();
         v.add(rs.getString("id"));
         v.add(rs.getString("carID"));
         v.add(rs.getString("adminID"));
         v.add(rs.getString("errorDesc"));
         v.add(rs.getString("stDate"));
         v.add(rs.getString("edDate") == null ? "<html><font color= \"red\">&lt;null&gt;</font>"
               : rs.getString("edDate"));
         v.add(rs.getString("cost"));
         dtm.addRow(v);
      }
   }

   private void fillFixHisJT() {
      Connection con = null;
      try {
         con = dbUtil.getCon();
         ResultSet rs = maintainDao.list(con, OrdersEnum.QUERY);
         fillTableHelper4(rs, this.hisFixJT);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   public MainFrm() {
      FrmUtil.setFont();
      initComponents();
      this.setLocationRelativeTo(null);
   }

   private void findJBActionPerformed(ActionEvent evt) {
      String id = this.idJTF.getText();
      String name = this.nameJTF.getText();
      String password = this.passwordJTF.getText();
      String realName = this.rNameJTF.getText();
      String idc = this.idcJTF.getText();
      String tel = this.telJTF.getText();

      if (StringUtil.existEmpty(id, name, password, realName, idc, tel)) {
         StringUtil.log("请输入有效信息!");
         return;
      }
      if (StringUtil.isNotEmpty(id)) {
         if (!StringUtil.isPositiveDigit(id)) {
            StringUtil.log("请输入有效的编号!\nThis id is invalid!");
            return;
         }
      }

      if (StringUtil.isNotEmpty(idc)) {
         if (StringUtil.isInvalidIdc(idc)) {
            StringUtil.log("请输入正确的身份证号!\nPlease Input Correct IDCN!");
            return;
         }
      }
      if (StringUtil.isNotEmpty(tel)) {
         if (StringUtil.isInvalidTel(tel)) {
            StringUtil.log("请输入正确的电话号码!\nPlease Input Correct Tel!");
            return;
         }
      }
      Usr usr = new Usr(StringUtil.isEmpty(id) ? -1 : Integer.parseInt(id), name, password, realName, idc, tel);
      Connection con = null;
      try {
         con = dbUtil.getCon();
         ResultSet rs = usrDao.detail(con, usr);
         fillTableHelper2(rs, usrJT);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception exception) {
            exception.printStackTrace();
         }
      }
   }

   private void addJBActionPerformed(ActionEvent e) {
      FrmUtil.openFrm(new RegisterFrm(OrdersEnum.ADD));
      this.fillUsrJT(new Usr());
      this.resetJBActionPerformed();
   }

   private void resetJBActionPerformed(ActionEvent e) {
      this.resetJBActionPerformed();
      this.fillUsrJT(new Usr());
   }

   private void resetJBActionPerformed() {
      this.idJTF.setText("");
      this.nameJTF.setText("");
      this.passwordJTF.setText("");
      this.rNameJTF.setText("");
      this.idcJTF.setText("");
      this.telJTF.setText("");
      this.curJTF.setText("");
      this.hisJTF.setText("");
   }

   private void removeJBActionPerformed(ActionEvent evt) {
      if (this.usrJT.getSelectedRow() == -1) {
         StringUtil.log("请点击左边的表格以选中一名用户!\nPlease click left table so as to select 1 user.");
         return;
      }
      int id = Integer.parseInt((String) this.usrJT.getValueAt(usrJT.getSelectedRow(), 0));
      Usr usr = new Usr();
      usr.setId(id);
      Connection con = null;
      try {
         con = dbUtil.getCon();
         int res = usrDao.remove(con, usr);
         if (res != 1) {
            StringUtil.log("删除失败");
         } else {
            this.fillUsrJT(new Usr());
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private void modifyJBActionPerformed() {
      if (this.usrJT.getSelectedRow() == -1) {
         StringUtil.log("请点击左边的表格以选中一名用户!\nPlease click left table so as to select 1 user.");
         return;
      }
      this.curJTF.setText("");
      this.hisJTF.setText("");
      int id = Integer.parseInt((String) this.usrJT.getValueAt(usrJT.getSelectedRow(), 0));
      String name = this.nameJTF.getText();
      String password = this.passwordJTF.getText();
      String rName = this.rNameJTF.getText();
      String idc = this.idcJTF.getText();
      String tel = this.telJTF.getText();
      // **** 非空判断 以及 长度合法判断 ****
      if (StringUtil.isEmpty(name)) {
         StringUtil.log("请输入用户名!\n Please Input Your User Name!");
         return;
      }
      if (StringUtil.isEmpty(idc)) {
         StringUtil.log("请输入您的身份证号!\n Please Input Your IDCN!");
         return;
      }
      if (StringUtil.isInvalidIdc(idc)) {
         StringUtil.log("请输入正确身份证号!");
         this.idcJTF.setText("");
      }
      if (StringUtil.isEmpty(rName)) {
         StringUtil.log("请输入您的真实姓名!\n Please Input Your Real Name!");
         return;
      }
      if (StringUtil.isEmpty(tel)) {
         StringUtil.log("请输入您的电话号码!\n Please Input Your Telephone Number!");
         return;
      }
      if (tel.length() != 11) {
         StringUtil.log("请输入正确的电话号码!\nPlease Input Correct Tel!");
         return;
      } else {
         if (!StringUtil.isPositiveDigit(tel)) {
            StringUtil.log("请输入正确的电话号码!\nPlease Input Correct Tel!");
            return;
         }
      }
      if (StringUtil.isEmpty(password)) {
         StringUtil.log("请输入密码!\n Enter your password!");
         return;
      }
      Usr usr = new Usr(id, name, password, rName, idc, tel);
      Connection con = null;
      try {
         con = dbUtil.getCon();
         int res = usrDao.modify(con, usr);
         if (res != 1) {
            StringUtil.log("修改失败");
         } else {
            this.fillUsrJT(new Usr());
            this.resetJBActionPerformed();
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private void fillRentedHisJT() {
      Connection con = null;
      try {
         con = dbUtil.getCon();
         ResultSet rs = rentedDao.list(con);
         fillTableHelper(rs, this.rentedHisTable);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private void fillTableHelper(ResultSet rs, JTable rentedHisTable) throws SQLException {
      DefaultTableModel dtm = (DefaultTableModel) rentedHisTable.getModel();
      dtm.setRowCount(0);
      // SELECT tu.id, tu.name, tc.id, tc.type, tc.brand, tc.seatNum, tc.license,
      // tc.color, tr.stDate, tr.edDate, tr.dates, tr.cost
      while (rs.next()) {
         Vector<String> v = new Vector<>();
         v.add(String.valueOf(rs.getInt("tu.id")));
         v.add(rs.getString("tu.name"));
         v.add(String.valueOf(rs.getInt("tc.id")));
         v.add(rs.getString("tc.type"));
         v.add(rs.getString("tc.brand"));
         v.add(String.valueOf(rs.getInt("tc.seatNum")));
         v.add(rs.getString("tc.license"));
         v.add(rs.getString("tc.color"));
         v.add(rs.getString("tr.stDate"));
         v.add(rs.getString("tr.edDate"));
         v.add(rs.getString("tr.dates"));
         v.add(String.valueOf(rs.getInt("tr.cost")));
         dtm.addRow(v);
      }

      for (int i = 0; i < this.rentedHisTable.getRowCount(); i++) {
         if (rentedHisTable.getValueAt(i, 9) == null) {
            rentedHisTable.setValueAt("<html><font color = 'red'>&lt;null&gt;</font>", i, 9);
         } else {
            break;
         }
      }
   }

   private void fillUsrJT(Usr usr) {
      Connection con = null;
      try {
         con = dbUtil.getCon();
         ResultSet rs = usrDao.list(con, usr);
         fillTableHelper2(rs, this.usrJT);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private void fillTableHelper2(ResultSet rs, JTable usrJT) throws SQLException {
      DefaultTableModel dtm = (DefaultTableModel) usrJT.getModel();
      dtm.setRowCount(0);
      // SELECT id, name, password, realName, idc, tel, 1 / 0, count(1)
      while (rs.next()) {
         Vector<String> v = new Vector<>();
         v.add(String.valueOf(rs.getInt("id")));
         v.add(rs.getString("name"));
         v.add(rs.getString("password"));
         v.add(rs.getString("realName"));
         v.add(rs.getString("idc"));
         v.add(rs.getString("tel"));
         Connection con = null;
         Usr usr = new Usr();
         usr.setId(rs.getInt("id"));
         try {
            con = dbUtil.getCon();
            v.add(rentedDao.hasUnreturned(con, usr) ? "1" : "0");
            ResultSet rs1 = rentedDao.countLines(con, usr);
            while (rs1.next())
               v.add(String.valueOf(rs1.getInt("count(1)")));
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            try {
               dbUtil.closeCon(con);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         dtm.addRow(v);
      }
   }

   private void logoutJBActionPerformed() {
      int confirm = JOptionPane.showConfirmDialog(null, "确认退出系统吗？\n再检查下还有没有要做的事哦～");
      if (confirm == 0) {
         this.dispose();
         FrmUtil.openFrm(new LoginFrm());
      }
   }

   /**
    * 表格 {@code usrJT} 行点击事件：点击某一行，会在右侧显示出详细数据。
    *
    * @author: tekola (teko7a@github.io)
    */
   private void usrJTMousePressed() {
      int row = this.usrJT.getSelectedRow();

      this.idJTF.setText((String) usrJT.getValueAt(row, 0));
      this.nameJTF.setText((String) usrJT.getValueAt(row, 1));
      this.passwordJTF.setText((String) usrJT.getValueAt(row, 2));
      this.rNameJTF.setText((String) usrJT.getValueAt(row, 3));
      this.idcJTF.setText((String) usrJT.getValueAt(row, 4));
      this.telJTF.setText((String) usrJT.getValueAt(row, 5));
      this.curJTF.setText((String) usrJT.getValueAt(row, 6));
      this.hisJTF.setText((String) usrJT.getValueAt(row, 7));
   }

   private void carJTMousePressed() {
      int row = this.carJT.getSelectedRow();

      this.carIDJTF.setText((String) carJT.getValueAt(row, 0));
      String carTypeName = (String) carJT.getValueAt(row, 1);
      int carTypeOrder = carTypeJCB.getItemCount();
      for (int i = 0; i < carTypeOrder; i++) {
         if (carTypeJCB.getItemAt(i).equals(carTypeName)) {
            carTypeJCB.setSelectedIndex(i);
         }
      }
      this.carLicenseJTF.setText((String) carJT.getValueAt(row, 2));
      this.carBrandJTF.setText((String) carJT.getValueAt(row, 3));
      this.carSizeJTF.setText((String) carJT.getValueAt(row, 4));
      this.carSeatNumJTF.setText((String) carJT.getValueAt(row, 5));

      this.carIsAutoJChB.setSelected("1".equals(carJT.getValueAt(row, 6)));
      this.carTonsJTF.setText((String) carJT.getValueAt(row, 7));
      int carColorOrder = carColorJCB.getItemCount();
      String carColor = (String) carJT.getValueAt(row, 8);
      for (int i = 0; i < carColorOrder; i++) {
         if (carColorJCB.getItemAt(i).equals(carColor)) {
            carColorJCB.setSelectedIndex(i);
         }
      }
      this.carFeeJTF.setText((String) carJT.getValueAt(row, 9));
      String carStatus = (String) carJT.getValueAt(row, 10);
      switch (Objects.requireNonNull(carStatus)) {
         case "1" -> carStatusJCB.setSelectedIndex(1);
         case "0" -> carStatusJCB.setSelectedIndex(2);
         case "-1" -> carStatusJCB.setSelectedIndex(3);
      }
   }

   private void fillCarJT(Car car) {
      Connection con = null;
      try {
         con = dbUtil.getCon();
         ResultSet rs = carDao.list_all(con, car);
         fillTableHelper3(rs, this.carJT);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private void fillTableHelper3(ResultSet rs, JTable carJT) throws SQLException {
      DefaultTableModel dtm = (DefaultTableModel) carJT.getModel();
      dtm.setRowCount(0);
      while (rs.next()) {
         Vector<String> v = new Vector<>();
         v.add(String.valueOf(rs.getInt("id")));
         v.add(rs.getString("type"));
         v.add(rs.getString("license"));
         v.add(rs.getString("brand"));
         v.add(rs.getString("size"));
         v.add(String.valueOf(rs.getInt("seatNum")));
         v.add(String.valueOf(rs.getInt("isAuto")));
         v.add(rs.getString("tons"));
         v.add(rs.getString("color"));
         v.add(String.valueOf(rs.getInt("cost")));
         v.add(String.valueOf(rs.getInt("status")));
         dtm.addRow(v);
      }
   }

   private void resetCarJBActionPerformed(ActionEvent e) {
      this.resetCarJBActionPerformed();
      this.fillCarJT(new Car());
   }

   private void resetCarJBActionPerformed() {
      this.carIDJTF.setText("");
      this.carTypeJCB.setSelectedIndex(0);
      this.carLicenseJTF.setText("");
      this.carBrandJTF.setText("");
      this.carSizeJTF.setText("");
      this.carSeatNumJTF.setText("");
      this.carIsAutoJChB.setSelected(true);
      this.carTonsJTF.setText("");
      this.carFeeJTF.setText("");
      this.carColorJCB.setSelectedIndex(0);
      this.carStatusJCB.setSelectedIndex(0);
   }

   private void modifyCarJBActionPerformed(ActionEvent evt) {
      if (this.carJT.getSelectedRow() == -1) {
         StringUtil.log("请点击左边的表格以选中一辆车!\nPlease click left table so as to select 1 car.");
         return;
      }
      Car car = null;
      while (car == null)
         car = this.getDetailCar();
      Connection con = null;
      try {
         con = dbUtil.getCon();
         int res;
         if (car.getStatus() == -1) {
            res = carDao.update(con, car, this.curAdmin);
         } else {
            res = carDao.update(con, car);
         }
         if (res != 1 && res != 2) {
            StringUtil.log("修改失败");
         } else {
            this.fillRentedHisJT();
            this.fillFixHisJT();
            this.updateProfitJBActionPerformed();

            this.fillUsrJT(new Usr());
            this.fillCarJT(new Car());
            this.fillFixJT();
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

   }

   private void removeCarJBActionPerformed(ActionEvent evt) {
      if (this.carJT.getSelectedRow() == -1) {
         StringUtil.log("请点击左边的表格以选中一辆车!\nPlease click left table so as to select 1 car.");
         return;
      }
      int id = Integer.parseInt((String) this.carJT.getValueAt(carJT.getSelectedRow(), 0));
      Car car = new Car();
      car.setId(id);
      Connection con = null;
      try {
         con = dbUtil.getCon();
         int res = carDao.remove(con, car);
         if (res != 1) {
            StringUtil.log("删除失败");
         } else {
            this.fillCarJT(new Car());
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private void addCarJBActionPerformed(ActionEvent evt) {
      this.idJTF.setText("");
      Car car = null;
      while (car == null)
         car = this.getDetailCar();
      Connection con = null;
      try {
         con = dbUtil.getCon();
         int res = carDao.add(con, car);
         if (res == 1) {
            StringUtil.log("增加成功!");
            this.resetCarJBActionPerformed();
            this.fillCarJT(new Car());
         } else {
            StringUtil.log("增加失败!");
         }
      } catch (Exception e) {
         StringUtil.log("增加失败!");
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private Car getDetailCar() {
      String licenseP = this.carLicenseJTF.getText();
      String brandP = this.carBrandJTF.getText();
      String sizeP = this.carSizeJTF.getText();
      String tonsP = this.carTonsJTF.getText();
      String colorP = (String) this.carColorJCB.getSelectedItem();

      if (StringUtil.existEmpty(licenseP, brandP, sizeP, tonsP, colorP)) {
         StringUtil.log("请输入完备信息!\nPlease input completed infos!");
         return null;
      }

      String idP = this.carIDJTF.getText();
      if (!StringUtil.isPositiveDigit(idP)) {
         StringUtil.log("请输入有效信息!\nPlease input correct infos!");
         return null;
      }
      int id = Integer.parseInt(idP);

      String seatNumP = this.carSeatNumJTF.getText();
      if (!StringUtil.isPositiveDigit(seatNumP)) {
         StringUtil.log("请输入有效信息!\nPlease input correct infos!");
         return null;
      }
      int seatNum = Integer.parseInt(seatNumP);

      String costP = this.carFeeJTF.getText();
      if (!StringUtil.isPositiveDigit(costP)) {
         StringUtil.log("请输入有效信息!\nPlease input correct infos!");
         return null;
      }
      int cost = Integer.parseInt(costP);

      String type = (String) this.carTypeJCB.getSelectedItem();
      if ("请选择..".equals(type)) {
         StringUtil.log("请选择类型!\nPlease select type of car!");
         return null;
      }

      int isAuto = this.carIsAutoJChB.isSelected() ? 1 : 0;
      String item = (String) this.carStatusJCB.getSelectedItem();
      int status = "可租".equals(item) ? 1 : "已租未还".equals(item) ? 0 : "请选择..".equals(item) ? -2 : -1;

      return new Car(id, type, licenseP, brandP, sizeP, seatNum, isAuto, tonsP, colorP, cost, status);
   }

   private void findCarJBActionPerformed(ActionEvent evt) {
      String idP = this.carIDJTF.getText();
      String licenseP = this.carLicenseJTF.getText();
      String brandP = this.carBrandJTF.getText();
      String sizeP = this.carSizeJTF.getText();
      String tonsP = this.carTonsJTF.getText();
      String typeP = "请选择..".equals(this.carTypeJCB.getSelectedItem()) ? null
            : (String) this.carTypeJCB.getSelectedItem();
      String colorP = "请选择..".equals(this.carColorJCB.getSelectedItem()) ? null
            : (String) this.carColorJCB.getSelectedItem();

      String seatNumP = this.carSeatNumJTF.getText();
      String costP = this.carFeeJTF.getText();
      String statusP = (String) this.carStatusJCB.getSelectedItem();
      String isAutoP = this.carIsAutoJChB.isSelected() ? "1" : "0";

      if (StringUtil.allEmpty(idP, licenseP, brandP, sizeP, seatNumP, tonsP, costP, typeP, colorP, statusP, isAutoP)) {
         StringUtil.log("请至少选择一项以开始搜索!\nSelect at least one element!");
         return;
      }

      if (!StringUtil.isPositiveDigit(idP))
         idP = "-1";
      if (!StringUtil.isPositiveDigit(seatNumP))
         seatNumP = "-1";
      if (!StringUtil.isPositiveDigit(costP))
         costP = "-1";

      if (StringUtil.isEmpty(statusP))
         statusP = "-1";
      else {
         switch (Objects.requireNonNull(statusP)) {
            case "请选择.." -> statusP = "-2";
            case "可租" -> statusP = "1";
            case "已租未还" -> statusP = "0";
            default -> statusP = "-1";
         }
      }

      Car car = new Car(Integer.parseInt(idP), typeP, licenseP, brandP, sizeP, Integer.parseInt(seatNumP),
            Integer.parseInt(isAutoP), tonsP, colorP, Integer.parseInt(costP), Integer.parseInt(statusP));
      Connection con = null;
      try {
         con = dbUtil.getCon();
         ResultSet rs = carDao.query(con, car, OrdersEnum.QUERY);
         fillTableHelper3(rs, carJT);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception exception) {
            exception.printStackTrace();
         }
      }
   }

   private void link1JBActionPerformed(ActionEvent e) {
      UrlLinkUtil.openUrl("https://teko7a.github.io");
   }

   private void link2JBActionPerformed(ActionEvent e) {
      UrlLinkUtil.openUrl("https://space.bilibili.com/22754284");
   }

   private void updateProfitJBActionPerformed(ActionEvent e) {
      this.updateProfitJBActionPerformed();
   }

   private void updateProfitJBActionPerformed() {
      String st = this.stDateJTF.getText();
      String ed = this.edDateJTF.getText();
      if (StringUtil.isEmpty(st)) {
         this.stDateJTF.setText("21/01/01");
         st = stDateJTF.getText();
      }
      if (StringUtil.isEmpty(ed)) {
         this.edDateJTF.setText(DateUtil.getToday());
         ed = edDateJTF.getText();
      }
      Connection con = null;
      try {
         con = dbUtil.getCon();
         int[] res = maintainDao.calcProfit(con, st, ed);
         this.totRentedCarsJTF.setText(String.valueOf(res[0]));
         this.totFixedCarsNumJTF.setText(String.valueOf(res[1]));
         this.totCostJTF.setText(String.valueOf(res[2]));
         this.totProfitJTF.setText(String.valueOf(res[3]));
      } catch (Exception e) {
         StringUtil.log("提交表单失败!");
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private void maintainJBActionPerformed(ActionEvent evt) {
      if (this.toFixJT.getSelectedRow() == -1) {
         StringUtil.log("请点击上面的表格以选中一条信息!\nClick Table up to select 1 record!");
         return;
      }
      int row = this.toFixJT.getSelectedRow();
      int carId = Integer.parseInt((String) this.toFixJT.getValueAt(row, 1));
      int adminId = Integer.parseInt((String) this.toFixJT.getValueAt(row, 2));
      String errorDesc = this.maintainMessageJTF.getText();
      String stDate = (String) this.toFixJT.getValueAt(row, 4);
      String edDate = DateUtil.getToday();
      int cost = Integer.parseInt(this.maintainCostJTF.getText());
      Maintain maintain = new Maintain(Integer.parseInt((String) this.toFixJT.getValueAt(row, 0)), carId, adminId,
            errorDesc, stDate, edDate, cost);
      Connection con = null;
      try {
         con = dbUtil.getCon();
         int res = maintainDao.update(con, maintain);
         if (res == 1) {
            StringUtil.log("提交表单成功!");
            Car car = carDao.detail(con, carId);
            car.setStatus(1);
            carDao.update(con, car);
            this.fillRentedHisJT();
            this.fillFixHisJT();
            this.updateProfitJBActionPerformed();

            this.fillUsrJT(new Usr());
            this.fillCarJT(new Car());
            this.fillFixJT();
         } else {
            StringUtil.log("提交表单失败!");
         }
      } catch (Exception e) {
         StringUtil.log("提交表单失败!");
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private void toFixJTMousePressed() {
      int row = this.toFixJT.getSelectedRow();

      this.maintainMessageJTF.setText((String) toFixJT.getValueAt(row, 3));
      this.maintainCostJTF.setText((String) toFixJT.getValueAt(row, 6));

      String[] cnt = null;
      Connection con = null;
      try {
         con = dbUtil.getCon();
         Car car = carDao.detail(con, Integer.parseInt((String) toFixJT.getValueAt(row, 1)));
         cnt = maintainDao.cnt(con, car);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception exception) {
            exception.printStackTrace();
         }
      }

      assert cnt != null;
      this.maintainCntJTF.setText(cnt[0]);
      this.rentedCntJTF.setText(cnt[1]);
   }

   private void initComponents() {
      JTabbedPane tabbedPane1 = new JTabbedPane();
      JPanel panel2 = new JPanel();
      JPanel panel10 = new JPanel();
      JScrollPane scrollPane1 = new JScrollPane();
      usrJT = new JTable();
      JPanel panel11 = new JPanel();
      JLabel idJL = new JLabel();
      JLabel nameJL = new JLabel();
      JLabel passwordJL = new JLabel();
      JLabel rNameJL = new JLabel();
      JLabel idcJL = new JLabel();
      JLabel telJL = new JLabel();
      JLabel curJL = new JLabel();
      JLabel hisJL = new JLabel();
      idJTF = new JTextField();
      nameJTF = new JTextField();
      passwordJTF = new JTextField();
      rNameJTF = new JTextField();
      idcJTF = new JTextField();
      telJTF = new JTextField();
      curJTF = new JTextField();
      hisJTF = new JTextField();
      JButton resetJB = new JButton();
      JButton modifyJB = new JButton();
      JButton removeJB = new JButton();
      JLabel title1JL = new JLabel();
      JButton addJB = new JButton();
      JButton findJB = new JButton();
      JPanel panel3 = new JPanel();
      JPanel panel12 = new JPanel();
      JScrollPane scrollPane4 = new JScrollPane();
      carJT = new JTable();
      JPanel panel13 = new JPanel();
      JLabel title2JL = new JLabel();
      JButton addCarJB = new JButton();
      JLabel carIDJL = new JLabel();
      JLabel carTypeJL = new JLabel();
      JLabel carLicenceJL = new JLabel();
      JLabel carBrandJL = new JLabel();
      JLabel carSizeJL = new JLabel();
      JLabel carSeatNumJL = new JLabel();
      JLabel carTonsJL = new JLabel();
      JLabel carColorJL = new JLabel();
      JLabel carFeeJL = new JLabel();
      JLabel carStatusJL = new JLabel();
      carIDJTF = new JTextField();
      carLicenseJTF = new JTextField();
      carBrandJTF = new JTextField();
      carSizeJTF = new JTextField();
      carSeatNumJTF = new JTextField();
      carIsAutoJChB = new JCheckBox();
      carStatusJCB = new JComboBox<>();
      carColorJCB = new JComboBox<>();
      carTypeJCB = new JComboBox<>();
      carTonsJTF = new JTextField();
      carFeeJTF = new JTextField();
      JButton resetCarJB = new JButton();
      JButton findCarJB = new JButton();
      JButton modifyCarJB = new JButton();
      JButton removeCarJB = new JButton();
      JPanel panel5 = new JPanel();
      JScrollPane scrollPane5 = new JScrollPane();
      toFixJT = new JTable();
      JPanel panel14 = new JPanel();
      JLabel maintainMessageJL = new JLabel();
      maintainMessageJTF = new JTextField();
      JLabel maintainCostJL = new JLabel();
      maintainCostJTF = new JTextField();
      JLabel maintainCntJL = new JLabel();
      maintainCntJTF = new JTextField();
      JLabel rentedCntJL = new JLabel();
      rentedCntJTF = new JTextField();
      JButton maintainJB = new JButton();
      JPanel panel15 = new JPanel();
      JLabel carPicJL = new JLabel();
      JLabel titleJL = new JLabel();
      JPanel panel6 = new JPanel();
      JScrollPane scrollPane2 = new JScrollPane();
      rentedHisTable = new JTable();
      JPanel panel7 = new JPanel();
      JLabel label6 = new JLabel();
      totRentedCarsJTF = new JTextField();
      JLabel label14 = new JLabel();
      totFixedCarsNumJTF = new JTextField();
      JLabel label15 = new JLabel();
      JLabel label16 = new JLabel();
      totCostJTF = new JTextField();
      JLabel label17 = new JLabel();
      totProfitJTF = new JTextField();
      JLabel label18 = new JLabel();
      JButton updateProfitJB = new JButton();
      JScrollPane scrollPane6 = new JScrollPane();
      hisFixJT = new JTable();
      stDateJTF = new JTextField();
      JLabel label19 = new JLabel();
      edDateJTF = new JTextField();
      JLabel label20 = new JLabel();
      JPanel panel9 = new JPanel();
      JPanel aboutAuthorJP = new JPanel();
      JButton link1JB = new JButton();
      JButton link2JB = new JButton();
      JLabel madeWithJL = new JLabel();
      JLabel picJL = new JLabel();
      JPanel panel1 = new JPanel();
      JLabel logoJL = new JLabel();
      JLabel curUsrJL = new JLabel();
      name_idJL = new JLabel();
      JButton logoutJB = new JButton();
      todayJL = new JLabel();

      // ======== this ========
      setTitle("\u6253\u9020\u66f4\u597d\u7528\u7684T-rentor\uff01");
      setResizable(false);
      var contentPane = getContentPane();

      // ======== tabbedPane1 ========
      {

         // ======== panel2 ========
         {
            panel2.setBorder(new javax.swing.border.CompoundBorder(
                  new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "Teko\u006fla\u0069.github \u0045.\u0074io", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM,
                        new java.awt.Font("D\u0069alog", java.awt.Font.BOLD, 12), java.awt.Color.red),
                  panel2.getBorder()));

            // ======== panel10 ========
            {

               // ======== scrollPane1 ========
               {
                  // ---- usrJT ----
                  usrJT.setModel(new DefaultTableModel(
                        new Object[][] {
                              { "1", null, null, null, "424", null, null, "242" },
                              { "2", null, null, null, null, null, null, null },
                              { "3", null, null, null, null, null, null, null },
                              { "..", null, null, null, null, null, null, null },
                              { "4", null, null, null, null, null, null, null },
                              { "5", null, null, null, null, null, null, null },
                        },
                        new String[] {
                              "\u7528\u6237\u7f16\u53f7", "\u7528\u6237\u540d", "\u7528\u6237\u5bc6\u7801",
                              "\u771f\u5b9e\u59d3\u540d", "\u8eab\u4efd\u8bc1\u53f7", "\u7535\u8bdd\u53f7\u7801",
                              "\u76ee\u524d\u79df\u8f66\u6570\u91cf", "\u5386\u53f2\u79df\u8f66\u6570\u91cf"
                        }) {
                     final boolean[] columnEditable = new boolean[] {
                           false, false, false, false, false, false, false, false
                     };

                     @Override
                     public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                     }
                  });
                  usrJT.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mousePressed(MouseEvent e) {
                        usrJTMousePressed();
                     }
                  });
                  scrollPane1.setViewportView(usrJT);
               }

               GroupLayout panel10Layout = new GroupLayout(panel10);
               panel10.setLayout(panel10Layout);
               panel10Layout.setHorizontalGroup(
                     panel10Layout.createParallelGroup()
                           .addGroup(panel10Layout.createSequentialGroup()
                                 .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                                 .addContainerGap()));
               panel10Layout.setVerticalGroup(
                     panel10Layout.createParallelGroup()
                           .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE));
            }

            // ======== panel11 ========
            {

               // ---- idJL ----
               idJL.setText("\u7528\u6237\u7f16\u53f7\uff1a");
               idJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/car1.png"))));

               // ---- nameJL ----
               nameJL.setText("\u7528\u6237\u540d\uff1a");
               nameJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/car2.png"))));

               // ---- passwordJL ----
               passwordJL.setText("\u7528\u6237\u5bc6\u7801\uff1a");
               passwordJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/car3.png"))));

               // ---- rNameJL ----
               rNameJL.setText("\u771f\u5b9e\u59d3\u540d\uff1a");
               rNameJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/car4.png"))));

               // ---- idcJL ----
               idcJL.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
               idcJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/car5.png"))));

               // ---- telJL ----
               telJL.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
               telJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/car6.png"))));

               // ---- curJL ----
               curJL.setText("\u76ee\u524d\u79df\u8f66\u6570\u91cf\uff1a");
               curJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/find.png"))));

               // ---- hisJL ----
               hisJL.setText("\u5386\u53f2\u79df\u8f66\u6570\u91cf\uff1a");
               hisJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/cloud.png"))));

               GroupLayout panel11Layout = new GroupLayout(panel11);
               panel11.setLayout(panel11Layout);
               panel11Layout.setHorizontalGroup(
                     panel11Layout.createParallelGroup()
                           .addGroup(panel11Layout.createSequentialGroup()
                                 .addContainerGap()
                                 .addGroup(panel11Layout.createParallelGroup()
                                       .addGroup(panel11Layout.createSequentialGroup()
                                             .addGap(25, 25, 25)
                                             .addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                   .addComponent(hisJL)
                                                   .addGroup(panel11Layout.createParallelGroup()
                                                         .addComponent(telJL)
                                                         .addComponent(curJL)
                                                         .addComponent(idcJL)
                                                         .addComponent(rNameJL)
                                                         .addComponent(passwordJL)
                                                         .addComponent(nameJL)
                                                         .addComponent(idJL)))
                                             .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                             .addGroup(panel11Layout.createParallelGroup()
                                                   .addComponent(curJTF, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                                   .addComponent(hisJTF))
                                             .addContainerGap())
                                       .addGroup(GroupLayout.Alignment.TRAILING, panel11Layout.createSequentialGroup()
                                             .addGap(0, 0, Short.MAX_VALUE)
                                             .addGroup(panel11Layout.createParallelGroup()
                                                   .addComponent(passwordJTF, GroupLayout.PREFERRED_SIZE, 177,
                                                         GroupLayout.PREFERRED_SIZE)
                                                   .addComponent(idJTF, GroupLayout.PREFERRED_SIZE, 177,
                                                         GroupLayout.PREFERRED_SIZE)
                                                   .addComponent(nameJTF, GroupLayout.PREFERRED_SIZE, 177,
                                                         GroupLayout.PREFERRED_SIZE))
                                             .addGap(26, 26, 26))
                                       .addGroup(panel11Layout.createSequentialGroup()
                                             .addGap(175, 175, 175)
                                             .addGroup(panel11Layout.createParallelGroup()
                                                   .addComponent(idcJTF)
                                                   .addGroup(panel11Layout.createSequentialGroup()
                                                         .addComponent(rNameJTF, GroupLayout.PREFERRED_SIZE, 177,
                                                               GroupLayout.PREFERRED_SIZE)
                                                         .addGap(0, 0, Short.MAX_VALUE))
                                                   .addComponent(telJTF))
                                             .addContainerGap()))));
               panel11Layout.setVerticalGroup(
                     panel11Layout.createParallelGroup()
                           .addGroup(panel11Layout.createSequentialGroup()
                                 .addGroup(panel11Layout.createParallelGroup()
                                       .addGroup(panel11Layout.createSequentialGroup()
                                             .addGap(14, 14, 14)
                                             .addComponent(idJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                   GroupLayout.PREFERRED_SIZE))
                                       .addGroup(panel11Layout.createSequentialGroup()
                                             .addContainerGap()
                                             .addComponent(idJL)))
                                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                       Short.MAX_VALUE)
                                 .addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(nameJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addComponent(nameJL))
                                 .addGap(18, 18, 18)
                                 .addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(passwordJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addComponent(passwordJL))
                                 .addGap(18, 18, 18)
                                 .addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(rNameJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addComponent(rNameJL))
                                 .addGap(18, 18, 18)
                                 .addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(idcJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addComponent(idcJL))
                                 .addGap(18, 18, 18)
                                 .addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(telJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addComponent(telJL))
                                 .addGap(18, 18, 18)
                                 .addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(curJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addComponent(curJL))
                                 .addGap(18, 18, 18)
                                 .addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(hisJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addComponent(hisJL))
                                 .addGap(15, 15, 15)));
            }

            // ---- resetJB ----
            resetJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/reset.png"))));
            resetJB.addActionListener(this::resetJBActionPerformed);

            // ---- modifyJB ----
            modifyJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/edit.png"))));
            modifyJB.setMaximumSize(new Dimension(78, 40));
            modifyJB.setMinimumSize(new Dimension(78, 40));
            modifyJB.addActionListener(e -> MainFrm.this.modifyJBActionPerformed());

            // ---- removeJB ----
            removeJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/delete.png"))));
            removeJB.setMaximumSize(new Dimension(78, 40));
            removeJB.setMinimumSize(new Dimension(78, 40));
            removeJB.addActionListener(MainFrm.this::removeJBActionPerformed);

            // ---- title1JL ----
            title1JL.setText("  ======\u7528\u6237\u7ba1\u7406======");

            // ---- addJB ----
            addJB.setText("\u65b0\u589e\u7528\u6237");
            addJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/add.png"))));
            addJB.addActionListener(MainFrm.this::addJBActionPerformed);

            // ---- findJB ----
            findJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/find.png"))));
            findJB.setMaximumSize(new Dimension(78, 40));
            findJB.setMinimumSize(new Dimension(78, 40));
            findJB.addActionListener(MainFrm.this::findJBActionPerformed);

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                  panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(panel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                    GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                          .addGap(6, 6, 6)
                                          .addComponent(resetJB, GroupLayout.PREFERRED_SIZE, 85,
                                                GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addComponent(findJB, GroupLayout.PREFERRED_SIZE, 84,
                                                GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(modifyJB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addComponent(removeJB, GroupLayout.PREFERRED_SIZE, 79,
                                                GroupLayout.PREFERRED_SIZE)
                                          .addGap(26, 26, 26))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                          .addComponent(title1JL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(addJB, GroupLayout.PREFERRED_SIZE, 176,
                                                GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                          .addGap(0, 0, Short.MAX_VALUE)
                                          .addComponent(panel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)))
                              .addContainerGap()));
            panel2Layout.linkSize(SwingConstants.HORIZONTAL, findJB, modifyJB, removeJB, resetJB);
            panel2Layout.setVerticalGroup(
                  panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                              .addGap(14, 14, 14)
                              .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(title1JL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                          Short.MAX_VALUE)
                                    .addComponent(addJB))
                              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(panel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                    GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(resetJB, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                          .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(modifyJB, GroupLayout.PREFERRED_SIZE, 46,
                                                      GroupLayout.PREFERRED_SIZE)
                                                .addComponent(removeJB, GroupLayout.PREFERRED_SIZE, 46,
                                                      GroupLayout.PREFERRED_SIZE)
                                                .addComponent(findJB, GroupLayout.PREFERRED_SIZE, 46,
                                                      GroupLayout.PREFERRED_SIZE))
                                          .addGap(0, 0, Short.MAX_VALUE)))
                              .addContainerGap())
                        .addGroup(panel2Layout.createSequentialGroup()
                              .addComponent(panel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                    GroupLayout.PREFERRED_SIZE)
                              .addGap(0, 0, Short.MAX_VALUE)));
            panel2Layout.linkSize(SwingConstants.VERTICAL, findJB, modifyJB, removeJB, resetJB);
         }
         tabbedPane1.addTab("\u7528\u6237\u7ba1\u7406", panel2);

         // ======== panel3 ========
         {

            // ======== panel12 ========
            {

               // ======== scrollPane4 ========
               {

                  // ---- carJT ----
                  carJT.setModel(new DefaultTableModel(
                        new Object[][] {
                              { "1", "\u7ecf\u6d4e\u578b", null, null, null, null, "0", null, null, null, "1" },
                              { "1", "SUV", null, null, null, null, "1", "11", null, null, "-1" },
                        },
                        new String[] {
                              "\u8f66\u8f86\u7f16\u53f7", "\u7c7b\u578b", "\u8f66\u724c\u53f7", "\u54c1\u724c",
                              "\u8f66\u578b", "\u5ea7\u6570", "\u81ea\u52a8\u6863", "\u6392\u91cf", "\u989c\u8272",
                              "\u65e5\u79df\u91d1", "\u72b6\u6001"
                        }) {
                     final boolean[] columnEditable = new boolean[] {
                           false, false, false, false, false, false, false, false, false, false, false
                     };

                     @Override
                     public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                     }
                  });
                  carJT.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mousePressed(MouseEvent e) {
                        carJTMousePressed();
                     }
                  });
                  scrollPane4.setViewportView(carJT);
               }

               GroupLayout panel12Layout = new GroupLayout(panel12);
               panel12.setLayout(panel12Layout);
               panel12Layout.setHorizontalGroup(
                     panel12Layout.createParallelGroup()
                           .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE));
               panel12Layout.setVerticalGroup(
                     panel12Layout.createParallelGroup()
                           .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE));
            }

            // ======== panel13 ========
            {

               // ---- title2JL ----
               title2JL.setText("  ======\u8f66\u8f86\u7ba1\u7406======");

               // ---- addCarJB ----
               addCarJB.setText("\u65b0\u589e\u8f66\u8f86");
               addCarJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/add.png"))));
               addCarJB.addActionListener(MainFrm.this::addCarJBActionPerformed);

               // ---- carIDJL ----
               carIDJL.setText("\u8f66\u8f86\u7f16\u53f7\uff1a");

               // ---- carTypeJL ----
               carTypeJL.setText("\u8f66\u8f86\u7c7b\u578b\uff1a");

               // ---- carLicenceJL ----
               carLicenceJL.setText("\u8f66\u724c\u53f7\uff1a");

               // ---- carBrandJL ----
               carBrandJL.setText("\u8f66\u8f86\u54c1\u724c\uff1a");

               // ---- carSizeJL ----
               carSizeJL.setText("\u8f66\u8f86\u578b\u53f7\uff1a");

               // ---- carSeatNumJL ----
               carSeatNumJL.setText("\u5ea7\u6570\uff1a");

               // ---- carTonsJL ----
               carTonsJL.setText("\u6392\u91cf\uff1a");

               // ---- carColorJL ----
               carColorJL.setText("\u989c\u8272\uff1a");

               // ---- carFeeJL ----
               carFeeJL.setText("\u65e5\u79df\u91d1\uff1a");

               // ---- carStatusJL ----
               carStatusJL.setText("\u72b6\u6001\uff1a");

               // ---- carIsAutoJChB ----
               carIsAutoJChB.setText("\u81ea\u52a8\u6863");
               carIsAutoJChB.setSelected(true);

               // ---- carStatusJCB ----
               carStatusJCB.setModel(new DefaultComboBoxModel<>(new String[] {
                     "\u8bf7\u9009\u62e9..",
                     "\u53ef\u79df",
                     "\u5df2\u79df\u672a\u8fd8",
                     "\u7ef4\u4fee\u4e2d"
               }));

               // ---- carColorJCB ----
               carColorJCB.setModel(new DefaultComboBoxModel<>(new String[] {
                     "\u8bf7\u9009\u62e9..",
                     "\u7ea2\u8272",
                     "\u767d\u8272",
                     "\u84dd\u8272",
                     "\u9ec4\u8272",
                     "\u7eff\u8272",
                     "\u7070\u8272",
                     "\u9ed1\u8272",
                     "\u7d2b\u8272"
               }));

               // ---- carTypeJCB ----
               carTypeJCB.setModel(new DefaultComboBoxModel<>(new String[] {
                     "\u8bf7\u9009\u62e9..",
                     "\u7ecf\u6d4e\u578b",
                     "\u8212\u9002\u578b",
                     "SUV",
                     "\u5546\u52a1\u578b",
                     "\u7535\u52a8\u578b",
                     "\u9ad8\u7aef\u8f66"
               }));

               // ---- resetCarJB ----
               resetCarJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/reset.png"))));
               resetCarJB.addActionListener(MainFrm.this::resetCarJBActionPerformed);

               // ---- findCarJB ----
               findCarJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/find.png"))));
               findCarJB.setMaximumSize(new Dimension(78, 40));
               findCarJB.setMinimumSize(new Dimension(78, 40));
               findCarJB.addActionListener(MainFrm.this::findCarJBActionPerformed);

               // ---- modifyCarJB ----
               modifyCarJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/edit.png"))));
               modifyCarJB.setMaximumSize(new Dimension(78, 40));
               modifyCarJB.setMinimumSize(new Dimension(78, 40));
               modifyCarJB.addActionListener(MainFrm.this::modifyCarJBActionPerformed);

               // ---- removeCarJB ----
               removeCarJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/delete.png"))));
               removeCarJB.setMaximumSize(new Dimension(78, 40));
               removeCarJB.setMinimumSize(new Dimension(78, 40));
               removeCarJB.addActionListener(MainFrm.this::removeCarJBActionPerformed);

               GroupLayout panel13Layout = new GroupLayout(panel13);
               panel13.setLayout(panel13Layout);
               panel13Layout.setHorizontalGroup(
                     panel13Layout.createParallelGroup()
                           .addGroup(panel13Layout.createSequentialGroup()
                                 .addGroup(panel13Layout.createParallelGroup()
                                       .addGroup(panel13Layout.createSequentialGroup()
                                             .addGap(22, 22, 22)
                                             .addGroup(panel13Layout.createParallelGroup()
                                                   .addGroup(panel13Layout.createSequentialGroup()
                                                         .addComponent(carSizeJL)
                                                         .addGap(12, 12, 12)
                                                         .addComponent(carSizeJTF))
                                                   .addGroup(panel13Layout.createSequentialGroup()
                                                         .addGroup(panel13Layout.createParallelGroup()
                                                               .addGroup(panel13Layout.createSequentialGroup()
                                                                     .addComponent(carSeatNumJL)
                                                                     .addGap(18, 18, 18)
                                                                     .addComponent(carSeatNumJTF,
                                                                           GroupLayout.PREFERRED_SIZE, 128,
                                                                           GroupLayout.PREFERRED_SIZE))
                                                               .addGroup(panel13Layout.createSequentialGroup()
                                                                     .addComponent(carIDJL)
                                                                     .addPreferredGap(
                                                                           LayoutStyle.ComponentPlacement.RELATED)
                                                                     .addComponent(carIDJTF, GroupLayout.PREFERRED_SIZE,
                                                                           95, GroupLayout.PREFERRED_SIZE))
                                                               .addGroup(panel13Layout.createSequentialGroup()
                                                                     .addComponent(carTonsJL)
                                                                     .addGap(18, 18, 18)
                                                                     .addComponent(carTonsJTF,
                                                                           GroupLayout.PREFERRED_SIZE, 127,
                                                                           GroupLayout.PREFERRED_SIZE))
                                                               .addGroup(panel13Layout.createSequentialGroup()
                                                                     .addComponent(carColorJL)
                                                                     .addGap(18, 18, 18)
                                                                     .addComponent(carColorJCB,
                                                                           GroupLayout.PREFERRED_SIZE,
                                                                           GroupLayout.DEFAULT_SIZE,
                                                                           GroupLayout.PREFERRED_SIZE)))
                                                         .addGroup(panel13Layout.createParallelGroup()
                                                               .addGroup(GroupLayout.Alignment.TRAILING, panel13Layout
                                                                     .createSequentialGroup()
                                                                     .addPreferredGap(
                                                                           LayoutStyle.ComponentPlacement.RELATED,
                                                                           GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                     .addComponent(carIsAutoJChB,
                                                                           GroupLayout.PREFERRED_SIZE, 88,
                                                                           GroupLayout.PREFERRED_SIZE)
                                                                     .addGap(59, 59, 59))
                                                               .addGroup(panel13Layout.createSequentialGroup()
                                                                     .addPreferredGap(
                                                                           LayoutStyle.ComponentPlacement.RELATED)
                                                                     .addGroup(panel13Layout.createParallelGroup()
                                                                           .addGroup(panel13Layout
                                                                                 .createSequentialGroup()
                                                                                 .addComponent(carTypeJL)
                                                                                 .addPreferredGap(
                                                                                       LayoutStyle.ComponentPlacement.RELATED)
                                                                                 .addComponent(carTypeJCB,
                                                                                       GroupLayout.PREFERRED_SIZE,
                                                                                       GroupLayout.DEFAULT_SIZE,
                                                                                       GroupLayout.PREFERRED_SIZE))
                                                                           .addGroup(panel13Layout
                                                                                 .createSequentialGroup()
                                                                                 .addGap(6, 6, 6)
                                                                                 .addComponent(carStatusJL)
                                                                                 .addGap(18, 18, 18)
                                                                                 .addComponent(carStatusJCB,
                                                                                       GroupLayout.PREFERRED_SIZE,
                                                                                       GroupLayout.DEFAULT_SIZE,
                                                                                       GroupLayout.PREFERRED_SIZE)))
                                                                     .addGap(0, 0, Short.MAX_VALUE))
                                                               .addGroup(panel13Layout.createSequentialGroup()
                                                                     .addGap(25, 25, 25)
                                                                     .addComponent(carFeeJL)
                                                                     .addPreferredGap(
                                                                           LayoutStyle.ComponentPlacement.RELATED)
                                                                     .addComponent(carFeeJTF))))
                                                   .addGroup(panel13Layout.createSequentialGroup()
                                                         .addGroup(panel13Layout.createParallelGroup()
                                                               .addGroup(panel13Layout.createSequentialGroup()
                                                                     .addGroup(panel13Layout.createParallelGroup()
                                                                           .addGroup(GroupLayout.Alignment.TRAILING,
                                                                                 panel13Layout.createSequentialGroup()
                                                                                       .addComponent(carBrandJL)
                                                                                       .addPreferredGap(
                                                                                             LayoutStyle.ComponentPlacement.UNRELATED))
                                                                           .addGroup(
                                                                                 panel13Layout.createSequentialGroup()
                                                                                       .addComponent(carLicenceJL)
                                                                                       .addGap(27, 27, 27)))
                                                                     .addGroup(panel13Layout
                                                                           .createParallelGroup(
                                                                                 GroupLayout.Alignment.TRAILING, false)
                                                                           .addComponent(carLicenseJTF,
                                                                                 GroupLayout.DEFAULT_SIZE, 239,
                                                                                 Short.MAX_VALUE)
                                                                           .addComponent(carBrandJTF,
                                                                                 GroupLayout.DEFAULT_SIZE, 239,
                                                                                 Short.MAX_VALUE)))
                                                               .addGroup(panel13Layout.createSequentialGroup()
                                                                     .addComponent(resetCarJB,
                                                                           GroupLayout.PREFERRED_SIZE, 85,
                                                                           GroupLayout.PREFERRED_SIZE)
                                                                     .addGap(12, 12, 12)
                                                                     .addComponent(findCarJB,
                                                                           GroupLayout.PREFERRED_SIZE, 85,
                                                                           GroupLayout.PREFERRED_SIZE)
                                                                     .addGap(6, 6, 6)
                                                                     .addComponent(modifyCarJB,
                                                                           GroupLayout.PREFERRED_SIZE, 85,
                                                                           GroupLayout.PREFERRED_SIZE)
                                                                     .addGap(12, 12, 12)
                                                                     .addComponent(removeCarJB,
                                                                           GroupLayout.PREFERRED_SIZE, 85,
                                                                           GroupLayout.PREFERRED_SIZE)))
                                                         .addGap(0, 0, Short.MAX_VALUE))))
                                       .addGroup(panel13Layout.createSequentialGroup()
                                             .addContainerGap()
                                             .addComponent(title2JL, GroupLayout.PREFERRED_SIZE, 202,
                                                   GroupLayout.PREFERRED_SIZE)
                                             .addGap(18, 18, 18)
                                             .addComponent(addCarJB, GroupLayout.PREFERRED_SIZE, 173,
                                                   GroupLayout.PREFERRED_SIZE)))
                                 .addGap(15, 15, 15)));
               panel13Layout.setVerticalGroup(
                     panel13Layout.createParallelGroup()
                           .addGroup(panel13Layout.createSequentialGroup()
                                 .addGap(14, 14, 14)
                                 .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(title2JL)
                                       .addComponent(addCarJB))
                                 .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                 .addGroup(panel13Layout.createParallelGroup()
                                       .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                             .addComponent(carIDJL)
                                             .addComponent(carTypeJL)
                                             .addComponent(carIDJTF, GroupLayout.PREFERRED_SIZE,
                                                   GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                       .addComponent(carTypeJCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE))
                                 .addGap(18, 18, 18)
                                 .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(carLicenceJL)
                                       .addComponent(carLicenseJTF, GroupLayout.PREFERRED_SIZE,
                                             GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                 .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                 .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(carBrandJL)
                                       .addComponent(carBrandJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE))
                                 .addGap(18, 18, 18)
                                 .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(carSizeJL)
                                       .addComponent(carSizeJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE))
                                 .addGap(18, 18, 18)
                                 .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(carSeatNumJL)
                                       .addComponent(carIsAutoJChB)
                                       .addComponent(carSeatNumJTF, GroupLayout.PREFERRED_SIZE,
                                             GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                 .addGap(28, 28, 28)
                                 .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(carTonsJL)
                                       .addComponent(carTonsJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addComponent(carFeeJL)
                                       .addComponent(carFeeJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE))
                                 .addGap(18, 18, 18)
                                 .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(carColorJL)
                                       .addComponent(carStatusJL)
                                       .addComponent(carStatusJCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addComponent(carColorJCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE))
                                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                 .addGroup(panel13Layout.createParallelGroup()
                                       .addComponent(resetCarJB, GroupLayout.PREFERRED_SIZE, 46,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addComponent(findCarJB, GroupLayout.PREFERRED_SIZE, 46,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addComponent(modifyCarJB, GroupLayout.PREFERRED_SIZE, 46,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addComponent(removeCarJB, GroupLayout.PREFERRED_SIZE, 46,
                                             GroupLayout.PREFERRED_SIZE))
                                 .addGap(20, 20, 20)));
            }

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                  panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(panel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                    GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(panel13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE)
                              .addGap(16, 16, 16)));
            panel3Layout.setVerticalGroup(
                  panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                              .addContainerGap()
                              .addGroup(panel3Layout.createParallelGroup()
                                    .addComponent(panel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                          Short.MAX_VALUE)
                                    .addComponent(panel13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                          Short.MAX_VALUE))
                              .addContainerGap()));
         }
         tabbedPane1.addTab("\u8f66\u8f86\u7ba1\u7406", panel3);

         // ======== panel5 ========
         {

            // ======== scrollPane5 ========
            {

               // ---- toFixJT ----
               toFixJT.setModel(new DefaultTableModel(
                     new Object[][] {
                           { null, null, null, null, null, null, null },
                           { null, null, null, null, null, null, null },
                     },
                     new String[] {
                           "\u7f16\u53f7", "\u8f66\u8f86\u7f16\u53f7", "\u7ba1\u7406\u5458\u7f16\u53f7",
                           "\u6545\u969c\u63cf\u8ff0", "\u9001\u4fee\u65e5\u671f", "\u8fd4\u8fd8\u65e5\u671f",
                           "\u603b\u82b1\u8d39"
                     }) {
                  final boolean[] columnEditable = new boolean[] {
                        false, false, false, true, true, true, true
                  };

                  @Override
                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return columnEditable[columnIndex];
                  }
               });
               toFixJT.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mousePressed(MouseEvent e) {
                     toFixJTMousePressed();
                  }
               });
               scrollPane5.setViewportView(toFixJT);
            }

            // ======== panel14 ========
            {

               // ---- maintainMessageJL ----
               maintainMessageJL.setText("\u7ef4\u4fee\u4fe1\u606f:");

               // ---- maintainCostJL ----
               maintainCostJL.setText("\u7ef4\u4fee\u82b1\u8d39:");

               // ---- maintainCntJL ----
               maintainCntJL.setText("\u7ef4\u4fee\u6b21\u6570:");

               // ---- maintainCntJTF ----
               maintainCntJTF.setEditable(false);

               // ---- rentedCntJL ----
               rentedCntJL.setText("\u88ab\u79df\u8d41\u6b21\u6570:");

               // ---- rentedCntJTF ----
               rentedCntJTF.setEditable(false);

               // ---- maintainJB ----
               maintainJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/return.png"))));
               maintainJB.addActionListener(MainFrm.this::maintainJBActionPerformed);

               GroupLayout panel14Layout = new GroupLayout(panel14);
               panel14.setLayout(panel14Layout);
               panel14Layout.setHorizontalGroup(
                     panel14Layout.createParallelGroup()
                           .addGroup(panel14Layout.createSequentialGroup()
                                 .addContainerGap()
                                 .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                       .addComponent(maintainCntJL, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                       .addComponent(maintainMessageJL, GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                       .addComponent(maintainCostJL, GroupLayout.PREFERRED_SIZE, 77,
                                             GroupLayout.PREFERRED_SIZE))
                                 .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                 .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                       .addGroup(panel14Layout.createSequentialGroup()
                                             .addComponent(maintainCntJTF, GroupLayout.PREFERRED_SIZE, 116,
                                                   GroupLayout.PREFERRED_SIZE)
                                             .addGap(18, 18, 18)
                                             .addComponent(rentedCntJL)
                                             .addGap(18, 18, 18)
                                             .addComponent(rentedCntJTF, GroupLayout.DEFAULT_SIZE, 130,
                                                   Short.MAX_VALUE))
                                       .addComponent(maintainMessageJTF)
                                       .addComponent(maintainCostJTF))
                                 .addGap(18, 18, 18)
                                 .addComponent(maintainJB, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                 .addContainerGap(35, Short.MAX_VALUE)));
               panel14Layout.setVerticalGroup(
                     panel14Layout.createParallelGroup()
                           .addGroup(panel14Layout.createSequentialGroup()
                                 .addGroup(panel14Layout.createParallelGroup()
                                       .addGroup(panel14Layout.createSequentialGroup()
                                             .addContainerGap()
                                             .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                   .addComponent(maintainMessageJL)
                                                   .addComponent(maintainMessageJTF, GroupLayout.PREFERRED_SIZE,
                                                         GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                             .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                             .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                   .addComponent(maintainCostJL)
                                                   .addComponent(maintainCostJTF, GroupLayout.PREFERRED_SIZE,
                                                         GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                             .addGap(18, 18, 18)
                                             .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                   .addComponent(maintainCntJL)
                                                   .addComponent(maintainCntJTF, GroupLayout.PREFERRED_SIZE,
                                                         GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                   .addComponent(rentedCntJL)
                                                   .addComponent(rentedCntJTF, GroupLayout.PREFERRED_SIZE,
                                                         GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                       .addGroup(panel14Layout.createSequentialGroup()
                                             .addGap(20, 20, 20)
                                             .addComponent(maintainJB, GroupLayout.PREFERRED_SIZE, 95,
                                                   GroupLayout.PREFERRED_SIZE)))
                                 .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
            }

            // ======== panel15 ========
            {

               GroupLayout panel15Layout = new GroupLayout(panel15);
               panel15.setLayout(panel15Layout);
               panel15Layout.setHorizontalGroup(
                     panel15Layout.createParallelGroup()
                           .addGap(0, 0, Short.MAX_VALUE));
               panel15Layout.setVerticalGroup(
                     panel15Layout.createParallelGroup()
                           .addGap(0, 0, Short.MAX_VALUE));
            }

            // ---- carPicJL ----
            carPicJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/car11.jpeg"))));

            // ---- titleJL ----
            titleJL.setText("==== \u7ef4\u4fee\u62a5\u8868 ====");

            GroupLayout panel5Layout = new GroupLayout(panel5);
            panel5.setLayout(panel5Layout);
            panel5Layout.setHorizontalGroup(
                  panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                              .addGap(157, 157, 157)
                              .addComponent(carPicJL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE)
                              .addGroup(panel5Layout.createParallelGroup()
                                    .addGroup(panel5Layout.createSequentialGroup()
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(panel15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                          .addGap(91, 91, 91)
                                          .addComponent(panel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                          .addGap(217, 217, 217))
                                    .addGroup(panel5Layout.createSequentialGroup()
                                          .addGap(304, 304, 304)
                                          .addComponent(titleJL)
                                          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(panel5Layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 1259, GroupLayout.PREFERRED_SIZE)
                              .addGap(0, 0, Short.MAX_VALUE)));
            panel5Layout.setVerticalGroup(
                  panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                              .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
                              .addGroup(panel5Layout.createParallelGroup()
                                    .addGroup(panel5Layout.createSequentialGroup()
                                          .addGap(81, 81, 81)
                                          .addComponent(panel15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                    .addGroup(panel5Layout.createSequentialGroup()
                                          .addGap(12, 12, 12)
                                          .addComponent(carPicJL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                    .addGroup(panel5Layout.createSequentialGroup()
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(titleJL)
                                          .addGap(18, 18, 18)
                                          .addComponent(panel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                          .addGap(12, 12, 12)))
                              .addContainerGap(22, Short.MAX_VALUE)));
         }
         tabbedPane1.addTab("\u7ef4\u4fee", panel5);

         // ======== panel6 ========
         {

            // ======== scrollPane2 ========
            {

               // ---- rentedHisTable ----
               rentedHisTable.setModel(new DefaultTableModel(
                     new Object[][] {
                           { "0", null, "1", null, null, null, null, null, null, null, null, null },
                           { null, null, "1", null, null, null, null, null, null, "21/09/02", null, null },
                     },
                     new String[] {
                           "\u7528\u6237\u7f16\u53f7", "\u7528\u6237\u540d", "\u8f66\u8f86\u7f16\u53f7",
                           "\u8f66\u8f86\u7c7b\u578b", "\u8f66\u8f86\u54c1\u724c", "\u8f66\u5ea7\u6570",
                           "\u8f66\u724c\u53f7", "\u8f66\u8f86\u989c\u8272", "\u79df\u8f66\u65e5\u671f",
                           "\u8fd8\u8f66\u65e5\u671f", "\u79df\u8d41\u5929\u6570", "\u603b\u79df\u91d1"
                     }) {
                  final boolean[] columnEditable = new boolean[] {
                        true, true, false, false, false, false, false, false, false, false, false, false
                  };

                  @Override
                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return columnEditable[columnIndex];
                  }
               });
               scrollPane2.setViewportView(rentedHisTable);
            }

            GroupLayout panel6Layout = new GroupLayout(panel6);
            panel6.setLayout(panel6Layout);
            panel6Layout.setHorizontalGroup(
                  panel6Layout.createParallelGroup()
                        .addGroup(panel6Layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
                              .addContainerGap()));
            panel6Layout.setVerticalGroup(
                  panel6Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)));
         }
         tabbedPane1.addTab("\u79df\u8d41\u5386\u53f2\u8bb0\u5f55\u8868", panel6);

         // ======== panel7 ========
         {

            // ---- label6 ----
            label6.setText("\u4ece");

            // ---- label14 ----
            label14.setText("\u6b21, \u7ef4\u4fee\u8f66\u8f86");

            // ---- label15 ----
            label15.setText("\u6b21.");

            // ---- label16 ----
            label16.setText("\u603b\u5171\u82b1\u8d39\u4e86");

            // ---- label17 ----
            label17.setText(", \u51c0\u6536\u5165");

            // ---- label18 ----
            label18.setText(".");

            // ---- updateProfitJB ----
            updateProfitJB.setText("\u67e5\u8be2");
            updateProfitJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/idea.png"))));
            updateProfitJB.addActionListener(MainFrm.this::updateProfitJBActionPerformed);

            // ======== scrollPane6 ========
            {

               // ---- hisFixJT ----
               hisFixJT.setModel(new DefaultTableModel(
                     new Object[][] {
                           { null, null, null, null, null, null, null },
                           { null, null, null, null, null, null, null },
                     },
                     new String[] {
                           "\u7f16\u53f7", "\u8f66\u8f86\u7f16\u53f7", "\u7ba1\u7406\u5458\u7f16\u53f7",
                           "\u6545\u969c\u63cf\u8ff0", "\u9001\u4fee\u65e5\u671f", "\u8fd4\u8fd8\u65e5\u671f",
                           "\u603b\u82b1\u8d39"
                     }) {
                  final boolean[] columnEditable = new boolean[] {
                        false, false, false, true, true, true, true
                  };

                  @Override
                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return columnEditable[columnIndex];
                  }
               });
               scrollPane6.setViewportView(hisFixJT);
            }

            // ---- label19 ----
            label19.setText("\u5230");

            // ---- label20 ----
            label20.setText("\u7d2f\u8ba1\u79df\u51fa\u8f66\u8f86");

            GroupLayout panel7Layout = new GroupLayout(panel7);
            panel7.setLayout(panel7Layout);
            panel7Layout.setHorizontalGroup(
                  panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                              .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel7Layout.createSequentialGroup()
                                          .addGap(18, 18, 18)
                                          .addGroup(
                                                panel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                      .addGroup(panel7Layout.createSequentialGroup()
                                                            .addComponent(label16)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(totCostJTF, GroupLayout.PREFERRED_SIZE, 102,
                                                                  GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(label17))
                                                      .addGroup(panel7Layout.createSequentialGroup()
                                                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 34,
                                                                  GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(stDateJTF)))
                                          .addGap(18, 18, 18)
                                          .addGroup(panel7Layout.createParallelGroup()
                                                .addGroup(panel7Layout.createSequentialGroup()
                                                      .addComponent(totProfitJTF, GroupLayout.PREFERRED_SIZE, 130,
                                                            GroupLayout.PREFERRED_SIZE)
                                                      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                      .addComponent(label18))
                                                .addGroup(panel7Layout.createSequentialGroup()
                                                      .addGap(51, 51, 51)
                                                      .addComponent(label19)))
                                          .addGap(18, 18, 18)
                                          .addGroup(panel7Layout.createParallelGroup()
                                                .addGroup(panel7Layout.createSequentialGroup()
                                                      .addComponent(edDateJTF, GroupLayout.PREFERRED_SIZE, 301,
                                                            GroupLayout.PREFERRED_SIZE)
                                                      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                      .addComponent(label20, GroupLayout.PREFERRED_SIZE, 182,
                                                            GroupLayout.PREFERRED_SIZE)
                                                      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                      .addComponent(totRentedCarsJTF, GroupLayout.PREFERRED_SIZE, 99,
                                                            GroupLayout.PREFERRED_SIZE)
                                                      .addGap(18, 18, 18)
                                                      .addComponent(label14)
                                                      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                      .addComponent(totFixedCarsNumJTF, GroupLayout.PREFERRED_SIZE,
                                                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                      .addComponent(label15))
                                                .addGroup(panel7Layout.createSequentialGroup()
                                                      .addGap(232, 232, 232)
                                                      .addComponent(updateProfitJB)
                                                      .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(panel7Layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addComponent(scrollPane6, GroupLayout.PREFERRED_SIZE, 1259,
                                                GroupLayout.PREFERRED_SIZE)))
                              .addContainerGap(11, Short.MAX_VALUE)));
            panel7Layout.setVerticalGroup(
                  panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(scrollPane6, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
                              .addGap(27, 27, 27)
                              .addGroup(panel7Layout.createParallelGroup()
                                    .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                          .addComponent(label6)
                                          .addComponent(stDateJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                          .addComponent(label19)
                                          .addComponent(edDateJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                          .addComponent(label14)
                                          .addComponent(totFixedCarsNumJTF, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                          .addComponent(label15)
                                          .addComponent(label20)
                                          .addComponent(totRentedCarsJTF, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                              .addGap(27, 27, 27)
                              .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label16)
                                    .addComponent(totCostJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                          GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label17)
                                    .addComponent(totProfitJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                          GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label18)
                                    .addComponent(updateProfitJB))
                              .addContainerGap(51, Short.MAX_VALUE)));
         }
         tabbedPane1.addTab("\u7ef4\u4fee\u5386\u53f2\u8bb0\u5f55\u8868", panel7);

         // ======== panel9 ========
         {

            // ======== aboutAuthorJP ========
            {

               // ---- link1JB ----
               link1JB.setText("\u5173\u6ce8\u4f5c\u8005\u7684\u535a\u5ba2 teko7a.github.io");
               link1JB.addActionListener(MainFrm.this::link1JBActionPerformed);

               // ---- link2JB ----
               link2JB.setText("\u5173\u6ce8\u4f5c\u8005\u7684BiliBili");
               link2JB.addActionListener(MainFrm.this::link2JBActionPerformed);

               // ---- madeWithJL ----
               madeWithJL.setText("   Made With Java16");
               madeWithJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/java.png"))));

               // ---- picJL ----
               picJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/author.png"))));

               GroupLayout aboutAuthorJPLayout = new GroupLayout(aboutAuthorJP);
               aboutAuthorJP.setLayout(aboutAuthorJPLayout);
               aboutAuthorJPLayout.setHorizontalGroup(
                     aboutAuthorJPLayout.createParallelGroup()
                           .addGroup(GroupLayout.Alignment.TRAILING, aboutAuthorJPLayout.createSequentialGroup()
                                 .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 .addGroup(aboutAuthorJPLayout.createParallelGroup()
                                       .addComponent(link1JB, GroupLayout.PREFERRED_SIZE, 318,
                                             GroupLayout.PREFERRED_SIZE)
                                       .addGroup(aboutAuthorJPLayout.createSequentialGroup()
                                             .addGap(32, 32, 32)
                                             .addComponent(picJL, GroupLayout.PREFERRED_SIZE, 207,
                                                   GroupLayout.PREFERRED_SIZE)
                                             .addGap(18, 18, 18)
                                             .addGroup(aboutAuthorJPLayout.createParallelGroup()
                                                   .addGroup(aboutAuthorJPLayout.createSequentialGroup()
                                                         .addGap(245, 245, 245)
                                                         .addComponent(madeWithJL, GroupLayout.PREFERRED_SIZE, 279,
                                                               GroupLayout.PREFERRED_SIZE))
                                                   .addComponent(link2JB, GroupLayout.PREFERRED_SIZE, 231,
                                                         GroupLayout.PREFERRED_SIZE))))
                                 .addGap(143, 143, 143)));
               aboutAuthorJPLayout.setVerticalGroup(
                     aboutAuthorJPLayout.createParallelGroup()
                           .addGroup(aboutAuthorJPLayout.createSequentialGroup()
                                 .addGap(60, 60, 60)
                                 .addComponent(link1JB, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                 .addGroup(aboutAuthorJPLayout.createParallelGroup()
                                       .addGroup(aboutAuthorJPLayout.createSequentialGroup()
                                             .addGap(66, 66, 66)
                                             .addComponent(link2JB, GroupLayout.PREFERRED_SIZE, 61,
                                                   GroupLayout.PREFERRED_SIZE)
                                             .addGap(33, 33, 33)
                                             .addComponent(madeWithJL, GroupLayout.PREFERRED_SIZE, 78,
                                                   GroupLayout.PREFERRED_SIZE)
                                             .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                       .addGroup(GroupLayout.Alignment.TRAILING,
                                             aboutAuthorJPLayout.createSequentialGroup()
                                                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                         GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                   .addComponent(picJL, GroupLayout.PREFERRED_SIZE, 193,
                                                         GroupLayout.PREFERRED_SIZE)
                                                   .addGap(63, 63, 63)))));
            }

            GroupLayout panel9Layout = new GroupLayout(panel9);
            panel9.setLayout(panel9Layout);
            panel9Layout.setHorizontalGroup(
                  panel9Layout.createParallelGroup()
                        .addGroup(panel9Layout.createParallelGroup()
                              .addGroup(panel9Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(aboutAuthorJP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                          GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 1282, Short.MAX_VALUE));
            panel9Layout.setVerticalGroup(
                  panel9Layout.createParallelGroup()
                        .addGroup(panel9Layout.createParallelGroup()
                              .addGroup(panel9Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(aboutAuthorJP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                          GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 497, Short.MAX_VALUE));
         }
         tabbedPane1.addTab("\u5173\u4e8e\u4f5c\u8005", panel9);
      }

      // ======== panel1 ========
      {

         // ---- logoJL ----
         logoJL.setText("    T-Rentor");
         logoJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/find.png"))));

         // ---- curUsrJL ----
         curUsrJL.setText("\u5f53\u524d\u7ba1\u7406\u5458\uff1a");
         curUsrJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/manager.png"))));

         // ---- name_idJL ----
         name_idJL.setText("usrName(id : )");

         // ---- logoutJB ----
         logoutJB.setText("\u9000\u51fa\u767b\u5f55");
         logoutJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/exit.png"))));
         logoutJB.addActionListener(e -> MainFrm.this.logoutJBActionPerformed());

         // ---- todayJL ----
         todayJL.setText("\u4eca\u5929\u662f:yy/MM/dd");
         todayJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/ballons.png"))));

         GroupLayout panel1Layout = new GroupLayout(panel1);
         panel1.setLayout(panel1Layout);
         panel1Layout.setHorizontalGroup(
               panel1Layout.createParallelGroup()
                     .addGroup(panel1Layout.createSequentialGroup()
                           .addGap(147, 147, 147)
                           .addComponent(logoJL, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                           .addGap(44, 44, 44)
                           .addComponent(todayJL)
                           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                           .addComponent(curUsrJL)
                           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                           .addComponent(name_idJL, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                           .addGap(55, 55, 55)
                           .addComponent(logoutJB)
                           .addGap(129, 129, 129)));
         panel1Layout.setVerticalGroup(
               panel1Layout.createParallelGroup()
                     .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                           .addContainerGap(37, Short.MAX_VALUE)
                           .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                 .addComponent(curUsrJL)
                                 .addComponent(name_idJL, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                 .addComponent(logoutJB))
                           .addGap(32, 32, 32))
                     .addGroup(panel1Layout.createSequentialGroup()
                           .addGap(18, 18, 18)
                           .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                 .addComponent(logoJL, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                 .addComponent(todayJL))
                           .addContainerGap(18, Short.MAX_VALUE)));
      }

      GroupLayout contentPaneLayout = new GroupLayout(contentPane);
      contentPane.setLayout(contentPaneLayout);
      contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                  .addGroup(contentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPaneLayout.createParallelGroup()
                              .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 1282, Short.MAX_VALUE))
                        .addContainerGap()));
      contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                  .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                              Short.MAX_VALUE)
                        .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)));
      pack();
      setLocationRelativeTo(getOwner());
   }

   private JTable usrJT;
   private JTextField idJTF;
   private JTextField nameJTF;
   private JTextField passwordJTF;
   private JTextField rNameJTF;
   private JTextField idcJTF;
   private JTextField telJTF;
   private JTextField curJTF;
   private JTextField hisJTF;
   private JTable carJT;
   private JTextField carIDJTF;
   private JTextField carLicenseJTF;
   private JTextField carBrandJTF;
   private JTextField carSizeJTF;
   private JTextField carSeatNumJTF;
   private JCheckBox carIsAutoJChB;
   private JComboBox<String> carStatusJCB;
   private JComboBox<String> carColorJCB;
   private JComboBox<String> carTypeJCB;
   private JTextField carTonsJTF;
   private JTextField carFeeJTF;
   private JTable toFixJT;
   private JTextField maintainMessageJTF;
   private JTextField maintainCostJTF;
   private JTextField maintainCntJTF;
   private JTextField rentedCntJTF;
   private JTable rentedHisTable;
   private JTextField totRentedCarsJTF;
   private JTextField totFixedCarsNumJTF;
   private JTextField totCostJTF;
   private JTextField totProfitJTF;
   private JTable hisFixJT;
   private JTextField stDateJTF;
   private JTextField edDateJTF;
   private JLabel name_idJL;
   private JLabel todayJL;
}
