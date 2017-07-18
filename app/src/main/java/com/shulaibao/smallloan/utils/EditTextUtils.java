package com.shulaibao.smallloan.utils;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;

/**
 * 刁剑
 * Created on 2017/1/5.
 * 注释:
 */

public class EditTextUtils {
    public static void hideAndShowPassword(EditText editText,boolean b){
        if (b){
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }else {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        editText.setSelection(editText.getText().length());
    }
}
