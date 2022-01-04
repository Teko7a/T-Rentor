package teko7a.Utils;

import org.junit.Test;

import javax.swing.*;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/24
 */
public class StringUtil {
   /**
    * 判断字符串是否为空
    *
    * @param str 需要判断的字符串
    * @return 如果本身为空或全为空格返回 true， 否则为 false
    * @author: tekola (teko7a@github.io)
    */
   public static boolean isEmpty(String str) {
      return str == null || "".equals(str.trim());
   }

   public static boolean allEmpty(String... strings) {
      boolean check = true;
      for (String string : strings) check &= isEmpty(string);
      return check;
   }

   public static boolean existEmpty(String... strings) {
      boolean check = false;
      for (String string : strings) {
         check |= isEmpty(string);
      }
      return check;
   }

   @Test public void test1() {
      String[] s = {"", null, "451412", "451515", "   "};
      System.out.println(allEmpty(s));
      System.out.println(existEmpty(s));
   }

   /**
    * 依赖于 StringUtil.isEmpty(String str) ，用于判断 str 非空
    *
    * @author: tekola (teko7a@github.io)
    */
   public static boolean isNotEmpty(String str) {
      return !isEmpty(str);
   }

   /**
    * 因为这句话太长了，容易影响单行代码长度。因此将其封装起来，功能是显示提示窗口。
    *
    * @param message 要显示的内容
    * @author: tekola (teko7a@github.io)
    */
   public static void log(String message) {
      JOptionPane.showMessageDialog(null, message);
   }

   private static final Pattern isPositiveDigitPat = Pattern.compile("[0-9]+(\\\\.[0-9]+)?");

   /**
    * 使用正则表达式 (REGEX) 来判断这是否是一个有效的数字字符串。
    *
    * @param str 要判断的字符串
    * @return 是否是一个正数
    * @author: tekola (teko7a@github.io)
    */
   public static boolean isPositiveDigit(String str) {
      if (isEmpty(str)) return false;
      if (str.charAt(0) == '0') return false;
      str = str.trim();
      return isPositiveDigitPat.matcher(str).matches();
   }

   public static boolean isInvalidIdc(String text) {
      return text.length() != 18 || !isPositiveDigit(text.substring(0, 16));
   }

   public static boolean isInvalidTel(String tel) {
      return tel.length() != 11 || !StringUtil.isPositiveDigit(tel);
   }
}
