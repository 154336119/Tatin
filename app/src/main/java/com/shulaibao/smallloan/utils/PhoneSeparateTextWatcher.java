package com.shulaibao.smallloan.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * 刁剑
 * Created on 2017/3/3.
 * 注释:手机号空格隔开3-3-4
 */

public class PhoneSeparateTextWatcher implements TextWatcher{
    private EditText mEditText;
    private ImageView mImageView;
    private int beforePhone=0;
    private int afterPhone=0;
    public PhoneSeparateTextWatcher(EditText editText, ImageView imageView){
        mEditText=editText;
        mImageView=imageView;
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        beforePhone=charSequence.length();
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence.length() < 1) {
            mImageView.setVisibility(View.INVISIBLE);
        } else {
            mImageView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        afterPhone=editable.length();
        if (beforePhone<afterPhone){//增加
            if (editable.length()==3 || editable.length() ==8){
                mEditText.setText(mEditText.getText().toString()+" ");
                mEditText.setSelection(mEditText.length());
            }
            if (editable.length()==4 && !mEditText.getText().toString().substring(mEditText.length()-1,mEditText.length()).equals(" ")){
                mEditText.setText(mEditText.getText().toString().substring(0,mEditText.length()-1)+" "+mEditText.getText().toString().substring(mEditText.length()-1,mEditText.length()));
                mEditText.setSelection(mEditText.length());
            }
            if (editable.length()==9 && !mEditText.getText().toString().substring(mEditText.length()-1,mEditText.length()).equals(" ")){
                mEditText.setText(mEditText.getText().toString().substring(0,mEditText.length()-1)+" "+mEditText.getText().toString().substring(mEditText.length()-1,mEditText.length()));
                mEditText.setSelection(mEditText.length());
            }
        }else {//减少
            if (editable.length()==9 || editable.length()==4){
                mEditText.setText(mEditText.getText().toString().substring(0,mEditText.getText().toString().length()-1));
                mEditText.setSelection(mEditText.length());
            }
        }
    }
}
