package com.lakala.appcomponent.qrcodemodule;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class QRCodeModule extends WXModule implements IQRCode {

    private ScanManager scanManager;

    @JSMethod
    @Override
    public boolean scanQRCode(String params, final JSCallback callback) {
        Context context = mWXSDKInstance.getContext();
        if (context == null) {
            return false;
        }

        if (scanManager == null) {
            scanManager = new ScanManager();
        }

        ScanConfig scanConfig = null;
        if (!TextUtils.isEmpty(params)) {
            scanConfig = new ScanConfig();

            try {
                JSONObject jsonObject = new JSONObject(params);

                //状态栏颜色
                if (jsonObject.has("statusBarColor")) {
                    scanConfig.setStatusBarColor(Color.parseColor(jsonObject.getString("statusBarColor")));
                }

                //标题栏颜色
                if (jsonObject.has("toolbarBarColor")) {
                    scanConfig.setToolbarBarColor(Color.parseColor(jsonObject.getString("toolbarBarColor")));
                }

                //标题
                if (jsonObject.has("title")) {
                    scanConfig.setTitle(jsonObject.getString("title"));
                }

                //下面文字提示
                if (jsonObject.has("hint")) {
                    scanConfig.setHint(jsonObject.getString("hint"));
                }

                /*是否播放声音*/
                if (jsonObject.has("isPlayBeep")) {
                    scanConfig.setPlayBeep(jsonObject.getBoolean("isPlayBeep"));
                }

                /*是否震动*/
                if (jsonObject.has("isShake")) {
                    scanConfig.setShake(jsonObject.getBoolean("isShake"));
                }

                /*是否显示闪光灯按钮*/
                if (jsonObject.has("isShowFlashLight")) {
                    scanConfig.setShowFlashLight(jsonObject.getBoolean("isShowFlashLight"));
                }

                /*四个角的颜色*/
                if (jsonObject.has("reactColor")) {
                    scanConfig.setReactColor(Color.parseColor(jsonObject.getString("reactColor")));
                }

                if (jsonObject.has("frameLineColor")) {
                    scanConfig.setFrameLineColor(Color.parseColor(jsonObject.getString("frameLineColor")));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        scanManager.scanQRCode((Activity) context, scanConfig, new ScanManager.ScanCallback() {
            @Override
            public void onResult(String result) {
                if (callback != null) {
                    callback.invoke(result);
                }
            }
        });

        return true;
    }

    @JSMethod
    @Override
    public boolean createQRCode(String params, JSCallback jsCallback) {
        if (jsCallback == null) {
            return false;
        }

        Context context = mWXSDKInstance.getContext();
        if (context == null) {
            return false;
        }

        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(params);
            //图片内容
            String message = jsonObject.optString("message");

            if (TextUtils.isEmpty(message)) {
                return false;
            }

            //图片大小
            int size = jsonObject.optInt("size", 50);

            //创建图片二维码
            Bitmap bitmap = ZXingUtils.createQRImage(message, size, size);

            if (bitmap != null) {
                String path = FileUtil.saveBitmapToFile(context, bitmap, getPhotoFileName(context));

                if (!TextUtils.isEmpty(path)) {
                    jsCallback.invoke("resLocal://" + path);
                    return true;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 设置拍照获得的照片名字
     *
     * @return 文件名
     */
    private String getPhotoFileName(Context context) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyyMMdd_HHmmss", Locale.getDefault());

        return "IMG_" + dateFormat.format(date) + ".jpg";
    }

}
