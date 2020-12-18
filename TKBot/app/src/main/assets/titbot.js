'use strict';

var Turtle = {};

Turtle.touchPort = "00";

Turtle.temperature = 0;

Turtle.potenl = 0;


Turtle.execute = function(code) {
try {
    eval(code);
  } catch (e) {
    if (e !== Infinity) {
      alert(e);
    }
  }
};
function sleep(milliseconds) {
  const date = Date.now();
  let currentDate = null;
  do {
    currentDate = Date.now();
  } while (currentDate - date < milliseconds);
}
// Move M1, M2 with forward_by method or backward by method.
Turtle.WMF = function(value){
    Android.mForward(value);
}
Turtle.WMB = function(value){
    Android.mBackward(value);
}
Turtle.movem1m2 = function(valueM1, valueM2){
  Android.moveMotorM1M2(valueM1, valueM2);
};

// Servo
Turtle.servo_no = function(value_port, speed_servo){
       Android.mservo_NO(value_port, speed_servo);
};

//servo
Turtle.servo = function(port, slot, angle){
    Android.servo(port, slot, angle);
}

Turtle.mAFServo = function(port, angle, duration){
    Android.mAServo(port, angle, duration);
}


 Turtle.ultraSensor = function(port){
    sleep(40);
    return Android.requestSensor(port);
 }

//Temperature sensor
Turtle.tempSensor = function(port){
    sleep(50);
     return Android.getTemVal(port);
}

//Potentimeter module
Turtle.potenSensor = function(port){
    sleep(50);
    return Android.getPotenlVal(port);
}
//Follow2 sensor
Turtle.lineFollow2 = function(port, side, color){
    sleep(50);
    return Android.lineFollow2(port, side, color);
}

//Touch sensor
Turtle.touchSensor = function(port){
    sleep(50);
    return Android.getTouchVal(port);
   }

//Avoid sensor
Turtle.avoidSensor = function(port){
//    sleep(50);
    return Android.getAvoidVal(port);
    }

//Light sensor
Turtle.lightSensor = function(port){
    Android.lightSensor(port);
}


//Stop  funtions
Turtle.isStop = function(){
if(Android.isStop() == 1){
    return true;
}
return false;
}




