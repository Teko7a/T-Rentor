package teko7a.Utils;

import java.awt.*;
import java.util.Enumeration;
import javax.swing.*;

/**
 * 设置 JFrame 工具类
 *
 * @author: tekola (teko7a@github.io)
 * @create 2021/8/24
 */
public class FrmUtil {
  /**
   * 设置全局字体
   *
   * @author: tekola (teko7a@github.io)
   */
  public static void setFont() {
    Font font = new Font("Dialog", Font.PLAIN, 14);
    Enumeration<Object> keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get(key);
      if (value instanceof javax.swing.plaf.FontUIResource) {
        UIManager.put(key, font);
      }
    }
  }

  /**
   * 打开窗体
   *
   * @param jFrame 要打开的窗体
   */
  public static void openFrm(JFrame jFrame) {
    EventQueue.invokeLater(() -> {
      try {
        jFrame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}
