package teko7a.Frames.Usr;

import teko7a.DAOs.CarDAO;
import teko7a.DAOs.RentedDAO;
import teko7a.Frames.Welcome.LoginFrm;
import teko7a.Models.Car;
import teko7a.Models.Rented;
import teko7a.Models.Usr;
import teko7a.Utils.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Vector;

enum Orders {RETURN, UNRETURNED}

/**
 * 用户主界面
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/30
 */
public class MainFrm extends JFrame {
   // ==== Usr ====
   Usr curUsr = null;

   // ==== variables reliable ====
   DataBaseUtil dbUtil = new DataBaseUtil();
   CarDAO carDao = new CarDAO();
   RentedDAO rentedDAO = new RentedDAO();

   // ==== components ====
   private JTable rentTable;
   private JTextField carIdJTF;
   private JComboBox<String> typeJCB;
   private JTextField brandJTF;
   private JTextField sizeJTF;
   private JTextField seatNumJTF;
   private JCheckBox autoJChB;
   private JComboBox<String> colorJCB;
   private JTextField tonsJTF;
   private JTextField fee_lowJTF;
   private JTextField fee_highJTF;
   private JTable toReturnJT;
   private JTable historyJT;
   private JLabel name_idJL;

   public MainFrm() {
      FrmUtil.setFont();
      initComponents();
      this.setLocationRelativeTo(null);
      this.fillRentTable(new Car());
   }

   public MainFrm(Usr curUsr) {
      this();
      this.curUsr = curUsr;
      this.name_idJL.setText("usrName(id : " + curUsr.getId() + ")");
      this.fillRentTable(new Car());
      this.fillToReturnJT(curUsr, Orders.UNRETURNED);
      this.fillHistoryJT(curUsr);
   }

   /**
    * 表格 {@code rentTable} 行点击事件：点击某一行，会在右侧显示出详细数据。
    *
    * @author: tekola (teko7a@github.io)
    */
   private void rentTableMousePressed() {
      int row = this.rentTable.getSelectedRow();
      this.carIdJTF.setText(String.valueOf(rentTable.getValueAt(row, 0)));

      String carTypeName = (String) rentTable.getValueAt(row, 1);
      int carTypeOrder = typeJCB.getItemCount();
      for (int i = 0; i < carTypeOrder; i++) {
         if (typeJCB.getItemAt(i).equals(carTypeName)) {
            typeJCB.setSelectedIndex(i);
         }
      }

      this.brandJTF.setText((String) rentTable.getValueAt(row, 3));
      this.sizeJTF.setText((String) rentTable.getValueAt(row, 4));
      this.seatNumJTF.setText(String.valueOf(rentTable.getValueAt(row, 5)));

      String carColor = (String) rentTable.getValueAt(row, 8);
      int carColorOrder = colorJCB.getItemCount();
      for (int i = 0; i < carColorOrder; i++) {
         if (colorJCB.getItemAt(i).equals(carColor)) {
            colorJCB.setSelectedIndex(i);
         }
      }

      this.autoJChB.setSelected("1".equals(rentTable.getValueAt(row, 6).toString()));
      this.tonsJTF.setText((String) rentTable.getValueAt(row, 7));
      this.fee_lowJTF.setText((String) rentTable.getValueAt(row, 9));
      this.fee_highJTF.setText((String) rentTable.getValueAt(row, 9));
   }

