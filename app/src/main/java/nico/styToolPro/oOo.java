package nico.styToolPro;

public class oOo {

    public static String QQPluginClass = "com.tenpay.android.qqplugin.a.q";

    public static void init(String version) {
        switch (version) {
            case "6.6.2":
                QQPluginClass = "com.tenpay.android.qqplugin.a.q";
                break;
            default:
                QQPluginClass = "com.tenpay.android.qqplugin.a.q";
        }
    }

}
