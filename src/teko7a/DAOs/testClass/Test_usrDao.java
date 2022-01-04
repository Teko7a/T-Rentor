package teko7a.DAOs.testClass;

import teko7a.DAOs.*;
import teko7a.Models.*;
import teko7a.Utils.*;

import java.sql.Connection;

/**
 * 登录测试类
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/30
 */
public class Test_usrDao {
   public static void main(String[] args) throws Exception {
      Connection con = null;
      DataBaseUtil dbUtil = new DataBaseUtil();
      UsrDAO usrDAO = new UsrDAO();

      System.out.println("======================");
      System.out.println(">>>测试登录系统");
      Usr usr = new Usr(1, "0", "0", "0", "000000111111222222", "00000011111");
      con = null;
      try {
         con = dbUtil.getCon();
         Usr successUsr = usrDAO.login(con, usr);
         if (successUsr != null) {
            System.out.println("登录成功！");
            System.out.println(successUsr);
            System.out.println("======================");
            System.out.println(">>>测试获取完整用户信息");
            successUsr = usrDAO.detail(con, successUsr.getName());

            System.out.println(successUsr);
         } else {
            System.out.println("登录失败！");
         }
      } catch (Exception e) {
         System.out.println("登录失败！");
         e.printStackTrace();
      } finally {
         try {
            dbUtil.closeCon(con);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      con = null;
      System.out.println("======================");
      System.out.println(">>>测试注册系统");
      try {
         con = dbUtil.getCon();
         if (usrDAO.hasTwoSameNameUsr(con, usr.getName())) {
            System.out.println("出现重复用户名！");
         } else {
            int result = usrDAO.register(con, usr);
            if (result == 1) {
               System.out.println("注册成功！");
               System.out.println(usr);
            } else {
               System.out.println("注册失败！");
            }
         }
      } catch (Exception e) {
         System.out.println("注册失败！");
         e.printStackTrace();
      } finally {
         dbUtil.closeCon(con);
      }
   }
}
/* ==== 测试日志 ====
usr = Usr(1, "0", "0", "0", "000000111111222222", "00000011111")
======================
>>>测试登录系统
登录成功！
Usr{id=1, name='0', password='0', realName='null', idc='null', tel='null'}
======================
>>>测试获取完整用户信息
Usr{id=1, name='0', password='0', realName='0', idc='000000111111222222', tel='00000011111'}
======================
>>>测试注册系统
出现重复用户名！

×××××××××××××××××××××××××××××××××××××××××××××××××××××××××××
×××××××××××××××××××××××××××××××××××××××××××××××××××××××××××

usr = Usr(1, "xxx", "0", "0", "000000111111222222", "00000011111")
======================
>>>测试登录系统
登录失败！
======================
>>>测试注册系统
注册成功！
Usr{id=1, name='xxx', password='0', realName='0', idc='000000111111222222', tel='00000011111'}
*/