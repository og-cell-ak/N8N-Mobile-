package com.naten.mobile;
import android.content.*;import java.util.*;
public class BootReceiver extends BroadcastReceiver { public void onReceive(Context c,Intent i){ long t=c.getSharedPreferences("naten",0).getLong("next",0); if(t>System.currentTimeMillis()) ScheduleReceiver.schedule(c,t); } }
