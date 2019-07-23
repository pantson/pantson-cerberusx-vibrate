import android.os.Vibrator;
import android.os.VibrationEffect;

class Vibrate {
  // info from https://stackoverflow.com/questions/4870667/how-can-i-use-getsystemservice-in-a-non-activity-class-locationmanager
  // effect info https://developer.android.com/reference/android/os/VibrationEffect to be fixed in API29 wrapper
  Activity activity = BBAndroidGame._androidGame._activity;
  Vibrator v = (Vibrator) activity.getSystemService(Context.VIBRATOR_SERVICE);
  
  public void vibrate(int millisecs,int effect){
     switch (effect) {
      case 0:
      effect = VibrationEffect.DEFAULT_AMPLITUDE;
      /*
      case 1:
      effect = VibrationEffect.EFFECT_CLICK;
      case 2:
      effect = VibrationEffect.EFFECT_DOUBLE_CLICK;
      case 3:
      effect = VibrationEffect.EFFECT_HEAVY_CLICK;
      case 4:
      effect = VibrationEffect.EFFECT_TICK;
      */
     }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      v.vibrate(VibrationEffect.createOneShot(millisecs, effect));
    } else {
      //deprecated in API 26 
      v.vibrate(millisecs);
    }
  }
}