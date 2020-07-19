package com.jinyeob.carinfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveSharedPreference {
    private static final String PREF_USER_NUM = "usernum";
    private static final String PREF_USER_NAME = "username";

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    // 계정 정보 저장
    public static void setUser(Context ctx, String userNum, String userName) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NUM, userNum);
        editor.putString(PREF_USER_NAME, userName);

        editor.commit();
    }

    // 저장된 정보 가져오기
    public static String getUserNum(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_USER_NUM, "");
    }
    public static String getUserName(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }

    // 재설정
    public static void clearUser(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear();
        editor.commit();
    }
}
