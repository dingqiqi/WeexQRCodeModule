package com.yzq.zxinglibrary.bean;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

import com.lakala.appcomponent.qrcodemodule.R;

/**
 * @author: yzq
 * @date: 2017/10/27 14:48
 * @declare :zxing配置类
 */


public class ZxingConfig{


    /*是否播放声音*/
    protected boolean isPlayBeep = true;
    /*是否震动*/
    protected boolean isShake = true;
    /*是否显示下方的其他功能布局*/
    protected boolean isShowbottomLayout = true;
    /*是否显示闪光灯按钮*/
    protected boolean isShowFlashLight = true;
    /*是否显示相册按钮*/
    protected boolean isShowAlbum = true;
    /*是否解析条形码*/
    protected boolean isDecodeBarCode = true;
    /*是否全屏扫描*/
    protected boolean isFullScreenScan = true;

    /*四个角的颜色*/
    @ColorInt
    protected int reactColor = Color.parseColor("#ffffff");
    /*扫描框颜色*/
    @ColorInt
    protected int frameLineColor = -1;

    public ZxingConfig() {
    }

    public int getFrameLineColor() {
        return frameLineColor;
    }

    public void setFrameLineColor(@ColorInt int frameLineColor) {
        this.frameLineColor = frameLineColor;
    }

    public int getReactColor() {
        return reactColor;
    }

    public void setReactColor(@ColorInt int reactColor) {
        this.reactColor = reactColor;
    }

    public boolean isFullScreenScan() {
        return isFullScreenScan;
    }

    public void setFullScreenScan(boolean fullScreenScan) {
        isFullScreenScan = fullScreenScan;
    }

    public boolean isDecodeBarCode() {
        return isDecodeBarCode;
    }

    public void setDecodeBarCode(boolean decodeBarCode) {
        isDecodeBarCode = decodeBarCode;
    }

    public boolean isPlayBeep() {
        return isPlayBeep;
    }

    public void setPlayBeep(boolean playBeep) {
        isPlayBeep = playBeep;
    }

    public boolean isShake() {
        return isShake;
    }

    public void setShake(boolean shake) {
        isShake = shake;
    }

    public boolean isShowbottomLayout() {
        return isShowbottomLayout;
    }

    public void setShowbottomLayout(boolean showbottomLayout) {
        isShowbottomLayout = showbottomLayout;
    }

    public boolean isShowFlashLight() {
        return isShowFlashLight;
    }

    public void setShowFlashLight(boolean showFlashLight) {
        isShowFlashLight = showFlashLight;
    }

    public boolean isShowAlbum() {
        return isShowAlbum;
    }

    public void setShowAlbum(boolean showAlbum) {
        isShowAlbum = showAlbum;
    }
}
