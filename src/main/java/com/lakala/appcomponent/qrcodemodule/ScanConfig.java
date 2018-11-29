package com.lakala.appcomponent.qrcodemodule;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

import com.yzq.zxinglibrary.bean.ZxingConfig;

public class ScanConfig extends ZxingConfig implements Parcelable {

    //状态栏颜色
    private int statusBarColor = Color.parseColor("#aa060606");
    //标题栏颜色
    private int toolbarBarColor = Color.parseColor("#000000");
    //标题
    private String title = "请扫描二维码";
    //下面扫码提示
    private String hint;

    public ScanConfig() {
    }

    protected ScanConfig(Parcel in) {
        isPlayBeep = in.readByte() != 0;
        isShake = in.readByte() != 0;
        isShowbottomLayout = in.readByte() != 0;
        isShowFlashLight = in.readByte() != 0;
        isShowAlbum = in.readByte() != 0;
        isDecodeBarCode = in.readByte() != 0;
        isFullScreenScan = in.readByte() != 0;
        reactColor = in.readInt();
        frameLineColor = in.readInt();
        statusBarColor = in.readInt();
        toolbarBarColor = in.readInt();
        title = in.readString();
        hint = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (isPlayBeep ? 1 : 0));
        dest.writeByte((byte) (isShake ? 1 : 0));
        dest.writeByte((byte) (isShowbottomLayout ? 1 : 0));
        dest.writeByte((byte) (isShowFlashLight ? 1 : 0));
        dest.writeByte((byte) (isShowAlbum ? 1 : 0));
        dest.writeByte((byte) (isDecodeBarCode ? 1 : 0));
        dest.writeByte((byte) (isFullScreenScan ? 1 : 0));
        dest.writeInt(reactColor);
        dest.writeInt(frameLineColor);
        dest.writeInt(statusBarColor);
        dest.writeInt(toolbarBarColor);
        dest.writeString(title);
        dest.writeString(hint);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ScanConfig> CREATOR = new Creator<ScanConfig>() {
        @Override
        public ScanConfig createFromParcel(Parcel in) {
            return new ScanConfig(in);
        }

        @Override
        public ScanConfig[] newArray(int size) {
            return new ScanConfig[size];
        }
    };

    public int getStatusBarColor() {
        return statusBarColor;
    }

    public void setStatusBarColor(@ColorInt int statusBarColor) {
        this.statusBarColor = statusBarColor;
    }

    public int getToolbarBarColor() {
        return toolbarBarColor;
    }

    public void setToolbarBarColor(@ColorInt int toolbarBarColor) {
        this.toolbarBarColor = toolbarBarColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
