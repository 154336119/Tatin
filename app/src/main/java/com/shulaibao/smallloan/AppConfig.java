package com.shulaibao.smallloan;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

import com.orhanobut.logger.Logger;
import com.shulaibao.frame.utils.FileUtils;

import java.io.File;

/**
 * 描述：
 * Created by Lee
 * on 2016/9/20.
 */
public class AppConfig {
    /**LinkFace ID */
    public static final String LINK_FACE_API_ID = "626b74c23fd14bf4a1d92f4209008017";
    /**LinkFace SECRET KYE */
    public static final String LINK_FACE_API_SECRET = "39b729e74f6c4daca63505ac6192dec4";
    /**应用名称 */
    public static final String APP_NAME = "ppadfund";
    /**当前外部存储设备的目录*/
    public static final String EXTERNAL_STORAGE_DIR =  Environment.getExternalStorageDirectory().getAbsolutePath();
    /**SD卡文件存储根目录 */
    private static final String FILE_ROOT_URL = "/ppdfund";
    /**SD卡文件存储-图片目录 */
    public static final String FILE_IMG_URL  = "/ppadfund-img";
    /**身份认证图片 */
    public static final String LIVENESS_IMG = "liveness.jpg";

    /**apatch保存路径 */
    public static final String UPDATE_APATCH_SAVE_PATH = FILE_ROOT_URL + "apatch/";
    /**APP保存路径 */
    public static final String UPDATE_APP_SAVE_PATH = FILE_ROOT_URL + "app/";
    /**下载差分包的名字*/
    public static final String DOWNLOAD_APATCH_NAME = "patch_signed_7zip.apk";
    /**下载APP的名字*/
    public static final String DOWNLOAD_APP_NAME = "danfei.apk";
    /**签名图片文件路径**/
    public static final String SING_PIC = Environment.getExternalStorageDirectory().getPath() +"/ppc/image.jpg";
    /**合同路径 */
    public static final String PATH_CONTRACT =Environment.getExternalStorageDirectory().getAbsolutePath() +"/contract/";
    /**合同 */
    public static final String FILE_CONTRACT_PDF ="ppc.pdf";
    /**最终合并的合同 */
    public static final String FILE_SUCCESS_CONTRACT_PDF ="successppc.pdf";
    /**签名图片文件路径**/
    public static final String  FILE_SCONTRACT_ING_PIC = "image.jpg";
    /**订单详情-查看合同**/
    public static final String  FILE_CHENCK_CONTRACT_PDF = "check_ppc.pdf";
    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("UpdateInfo", "Exception", e);
        }
        return versionName;
    }
    /**
     * 返回当前程序版本名
     */
    public static int getAppVersionCode(Context context) {
        int versioncode = 0;
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versioncode = pi.versionCode;
        } catch (Exception e) {
            Log.e("UpdateInfo", "Exception", e);
        }
        return versioncode;
    }
    public static String getAppPackageName(Context context) {
        try {
            String pkName = context.getPackageName();
            String versionName = context.getPackageManager().getPackageInfo(
                    pkName, 0).versionName;
            int versionCode = context.getPackageManager()
                    .getPackageInfo(pkName, 0).versionCode;
            return pkName + "   " + versionName + "  " + versionCode;
        } catch (Exception e) {
        }
        return null;
    }
    public static String getMetaData(Context context,String name){
        ApplicationInfo appInfo;
        try {
            appInfo = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);
            String msg = appInfo.metaData.getString(name);
            return msg;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取apatch文件夹路径   /storage/emulated/0/danfei/apatch/
     * @return
     */
    private String getApatchDirName(){
        String mDirPath;
        try{
            if(FileUtils.haveSDCard()){
                //当前外部存储设备的目录
                File sdFile = Environment.getExternalStorageDirectory();
                if(!sdFile.exists()){
                    sdFile.mkdir();
                }
                Logger.d("**************sdFile.getAbsolutePath():"+sdFile.getAbsolutePath());
                //当前外部存储设备的目录/base/apatch/
                mDirPath = sdFile.getAbsolutePath()+UPDATE_APP_SAVE_PATH;
                File dirFile = new File(sdFile.getAbsolutePath(),UPDATE_APP_SAVE_PATH
                );
                if(dirFile.exists()){
                    dirFile.delete();
                }
                Logger.d("****************dirFile.getAbsolutePath():"+dirFile.getAbsolutePath());
                return dirFile.getAbsolutePath();
            }else{

            }
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取apatch文件夹路径   /storage/emulated/0/danfei/apatch/
     * @return
     */
    public static String getAppDirName(){
        String mDirPath;
        try{
            if(FileUtils.haveSDCard()){
                //当前外部存储设备的目录
                File sdFile = Environment.getExternalStorageDirectory();
                if(!sdFile.exists()){
                    sdFile.mkdir();
                }
                Logger.d("**************sdFile.getAbsolutePath():"+sdFile.getAbsolutePath());
                //当前外部存储设备的目录/base/apatch/
                mDirPath = sdFile.getAbsolutePath()+UPDATE_APATCH_SAVE_PATH;
                File dirFile = new File(sdFile.getAbsolutePath(),UPDATE_APATCH_SAVE_PATH
                );
                if(dirFile.exists()){
                    dirFile.delete();
                }
                Logger.d("****************dirFile.getAbsolutePath():"+dirFile.getAbsolutePath());
                return dirFile.getAbsolutePath();
            }else{

            }
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
