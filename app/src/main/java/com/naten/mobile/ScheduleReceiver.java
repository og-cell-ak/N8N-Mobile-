package com.naten.mobile;
import android.app.*;import android.content.*;import android.os.*;
public class ScheduleReceiver extends BroadcastReceiver {
 public void onReceive(Context c, Intent i){ NotificationUtil.show(c,"NATEN","Scheduled workflow triggered"); WorkflowStore.run(c); }
 public static void schedule(Context c,long at){ AlarmManager a=(AlarmManager)c.getSystemService(Context.ALARM_SERVICE); Intent in=new Intent(c,ScheduleReceiver.class); PendingIntent p=PendingIntent.getBroadcast(c,64,in,PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE); try{ if(Build.VERSION.SDK_INT>=23)a.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,at,p); else a.setExact(AlarmManager.RTC_WAKEUP,at,p); }catch(SecurityException e){ if(Build.VERSION.SDK_INT>=23)a.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,at,p); else a.set(AlarmManager.RTC_WAKEUP,at,p); } }
}