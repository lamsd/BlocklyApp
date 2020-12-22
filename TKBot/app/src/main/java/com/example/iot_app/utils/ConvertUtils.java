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


    public static int getSensor(String hex) {
        //ff 55 00 02 8d b0 cc 40 0d 0a
        String sa[] = hex.split(" ");
        int sensorVal = com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[7] + sa[6] + sa[5] + sa[4]);
        return (int) com.example.iot_app.utils.HexUtil.hexToFloat(sensorVal);
    }

    public static void getUltra(String s) {
//       ID: 61 61 port value[4]: The Ultrasonic sensor.
        try {
            if (s.contains("61 61 02")) {
                int index = s.indexOf("61 61 02") + "61 61 02".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                Log.d("TAG", "getUltra: Ultrasss 2 " + sa[3] + sa[2] + sa[1] + sa[0]);
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getUltra: Ultra 2 " + s1);
                BlocklyActivity.ultradata1 = (int) s1;
            }
            if (s.contains("61 61 03")) {
                int index = s.indexOf("61 61 03") + "61 61 03".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getUltra: Ultra 3 " + s1);
                BlocklyActivity.ultradata2 = (int) s1;
            }
            if (s.contains("61 61 05")) {
                int index = s.indexOf("61 61 05") + "61 61 05".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getUltra: Ultra 5 " + s1);
                BlocklyActivity.ultradata3 = (int) s1;
            }
            if (s.contains("61 61 06")) {
                int index = s.indexOf("61 61 06") + "61 61 06".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getUltra: Ultra 6 " + s1);
                BlocklyActivity.ultradata4 = (int) s1;
            }
            if (s.contains("61 61 07")) {
                int index = s.indexOf("61 61 07") + "61 61 07".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getUltra: Ultra 7 " + s1);
                BlocklyActivity.ultradata5 = (int) s1;
            }
            if (s.contains("61 61 08")) {
                int index = s.indexOf("61 61 08") + "61 61 08".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getUltra: Ultra 8 " + s1);
                BlocklyActivity.ultradata6 = (int) s1;
            }
        } catch (Exception e) {
        }
    }

    public static void getPotenl(String s) {
//        ID : 70 70 port value[4] the potenetimation module
        try {
            if (s.contains("70 70 01")) {
                int index = s.indexOf("70 70 01") + "70 70 01".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getPotenl: Port1" + s1);
                BlocklyActivity.potenldata1 = (int) s1;
            }
            if (s.contains("70 70 02")) {
                int index = s.indexOf("70 70 02") + "70 70 02".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getPotenl: Port2" + s1);
                BlocklyActivity.potenldata2 = (int) s1;
            }
            if (s.contains("70 70 03")) {
                int index = s.indexOf("70 70 03") + "70 70 03".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getPotenl: Port3" + s1);
                BlocklyActivity.potenldata3 = (int) s1;
            }
        } catch (Exception e) {
        }
    }

    public static void getLinevalue(String s) {
//      ID : 66 77 port value[4]
        try {
            if (s.contains("66 77 02")) {
                int index = s.indexOf("66 77 02") + "66 77 02".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                Log.d("TAG", "line : Follow Line port 2 " + sa[3] + sa[2] + sa[1] + sa[0]);
                int s1 = (int) com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "line: Value port 2  " + s1);
                if (s1 == 0) {
                    BlocklyActivity.lineValueS11 = "00";
                    BlocklyActivity.lineValueS12 = "00";
                    Log.d("TAG", "Value Port 2:" + "66 77 02 00");
                } else if (s1 == 1) {
                    BlocklyActivity.lineValueS11 = "00";
                    BlocklyActivity.lineValueS12 = "40";
                    Log.d("TAG", "Value Port 2:" + "66 77 02 01");
                } else if (s1 == 2) {
                    BlocklyActivity.lineValueS11 = "80";
                    BlocklyActivity.lineValueS12 = "3f";
                    Log.d("TAG", "Value Port 2:" + "66 77 02 02");
                } else if (s1 == 3) {
                    BlocklyActivity.lineValueS11 = "40";
                    BlocklyActivity.lineValueS12 = "40";
                    Log.d("TAG", "Value Port 2:" + "66 77 02 03");
                }
            }
            if (s.contains("66 77 03")) {
                int index = s.indexOf("66 77 03") + "66 77 03".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                Log.d("TAG", "line : Follow Line port 3 " + sa[3] + sa[2] + sa[1] + sa[0]);
                int s1 = (int) com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "line: Value port 3  " + s1);
                if (s1 == 0) {
                    BlocklyActivity.lineValueS21 = "00";
                    BlocklyActivity.lineValueS22 = "00";
                    Log.d("TAG", "Value Port 3:" + "66 77 03 00");
                } else if (s1 == 1) {
                    BlocklyActivity.lineValueS21 = "00";
                    BlocklyActivity.lineValueS22 = "40";
                    Log.d("TAG", "Value Port 3:" + "66 77 03 01");
                } else if (s1 == 2) {
                    BlocklyActivity.lineValueS21 = "80";
                    BlocklyActivity.lineValueS22 = "3f";
                    Log.d("TAG", "Value Port 3:" + "66 77 03 02");
                } else if (s1 == 3) {
                    BlocklyActivity.lineValueS21 = "40";
                    BlocklyActivity.lineValueS22 = "40";
                    Log.d("TAG", "Value Port 3:" + "66 77 03 03");
                }
            }
            if (s.contains("66 77 05")) {
                int index = s.indexOf("66 77 05") + "66 77 05".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                Log.d("TAG", "line : Follow Line port 5 " + sa[3] + sa[2] + sa[1] + sa[0]);
                int s1 = (int) com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "line: Value port 5  " + s1);
                if (s1 == 0) {
                    BlocklyActivity.lineValueS31 = "00";
                    BlocklyActivity.lineValueS32 = "00";
                    Log.d("TAG", "Value Port 5:" + "66 77 05 00");
                } else if (s1 == 1) {
                    BlocklyActivity.lineValueS31 = "00";
                    BlocklyActivity.lineValueS32 = "40";
                    Log.d("TAG", "Value Port 5:" + "66 77 05 01");
                } else if (s1 == 2) {
                    BlocklyActivity.lineValueS31 = "80";
                    BlocklyActivity.lineValueS32 = "3f";
                    Log.d("TAG", "Value Port 5:" + "66 77 05 02");
                } else if (s1 == 3) {
                    BlocklyActivity.lineValueS31 = "40";
                    BlocklyActivity.lineValueS32 = "40";
                    Log.d("TAG", "Value Port 5:" + "66 77 05 03");
                }
            }
            if (s.contains("66 77 06")) {
                int index = s.indexOf("66 77 06") + "66 77 06".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                Log.d("TAG", "line : Follow Line port 6 " + sa[3] + sa[2] + sa[1] + sa[0]);
                int s1 = (int) com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "line: Value port 6  " + s1);
                if (s1 == 0) {
                    BlocklyActivity.lineValueS41 = "00";
                    BlocklyActivity.lineValueS42 = "00";
                    Log.d("TAG", "Value Port 6:" + "66 77 06 00");
                } else if (s1 == 1) {
                    BlocklyActivity.lineValueS41 = "00";
                    BlocklyActivity.lineValueS42 = "40";
                    Log.d("TAG", "Value Port 6:" + "66 77 06 01");
                } else if (s1 == 2) {
                    BlocklyActivity.lineValueS41 = "80";
                    BlocklyActivity.lineValueS42 = "3f";
                    Log.d("TAG", "Value Port 6:" + "66 77 06 02");
                } else if (s1 == 3) {
                    BlocklyActivity.lineValueS41 = "40";
                    BlocklyActivity.lineValueS42 = "40";
                    Log.d("TAG", "Value Port 6:" + "66 77 06 03");
                }
            }
            if (s.contains("66 77 07")) {
                int index = s.indexOf("66 77 07") + "66 77 07".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                Log.d("TAG", "line : Follow Line port 7" + sa[3] + sa[2] + sa[1] + sa[0]);
                int s1 = (int) com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "line: Value port 7  " + s1);
                if (s1 == 0) {
                    BlocklyActivity.lineValueS51 = "00";
                    BlocklyActivity.lineValueS52 = "00";
                    Log.d("TAG", "Value Port 7:" + "66 77 07 00");
                } else if (s1 == 1) {
                    BlocklyActivity.lineValueS51 = "00";
                    BlocklyActivity.lineValueS52 = "40";
                    Log.d("TAG", "Value Port 7:" + "66 77 07 01");
                } else if (s1 == 2) {
                    BlocklyActivity.lineValueS51 = "80";
                    BlocklyActivity.lineValueS52 = "3f";
                    Log.d("TAG", "Value Port 7:" + "66 77 07 02");
                } else if (s1 == 3) {
                    BlocklyActivity.lineValueS51 = "40";
                    BlocklyActivity.lineValueS52 = "40";
                    Log.d("TAG", "Value Port 7:" + "66 77 07 03");
                }
            }
            if (s.contains("66 77 08")) {
                int index = s.indexOf("66 77 08") + "66 77 08".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                Log.d("TAG", "line : Follow Line port 8" + sa[3] + sa[2] + sa[1] + sa[0]);
                int s1 = (int) com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "line: Value port 8  " + s1);
                if (s1 == 0) {
                    BlocklyActivity.lineValueS61 = "00";
                    BlocklyActivity.lineValueS62 = "00";
                    Log.d("TAG", "Value Port 8:" + "66 77 08 00");
                } else if (s1 == 1) {
                    BlocklyActivity.lineValueS61 = "00";
                    BlocklyActivity.lineValueS62 = "40";
                    Log.d("TAG", "Value Port 8:" + "66 77 08 01");
                } else if (s1 == 2) {
                    BlocklyActivity.lineValueS61 = "80";
                    BlocklyActivity.lineValueS62 = "3f";
                    Log.d("TAG", "Value Port 8:" + "66 77 08 02");
                } else if (s1 == 3) {
                    BlocklyActivity.lineValueS61 = "40";
                    BlocklyActivity.lineValueS62 = "40";
                    Log.d("TAG", "Value Port 8:" + "66 77 08 03");
                }
            }
        } catch (Exception e) {
        }
    }

    public static void getTemperature(String s) {
//      ID 74 65 port value[4] The temperature sensor
        try {
            if (s.contains("74 65 02")) {
                int index = s.indexOf("74 65 02") + "74 65 02".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getTemperature: Port 2  " + s1);
                BlocklyActivity.temperatureData1 = (int) s1;
            }
            if (s.contains("74 65 03")) {
                int index = s.indexOf("74 65 03") + "74 65 03".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getTemperature: Port 3  " + s1);
                BlocklyActivity.temperatureData2 = (int) s1;
            }
            if (s.contains("74 65 05")) {
                int index = s.indexOf("74 65 05") + "74 65 05".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getTemperature: Port 5  " + s1);
                BlocklyActivity.temperatureData3 = (int) s1;
            }
            if (s.contains("74 65 06")) {
                int index = s.indexOf("74 65 06") + "74 65 06".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getTemperature: Port 6  " + s1);
                BlocklyActivity.temperatureData4 = (int) s1;
            }
            if (s.contains("74 65 07")) {
                int index = s.indexOf("74 65 07") + "74 65 07".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getTemperature: Port 7  " + s1);
                BlocklyActivity.temperatureData5 = (int) s1;
            }
            if (s.contains("74 65 08")) {
                int index = s.indexOf("74 65 08") + "74 65 08".length();
                String sa[] = s.substring(index + 1, index + 12).split(" ");
                float s1 = com.example.iot_app.utils.HexUtil.hexToFloat(com.example.iot_app.utils.HexUtil.getDecimal("0x" + sa[3] + sa[2] + sa[1] + sa[0]));
                Log.d("TAG", "getTemperature: Port 8  " + s1);
                BlocklyActivity.temperatureData6 = (int) s1;
            }
        } catch (Exception e) {
        }
    }

    public static void getAvoidValue(String s) {
//      ID: 61 76 port value[1] : The avoid sensor.
        if (s.contains("61 76 02 00")) {
            Log.d("TAG", "getAvoidValue2: true");
            BlocklyActivity.avoidData1 = true;   // touch
        } else if (s.contains("61 76 02 01")) {
            Log.d("TAG", "getAvoidValue2: false");
            BlocklyActivity.avoidData1 = false;
        }
        ;
        if (s.contains("61 76 03 00")) {
            Log.d("TAG", "getAvoidValue3: true");
            BlocklyActivity.avoidData2 = true;   // touch
        } else if (s.contains("61 76 03 01")) {
            Log.d("TAG", "getAvoidValue3: false");
            BlocklyActivity.avoidData2 = false;
        }
        ;
        if (s.contains("61 76 05 00")) {
            Log.d("TAG", "getAvoidValue5: true");
            BlocklyActivity.avoidData3 = true;   // touch
        } else if (s.contains("61 76 05 01")) {
            Log.d("TAG", "getAvoidValue5: false");
            BlocklyActivity.avoidData3 = false;
        }
        ;
        if (s.contains("61 76 06 00")) {
            Log.d("TAG", "getAvoidValue6: true");
            BlocklyActivity.avoidData4 = true;   // touch
        } else if (s.contains("61 76 06 01")) {
            Log.d("TAG", "getAvoidValue6: false");
            BlocklyActivity.avoidData4 = false;
        }
        ;
        if (s.contains("61 76 07 00")) {
            Log.d("TAG", "getAvoidValue7: true");
            BlocklyActivity.avoidData5 = true;   // touch
        } else if (s.contains("61 76 07 01")) {
            Log.d("TAG", "getAvoidValue7: false");
            BlocklyActivity.avoidData5 = false;
        }
        ;
        if (s.contains("61 76 08 00")) {
            Log.d("TAG", "getAvoidValue8: true");
            BlocklyActivity.avoidData6 = true;
        } else if (s.contains("61 76 08 01")) {
            Log.d("TAG", "getAvoidValue8: false");
            BlocklyActivity.avoidData6 = false;
        }
        ;
    }

    public static void getTouchValue(String s) {
//      ID 61 76 port value[1] : The touch sensor.
        if (s.contains("61 74 02 00")) {
            Log.d("TAG", "getTouchValue2: true");
            BlocklyActivity.touchData1 = true;   // touch
        } else if (s.contains("61 74 02 01")) {
            Log.d("TAG", "getTouchValue2: false");
            BlocklyActivity.touchData1 = false;
        }
        ;
        if (s.contains("61 74 03 00")) {
            Log.d("TAG", "getTouchValue3: true");
            BlocklyActivity.touchData2 = true;   // touch
        } else if (s.contains("61 74 03 01")) {
            Log.d("TAG", "getTouchValue3: false");
            BlocklyActivity.touchData2 = false;
        }
        ;
        if (s.contains("61 74 05 00")) {
            Log.d("TAG", "getTouchValue5: true");
            BlocklyActivity.touchData3 = true;   // touch
        } else if (s.contains("61 74 05 01")) {
            Log.d("TAG", "getTouchValue5: false");
            BlocklyActivity.touchData3 = false;
        }
        ;
        if (s.contains("61 74 06 00")) {
            Log.d("TAG", "getTouchValue6: true");
            BlocklyActivity.touchData4 = true;   // touch
        } else if (s.contains("61 74 06 01")) {
            Log.d("TAG", "getTouchValue6: false");
            BlocklyActivity.touchData4 = false;
        }
        ;
        if (s.contains("61 74 07 00")) {
            Log.d("TAG", "getTouchValue7: true");
            BlocklyActivity.touchData5 = true;   // touch
        } else if (s.contains("61 74 07 01")) {
            Log.d("TAG", "getTouchValue7: false");
            BlocklyActivity.touchData5 = false;
        }
        ;
        if (s.contains("61 74 08 00")) {
            Log.d("TAG", "getTouchValue8: true");
            BlocklyActivity.touchData6 = true;   // touch
        } else if (s.contains("61 74 08 01")) {
            Log.d("TAG", "getTouchValue8: false");
            BlocklyActivity.touchData6 = false;
        }
        ;
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
