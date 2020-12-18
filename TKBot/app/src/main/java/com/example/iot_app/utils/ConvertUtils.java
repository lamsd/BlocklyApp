package com.example.iot_app.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

import androidx.core.app.ActivityCompat;

import com.example.iot_app.ui.blockly_activity.BlocklyActivity;

import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class ConvertUtils {


    public static int getSensor(String hex){
        //ff 55 00 02 8d b0 cc 40 0d 0a
        String sa[] = hex.split(" ");
        int sensorVal =   com.example.iot_app.utils.HexUtil.getDecimal("0x"+ sa[7] + sa[6] + sa[5] + sa[4]);
        return (int) com.example.iot_app.utils.HexUtil.hexToFloat(sensorVal);
    }
    public static void getUltra(String s){
        try{
            if (s.contains("aa2")){
                int index = s.indexOf("aa2") + "aa2".length();
                String sa[] = s.substring(index,index+5).split("");
                String s1 = sa[0]+sa[1]+sa[2]+sa[3] +sa[4];
                Log.d("TAG", "getUltra: Ultra 2 "+ s1);
                BlocklyActivity.ultradata1 = (int) Float.parseFloat(s1);
            }
            else if (s.contains("aa3")){
                int index = s.indexOf("aa3") + "aa3".length();
                String sa[] = s.substring(index,index+5).split("");
                String s1 = sa[0]+sa[1]+sa[2]+sa[3] +sa[4];
                Log.d("TAG", "getUltra: Ultra 3 "+ s1);
                BlocklyActivity.ultradata2 = (int) Float.parseFloat(s1);
            }
            else if (s.contains("aa5")){
                int index = s.indexOf("aa5") + "aa5".length();
                String sa[] = s.substring(index,index+5).split("");
                String s1 = sa[0]+sa[1]+sa[2]+sa[3] +sa[4];
                Log.d("TAG", "getUltra: Ultra 5 "+ s1);
                BlocklyActivity.ultradata3 = (int) Float.parseFloat(s1);
            }
            else if (s.contains("aa6")){
                int index = s.indexOf("aa6") + "aa6".length();
                String sa[] = s.substring(index,index+5).split("");
                String s1 = sa[0]+sa[1]+sa[2]+sa[3] +sa[4];
                Log.d("TAG", "getUltra: Ultra 6 "+ s1);
                BlocklyActivity.ultradata4 = (int) Float.parseFloat(s1);
            }
            else if (s.contains("aa7")){
                int index = s.indexOf("aa7") + "aa7".length();
                String sa[] = s.substring(index,index+5).split("");
                String s1 = sa[0]+sa[1]+sa[2]+sa[3] +sa[4];
                Log.d("TAG", "getUltra: Ultra 7 "+ s1);
                BlocklyActivity.ultradata5 = (int) Float.parseFloat(s1);
            }
            else if (s.contains("aa8")){
                int index = s.indexOf("aa8") + "aa8".length();
                String sa[] = s.substring(index,index+5).split("");
                String s1 = sa[0]+sa[1]+sa[2]+sa[3] +sa[4];
                Log.d("TAG", "getUltra: Ultra 8 "+ s1);
                BlocklyActivity.ultradata6 = (int) Float.parseFloat(s1);
            }
        }
        catch (Exception e){
        }
    }


    public static void getPotenl(String s){
        //ff 55 00 ff 55 00 16 2c f7 04 41 0d 0a ff 55 0d 0a 00 16 2c f7 04
//        String s = "ff 55 00 ff 55 00 16 2c f7 04 41 0d 0a ff 55 0d 0a 00 16 2c f7 04";
        try{
            if(s.contains("pp1")){
                int index = s.indexOf("pp1") + "pp1".length();
                String sa[] = s.substring(index,index+4).split("");
                String s1 = sa[0]+sa[1]+sa[2];
                Log.d("TAG", "getPotenl: Port1"+ s1);
                BlocklyActivity.potenldata1 = (int) Integer.parseInt(s1);
            }
            else if(s.contains("pp2")){
                int index = s.indexOf("pp2") + "pp2".length();
                String sa[] = s.substring(index,index+4).split("");
                String s1 = sa[0]+sa[1]+sa[2];
                Log.d("TAG", "getPotenl: Port2"+ s1);
                BlocklyActivity.potenldata3 = (int) Integer.parseInt(s1);
            }
            else if(s.contains("pp3")) {
                int index = s.indexOf("pp3") + "pp3".length();
                String sa[] = s.substring(index, index + 4).split("");
                String s1 = sa[0] + sa[1] + sa[2];
                Log.d("TAG", "getPotenl: Port3" + s1);
                BlocklyActivity.potenldata2 = (int) Integer.parseInt(s1);
            }
        }
        catch (Exception e){
        }
    }

    public static void getLinevalue (String s){
        try{
            if(s.contains("fw20")){
                BlocklyActivity.lineValueS11 = "00";
                BlocklyActivity.lineValueS12 = "00";
                Log.d("TAG", "Value Port 2:"+ "fw20");
            } else  if(s.contains("fw21")){
                BlocklyActivity.lineValueS11 = "00";
                BlocklyActivity.lineValueS12 = "40";
                Log.d("TAG", "Value Port 2:"+ "fw21");
            } else  if(s.contains("fw22")){
                BlocklyActivity.lineValueS11 = "80";
                BlocklyActivity.lineValueS12 = "3f";
                Log.d("TAG", "Value Port 2:"+ "fw22");
            } else  if(s.contains("fw23")){
                BlocklyActivity.lineValueS11 = "40";
                BlocklyActivity.lineValueS12 = "40";
                Log.d("TAG", "Value Port 2:"+ "fw23");
            }
            if(s.contains("fw30")){
                BlocklyActivity.lineValueS21 = "00";
                BlocklyActivity.lineValueS22 = "00";
                Log.d("TAG", "Value Port 3:"+ "fw30");
            } else  if(s.contains("fw31")){
                BlocklyActivity.lineValueS21 = "00";
                BlocklyActivity.lineValueS22 = "40";
                Log.d("TAG", "Value Port 3:"+ "fw31");
            } else  if(s.contains("fw32")){
                BlocklyActivity.lineValueS21 = "80";
                BlocklyActivity.lineValueS22 = "3f";
                Log.d("TAG", "Value Port 3:"+ "fw32");
            } else  if(s.contains("fw33")){
                BlocklyActivity.lineValueS21 = "40";
                BlocklyActivity.lineValueS22 = "40";
                Log.d("TAG", "Value Port 3:"+ "fw33");
            }
            if(s.contains("fw50")){
                BlocklyActivity.lineValueS31 = "00";
                BlocklyActivity.lineValueS32 = "00";
                Log.d("TAG", "Value Port 5:"+ "fw50");
            } else  if(s.contains("fw51")){
                BlocklyActivity.lineValueS31 = "00";
                BlocklyActivity.lineValueS32 = "40";
                Log.d("TAG", "Value Port 5:"+ "fw51");
            } else  if(s.contains("fw52")){
                BlocklyActivity.lineValueS31 = "80";
                BlocklyActivity.lineValueS32 = "3f";
                Log.d("TAG", "Value Port 5:"+ "fw52");
            } else  if(s.contains("fw53")){
                BlocklyActivity.lineValueS31 = "40";
                BlocklyActivity.lineValueS32 = "40";
                Log.d("TAG", "Value Port 5:"+ "fw53");
            }
            if(s.contains("fw60")){
                BlocklyActivity.lineValueS41 = "00";
                BlocklyActivity.lineValueS42 = "00";
                Log.d("TAG", "Value Port 6:"+ "fw60");
            } else  if(s.contains("fw61")){
                BlocklyActivity.lineValueS41 = "00";
                BlocklyActivity.lineValueS42 = "40";
                Log.d("TAG", "Value Port 6:"+ "fw61");
            } else  if(s.contains("fw62")){
                BlocklyActivity.lineValueS41 = "80";
                BlocklyActivity.lineValueS42 = "3f";
                Log.d("TAG", "Value Port 6:"+ "fw62");
            } else  if(s.contains("fw63")){
                BlocklyActivity.lineValueS41 = "40";
                BlocklyActivity.lineValueS42 = "40";
                Log.d("TAG", "Value Port 6:"+ "fw63");
            }
            if(s.contains("fw70")){
                BlocklyActivity.lineValueS51 = "00";
                BlocklyActivity.lineValueS52 = "00";
                Log.d("TAG", "Value Port 7:"+ "fw70");
            } else  if(s.contains("fw71")){
                BlocklyActivity.lineValueS51 = "00";
                BlocklyActivity.lineValueS52 = "40";
                Log.d("TAG", "Value Port 7:"+ "fw71");
            } else  if(s.contains("fw72")){
                BlocklyActivity.lineValueS51 = "80";
                BlocklyActivity.lineValueS52 = "3f";
                Log.d("TAG", "Value Port 7:"+ "fw72");
            } else  if(s.contains("fw73")){
                BlocklyActivity.lineValueS51 = "40";
                BlocklyActivity.lineValueS52 = "40";
                Log.d("TAG", "Value Port 7:"+ "fw73");
            }
            if(s.contains("fw80")){
                BlocklyActivity.lineValueS61 = "00";
                BlocklyActivity.lineValueS62 = "00";
                Log.d("TAG", "Value Port 8:"+ "fw80");
            } else  if(s.contains("fw81")){
                BlocklyActivity.lineValueS61 = "00";
                BlocklyActivity.lineValueS62 = "40";
                Log.d("TAG", "Value Port 8:"+ "fw81");
            } else  if(s.contains("fw82")){
                BlocklyActivity.lineValueS61 = "80";
                BlocklyActivity.lineValueS62 = "3f";
                Log.d("TAG", "Value Port 8:"+ "fw82");
            } else  if(s.contains("fw83")){
                BlocklyActivity.lineValueS61 = "40";
                BlocklyActivity.lineValueS62 = "40";
                Log.d("TAG", "Value Port 8:"+ "fw83");
            }
        }
        catch (Exception e){
        }
    }

//    public static void getLinevalue (String s){
//        try{
//            if(s.contains("fw0")){
//                BlocklyActivity.lineValueS1 = "00";
//                BlocklyActivity.lineValueS2 = "00";
//                Log.d("TAG", "Vlaue assss:"+ "fw0");
//            } else  if(s.contains("fw1")){
//                BlocklyActivity.lineValueS1 = "00";
//                BlocklyActivity.lineValueS2 = "40";
//                Log.d("TAG", "Vlaue assss:"+ "fw1");
//            } else  if(s.contains("fw2")){
//                BlocklyActivity.lineValueS1 = "80";
//                BlocklyActivity.lineValueS2 = "3f";
//                Log.d("TAG", "Vlaue assss:"+ "fw2");
//            } else  if(s.contains("fw3")){
//                BlocklyActivity.lineValueS1 = "40";
//                BlocklyActivity.lineValueS2 = "40";
//                Log.d("TAG", "Vlaue assss:"+ "fw3");
//            }
//
//            }
//        catch (Exception e){
//        }
//    }



    public static void getTemperature(String s){
        try{
            if(s.contains("te2")){
                int index = s.indexOf("te2") + "te2".length();
                String sa[] = s.substring(index,index+5).split("");
                String s1 = sa[0]+sa[1]+sa[2]+sa[3]+sa[4];
                Log.d("TAG", "getTemperature: Port 2  "+s1);
                BlocklyActivity.temperatureData1 = (int) Float.parseFloat(s1);
            }
            else if(s.contains("te3")){
                int index = s.indexOf("te3") + "te3".length();
                String sa[] = s.substring(index,index+5).split("");
                String s1 = sa[0]+sa[1]+sa[2]+sa[3]+sa[4];
                Log.d("TAG", "getTemperature: Port 3  "+s1);
                BlocklyActivity.temperatureData2 = (int) Float.parseFloat(s1);
            }
            else if(s.contains("te5")){
                int index = s.indexOf("te5") + "te5".length();
                String sa[] = s.substring(index,index+5).split("");
                String s1 = sa[0]+sa[1]+sa[2]+sa[3]+sa[4];
                Log.d("TAG", "getTemperature: Port 5  "+s1);
                BlocklyActivity.temperatureData3 = (int) Float.parseFloat(s1);
            }
            else if(s.contains("te6")){
                int index = s.indexOf("te6") + "te6".length();
                String sa[] = s.substring(index,index+5).split("");
                String s1 = sa[0]+sa[1]+sa[2]+sa[3]+sa[4];
                Log.d("TAG", "getTemperature: Port 6  "+s1);
                BlocklyActivity.temperatureData4 = (int) Float.parseFloat(s1);
            }
            else if(s.contains("te7")){
                int index = s.indexOf("te7") + "te7".length();
                String sa[] = s.substring(index,index+5).split("");
                String s1 = sa[0]+sa[1]+sa[2]+sa[3]+sa[4];
                Log.d("TAG", "getTemperature: Port 7  "+s1);
                BlocklyActivity.temperatureData5 = (int) Float.parseFloat(s1);
            }
            else if(s.contains("te8")){
                int index = s.indexOf("te8") + "te8".length();
                String sa[] = s.substring(index,index+5).split("");
                String s1 = sa[0]+sa[1]+sa[2]+sa[3]+sa[4];
                Log.d("TAG", "getTemperature: Port 8  "+s1);
                BlocklyActivity.temperatureData6 = (int) Float.parseFloat(s1);
            }
        }
        catch (Exception e){
        }
    }


    public static void getAvoidValue(String s) {
        if (s.contains("av21")) {
            Log.d("TAG", "getAvoidValue2: true");
            BlocklyActivity.avoidData1 = true;   // touch
        }
        else if (s.contains("av20")){
            Log.d("TAG", "getAvoidValue2: false");
            BlocklyActivity.avoidData1 = false;
        };
        if (s.contains("av31")) {
            Log.d("TAG", "getAvoidValue3: true");
            BlocklyActivity.avoidData2 = true;   // touch
        }
        else if (s.contains("av30")){
            Log.d("TAG", "getAvoidValue3: false");
            BlocklyActivity.avoidData2 = false;
        };
        if (s.contains("av51")) {
            Log.d("TAG", "getAvoidValue5: true");
            BlocklyActivity.avoidData3 = true;   // touch
        }
        else if (s.contains("av50")){
            Log.d("TAG", "getAvoidValue5: false");
            BlocklyActivity.avoidData3 = false;
        };
        if (s.contains("av61")) {
            Log.d("TAG", "getAvoidValue6: true");
            BlocklyActivity.avoidData4 = true;   // touch
        }
        else if  (s.contains("av60")){
            Log.d("TAG", "getAvoidValue6: false");
            BlocklyActivity.avoidData4 = false;
        };
        if (s.contains("av71")) {
            Log.d("TAG", "getAvoidValue7: true");
            BlocklyActivity.avoidData5 = true;   // touch
        }
        else if (s.contains("av70")){
            Log.d("TAG", "getAvoidValue7: false");
            BlocklyActivity.avoidData5 = false;
        };
        if (s.contains("av81")) {
            Log.d("TAG", "getAvoidValue8: true");
            BlocklyActivity.avoidData6 = true;
        }
        else if  (s.contains("av80")){
            Log.d("TAG", "getAvoidValue8: false");
            BlocklyActivity.avoidData6 = false;
        };
    }

    public static void getTouchValue(String s) {
        if (s.contains("at21")) {
            Log.d("TAG", "getTouchValue2: true");
            BlocklyActivity.touchData1 = true;   // touch
        }
        else if (s.contains("at20")){
            Log.d("TAG", "getTouchValue2: false");
            BlocklyActivity.touchData1 = false;
        };
        if (s.contains("at31")) {
            Log.d("TAG", "getTouchValue3: true");
            BlocklyActivity.touchData2 = true;   // touch
        }
        else if (s.contains("at30")){
            Log.d("TAG", "getTouchValue3: false");
            BlocklyActivity.touchData2 = false;
        };
        if (s.contains("at51")) {
            Log.d("TAG", "getTouchValue5: true");
            BlocklyActivity.touchData3 = true;   // touch
        }
        else if (s.contains("at50")){
            Log.d("TAG", "getTouchValue5: false");
            BlocklyActivity.touchData3 = false;
        };
        if (s.contains("at61")) {
            Log.d("TAG", "getTouchValue6: true");
            BlocklyActivity.touchData4 = true;   // touch
        }
        else if  (s.contains("at60")){
            Log.d("TAG", "getTouchValue6: false");
            BlocklyActivity.touchData4 = false;
        };
        if (s.contains("at71")) {
            Log.d("TAG", "getTouchValue7: true");
            BlocklyActivity.touchData5 = true;   // touch
        }
        else if (s.contains("at70")){
            Log.d("TAG", "getTouchValue7: false");
            BlocklyActivity.touchData5 = false;
        };
        if (s.contains("at81")) {
            Log.d("TAG", "getTouchValue8: true");
            BlocklyActivity.touchData6 = true;   // touch
        }
        else if  (s.contains("at80")){
            Log.d("TAG", "getTouchValue8: false");
            BlocklyActivity.touchData6 = false;
        };
    }
    public static void requestBlePermissions(final Activity activity, int requestCode) {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, requestCode);
    }

    public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

}
