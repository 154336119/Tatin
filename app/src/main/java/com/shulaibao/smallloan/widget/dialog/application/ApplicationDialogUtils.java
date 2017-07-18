package com.shulaibao.smallloan.widget.dialog.application;

/**
 * Created by 于德海 on 2016/9/8.
 *
 * @version ${VERSION}
 * @decpter
 */
public class ApplicationDialogUtils {

    private static ApplicationDialogUtils instances;
    private static CommonDialogListener mListener;

    private ApplicationDialogUtils(){

    }

    public void setListener(CommonDialogListener listener){
        this.mListener = listener;
    }

    public static ApplicationDialogUtils getInstances(){
        if (instances == null)
        {
            synchronized (ApplicationDialogUtils.class)
            {
                if (instances == null)
                {
                    instances = new ApplicationDialogUtils();
                }
            }
        }
        return instances;
    }


    public void showDialog(){
        if(mListener!=null){
            mListener.show();
        }
    }

    public void cancel(){
        if(mListener!=null){
            mListener.cancel();
        }
    }
}
