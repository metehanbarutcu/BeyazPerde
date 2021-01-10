package com.h5190019.ibrahim_metehan_barutcu.util;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import androidx.appcompat.app.AlertDialog;

import com.h5190019.ibrahim_metehan_barutcu.R;

public class AlertUtil {

    public static void showExitAlert(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.exit_title));
        builder.setMessage(context.getResources().getString(R.string.exit_app));
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton(context.getResources().getString(R.string.exit_no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(context.getResources().getString(R.string.exit_yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                closeApp(context);
            }
        });
        builder.show();
    }

    public static void checkInternetAlert(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.internet_alert_title));
        builder.setMessage(context.getResources().getString(R.string.internet_app));
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton(context.getResources().getString(R.string.open_internet), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                openInternetSettings(context);
            }
        });
        builder.setNegativeButton(context.getResources().getString(R.string.close_app), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                closeApp(context);
            }
        });
        builder.show();
    }

    private static void closeApp(Context context) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private static void openInternetSettings(Context context) {
        Intent settings = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
        context.startActivity(settings);
    }


}