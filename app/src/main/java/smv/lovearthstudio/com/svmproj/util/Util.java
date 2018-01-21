package smv.lovearthstudio.com.svmproj.util;

/**
 * Created by zhaoliang on 16/10/3.
 */

public class Util {

    /**
     * 根据系统类型获取换行
     *
     * @return
     */
    public static String getChangeRow() {
        return System.getProperty("line.separator", "/n");
    }
}
