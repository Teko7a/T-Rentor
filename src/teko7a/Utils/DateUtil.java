package teko7a.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/26
 */
public class DateUtil {
  /**
   * 得到当前日期
   *
   * @return 当前的时间格式串
   * @author: tekola (teko7a@github.io)
   */
  public static String getToday() {
    SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
    Calendar calendar = Calendar.getInstance();
    Date today = calendar.getTime();
    return sdf.format(today);
  }

  /**
   * 返回两个时间之差
   *
   * @param F {@code Former Date}之前的时间
   * @return 时间之差
   * @author: tekola (teko7a@github.io)
   */
  public static int getDelta(String F, String L) {
    int f = DateToInt.dayTH(F), l = DateToInt.dayTH(L);
    return l - f;
  }

  public static int getDelta(String F) {
    return getDelta(F, DateUtil.getToday());
  }

  /**
   * 判断两个日期是否是有效的。
   *
   * @param F Former
   * @param L Latter
   * @return is valid if getDelta(F, L) > 0
   * @author: tekola (teko7a@github.io)
   */
  public static boolean isVaild(String F, String L) {
    return getDelta(F, L) > 0;
  }

  public static boolean isVaild(String F) {
    return getDelta(F) > 0;
  }

  /**
   * 简单的辅助内部类， 用于将日期与格式化的字符串对应
   *
   * @author: tekola (teko7a@github.io)
   */
  private static class DateToInt {
    int yy, mm, dd;

    public DateToInt(String date) {
      String[] split = date.split("/");
      this.yy = Integer.parseInt(split[0]);
      this.mm = Integer.parseInt(split[1]);
      this.dd = Integer.parseInt(split[2]);
    }

    public static int dayTH(String date) {
      DateToInt newDate = new DateToInt(date);
      newDate.yy += 2000;
      int[] dates = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
      int ans = 0;
      for (int i = 1; i < newDate.mm; ++i)
        ans += dates[i];
      ans += newDate.dd;
      boolean check = newDate.yy % 4 == 0 && newDate.yy % 100 != 0 || newDate.yy % 400 == 0;
      if (check && newDate.mm > 2)
        ans++;
      return ans;
    }
  }
}
