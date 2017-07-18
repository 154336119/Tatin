package com.shulaibao.smallloan;

/**
 * 描述：
 * Created by Lee
 * on 2016/10/11.
 */
public class PreferenceConfig {
    /** 上次安装应用版本 */
    public static final String APP_LAST_VERSION_CODE = "app_last_version_code";
    /**参数 - 是否设置手势密码*/
    public static final String IS_SET_GESTURE = "is_set_gesture";
    /**参数 - 手势秘密开关*/
    public static final String LOCK_PASSWORD_ON_OFF = "lock_password_on_off";
    /**参数 - 补丁文件版本*/
    public static final String PATCH_VERSION = "patchVersion";
    /**参数 - d*/
    public static final String LOCK_PASSWORD = "lock_password";
    /** 获取 - 是否设置手势密码 */
    public static boolean isSetGesture() {
        return Base.getSpUtils().getBoolean(IS_SET_GESTURE);
    }

    /** 获取安装版本号 */
    public static int getAppLastVersionCode() {
        return Base.getSpUtils().getInt(APP_LAST_VERSION_CODE,0);
    }

    /** 保存安装版本号 */
    public static void saveAppLastVersionCode(int versionCode) {
        Base.getSpUtils().putInt(APP_LAST_VERSION_CODE,versionCode);
    }

    /**设置 - 是否设置手势密码*/
    public static void saveIsSetGesture(boolean b) {
        Base.getSpUtils().putBoolean(IS_SET_GESTURE,b);
    }

    /** 获取 - 手势密码开关 */
    public static boolean getGesturePwOn() {
        return Base.getSpUtils().getBoolean(LOCK_PASSWORD_ON_OFF);
    }

    /**设置 - 手势密码开关*/
    public static void setGesturePwOn(boolean b) {
        Base.getSpUtils().putBoolean(LOCK_PASSWORD_ON_OFF,b);
    }

    /** 获取 - 手势密码 */
    public static String getGesturePw() {
        return Base.getSpUtils().getString(LOCK_PASSWORD);
    }

    /**设置 - 手势密码*/
    public static void setGesturePw(String pw) {
        Base.getSpUtils().putString(LOCK_PASSWORD,pw);
    }

    /** 获取 - patch版本号 */
    public static String getPatchVersion() {
        return Base.getSpUtils().getString(PATCH_VERSION);
    }

    /**获取 - patch版本号*/
    public static void setPatchVersion(String version) {
        Base.getSpUtils().putString(PATCH_VERSION,version);
    }

}
