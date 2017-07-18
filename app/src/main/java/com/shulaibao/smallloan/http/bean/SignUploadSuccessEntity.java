package com.shulaibao.smallloan.http.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 描述：
 * Created by Lee
 * on 2017/1/11.
 */
public class SignUploadSuccessEntity implements Parcelable {

    /**
     * downloadPdf : http://118.123.245.197:90/1001/2017/01/11/2a50edf2-e939-4cb9-8bcc-dcc8fafff7eb.pdf?originalFilename=1189df3231-da1c-487b-9ced-c1f99e5196f3-pdf3.pdf
     * downloadV
     */

    private String downloadPdf;
    private String downloadVdo;

    public void setDownloadPdf(String downloadPdf) {
        this.downloadPdf = downloadPdf;
    }

    public void setDownloadVdo(String downloadVdo) {
        this.downloadVdo = downloadVdo;
    }

    public String getDownloadPdf() {
        return downloadPdf;
    }

    public String getDownloadVdo() {
        return downloadVdo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.downloadPdf);
        dest.writeString(this.downloadVdo);
    }

    public SignUploadSuccessEntity() {
    }

    protected SignUploadSuccessEntity(Parcel in) {
        this.downloadPdf = in.readString();
        this.downloadVdo = in.readString();
    }

    public static final Creator<SignUploadSuccessEntity> CREATOR = new Creator<SignUploadSuccessEntity>() {
        @Override
        public SignUploadSuccessEntity createFromParcel(Parcel source) {
            return new SignUploadSuccessEntity(source);
        }

        @Override
        public SignUploadSuccessEntity[] newArray(int size) {
            return new SignUploadSuccessEntity[size];
        }
    };
}
