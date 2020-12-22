package com.example.iot_app.ui.blockly_activity.webview;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;

import com.example.iot_app.ui.blockly_activity.BlocklyActivity;
import com.example.iot_app.ui.blockly_activity.TypeConnected;
import com.example.iot_app.utils.HexUtil;

public class WebAppInterface {
    private static String TAG = "WebAppInterface";
    Context mContext;
    /**
     * Instantiate the interface and set the context
     */
    public WebAppInterface(Context c) {
        mContext = c;
    }

//    @JavascriptInterface
//    public int getSensor() {
//        return BlocklyActivity.sensorData;
//    }
    @JavascriptInterface
    public void mBackward(int data) {
        // ff 55 07 00 02 01 00 00 00 00
        Log.d(TAG, "moveBackward: " + data);
        String mBvalue = HexUtil.formatHexString4((int) (data*2.54));
        String mB1value = HexUtil.formatHexString4((int) ((-1)*data*2.54));
        if(data > 0){
            mBvalue = mBvalue + "00" + mB1value + "ff";
        }else if(data == 0){
            mBvalue = "00000000";
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HC05) {
            BlocklyActivity.hc05Send("ff5507000202"+mBvalue);
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HM10) {
            BlocklyActivity.writeBle("ff5507000202"+mBvalue);
        }
        Log.d(TAG, "motorM1,M2: " +mBvalue);
    }
    @JavascriptInterface
    public void mForward(int data) {
        Log.d(TAG, "moveBackward: " + data);
        String mF1value = HexUtil.formatHexString4((int) (data*2.54));
        String mFvalue = HexUtil.formatHexString4((int) ((-1)*data*2.54));
        if(data > 0){
            mFvalue = mFvalue + "ff" + mF1value + "00";
        }else if(data == 0){
            mFvalue = "00000000";
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HC05) {
            BlocklyActivity.hc05Send("ff5507000202"+mFvalue);
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HM10) {
            BlocklyActivity.writeBle("ff5507000202"+mFvalue);
        }
        Log.d(TAG, "motorM1,M2: " +mFvalue);
    }
    @JavascriptInterface
    public void mAServo(String port, int angle, int duaration) {
        //3 cặp cuối lần lượt là porti, slot, angle
        String mess = port + "01";
        String ag = "";
        String duarationmS = "";
        if (angle == 0) {
            ag = "00";
        } else {
            ag = HexUtil.formatHexString4(angle);
        }
        if (duaration < 10){
            duarationmS = "00";
        } else if ((duaration >= 10) && (duaration < 200)){
            duarationmS = "03";
        }else if ((duaration >= 200) && (duaration < 1000)){
            duarationmS = "05";
        }else if ((duaration >= 1000) && (duaration < 8000)){
            duarationmS = "07";
        }else if (duaration >= 8000){
            duarationmS = "0a";
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HC05) {
            BlocklyActivity.hc05Send("ff550600020b"+ mess+duarationmS + ag);
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HM10) {
            BlocklyActivity.writeBle("ff550600020b" + mess+ag+duarationmS);
        }
        Log.d(TAG, "Servo: " +"ff550900020b"+ mess+duarationmS + ag);
    }
    @JavascriptInterface
    public void mservo_NO(String port, int angle) {
        //3 cặp cuối lần lượt là porti, slot, angle
//        ff 55 06 00 02 03 port slot angle
        String mess = "ff5506000203";
        String ag = Integer.toHexString(angle);
        mess += port;
        mess += "01";
        if (angle == 0) {
            mess += "00";
        } else {
            mess += ag;
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HC05) {
            BlocklyActivity.hc05Send(mess);
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HM10) {
            BlocklyActivity.writeBle(mess);
        }
        Log.d(TAG, "mservo_NO: ddd");

    }
    @JavascriptInterface
    public void buzzerTK(String port, int frequence, int duration){
//        ff 55 09 00 02 04 02 01 00 00 00 00
        Log.d(TAG, "buzzer: " + "frequence   " + frequence + "  duration  " + duration);
        if (BlocklyActivity.typeConnected == TypeConnected.HC05) {
            BlocklyActivity.hc05Send("ff5509000204" +port + "01"+HexUtil.dectoHex16(frequence)+ HexUtil.dectoHex16(duration));
            Log.d(TAG, "buzzer: " + "FRR   " + HexUtil.dectoHex16(frequence) + "  DUR  " + HexUtil.dectoHex16(duration));
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HM10) {
        }
    }
    @JavascriptInterface
    public void servo(String port, String slot, int angle) {
        //3 cặp cuối lần lượt là porti, slot, angle
        String mess = "ff550600020b";
        String ag = Integer.toHexString(angle);
        mess += port;
        mess += slot;
        if (angle == 0) {
            mess += "00";
        } else {
            mess += ag;
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HC05) {
            BlocklyActivity.hc05Send(mess);
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HM10) {
            BlocklyActivity.writeBle(mess);
        }

    }
    @JavascriptInterface
    public void moveMotorM1M2(int M1data, int M2data) {
//        ff 55 07 00 02 02 00 00 00 00
        Log.d(TAG, "moveMotorM1M2: " + "M1   " + M1data + "  M2  " + M2data);
        String M1stringmotor = "";
        String M2stringmotor = "" ;
        if ((M1data <0) && (M2data <0)){
            M1stringmotor = HexUtil.formatHexString4((int) ((-1)*M1data*2.54));
            M2stringmotor = HexUtil.formatHexString4((int) (M2data*2.54));
            M1stringmotor = M1stringmotor+ "00";
            M2stringmotor = M2stringmotor+ "ff";
        } else if ((M1data > 0) && (M2data >0)){
            M1stringmotor = HexUtil.formatHexString4((int) ((-1)*M1data*2.54));
            M2stringmotor = HexUtil.formatHexString4((int) (M2data*2.54));
            M1stringmotor = M1stringmotor+ "ff";
            M2stringmotor = M2stringmotor+ "00";
        }else if ((M1data < 0) && (M2data > 0)){
            M1stringmotor = HexUtil.formatHexString4((int) ((-1)*M1data*2.54));
            M2stringmotor = HexUtil.formatHexString4((int) (M2data*2.54));
            M1stringmotor = M1stringmotor+ "00";
            M2stringmotor = M2stringmotor+ "00";
        }else if ((M1data > 0) && (M2data < 0)){
            M1stringmotor = HexUtil.formatHexString4((int) (M1data*2.54));
            M2stringmotor = HexUtil.formatHexString4((int) ((-1)*M2data*2.54));
            M1stringmotor = M1stringmotor+ "00";
            M2stringmotor = M2stringmotor+ "00";
        }else if ((M1data == 0) && (M2data < 0)){
            M2stringmotor = HexUtil.formatHexString4((int) (M2data*2.54));
            M1stringmotor =  "0000";
            M2stringmotor = M2stringmotor+ "ff";
        }else if ((M1data == 0) && (M2data > 0)){
            M2stringmotor = HexUtil.formatHexString4((int) (M2data*2.54));
            M1stringmotor =  "0000";
            M2stringmotor = M2stringmotor+ "00";
        }else if ((M2data == 0) && (M1data > 0)){
            M1stringmotor = HexUtil.formatHexString4((int) ((-1)*M1data*2.54));
            M2stringmotor =  "0000";
            M1stringmotor = M1stringmotor+ "ff";
        }else if ((M2data == 0) && (M1data < 0)){
            M1stringmotor = HexUtil.formatHexString4((int) ((-1)*M1data*2.54));
            M2stringmotor =  "0000";
            M1stringmotor = M1stringmotor+ "00";
        }else if ((M2data == 0) && (M1data == 0)){
            M2stringmotor =  "0000";
            M1stringmotor =  "0000";
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HC05) {
            BlocklyActivity.hc05Send("ff5507000202" + M1stringmotor + M2stringmotor);
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HM10) {
        }
        Log.d(TAG, "motorM1,M2: " +M1stringmotor+ M2stringmotor);
    }
    @JavascriptInterface
    public int requestSensor(String port) {
        String mess = "ff550400010a" + port;
        if (BlocklyActivity.typeConnected == TypeConnected.HC05) {
            BlocklyActivity.hc05Send(mess);
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HM10) {
            BlocklyActivity.writeBle(mess);
        }
        if (port.equals("02")){
            Log.d(TAG, " usltr222: " + port + " " + BlocklyActivity.ultradata1);
            return  BlocklyActivity.ultradata1;
        }
        else if (port.equals("03")){
            Log.d(TAG, " usltr333: " + port + " " + BlocklyActivity.ultradata2);
            return  BlocklyActivity.ultradata2;
        }
        else if (port.equals("05")){
            Log.d(TAG, " usltr555: " + port + " " + BlocklyActivity.ultradata3);
            return BlocklyActivity.ultradata3;
        }
        else if (port.equals("06")){
            Log.d(TAG, " usltr666: " + port + " " + BlocklyActivity.ultradata4);
            return  BlocklyActivity.ultradata4;
        }
        else if (port.equals("07")){
            Log.d(TAG, " usltr777: " + port + " " + BlocklyActivity.ultradata5);
            return BlocklyActivity.ultradata5;
        }
        else if (port.equals("08")){
            Log.d(TAG, " usltr888: " + port + " " + BlocklyActivity.ultradata6);
            return BlocklyActivity.ultradata6;
        }else {
        Log.d(TAG, " usltr111111111: " + port + " " + BlocklyActivity.sensorData7);
        return BlocklyActivity.sensorData7;
        }
    }
    @JavascriptInterface
    public boolean lineFollow2(String port, String s1, String s2) {
        String mess = "ff5504000110" + port;
        String x1 = "";
        String x2 = "";
        if (BlocklyActivity.typeConnected == TypeConnected.HC05) {
            BlocklyActivity.hc05Send(mess);
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HM10) {
            BlocklyActivity.writeBle(mess);
        }
        if(s1.equals("black") && s2.equals("black")){
            x1 = "40";
            x2 = "40";
        } else

        if(s1.equals("black") && s2.equals("white")){

            x1 = "00";
            x2 = "40";
        } else

        if(s1.equals("white") && s2.equals("black")){
            x1 = "80";
            x2 = "3f";
        } else

        if(s1.equals("white") && s2.equals("white")){
            x1 = "00";
            x2 = "00";
        }
        if (port.equals("02")){
            if ((BlocklyActivity.lineValueS12.equals(x1) && BlocklyActivity.lineValueS11.equals(x2))){
                    return true;
            }else{
                return  false;
            }
        } else if (port.equals("03")){
            if ((BlocklyActivity.lineValueS22.equals(x1) && BlocklyActivity.lineValueS21.equals(x2))){
                return true;
            }else{
                return  false;
            }
        } else if (port.equals("05")){
            if ((BlocklyActivity.lineValueS32.equals(x1) && BlocklyActivity.lineValueS31.equals(x2))){
                return true;
            }else{
                return  false;
            }
        } else if (port.equals("06")){
            if ((BlocklyActivity.lineValueS42.equals(x1) && BlocklyActivity.lineValueS41.equals(x2))){
                return true;
            }else{
                return  false;
            }
        } else if (port.equals("07")){
            if ((BlocklyActivity.lineValueS52.equals(x1) && BlocklyActivity.lineValueS51.equals(x2))){
                return true;
            }else{
                return  false;
            }
        } else if (port.equals("08")){
            if ((BlocklyActivity.lineValueS62.equals(x1) && BlocklyActivity.lineValueS61.equals(x2))){
                return true;
            }else{
                return  false;
            }
        } else {
            return false;
        }
    }
    @JavascriptInterface
    public boolean getTouchVal(String port) {
        String mess = "ff550400010d" + port;
        BlocklyActivity.hc05Send(mess);
        if (port.equals("02")){
            Log.d(TAG, " touch222: " + port + " " + BlocklyActivity.touchData1);
            return  BlocklyActivity.touchData1;
        }
        else if (port.equals("03")){
            Log.d(TAG, " touch333: " + port + " " + BlocklyActivity.touchData2);
            return  BlocklyActivity.touchData2;
        }
        else if (port.equals("05")){
            Log.d(TAG, " touch555: " + port + " " + BlocklyActivity.touchData3);
            return  BlocklyActivity.touchData3;
        }
        else if (port.equals("06")){
            Log.d(TAG, " touch666: " + port + " " + BlocklyActivity.touchData4);
            return  BlocklyActivity.touchData4;
        }
        else if (port.equals("07")){
            Log.d(TAG, " touch777: " + port + " " + BlocklyActivity.touchData5);
            return  BlocklyActivity.touchData5;
        }
        else if (port.equals("08")){
            Log.d(TAG, " touch888: " + port + " " + BlocklyActivity.touchData6);
            return  BlocklyActivity.touchData6;
        }else {
            return BlocklyActivity.touchData;
        }
    }
    @JavascriptInterface
    public boolean getAvoidVal(String port) {
        //yêu cầu trả về touch
        String mess = "ff550400010c" + port;
        // BlocklyActivity.writeBle(mess);
        BlocklyActivity.hc05Send(mess);
        if (port.equals("02")){
            Log.d(TAG, " avoid222: " + port + " " + BlocklyActivity.avoidData1);
            return  BlocklyActivity.avoidData1;
        }
        else if (port.equals("03")){
            Log.d(TAG, " avoid333: " + port + " " + BlocklyActivity.avoidData2);
            return  BlocklyActivity.avoidData2;
        }
        else if (port.equals("05")){
            Log.d(TAG, " avoid555: " + port + " " + BlocklyActivity.avoidData3);
            return  BlocklyActivity.avoidData3;
        }
        else if (port.equals("06")){
            Log.d(TAG, " avoid666: " + port + " " + BlocklyActivity.avoidData4);
            return  BlocklyActivity.avoidData4;
        }
        else if (port.equals("07")){
            Log.d(TAG, " avoid777: " + port + " " + BlocklyActivity.avoidData5);
            return  BlocklyActivity.avoidData5;
        }
        else if (port.equals("08")){
            Log.d(TAG, " avoid888: " + port + " " + BlocklyActivity.avoidData6);
            return  BlocklyActivity.avoidData6;
        }else {
            return BlocklyActivity.avoidData;
        }
    }
    @JavascriptInterface
    public int lightSensor(String port) {
        return BlocklyActivity.lightData;
    }
    @JavascriptInterface
    public int getTemVal(String port) {
        String mess = "ff550400010e" + port;
        if (BlocklyActivity.typeConnected == TypeConnected.HC05) {
            BlocklyActivity.hc05Send(mess);
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HM10) {
            BlocklyActivity.writeBle(mess);
        }
        if (port.equals("02")){
            Log.d(TAG, " temValue222: " + port + " " + BlocklyActivity.temperatureData1);
            return  BlocklyActivity.temperatureData1;
        }
        else if (port.equals("03")){
            Log.d(TAG, " temValue333: " + port + " " + BlocklyActivity.temperatureData2);
            return  BlocklyActivity.temperatureData2;
        }
        else if (port.equals("05")){
            Log.d(TAG, " temValue555: " + port + " " + BlocklyActivity.temperatureData3);
            return  BlocklyActivity.temperatureData3;
        }
        else if (port.equals("06")){
            Log.d(TAG, " temValue666: " + port + " " + BlocklyActivity.temperatureData4);
            return  BlocklyActivity.temperatureData4;
        }
        else if (port.equals("07")){
            Log.d(TAG, " temValue777: " + port + " " + BlocklyActivity.temperatureData5);
            return  BlocklyActivity.temperatureData5;
        }
        else if (port.equals("08")){
            Log.d(TAG, " temValue888: " + port + " " + BlocklyActivity.temperatureData6);
            return  BlocklyActivity.temperatureData6;
        }else {
            return BlocklyActivity.temperatureData;
        }
    }
    @JavascriptInterface
    public int getPotenlVal(String port) {
        String mess = "ff550400010b" + port;
        if (BlocklyActivity.typeConnected == TypeConnected.HC05) {
            BlocklyActivity.hc05Send(mess);
        }
        if (BlocklyActivity.typeConnected == TypeConnected.HM10) {
            BlocklyActivity.writeBle(mess);
        }
        if (port.equals("01")){
            Log.d(TAG, " poten111: " + port + " " + BlocklyActivity.potenldata1);
            return  BlocklyActivity.potenldata1;
        }
        else if (port.equals("02")){
            Log.d(TAG, " poten222: " + port + " " + BlocklyActivity.potenldata2);
            return  BlocklyActivity.potenldata2;
        }
        else if (port.equals("03")){
            Log.d(TAG, " poten333: " + port + " " + BlocklyActivity.potenldata3);
            return  BlocklyActivity.potenldata3;
        }
        else {
            return BlocklyActivity.potenlData;
        }
    }
    @JavascriptInterface
    public int isStop() {
        return BlocklyActivity.isStop;
    }
}
