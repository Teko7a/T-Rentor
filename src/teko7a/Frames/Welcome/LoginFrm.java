package teko7a.Frames.Welcome;

import teko7a.DAOs.AdminDAO;
import teko7a.DAOs.UsrDAO;
import teko7a.Frames.Admin.MainFrm;
import teko7a.Models.Admin;
import teko7a.Models.Usr;
import teko7a.Utils.DataBaseUtil;
import teko7a.Utils.FrmUtil;
import teko7a.Utils.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.Objects;

/**
 * 登陆界面 JFrame 类
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/30
 */
public class LoginFrm extends JFrame {
   DataBaseUtil dbUtil = new DataBaseUtil();
   UsrDAO usrDAO = new UsrDAO();
   AdminDAO adminDAO = new AdminDAO();

   public LoginFrm() {
      FrmUtil.setFont();
      initComponents();
   }

   /**
    * 管理员登录具体实现
    *
    * @param admin 登入管理员
    * @author: tekola (teko7a@github.io)
    */
   private void confirm(Admin admin) {
      Connection con = null;
      try {
         con = dbUtil.getCon();
         Admin curAdmin = adminDAO.login(con, admin);
         if (curAdmin != null) {
            curAdmin = adminDAO.detail(con, curAdmin.getName());
            StringUtil.log("感谢使用 CarsRentor!");
            this.dispose(); // 登录成功，销毁当前窗体
            FrmUtil.openFrm(new MainFrm(curAdmin));
         } else {
            StringUtil.log("您忘记了密码，请在数据库中重置密码！");
            resetActionPerformed();
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

   /**
    * 用户登录具体实现
    *
    * @param usr 登入用户
    * @author: tekola (teko7a@github.io)
    */
   private void confirm(Usr usr) {
      Connection con = null;
      try {
         con = dbUtil.getCon();
         Usr curUser = usrDAO.login(con, usr);
         if (curUser != null) {
            curUser = usrDAO.detail(con, curUser.getName());
            StringUtil.log("欢迎使用 CarsRentor!");
            this.dispose();
            // **** 成功登入， 跳转至 CarsRentorUser ****
            FrmUtil.openFrm(new teko7a.Frames.Usr.MainFrm(curUser));
         } else {
            StringUtil.log("请检查用户名或者密码是否错误！");
            resetActionPerformed();
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

   /**
    * 重置
    *
    * @author: tekola (teko7a@github.io)
    */
   private void resetActionPerformed() {
      this.nameJTF.setText("");
      this.passwordJPF.setText("");
   }


   /**
    * 登录按键事件处理
    *
    * @author: tekola (teko7a@github.io)
    */
   private void loginJBActionPerformed(ActionEvent e) {
      String name = this.nameJTF.getText();
      String password = new String(this.passwordJPF.getPassword());

      // **** 非空判断 ****
      if (StringUtil.isEmpty(name)) {
         StringUtil.log("请输入用户名\nPlease Input UserName");
         return;
      }
      if (StringUtil.isEmpty(password)) {
         StringUtil.log("请输入您的密码！\nPlease Input Your Password!");
         return;
      }

      // 分别调用 User 和 Admin 的登录方法
      if (imUsrJRB.isSelected()) {
         confirm(new Usr(name, password));
      } else {
         confirm(new Admin(name, password));
      }
   }

   /**
    * 跳转至注册界面
    *
    * @author: tekola (teko7a@github.io)
    */
   private void registerJBActionPerformed(ActionEvent e) {
      this.dispose();
      FrmUtil.openFrm(new RegisterFrm());
   }

   private void initComponents() {
      JLabel welcomeJL = new JLabel();
      JRadioButton imAdminJRB = new JRadioButton();
      imUsrJRB = new JRadioButton();
      JLabel nameJL = new JLabel();
      nameJTF = new JTextField();
      JLabel passwordJL = new JLabel();
      passwordJPF = new JPasswordField();
      JButton loginJB = new JButton();
      JButton registerJB = new JButton();

      //======== this ========
      setTitle("Welcome to use T-Rentor !!!");
      setResizable(false);
      Container contentPane = getContentPane();

      //---- welcomeJL ----
      welcomeJL.setText("   T-Rentor");
      welcomeJL.setFont(new Font("Monaco", Font.BOLD, 24));
      welcomeJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/busy.png"))));

      //---- imAdminJRB ----
      imAdminJRB.setText("\u6211\u662f\u7ba1\u7406\u5458");

      //---- imUsrJRB ----
      imUsrJRB.setText("\u6211\u662f\u7528\u6237");
      imUsrJRB.setSelected(true);

      //---- nameJL ----
      nameJL.setText("\u7528\u6237\u540d\uff1a");
      nameJL.setFont(new Font("AR PL UKai CN", Font.PLAIN, 18));
      nameJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/dir.png"))));

      //---- passwordJL ----
      passwordJL.setText("\u5bc6  \u7801\uff1a");
      passwordJL.setFont(new Font("AR PL UKai CN", Font.PLAIN, 18));
      passwordJL.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/base.png"))));

      //---- loginJB ----
      loginJB.setText("\u767b\u5f55\u5230T-Rentor!");
      loginJB.setFont(new Font("Noto Sans CJK HK", Font.BOLD, 18));
      loginJB.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/login.png"))));
      loginJB.addActionListener(this::loginJBActionPerformed);

      //---- registerJB ----
      registerJB.setText("\u8fd8\u6ca1\u6709\u8d26\u6237\uff1f\u70b9\u51fb\u6ce8\u518c\uff01");
      registerJB.setForeground(new Color(0, 153, 204));
      registerJB.setFont(new Font("AR PL UMing CN", Font.ITALIC, 13));
      registerJB.addActionListener(this::registerJBActionPerformed);

      GroupLayout contentPaneLayout = new GroupLayout(contentPane);
      contentPane.setLayout(contentPaneLayout);
      contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                  .addGroup(contentPaneLayout.createSequentialGroup()
                  .addGroup(contentPaneLayout.createParallelGroup()
                  .addGroup(contentPaneLayout.createSequentialGroup()
                  .addGroup(contentPaneLayout.createParallelGroup()
                  .addGroup(contentPaneLayout.createSequentialGroup()
                  .addGap(76, 76, 76)
                  .addComponent(imAdminJRB))
                  .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                  .addComponent(nameJL, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                  .addComponent(passwordJL, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
                  .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(contentPaneLayout.createParallelGroup()
                  .addComponent(passwordJPF)
                  .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                  .addGap(0, 0, Short.MAX_VALUE)
                  .addGroup(contentPaneLayout.createParallelGroup()
                  .addComponent(nameJTF, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                  .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                  .addComponent(imUsrJRB, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                  .addGap(40, 40, 40))))))
                  .addGroup(contentPaneLayout.createSequentialGroup()
                  .addGap(48, 48, 48)
                  .addComponent(welcomeJL, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
                  .addGap(1, 1, 1)))
                  .addContainerGap(42, Short.MAX_VALUE))
                  .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                  .addContainerGap(102, Short.MAX_VALUE)
                  .addComponent(loginJB, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
                  .addGap(94, 94, 94))
                  .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                  .addGap(0, 128, Short.MAX_VALUE)
                  .addComponent(registerJB, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
                  .addGap(126, 126, 126))
      );
      contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                  .addGroup(contentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(welcomeJL)
                        .addGap(45, 45, 45)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                              .addComponent(imAdminJRB)
                              .addComponent(imUsrJRB))
                        .addGap(38, 38, 38)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                              .addComponent(nameJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                              .addComponent(nameJL))
                        .addGap(28, 28, 28)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                              .addComponent(passwordJPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                              .addComponent(passwordJL))
                        .addGap(18, 18, 18)
                        .addComponent(loginJB, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(registerJB)
                        .addContainerGap(21, Short.MAX_VALUE))
      );
      pack();
      setLocationRelativeTo(getOwner());

      //---- usrOrAdmin ----
      var usrOrAdmin = new ButtonGroup();
      usrOrAdmin.add(imAdminJRB);
      usrOrAdmin.add(imUsrJRB);
   }

   private JRadioButton imUsrJRB;
   private JTextField nameJTF;
   private JPasswordField passwordJPF;
}
