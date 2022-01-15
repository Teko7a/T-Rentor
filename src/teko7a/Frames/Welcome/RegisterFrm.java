package teko7a.Frames.Welcome;

import teko7a.DAOs.UsrDAO;
import teko7a.Models.Usr;
import teko7a.Utils.DataBaseUtil;
import teko7a.Utils.FrmUtil;
import teko7a.Utils.OrdersEnum;
import teko7a.Utils.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.Objects;

/**
 * 注册类 JFrame
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/30
 */
public class RegisterFrm extends JFrame {
   DataBaseUtil dbUtil = new DataBaseUtil();
   UsrDAO usrDAO = new UsrDAO();
   OrdersEnum order = null;
   private JTextField nameJTF;
   private JTextField rNameJTF;
   private JTextField idcJTF;
   private JTextField telJTF;
   private JPasswordField passwordJPF;
   private JPasswordField passwordConfirmJPF;

   public RegisterFrm(OrdersEnum order) {
      this();
      this.order = order;
   }

   public RegisterFrm() {
      FrmUtil.setFont();
      initComponents();
   }

   private void registerJBActionPerformed(ActionEvent evt) {
      String name = this.nameJTF.getText();
      String rName = this.rNameJTF.getText();
      String idc = this.idcJTF.getText();
      String tel = this.telJTF.getText();
      String password1 = new String(this.passwordJPF.getPassword());
      String password2 = new String(this.passwordConfirmJPF.getPassword());

      Connection con = null;
      try {
         con = dbUtil.getCon();
         boolean result = usrDAO.hasTwoSameNameUsr(con, name);
         if (result) {
            StringUtil.log("该用户名已存在!");
            this.resetJBActionPerformed();
            return;
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

      // **** 非空判断 以及 长度合法判断 ****
      if (StringUtil.allEmpty(name, idc, rName, tel, password1, password2)) {
         StringUtil.log("请输入您的信息!\n Please Input your infos!");
         return;
      }
      if (StringUtil.isEmpty(name)) {
         StringUtil.log("请输入用户名!\n Please Input Your User Name!");
         return;
      }
      if (StringUtil.isEmpty(idc)) {
         StringUtil.log("请输入您的身份证号!\n Please Input Your IDCN!");
         return;
      }
      if (StringUtil.isInvalidIdc(idc)) {
         StringUtil.log("请输入正确的身份证号!\nPlease Input Correct IDCN!");
         return;
      }
      if (StringUtil.isEmpty(rName)) {
         StringUtil.log("请输入您的真实姓名!\n Please Input Your Real Name!");
         return;
      }
      if (StringUtil.isEmpty(tel)) {
         StringUtil.log("请输入您的电话号码!\n Please Input Your Telephone Number!");
         return;
      }
      if (StringUtil.isInvalidTel(tel)) {
         StringUtil.log("请输入正确的电话号码!\nPlease Input Correct Tel!");
         return;
      }
      if (StringUtil.isEmpty(password1)) {
         StringUtil.log("请输入您的密码!\n Please Input Your Password!");
         return;
      }
      if (StringUtil.isEmpty(password2)) {
         StringUtil.log("请确认密码!\n Please Input Your Password Again!");
         return;
      }


      // **** 密码合法判断， 不一致应当重置 ****
      if (!password1.equals(password2)) {
         StringUtil.log("两次输入的密码不一致!");
         this.passwordJPF.setText("");
         this.passwordConfirmJPF.setText("");
         return;
      }

      // **** 创建新用户 ****
      Usr user = new Usr(name, password1, rName, idc, tel);
      con = null;
      try {
         con = dbUtil.getCon();
         int item = usrDAO.register(con, user);
         if (item == 1) {
            if (order != OrdersEnum.ADD) StringUtil.log("创建新用户 '" + name + "' 成功\n 现在就去登录!");
            else StringUtil.log("创建新用户 '" + name + "' 成功");

            this.dispose();
            if (order != OrdersEnum.ADD) FrmUtil.openFrm(new LoginFrm());
         } else {
            StringUtil.log("创建新用户 '" + name + "' 失败\n 请重试!");
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

   private void resetJBActionPerformed(ActionEvent evt) {
      this.resetJBActionPerformed();
   }

   private void resetJBActionPerformed() {
      this.nameJTF.setText("");
      this.rNameJTF.setText("");
      this.idcJTF.setText("");
      this.telJTF.setText("");
      this.passwordJPF.setText("");
      this.passwordConfirmJPF.setText("");
   }

   private void initComponents() {
      JLabel welcomeJL = new JLabel();
      JLabel nameJL = new JLabel();
      JLabel rNameJL = new JLabel();
      JLabel idcJL = new JLabel();
      JLabel telJC = new JLabel();
      JLabel passwordJL = new JLabel();
      JLabel passwordConfirmJL = new JLabel();
      JButton registerJB = new JButton();
      JButton resetJB = new JButton();
      nameJTF = new JTextField();
      rNameJTF = new JTextField();
      idcJTF = new JTextField();
      telJTF = new JTextField();
      passwordJPF = new JPasswordField();
      passwordConfirmJPF = new JPasswordField();

      //======== this ========
      setTitle("\u6ce8\u518c\u5230T-rentor");
      Container contentPane = getContentPane();

      //---- welcomeJL ----
      welcomeJL.setText("   T-Rentor");
      welcomeJL.setFont(new Font("Monaco", Font.BOLD, 24));
      welcomeJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/busy.png"))));

      //---- nameJL ----
      nameJL.setText("\u7528\u6237\u540d\uff1a");

      //---- rNameJL ----
      rNameJL.setText("\u59d3  \u540d\uff1a");

      //---- idcJL ----
      idcJL.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");

      //---- telJC ----
      telJC.setText("\u7535\u8bdd\u53f7\u7801\uff1a");

      //---- passwordJL ----
      passwordJL.setText("\u5bc6  \u7801\uff1a");

      //---- passwordConfirmJL ----
      passwordConfirmJL.setText("\u5bc6\u7801\u786e\u8ba4\uff1a");

      //---- registerJB ----
      registerJB.setText("\u786e\u8ba4\u6ce8\u518c/\u91cd\u7f6e\u5bc6\u7801");
      registerJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/edit.png"))));
      registerJB.addActionListener(this::registerJBActionPerformed);

      //---- resetJB ----
      resetJB.setText("\u91cd\u65b0\u586b\u5199");
      resetJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/reset.png"))));
      resetJB.addActionListener(this::resetJBActionPerformed);

      GroupLayout contentPaneLayout = new GroupLayout(contentPane);
      contentPane.setLayout(contentPaneLayout);
      contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                  .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addContainerGap(81, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup()
                              .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                          .addComponent(passwordConfirmJL, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                          .addComponent(telJC, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                          .addComponent(passwordJL, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                          .addComponent(idcJL, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                          .addComponent(rNameJL, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                          .addComponent(nameJL, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                    .addGap(30, 30, 30)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                          .addComponent(nameJTF, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                          .addComponent(rNameJTF, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                          .addComponent(idcJTF, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                          .addComponent(telJTF, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                          .addComponent(passwordJPF, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                          .addComponent(passwordConfirmJPF, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
                              .addComponent(welcomeJL, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                  .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(registerJB)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(resetJB)
                        .addGap(45, 45, 45))
      );
      contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                  .addGroup(contentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(welcomeJL)
                        .addGap(40, 40, 40)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                              .addComponent(nameJL)
                              .addComponent(nameJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                              .addComponent(rNameJL)
                              .addComponent(rNameJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                              .addComponent(idcJL)
                              .addComponent(idcJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                              .addComponent(telJC)
                              .addComponent(telJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                              .addComponent(passwordJL)
                              .addComponent(passwordJPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                              .addComponent(passwordConfirmJL)
                              .addComponent(passwordConfirmJPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                              .addComponent(registerJB)
                              .addComponent(resetJB))
                        .addContainerGap(34, Short.MAX_VALUE))
      );
      pack();
      setLocationRelativeTo(getOwner());
   }
}
