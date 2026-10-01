package com.naten.mobile;
import android.content.*;import org.json.*;
public final class WorkflowStore {
 static String key="workflow";
 public static void save(Context c,String json){c.getSharedPreferences("naten",0).edit().putString(key,json).apply();}
 public static String load(Context c){return c.getSharedPreferences("naten",0).getString(key,"{}");}
 public static void run(Context c){ try{JSONObject w=new JSONObject(load(c)); JSONArray ns=w.optJSONArray("nodes"); if(ns==null)return; for(int i=0;i<ns.length();i++){JSONObject n=ns.getJSONObject(i); if("Notification".equals(n.optString("type"))) NotificationUtil.show(c,n.optString("title","AutoPilot"),n.optString("message","Workflow executed"));} }catch(Exception ignored){} }
}
