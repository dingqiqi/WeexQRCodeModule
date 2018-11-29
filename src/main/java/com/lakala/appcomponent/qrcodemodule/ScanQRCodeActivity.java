package com.lakala.appcomponent.qrcodemodule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;

/**
 * 扫描二维码
 * Created by dingqq on 2018/10/30.
 */

public class ScanQRCodeActivity extends Activity {

    public static ScanManager.ScanCallback mScanCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, CaptureActivity.class);
//        ZxingConfig config = new ZxingConfig();
//        config.setPlayBeep(true);//是否播放扫描声音 默认为true
//        config.setShake(true);//是否震动  默认为true
//        config.setDecodeBarCode(false);//是否扫描条形码 默认为true
//        config.setReactColor(R.color.blueTheme);//设置扫描框四个角的颜色 默认为淡蓝色
////        config.setFrameLineColor(R.color.blueTheme);//设置扫描框边框颜色 默认无色
//        config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
        //Color.parseColor("#aa060606")

        if (ScanManager.mScanConfig != null) {
            intent.putExtra(Constant.INTENT_ZXING_CONFIG, ScanManager.mScanConfig);
        }

        startActivityForResult(intent, 0x03);
    }

    public static void setScanCallback(ScanManager.ScanCallback mScanCallback) {
        ScanQRCodeActivity.mScanCallback = mScanCallback;
    }

    /**
     * 文件选中后回调
     *
     * @param requestCode 请求code
     * @param resultCode  返回code
     * @param data        数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0x03 && resultCode == RESULT_OK && data != null) {
            // 扫描二维码/条码回传
            if (ScanQRCodeActivity.mScanCallback != null) {
                ScanQRCodeActivity.mScanCallback.onResult(data.getStringExtra(Constant.CODED_CONTENT));
                ScanQRCodeActivity.mScanCallback = null;
            }
        }

        finish();
    }
}
