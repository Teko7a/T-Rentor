package teko7a.Utils;

import org.junit.Test;

/**
 * 用于开启网页的工具类
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/24
 */
public class UrlLinkUtil {
   public static void openUrl(String url) {
      try {
         java.net.URI uri = java.net.URI.create(url);
         // 获取当前系统桌面拓展
         java.awt.Desktop dp = java.awt.Desktop.getDesktop();
         // 判断系统桌面是否支持要执行的功能
         if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
            //File file = new File("D:\\aa.txt");
            //dp.edit(file);// 　编辑文件
            dp.browse(uri);// 获取系统默认浏览器打开链接
            // dp.open(file);// 用默认方式打开文件
            // dp.print(file);// 用打印机打印文件
         }
      } catch (NullPointerException e) {
         StringUtil.log("uri is empty!");
         // 此为uri为空时抛出异常
         e.printStackTrace();
      } catch (java.io.IOException e) {
         StringUtil.log("Cannot get System default browser!");
         // 此为无法获取系统默认浏览器
         e.printStackTrace();
      }
   }

   /**
    * 该测试类用于测试上述代码是否完备
    *
    * @author: tekola (teko7a@github.io)
    */
   @Test public void test() {
      String url1 = "https://www.bilibili.com/";
      UrlLinkUtil.openUrl(url1);

      String url2 = "https://www.github.com/teko7a/myStudyJava";
      UrlLinkUtil.openUrl(url2);
   }
}
