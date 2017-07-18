package com.shulaibao.smallloan.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shulaibao.smallloan.R;


/**
 * 通用自定义样式AlertDialog
 */
public class CommonAlertDialog {
	private static CommonAlertDialog mInstance;
	private AlertDialog mAlertDialog;
	private TextView mTxtViewTitle;
	private TextView mTxtViewMessage;
	private TextView mTxtViewContent;
	private Button mBtnleft;
	private Button mBtnRight;
	private View mLine;
	private Context mContext;
	private LinearLayout mLl_dialog_bottom_bar;
	public  static  class WarningDialogListener {
		public  void onWarningDialogOK(CharSequence charSequence){};
		public  void onWarningDialogCancel(CharSequence charSequence){};
	}
	public CommonAlertDialog(Context context) {
		mAlertDialog = new AlertDialog.Builder(context).create();
		mAlertDialog.show();//mAlertDialog.create()在低API的手机上有问题
		Window window = mAlertDialog.getWindow();
		window.setContentView(R.layout.tatin_dialog_custom);
		mTxtViewContent = (TextView) window.findViewById(R.id.txt_dialog_content);
		mTxtViewTitle = (TextView) window.findViewById(R.id.txt_dialog_title);
		mTxtViewMessage = (TextView) window.findViewById(R.id.txt_dialog_message);
		mBtnleft = (Button) window.findViewById(R.id.btn_dialog_left);
		mBtnRight = (Button) window.findViewById(R.id.btn_dialog_right);
		mLine = (View) window.findViewById(R.id.line);
		mLl_dialog_bottom_bar=(LinearLayout)window.findViewById(R.id.ll_dialog_bottom_bar);
	}
	public static CommonAlertDialog getInstance(Context context){
		mInstance = null;
		if(mInstance==null){
			mInstance = new CommonAlertDialog(context);
		}
		return mInstance;
	}
	public void setTitleHeightWrap(){
		LayoutParams params = mTxtViewTitle.getLayoutParams();
		params.height = LayoutParams.WRAP_CONTENT;
		mTxtViewTitle.setSingleLine(false);
		mTxtViewTitle.setLayoutParams(params);
	}

	public void setBtnTextSize(){
		mBtnleft.setTextSize(14);
		mBtnRight.setTextSize(14);
	}

	public void setButtonTextColor(int resId){
		mBtnleft.setTextColor(resId);
		mBtnRight.setTextColor(resId);
	}

	public void setTitleMarginTop(){
		mTxtViewTitle.setPadding(32, 30, 32, 0);
	}

	public void setMessagePaddingTop(){
		mTxtViewMessage.setPadding(32, 20, 32, 32);
	}

	public void setTitle(int resId) {
		mTxtViewTitle.setText(resId);
		mTxtViewTitle.setVisibility(View.VISIBLE);
	}

	public void setMessage(int resId) {
		mTxtViewMessage.setText(resId);
	}

    public void setMessage(String txt){
        mTxtViewMessage.setText(txt);
    }
    public void setMessageGravity(int gravity){
    	mTxtViewMessage.setGravity(gravity);
    }

	public void setTitle(String txt) {
		mTxtViewTitle.setText(txt);
		mTxtViewTitle.setVisibility(View.VISIBLE);
	}
	/**
	 * 设置按钮（确定）
	 */
	public void setRightButton(int resId, final OnClickListener onClickListener) {
		mBtnRight.setText(resId);
		mBtnRight.setOnClickListener(onClickListener);
	}
	public void setRightButton(String resId, final OnClickListener onClickListener) {
		mBtnRight.setText(resId);
		mBtnRight.setOnClickListener(onClickListener);
	}

	/**
	 * 设置按钮（否定）
	 */
	public void setLeftButton(int resId, final OnClickListener onClickListener) {
		mBtnleft.setText(resId);
		mBtnleft.setOnClickListener(onClickListener);
	}
	public void setLeftButton(String resId, final OnClickListener onClickListener) {
		mBtnleft.setText(resId);
		mBtnleft.setOnClickListener(onClickListener);
	}

	/**
	 * 关闭对话框
	 */
	public void dismiss() {
		if (null != mAlertDialog) {
			mAlertDialog.dismiss();
		}
	}
	/**
	 * 对话框是否显示
	 */
	public boolean isShowing(){
		if (null != mAlertDialog) {
			return mAlertDialog.isShowing();
		}else{
			return false;
		}
	}

	/**
	 * 显示对话框
	 */
	public void show() {
		if (null != mAlertDialog && !mAlertDialog.isShowing()) {
			mAlertDialog.show();
		}
	}

	/**
	 * 隐藏取消按钮
	 */
	public void closeCancelBtn(){
		mLine.setVisibility(View.GONE);
		mBtnRight.setVisibility(View.GONE);
	}

	/**
	 * 隐藏取消按钮
	 */
	public void setCanceledOnTouchOutside(boolean b){
		mAlertDialog.setCanceledOnTouchOutside(b);
	}
	public static AlertDialog showCommonAlertDialog(final Context context,String title,String message,String rightText,String leftText,final WarningDialogListener listener,boolean isSingle){
			final CommonAlertDialog mCommonAlertDialog = new CommonAlertDialog(context);
//				if(isSingle){
//	 				mCommonAlertDialog.mBtnRight.setVisibility(View.GONE);
//	 				mCommonAlertDialog.mLine.setVisibility(View.GONE);
//	 				mCommonAlertDialog.mLl_dialog_bottom_bar.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(){
//						@Override
//						public void onGlobalLayout() {
//							int width=mCommonAlertDialog.mLl_dialog_bottom_bar.getWidth();
//							int height=mCommonAlertDialog.mLl_dialog_bottom_bar.getHeight();
//							int[] params=new int[]{0,0,DensityUtil.dip2px(context, 5),DensityUtil.dip2px(context, 5)};
//							mCommonAlertDialog.mBtnleft.setBackgroundDrawable(ImageUtil.setbg(ImageUtil.createCustomCornerBackground(width, height, context.getResources().getColor(R.color.color_f2f2f2), params, true,false), ImageUtil.createCustomCornerBackground(width, height, context.getResources().getColor(R.color.color_d9d9d9), params, true,false), null));
//							mCommonAlertDialog.mLl_dialog_bottom_bar.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//						}
//	 				});
//	 			}

			mCommonAlertDialog.setTitle(title);
			mCommonAlertDialog.setMessage(message);
			mCommonAlertDialog.setRightButton(rightText, new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					if(listener!=null){
						listener.onWarningDialogOK(null);
					}
					mCommonAlertDialog.dismiss();

				}
			});
			mCommonAlertDialog.setLeftButton(leftText, new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					if(listener!=null){
						listener.onWarningDialogCancel(null);
					}
					mCommonAlertDialog.dismiss();
				}
			});
		mCommonAlertDialog.show();
		return mCommonAlertDialog.mAlertDialog;
	}


	public void setContentMessage(String txt){
		mTxtViewContent.setVisibility(View.VISIBLE);
		mTxtViewContent.setText(txt);
	}

}
