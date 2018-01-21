package smv.lovearthstudio.com.svmproj.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by zhaoliang on 16/10/3.
 */

public class PermissionUtil {

    /**
     * 在Android6.0的手机上需要申请权限
     */
    public static void requestWriteFilePermission(Activity context) {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(context,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(context,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        0);

            }
        }
    }
}
