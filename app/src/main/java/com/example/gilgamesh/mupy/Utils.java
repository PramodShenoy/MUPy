package com.example.gilgamesh.mupy;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Utils {



//    SHARED PREFERENCES
    public static class SessionManager
    {
        private Context _context;
        private SharedPreferences preferences;
        private SharedPreferences.Editor editor;
        public static final String PREF_NAME = "USER_INFO";
        public static final String KEY_STATUS = "STATUS";

        public static String REGNO = "REGNO";
        public static String IMAGE_PATH = "USER_PATH";

        public SessionManager(Context context)
        {
            this._context = context;
            preferences = _context.getSharedPreferences(PREF_NAME, 0);
            editor = preferences.edit();
        }

        public void createSession(String regno) {
            editor.putBoolean(KEY_STATUS, true);
            editor.putString(REGNO, regno);
            editor.putString(IMAGE_PATH, null);
            editor.commit();
        }

        public static String getDefaults(String key, Context context) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            return preferences.getString(key, null);
        }

        public boolean isLoggedIn()
        {
            return preferences.getBoolean(KEY_STATUS, false);
        }

        public String getReg() {
            return preferences.getString(REGNO, null);
        }

        public void logout() {
            editor.clear();
            editor.commit();
        }

        public void setImagePath(String path) {
            editor.putString(IMAGE_PATH, path);
            editor.commit();
        }

        public String getImagePath() {
            return preferences.getString(IMAGE_PATH, null);
        }
    }
}