   /**
    * 搜索事件处理
    */
   private void searchButtonActionPerformed() {
      // 不需要做非空判断
      boolean isCarAuto = this.autoJChB.isSelected();
      String carType = Objects.equals(this.typeJCB.getSelectedItem(), "请选择...") ? null : (String) this.typeJCB.getSelectedItem();
      String carBrand = this.brandJTF.getText();
      String carSize = this.sizeJTF.getText();
      String carColor = Objects.equals(this.colorJCB.getSelectedItem(), "请选择..") ? null : (String) this.colorJCB.getSelectedItem();
      String carWater = this.tonsJTF.getText();
      String carSeatNum = this.seatNumJTF.getText();
      String carLow = this.fee_lowJTF.getText();
      String carHigh = this.fee_highJTF.getText();

      boolean ok = StringUtil.isNotEmpty(carBrand) || StringUtil.isNotEmpty(carSize)
            || StringUtil.isNotEmpty(carWater) || StringUtil.isNotEmpty(carSeatNum)
            || StringUtil.isNotEmpty(carLow) || StringUtil.isNotEmpty(carHigh)
            || StringUtil.isNotEmpty(carType) || StringUtil.isNotEmpty(carColor);
      Car car;

      // **** 检验 carSeatNum 是否有效 ****
      if (ok) {
         int carSeats = -1;
         if (StringUtil.isNotEmpty(carSeatNum)) {
            carSeatNum = carSeatNum.trim();
            if (StringUtil.isPositiveDigit(carSeatNum)) {
               carSeats = Integer.parseInt(carSeatNum);
            } else {
               StringUtil.log("请输入有效的座数！");
               return;
            }
         }
         car = new Car(carType, carBrand, carSize, carSeats, carWater, carColor, isCarAuto ? 1 : 0);
      } else {
         StringUtil.log("请至少输入一项有效内容！");
         this.resetRentTable();
         return;
      }

      // **** 检验 low, high 是否有效， 如果两者都是有效的那么应当 assert low <= high ****
      int low = -1, high = -1;
      if (StringUtil.isEmpty(carLow)) low = 0;
      else if (!StringUtil.isPositiveDigit(carLow)) {
         StringUtil.log("请输入正确的下界！");
         this.fee_lowJTF.setText("");
      } else {
         low = Integer.parseInt(carLow);
      }

      if (StringUtil.isEmpty(carHigh)) high = Integer.MAX_VALUE;
      else if (!StringUtil.isPositiveDigit(carHigh)) {
         StringUtil.log("请输入正确的上界！");
         this.fee_highJTF.setText("");
      } else {
         high = Integer.parseInt(carHigh);
      }

      if (low > high) {
         int t = low;
         low = high;
         high = t;
      }
      if (low == high && low == 0) {
         int confirm = JOptionPane.showConfirmDialog(null, "注意，该范围不能查询到任何值!\n仍要继续吗？");
         if (confirm == 0) {
            this.resetRentTable();
            this.fillRentTable(null);
         } else {
            this.fee_lowJTF.setText("");
            this.fee_highJTF.setText("");
         }
      }

      // **** 执行查找操作 ****
      Connection con = null;
      try {
         con = dbUtil.getCon();
         car.setStatus(1);
         ResultSet rs = carDao.query(con, car, low, high);
         fillTableHelper(rs, rentTable);
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

   /**
    * {@code RentTable} 填充方法， 帮助用户筛选出所有状态为 {@code 1 : 可租} 的车辆。
    *
    * @param car {@code CarDao} 依赖
    */
   private void fillRentTable(Car car) {
      if (car == null) {
         DefaultTableModel dtm = (DefaultTableModel) rentTable.getModel();
         dtm.setRowCount(0);
      }
      Connection con = null;
      try {
         con = dbUtil.getCon();
         ResultSet rs = carDao.list(con, car);
         fillTableHelper(rs, rentTable);
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

   /**
    * {@code ToReturnJT} 填充方法， 选出所有的未还车辆。默认不会出现同时租多辆车的情况
    *
    * @param usr   用户
    * @param ORDER 命令， 是一个枚举类， 仅有两个值。当为 'RETURN' 时，可以进行还车；反之可以计算当前的租金。
    */
   private void fillToReturnJT(Usr usr, Orders ORDER) {
      Connection con = null;
      try {
         con = dbUtil.getCon();
         ResultSet rs = rentedDAO.listUnreturned(con, usr);
         Car car = null;
         while (rs.next()) {
            int delta = DateUtil.getDelta(rs.getString("tr.stDate"));
            int fee = carDao.detail(con, rs.getInt("tc.id")).getCost();
            car = carDao.detail(con, rs.getInt("tc.id"));
            int cost = delta * fee;
            String edDate = ORDER == Orders.RETURN ? DateUtil.getToday() : null;
            Rented cur = new Rented(rs.getInt("tr.id"), rs.getInt("tr.usrID"), rs.getInt("tc.id"), rs.getString("tr.stDate"), edDate, delta, cost);
            int res = rentedDAO.update(con, cur);
            if (res != 1) {
               StringUtil.log("失败！");
               return;
            }
         }
         if (ORDER == Orders.RETURN) {
            assert car != null;
            car.setStatus(1);
            carDao.update(con, car);
            this.fillRentTable(new Car());
         }
         rs = rentedDAO.listUnreturned(con, usr);
         fillTableHelper2(rs, toReturnJT);
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

   /**
    * {@code HistoryJT} 填充方法，填充所有用户租车历史条。
    *
    * @param usr 用户
    */
   private void fillHistoryJT(Usr usr) {
      Connection con = null;
      try {
         con = dbUtil.getCon();
         ResultSet rs = rentedDAO.list(con, usr);
         fillTableHelper3(rs, historyJT);
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

   /**
    * 工具类
    *
    * @param rs        表信息
    * @param rentTable 表
    * @throws SQLException 异常
    */
   private void fillTableHelper(ResultSet rs, JTable rentTable) throws SQLException {
      DefaultTableModel dtm = (DefaultTableModel) rentTable.getModel();
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

   /**
    * 工具类
    *
    * @param rs         表信息
    * @param toReturnJT 表
    * @throws SQLException 异常
    */
   private void fillTableHelper2(ResultSet rs, JTable toReturnJT) throws SQLException {
      DefaultTableModel dtm = (DefaultTableModel) toReturnJT.getModel();
      dtm.setRowCount(0);
      while (rs.next()) {
         Vector<String> v = new Vector<>();
            /*
             "SELECT tc.id, tc.type, tc.brand, tc.seatNum, tc.license, tc.color, tr.stDate, NULL, tr.edDate, tr.cost " +
             "FROM t_rented tr, t_car tc WHERE tr.carID = tc.id AND usrID = '" + usr.getId() + "' AND edDate IS NULL";
            */
         v.add(String.valueOf(rs.getInt("tc.id")));
         v.add(rs.getString("tc.type"));
         v.add(rs.getString("tc.brand"));
         v.add(rs.getString("tc.seatNum"));
         v.add(rs.getString("tc.license"));
         v.add(rs.getString("tc.color"));
         v.add(rs.getString("tr.stDate"));
         v.add(null);
         v.add(rs.getString("tr.dates"));
         v.add(String.valueOf(rs.getInt("tr.cost")));
         dtm.addRow(v);
      }
   }

   /**
    * 工具类
    *
    * @param rs        表信息
    * @param historyJT 表
    * @throws SQLException 异常
    */
   private void fillTableHelper3(ResultSet rs, JTable historyJT) throws SQLException {
      DefaultTableModel dtm = (DefaultTableModel) historyJT.getModel();
      dtm.setRowCount(0);
      while (rs.next()) {
         Vector<String> v = new Vector<>();
         v.add(String.valueOf(rs.getInt("tc.id")));
         v.add(rs.getString("tc.type"));
         v.add(rs.getString("tc.brand"));
         v.add(rs.getString("tc.seatNum"));
         v.add(rs.getString("tc.license"));
         v.add(rs.getString("tc.color"));
         v.add(rs.getString("tr.stDate"));
         v.add(rs.getString("tr.edDate"));
         v.add(rs.getString("tr.dates"));
         v.add(String.valueOf(rs.getInt("tr.cost")));
         dtm.addRow(v);
      }
   }

   /**
    * 重置已经填写的信息
    */
   private void resetButtonActionPerformed() {
      this.resetRentTable();
   }

   /**
    * 上面函数的重载形式，便于其他函数调用。
    */
   private void resetRentTable() {
      this.carIdJTF.setText("");
      this.typeJCB.setSelectedIndex(0);
      this.brandJTF.setText("");
      this.sizeJTF.setText("");
      this.seatNumJTF.setText("");
      this.colorJCB.setSelectedIndex(0);
      this.autoJChB.setSelected(true);
      this.tonsJTF.setText("");
      this.fee_lowJTF.setText("");
      this.fee_highJTF.setText("");
   }

   /**
    * 填充 {@code rentTable} 的函数
    */
   private void resetActionPerformed() {
      this.fillRentTable(new Car());
   }

   /**
    * 租车事件处理
    */
   private void rentButtonActionPerformed() {
      if (this.rentTable.getSelectedRow() == -1) {
         StringUtil.log("请点击左边的表格以选中一辆车！\nPlease click left table so as to select 1 car.");
         return;
      }
      int row = this.rentTable.getSelectedRow();
      Connection con = null;
      try {
         con = dbUtil.getCon();

         if (rentedDAO.hasUnreturned(con, curUsr)) {
            StringUtil.log("租用失败！您有未还车辆！");
            this.resetRentTable();
            this.fillRentTable(new Car());
            return;
         }

         Car car = carDao.detail(con, Integer.parseInt((String) rentTable.getValueAt(row, 0)));
         if (curUsr == null) {
            curUsr = new Usr();
            curUsr.setId(1);
         }
         Rented rented = new Rented(-1, curUsr.getId(), car.getId(), DateUtil.getToday(), null, 1, 0);
         int res = rentedDAO.add(con, rented);
         if (res != 1) {
            StringUtil.log("Fail to operate!");
            return;
         }
         car.setStatus(0);
         int result = carDao.update(con, car);
         if (result != 1) {
            StringUtil.log("租用失败");
         }

         this.fillRentTable(new Car());
         this.fillToReturnJT(curUsr, Orders.UNRETURNED);

         StringUtil.log("租用成功");
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

   /**
    * 还车事件处理
    */
   private void returnJBActionPerformed() {
      fillToReturnJT(curUsr, Orders.RETURN);
      fillHistoryJT(curUsr);
      StringUtil.log("还车成功！");
   }

   /**
    * 退出事件处理
    */
   private void logoutJBActionPerformed() {
      int confirm = JOptionPane.showConfirmDialog(null, "确认退出系统吗？\n再检查下还有没有要做的事哦～");
      if (confirm == 0) {
         this.dispose();
         FrmUtil.openFrm(new LoginFrm());
      }
   }

   private void link1JBActionPerformed() {
      UrlLinkUtil.openUrl("https://teko7a.github.io");
   }

   private void link2JBActionPerformed() {
      UrlLinkUtil.openUrl("https://space.bilibili.com/22754284");
   }

   private void initComponents() {
      JTabbedPane tabbedPane1 = new JTabbedPane();
      JPanel panel2 = new JPanel();
      JScrollPane scrollPane1 = new JScrollPane();
      rentTable = new JTable();
      JPanel panel12 = new JPanel();
      JLabel title1JL = new JLabel();
      JLabel carIdJL = new JLabel();
      carIdJTF = new JTextField();
      JLabel typeJL = new JLabel();
      typeJCB = new JComboBox<>();
      JLabel brandJL = new JLabel();
      brandJTF = new JTextField();
      JLabel sizeJL = new JLabel();
      sizeJTF = new JTextField();
      JLabel seatNumJL = new JLabel();
      seatNumJTF = new JTextField();
      autoJChB = new JCheckBox();
      JLabel colorJL = new JLabel();
      colorJCB = new JComboBox<>();
      JLabel tonsJL = new JLabel();
      tonsJTF = new JTextField();
      JLabel unit1JL = new JLabel();
      JLabel title2JL = new JLabel();
      JButton searchJB = new JButton();
      JButton resetJB = new JButton();
      JLabel feeJL = new JLabel();
      fee_lowJTF = new JTextField();
      JLabel toJL = new JLabel();
      fee_highJTF = new JTextField();
      JLabel unit2JL = new JLabel();
      JButton refillJB = new JButton();
      JButton rentJB = new JButton();
      JPanel panel3 = new JPanel();
      JLabel remainToReturnJL = new JLabel();
      JScrollPane scrollPane3 = new JScrollPane();
      toReturnJT = new JTable();
      JButton returnJB = new JButton();
      JLabel carPicJL = new JLabel();
      JPanel panel4 = new JPanel();
      JScrollPane scrollPane2 = new JScrollPane();
      historyJT = new JTable();
      JPanel aboutAuthorJP = new JPanel();
      JButton link1JB = new JButton();
      JButton link2JB = new JButton();
      JLabel madeWithJL = new JLabel();
      JLabel picJL = new JLabel();
      JPanel panel1 = new JPanel();
      JLabel curUsrJL = new JLabel();
      name_idJL = new JLabel();
      JButton logoutJB = new JButton();
      JLabel logoJL = new JLabel();

      //======== this ========
      setTitle("\u4f18\u79c0\u7684\u79df\u8f66\u7cfb\u7edf\u4e3a\u60a8\u670d\u52a1\uff01");
      setResizable(false);
      var contentPane = getContentPane();

      //======== tabbedPane1 ========
      {

         //======== panel2 ========
         {
            panel2.addPropertyChangeListener(e -> {
               if ("\u0062or\u0064er".
                     equals(e.getPropertyName())) throw new RuntimeException();
            });

            //======== scrollPane1 ========
            {

               //---- rentTable ----
               rentTable.setModel(new DefaultTableModel(
                     new Object[][]{
                           {"1", "SUV", "45564", "asdfgh", "5345", "4554", "1", "4554", "\u7ea2\u8272", "99999"},
                     },
                     new String[]{
                           "\u7f16\u53f7", "\u8f66\u8f86\u7c7b\u578b", "\u8f66\u724c\u53f7", "\u8f66\u8f86\u54c1\u724c", "\u8f66\u8f86\u578b\u53f7", "\u5ea7\u4f4d\u6570", "\u81ea\u52a8\u6863", "\u6392\u91cf(T)", "\u989c\u8272", "\u65e5\u79df\u91d1"
                     }
               ) {
                  final Class<?>[] columnTypes = new Class<?>[]{
                        String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
                  };
                  final boolean[] columnEditable = new boolean[]{
                        false, false, false, false, false, false, false, false, false, false
                  };

                  @Override
                  public Class<?> getColumnClass(int columnIndex) {
                     return columnTypes[columnIndex];
                  }

                  @Override
                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return columnEditable[columnIndex];
                  }
               });
               {
                  TableColumnModel cm = rentTable.getColumnModel();
                  cm.getColumn(0).setResizable(false);
                  cm.getColumn(1).setResizable(false);
                  cm.getColumn(1).setCellEditor(new DefaultCellEditor(
                        new JComboBox<>(new DefaultComboBoxModel<>(new String[]{
                              "SUV"
                        }))));
                  cm.getColumn(2).setResizable(false);
                  cm.getColumn(3).setResizable(false);
                  cm.getColumn(3).setCellEditor(new DefaultCellEditor(
                        new JComboBox<>(new DefaultComboBoxModel<>(new String[]{
                              "asdfgh"
                        }))));
                  cm.getColumn(4).setResizable(false);
                  cm.getColumn(5).setResizable(false);
                  cm.getColumn(6).setResizable(false);
                  cm.getColumn(6).setCellEditor(new DefaultCellEditor(
                        new JComboBox<>(new DefaultComboBoxModel<>(new String[]{
                              "1"
                        }))));
                  cm.getColumn(7).setResizable(false);
                  cm.getColumn(8).setResizable(false);
                  cm.getColumn(9).setResizable(false);
               }
               rentTable.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
               rentTable.addMouseListener(new MouseAdapter() {
                  @Override public void mousePressed(MouseEvent e) {
                     rentTableMousePressed();
                  }
               });
               scrollPane1.setViewportView(rentTable);
            }

            //======== panel12 ========
            {

               //---- title1JL ----
               title1JL.setText("  ==== \u8f66\u8f86\u4fe1\u606f\u4e00\u89c8\u8868 ====");

               //---- carIdJL ----
               carIdJL.setText("\u7f16\u53f7\uff1a");

               //---- carIdJTF ----
               carIdJTF.setEditable(false);

               //---- typeJL ----
               typeJL.setText("\u7c7b\u578b\uff1a");

               //---- typeJCB ----
               typeJCB.setModel(new DefaultComboBoxModel<>(new String[]{
                     "\u8bf7\u9009\u62e9...",
                     "\u7ecf\u6d4e\u578b",
                     "\u8212\u9002\u578b",
                     "SUV",
                     "\u5546\u52a1\u578b",
                     "\u7535\u52a8\u578b",
                     "\u9ad8\u7aef\u8f66"
               }));

               //---- brandJL ----
               brandJL.setText("\u54c1\u724c\uff1a");

               //---- sizeJL ----
               sizeJL.setText("\u8f66\u578b\uff1a");

               //---- seatNumJL ----
               seatNumJL.setText("\u5ea7\u6570\uff1a");

               //---- autoJChB ----
               autoJChB.setText("\u81ea\u52a8\u6863");
               autoJChB.setSelected(true);

               //---- colorJL ----
               colorJL.setText("\u989c\u8272\uff1a");

               //---- colorJCB ----
               colorJCB.setModel(new DefaultComboBoxModel<>(new String[]{
                     "\u8bf7\u9009\u62e9..",
                     "\u767d\u8272",
                     "\u9ed1\u8272",
                     "\u7070\u8272",
                     "\u7ea2\u8272"
               }));

               //---- tonsJL ----
               tonsJL.setText("\u6392\u91cf\uff1a");

               //---- unit1JL ----
               unit1JL.setText("T");

               //---- title2JL ----
               title2JL.setText("  ==== \u9009\u62e9\u64cd\u4f5c ====");

               //---- searchJB ----
               searchJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/searchCar.png"))));
               searchJB.addActionListener(e -> searchButtonActionPerformed());

               //---- resetJB ----
               resetJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/resetButton.png"))));
               resetJB.addActionListener(e -> resetButtonActionPerformed());

               //---- feeJL ----
               feeJL.setText("\u65e5\u79df\uff1a");

               //---- toJL ----
               toJL.setText("\uff5e");

               //---- unit2JL ----
               unit2JL.setText("\u5706");

               //---- refillJB ----
               refillJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/reset.png"))));
               refillJB.addActionListener(e -> resetActionPerformed());

               GroupLayout panel12Layout = new GroupLayout(panel12);
               panel12.setLayout(panel12Layout);
               panel12Layout.setHorizontalGroup(
                     panel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                           .addGroup(panel12Layout.createSequentialGroup()
                                 .addGap(16, 16, 16)
                                 .addGroup(panel12Layout.createParallelGroup()
                                       .addGroup(panel12Layout.createSequentialGroup()
                                             .addGroup(panel12Layout.createParallelGroup()
                                                   .addGroup(panel12Layout.createSequentialGroup()
                                                         .addGap(51, 51, 51)
                                                         .addComponent(title2JL, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
                                                   .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                         .addGroup(GroupLayout.Alignment.LEADING, panel12Layout.createSequentialGroup()
                                                               .addGap(33, 33, 33)
                                                               .addComponent(searchJB, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                               .addComponent(resetJB, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                                                         .addGroup(GroupLayout.Alignment.LEADING, panel12Layout.createSequentialGroup()
                                                               .addGroup(panel12Layout.createParallelGroup()
                                                                     .addGroup(panel12Layout.createSequentialGroup()
                                                                           .addComponent(seatNumJL)
                                                                           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                           .addComponent(seatNumJTF, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                                                     .addGroup(panel12Layout.createSequentialGroup()
                                                                           .addComponent(feeJL)
                                                                           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                           .addComponent(fee_lowJTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
                                                                     .addGroup(panel12Layout.createSequentialGroup()
                                                                           .addGap(20, 20, 20)
                                                                           .addComponent(autoJChB)))
                                                               .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                     .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                           .addGroup(panel12Layout.createSequentialGroup()
                                                                                 .addComponent(colorJL)
                                                                                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                 .addComponent(colorJCB, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                                                                           .addGroup(panel12Layout.createSequentialGroup()
                                                                                 .addComponent(tonsJL)
                                                                                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                 .addComponent(tonsJTF, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                                                                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                 .addComponent(unit1JL, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
                                                                     .addGroup(panel12Layout.createSequentialGroup()
                                                                           .addGap(2, 2, 2)
                                                                           .addComponent(toJL)
                                                                           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                           .addComponent(fee_highJTF, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                                           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                           .addComponent(unit2JL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))))
                                             .addContainerGap())
                                       .addGroup(panel12Layout.createSequentialGroup()
                                             .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                   .addGroup(panel12Layout.createSequentialGroup()
                                                         .addComponent(brandJL)
                                                         .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                         .addComponent(brandJTF))
                                                   .addGroup(panel12Layout.createSequentialGroup()
                                                         .addComponent(carIdJL)
                                                         .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                         .addComponent(carIdJTF, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
                                             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                             .addGroup(panel12Layout.createParallelGroup()
                                                   .addGroup(panel12Layout.createSequentialGroup()
                                                         .addComponent(typeJL)
                                                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                         .addComponent(typeJCB))
                                                   .addGroup(panel12Layout.createSequentialGroup()
                                                         .addComponent(sizeJL)
                                                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                         .addComponent(sizeJTF))))))
                           .addGroup(panel12Layout.createSequentialGroup()
                                 .addContainerGap()
                                 .addComponent(refillJB, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                 .addComponent(title1JL, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                                 .addGap(42, 42, 42))
               );
               panel12Layout.setVerticalGroup(
                     panel12Layout.createParallelGroup()
                           .addGroup(panel12Layout.createSequentialGroup()
                                 .addGroup(panel12Layout.createParallelGroup()
                                       .addGroup(panel12Layout.createSequentialGroup()
                                             .addGap(27, 27, 27)
                                             .addComponent(title1JL))
                                       .addGroup(GroupLayout.Alignment.TRAILING, panel12Layout.createSequentialGroup()
                                             .addContainerGap()
                                             .addComponent(refillJB, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
                                 .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                 .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(carIdJL)
                                       .addComponent(typeJL)
                                       .addComponent(carIdJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                       .addComponent(typeJCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                 .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                 .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(brandJL)
                                       .addComponent(sizeJL)
                                       .addComponent(sizeJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                       .addComponent(brandJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                 .addGap(11, 11, 11)
                                 .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(seatNumJL)
                                       .addComponent(colorJL)
                                       .addComponent(colorJCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                       .addComponent(seatNumJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                 .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                 .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                       .addComponent(tonsJL)
                                       .addComponent(tonsJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                       .addComponent(unit1JL)
                                       .addComponent(autoJChB))
                                 .addGroup(panel12Layout.createParallelGroup()
                                       .addGroup(panel12Layout.createSequentialGroup()
                                             .addGap(4, 4, 4)
                                             .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                   .addComponent(feeJL)
                                                   .addComponent(fee_lowJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                       .addGroup(GroupLayout.Alignment.TRAILING, panel12Layout.createSequentialGroup()
                                             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                             .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                   .addComponent(unit2JL)
                                                   .addComponent(toJL)
                                                   .addComponent(fee_highJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                 .addComponent(title2JL)
                                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                 .addGroup(panel12Layout.createParallelGroup()
                                       .addComponent(searchJB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                       .addComponent(resetJB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                 .addContainerGap())
               );
            }

            //---- rentJB ----
            rentJB.setText("\u7acb\u523b\u79df\u7528\uff01");
            rentJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/rent.png"))));
            rentJB.setFont(new Font("AR PL UMing CN", Font.BOLD, 24));
            rentJB.setForeground(Color.white);
            rentJB.addActionListener(e -> rentButtonActionPerformed());

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                  panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                              .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 676, GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                          .addGap(6, 6, 6)
                                          .addComponent(rentJB, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
                                          .addGap(0, 24, Short.MAX_VALUE))
                                    .addComponent(panel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );
            panel2Layout.setVerticalGroup(
                  panel2Layout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createSequentialGroup()
                              .addComponent(panel12, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(rentJB, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                              .addContainerGap())
            );
         }
         tabbedPane1.addTab("\u79df\u8f66", panel2);

         //======== panel3 ========
         {

            //---- remainToReturnJL ----
            remainToReturnJL.setText("\u5f53\u524d\u672a\u8fd8\u8f66\u8f86\uff1a");

            //======== scrollPane3 ========
            {

               //---- toReturnJT ----
               toReturnJT.setModel(new DefaultTableModel(
                     new Object[][]{
                           {"1", "1", "1", "1", "1", "1", "1", "1", "41422", "414141"},
                           {"2", "2", "2", "2", "2", "2", "2", "2", "141", "141"},
                     },
                     new String[]{
                           "\u8f66\u8f86\u7f16\u53f7", "\u8f66\u8f86\u7c7b\u578b", "\u8f66\u8f86\u54c1\u724c", "\u8f66\u5ea7\u6570", "\u8f66\u724c\u53f7", "\u8f66\u8f86\u989c\u8272", "\u79df\u8f66\u65e5\u671f", "\u8fd8\u8f66\u65e5\u671f", "\u5df2\u79df\u5929\u6570", "\u603b\u8d39\u7528"
                     }
               ) {
                  final boolean[] columnEditable = new boolean[]{
                        false, false, false, false, false, false, false, false, false, false
                  };

                  @Override
                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return columnEditable[columnIndex];
                  }
               });
               scrollPane3.setViewportView(toReturnJT);
            }

            //---- returnJB ----
            returnJB.setText("\u4e00\u952e\u8fd8\u8f66");
            returnJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/return.png"))));
            returnJB.setFont(new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, 28));
            returnJB.addActionListener(e -> returnJBActionPerformed());

            //---- carPicJL ----
            carPicJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/car10.jpeg"))));

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                  panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                              .addContainerGap()
                              .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                          .addComponent(remainToReturnJL, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                          .addContainerGap(918, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                          .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
                                          .addContainerGap())
                                    .addGroup(panel3Layout.createSequentialGroup()
                                          .addComponent(carPicJL)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                                          .addComponent(returnJB, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                                          .addGap(102, 102, 102))))
            );
            panel3Layout.setVerticalGroup(
                  panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                              .addGap(33, 33, 33)
                              .addComponent(remainToReturnJL)
                              .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                          .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(carPicJL, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                                          .addContainerGap())
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                                          .addComponent(returnJB, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                          .addGap(72, 72, 72))))
            );
         }
         tabbedPane1.addTab("\u8fd8\u8f66", panel3);

         //======== panel4 ========
         {

            //======== scrollPane2 ========
            {

               //---- historyJT ----
               historyJT.setModel(new DefaultTableModel(
                     new Object[][]{
                           {"1", "1", "1", "1", "1", "1", "1", "1", "1", "1"},
                           {"2", null, null, null, null, null, null, null, null, null},
                           {"3", null, null, null, null, null, null, null, null, null},
                           {"4", null, null, null, null, null, null, null, null, null},
                           {"5", null, null, null, null, null, null, null, null, null},
                           {"6", null, null, null, null, null, null, null, null, null},
                           {"...", null, null, null, null, null, null, null, null, null},
                           {"114514", null, null, null, null, null, null, null, null, null},
                     },
                     new String[]{
                           "\u8f66\u8f86\u7f16\u53f7", "\u8f66\u8f86\u7c7b\u578b", "\u8f66\u8f86\u54c1\u724c", "\u8f66\u5ea7\u6570", "\u8f66\u724c\u53f7", "\u8f66\u8f86\u989c\u8272", "\u79df\u8f66\u65e5\u671f", "\u8fd8\u8f66\u65e5\u671f", "\u79df\u8d41\u5929\u6570", "\u8d39\u7528"
                     }
               ));
               scrollPane2.setViewportView(historyJT);
            }

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                  panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                              .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
                              .addContainerGap())
            );
            panel4Layout.setVerticalGroup(
                  panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                              .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                              .addContainerGap())
            );
         }
         tabbedPane1.addTab("\u5386\u53f2\u8bb0\u5f55", panel4);

         //======== aboutAuthorJP ========
         {

            //---- link1JB ----
            link1JB.setText("\u5173\u6ce8\u4f5c\u8005\u7684\u535a\u5ba2 teko7a.github.io");
            link1JB.addActionListener(e -> link1JBActionPerformed());

            //---- link2JB ----
            link2JB.setText("\u5173\u6ce8\u4f5c\u8005\u7684BiliBili");
            link2JB.addActionListener(e -> link2JBActionPerformed());

            //---- madeWithJL ----
            madeWithJL.setText("   Made With Java16");
            madeWithJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/java.png"))));

            //---- picJL ----
            picJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/author.png"))));

            GroupLayout aboutAuthorJPLayout = new GroupLayout(aboutAuthorJP);
            aboutAuthorJP.setLayout(aboutAuthorJPLayout);
            aboutAuthorJPLayout.setHorizontalGroup(
                  aboutAuthorJPLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, aboutAuthorJPLayout.createSequentialGroup()
                              .addContainerGap(133, Short.MAX_VALUE)
                              .addGroup(aboutAuthorJPLayout.createParallelGroup()
                                    .addComponent(link1JB, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(aboutAuthorJPLayout.createSequentialGroup()
                                          .addGap(32, 32, 32)
                                          .addComponent(picJL, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                          .addGap(18, 18, 18)
                                          .addGroup(aboutAuthorJPLayout.createParallelGroup()
                                                .addGroup(aboutAuthorJPLayout.createSequentialGroup()
                                                      .addGap(245, 245, 245)
                                                      .addComponent(madeWithJL, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(link2JB, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))))
                              .addGap(143, 143, 143))
            );
            aboutAuthorJPLayout.setVerticalGroup(
                  aboutAuthorJPLayout.createParallelGroup()
                        .addGroup(aboutAuthorJPLayout.createSequentialGroup()
                              .addGap(60, 60, 60)
                              .addComponent(link1JB, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                              .addGroup(aboutAuthorJPLayout.createParallelGroup()
                                    .addGroup(aboutAuthorJPLayout.createSequentialGroup()
                                          .addGap(66, 66, 66)
                                          .addComponent(link2JB, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                          .addGap(33, 33, 33)
                                          .addComponent(madeWithJL, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                          .addContainerGap(108, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, aboutAuthorJPLayout.createSequentialGroup()
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                          .addComponent(picJL, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                          .addGap(63, 63, 63))))
            );
         }
         tabbedPane1.addTab("\u5173\u4e8e\u4f5c\u8005", aboutAuthorJP);
      }

      //======== panel1 ========
      {

         //---- curUsrJL ----
         curUsrJL.setText("\u5f53\u524d\u7528\u6237\uff1a");
         curUsrJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/user.png"))));

         //---- name_idJL ----
         name_idJL.setText("usrName(id : )");

         //---- logoutJB ----
         logoutJB.setText("\u9000\u51fa\u767b\u5f55");
         logoutJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/exit.png"))));
         logoutJB.addActionListener(e -> logoutJBActionPerformed());

         //---- logoJL ----
         logoJL.setText("    T-Rentor");
         logoJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/find.png"))));

         GroupLayout panel1Layout = new GroupLayout(panel1);
         panel1.setLayout(panel1Layout);
         panel1Layout.setHorizontalGroup(
               panel1Layout.createParallelGroup()
                     .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                           .addGap(96, 96, 96)
                           .addComponent(logoJL, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                           .addComponent(curUsrJL, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                           .addComponent(name_idJL, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                           .addComponent(logoutJB)
                           .addGap(15, 15, 15))
         );
         panel1Layout.setVerticalGroup(
               panel1Layout.createParallelGroup()
                     .addGroup(panel1Layout.createSequentialGroup()
                           .addGap(24, 24, 24)
                           .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                 .addComponent(logoutJB)
                                 .addComponent(curUsrJL)
                                 .addComponent(name_idJL, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                           .addContainerGap(15, Short.MAX_VALUE))
                     .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                           .addContainerGap()
                           .addComponent(logoJL, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
         );
      }

      GroupLayout contentPaneLayout = new GroupLayout(contentPane);
      contentPane.setLayout(contentPaneLayout);
      contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                  .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 1057, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
      );
      contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                  .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
      );
      pack();
      setLocationRelativeTo(getOwner());
   }
}
