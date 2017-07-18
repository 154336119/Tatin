package com.shulaibao.smallloan.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.hwangjr.rxbus.RxBus;
import com.orhanobut.logger.Logger;
import com.shulaibao.frame.utils.FileUtils;
import com.shulaibao.smallloan.R;
import com.shulaibao.smallloan.event.HasSignPicEvent;
import com.shulaibao.smallloan.http.dns.DnsFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class WebviewPanel {
    private Context mContext;
	private View mRootView;
    private Dialog mSelectDialog;
    private WebView mWebView;
    private Button mEnsureBtn;
    private Button mCancelBtn;
    private CommonAlertDialog mCommonAlertDialog;
    private ImageView iv;
    private String mEmptyStr = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAoCAIAAAADnC86AAAACXBIWXMAAAsTAAALEwEAmpwYAAAABGdBTUEAALGOfPtRkwAAACBjSFJNAAB6JQAAgIMAAPn/AACA6QAAdTAAAOpgAAA6mAAAF2+SX8VGAAAETklEQVR42nSXyVbsMBBDPVQS4P//Ew4bSNtx3kJ5F+E0XvRJJx5qkFTl/PHxkVJKKeWcc856Ps/zPM8xhh5qraWUUkpKiZcppVprzrmUwkKt3fdd89lE+6/rylmh7fRNz6zXSh2WbHCwBl91jPaRTZyqN/iTUgoZq9/eu+Zho96X/wN7mYYFPJ/nuSwLb2qt7L/vOzuHnySjZJFiqDHG0F+9x8XWmqcJH3LOx3FoGq4fx3Ech1yvteb39/dlWXLOuDttNAXZ/67r2ntvrSkv2rGU8ng8mDz94sBPjgngdEDOubXmGcGmfd+VCAyVZ/cdJvSd5xkKCzOmbBFeft2y3rtyoU+kwGcCezmGZXGeZ++dZPjx/IoG5++RUooI7U6aFHAAqPMwTiAXWeIeQA+IFqc/BmB0SJ7n6SHEUfaRKZFzRgf0WVN9CCy+ktjqWZiSBb13Hew4x1DeBz5hcq3V5Qm/3XtHA0DV2ezDwTgALccY0XuXIWMMuc43Yi5BuNPJw0gigZIeNEFDYJStAZc0VRki/lqw77veRITeowaoJmLp+PKsjzEAY8458HKi+ZWJiIn4OgA6TZiQ9yiU74PkwYggVmIFckr0sBT0aoJigwTda8lU31zkAzTeRd/hxhusvMvqhF6vrcK53muE9qL8eX0FFCSCmVeeLBJ6mNaWUtZ1VZCVlx86wTmnAfh0XjlJXJgmZChByoJTnNRcHlMyQR0iOima1G7qUu56J1rSfogRGETYwrertR7H0XsXyrB3XdepNVAkhV4OBlzyb4zRWlNl27Zt27aIK8BjjPz5+YlDOvg4Dg/jJNeTOMjEUsqyLOIFRt+Va9s2QBP3mkOCiZ5rLwd7bDFR9EWCnGmKEPNjqr4OS8kNIHCV0MPr66uj/alYEicZBH0CWJZSvr+/pYvASkfCP6SRVD1NBFqLQQjIDxVZ7GQlkpotgNBxyiAvD/n3oFw67lx3LwFByhU61wTvq+/tX2uNTvQuYZAT7/8sEp4SF4qXl5e7pqpITMrlmJhYABSuDkQ0QHpIjIbYRT2emre3t7fJS0evi4GGutIf5fKOp/dOjltrIkZrTYiTixFXTXvabNw7c/dV/rTWQsfQsE0XC1daBzDhmbpxaq1fvVzPwWyQfFUPv2xBA6LnaJBZ92uc09evWxN0wm9wtAqPx8OroaqNYqBnLfGy6IPOZIo57ezV3l4aFjFdApxUwMTFwUvs5NnTO60LbfBKrsCQ6073u38mZ1pMvz1RXDn2SExd6YVql35xgPyRCL+DIEBU+6c9kFdSVG+ux+BFdLpjis4Xs1TmniqawkYJYODuGCOWZSEgX19fEbGuK6hR/JXOWqsaKKzWWu/aUBhXIUCuAnVBauqqdAYNMISmMDuOtItHRRmBmd6YTo1UOF6IuZcXidT98i5pY/JUs4nthC8gFl5YPA2wVnXaa8YUw4uX/+8K96pKT0Enk1L6NwB496XI9pIofQAAAABJRU5ErkJggg==";
    public String signPicPath;
    public OnClickListener listener;
    public WebviewPanel(Context mContext) {
        this.mContext = mContext;
        init(mContext);
        delPic();
    }

    private String url = DnsFactory.getInstance().getDns().getWebPanelUrl();
    private void init(Context context) {
        mContext = context;
        mRootView = LayoutInflater.from(mContext).inflate(R.layout.widget_web_panel, null);
        mWebView = (WebView) mRootView.findViewById(R.id.web_view);
        mEnsureBtn = (Button) mRootView.findViewById(R.id.btn_ensure);
        mCancelBtn = (Button) mRootView.findViewById(R.id.btn_cancel);
        iv = (ImageView) mRootView.findViewById(R.id.TvTest);
        mWebView.addJavascriptInterface(new InJavaScriptLocalObj(), "local_obj");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.loadUrl(url);
        mEnsureBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.loadUrl("javascript:getPng()");
                mWebView.loadUrl("javascript:window.local_obj.showSource(" +
                        "document.getElementById('signature').src);");
            }
        });
        mCancelBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               // clearWebviewCache();
                dismissDialog();
            }
        });
    }

    final class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Logger.d("WebView", "onPageStarted");
            super.onPageStarted(view, url, favicon);
        }

        public void onPageFinished(WebView view, String url) {
            Logger.d("WebView", "onPageFinished ");
            super.onPageFinished(view, url);
        }
    }

    public void showDialog(Context context) {
        if (null == mSelectDialog) {
            mSelectDialog = new Dialog(mContext, R.style.WebviewDialog);
            Window window = mSelectDialog.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.width = LayoutParams.MATCH_PARENT;
            layoutParams.height = LayoutParams.WRAP_CONTENT;
            layoutParams.gravity = Gravity.BOTTOM;
            mSelectDialog.getWindow().setAttributes(layoutParams);
            mSelectDialog.setContentView(mRootView);
        }
        mSelectDialog.show();
    }
    
    public void dismissDialog() {
        if (null != mSelectDialog) {
            mSelectDialog.dismiss();
        }
    }

    final class InJavaScriptLocalObj {
        @JavascriptInterface
        public void showSource(String html) {
            Logger.d(html);
            if(html.equals(mEmptyStr)){
                Toast toast = Toast.makeText(mContext, "请先确认签名！", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            if(TextUtils.isEmpty(html)){
                Toast toast = Toast.makeText(mContext, "请先确认签名！", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            Logger.d(html);
            html = html.substring(html.indexOf(",")+1);
            Logger.d(html);
            Bitmap bitmap = stringtoBitmap(html);
            saveBitmapInExternalStorage(bitmap,mContext);
            Logger.d("图片转换成功");
            File file = new File(Environment.getExternalStorageDirectory().getPath() +"/ppc","image.jpg");
            signPicPath = file.getAbsolutePath();
            if(file.exists()){
                //showSureDialog();
                showSureDialog(listener);
            }
        }
    }

    /**
     * base64 转 bitmap
     * @param string
     * @return
     */
    public Bitmap stringtoBitmap(String string){
        Bitmap bitmap=null;
        try {
            byte[]bitmapArray;
            bitmapArray=Base64.decode(string, Base64.DEFAULT);
            bitmap=BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }


    /**
     * 保存图片到本地
     * @param bitmap
     * @param context
     */
    public static void saveBitmapInExternalStorage(Bitmap bitmap,Context context) {
        try {
            if(FileUtils.haveSDCard()) {
                File extStorage = new File(Environment.getExternalStorageDirectory().getPath() +"/ppc");//orimuse为SD卡下一个文件夹
                if (!extStorage.exists()) {
                    extStorage.mkdirs();
                }
                File file = new File(extStorage,"image.jpg" +
                        "");
                FileOutputStream fOut = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fOut);//压缩图片
                fOut.flush();
                fOut.close();
                Logger.d(file.getAbsoluteFile());
                Logger.d("保存成功");
            }
            else {
                Logger.d("保存失败");
            }
        }
        catch (IOException ioe){
            Logger.d(ioe.getMessage());
            ioe.printStackTrace();
        }
    }


    /**
     * 获取 签名图片元素html
     */
    public void getWebElementHtml(){
        mWebView.loadUrl("javascript:window.local_obj.showSource(" +
                "document.getElementById('signature').src);");
    }

    /**
     * 删除已经存在签名图片
     */
    private void delPic(){
        FileUtils.deleteFile(Environment.getExternalStorageDirectory().getPath() +"/ppc/image.jpg");
    }

    public void dimissSureDialog(){
        mCommonAlertDialog.dismiss();
    }
    /**
     * 显示dialog
     */
    private void showSureDialog(){
        if(mCommonAlertDialog == null){
            mCommonAlertDialog = new CommonAlertDialog(mContext);
            mCommonAlertDialog.setMessage("确定提交该签名吗？");
            mCommonAlertDialog.setRightButton("确定", new OnClickListener() {
                @Override
                public void onClick(View v) {
                    RxBus.get().post(new HasSignPicEvent(signPicPath));
                    mCommonAlertDialog.dismiss();
                    dismissDialog();
                }
            });
            mCommonAlertDialog.setLeftButton("取消", new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCommonAlertDialog.dismiss();
                }
            });
        }else{
            mCommonAlertDialog.show();
        }
    }

    public void showSureDialog(OnClickListener listener){
        if(mCommonAlertDialog == null){
            mCommonAlertDialog = new CommonAlertDialog(mContext);
            mCommonAlertDialog.setMessage("确定提交该签名吗？");
            mCommonAlertDialog.setRightButton("确定",listener);
            mCommonAlertDialog.setLeftButton("取消", new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCommonAlertDialog.dismiss();
                }
            });
        }else{
            mCommonAlertDialog.show();
        }
    }

    public String getSignPicPath() {
        return signPicPath;
    }

    public void setSignPicPath(String signPicPath) {
        this.signPicPath = signPicPath;
    }

    public OnClickListener getListener() {
        return listener;
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }
}
