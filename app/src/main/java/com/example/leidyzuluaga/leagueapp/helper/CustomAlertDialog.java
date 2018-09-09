package com.example.leidyzuluaga.leagueapp.helper;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;

public class CustomAlertDialog {

    private final Activity activity;

    public CustomAlertDialog(Activity activity) {
        this.activity = activity;
    }

    public void showAlertDialog(int title, String message, boolean cancelable, int textPositiveButton, DialogInterface.OnClickListener onClickListenerPositiveButton, int textNegativeButton, DialogInterface.OnClickListener onClickListenerNegativeButton) {
        showAlertDialog(activity.getResources().getString(title), message, cancelable, textPositiveButton, onClickListenerPositiveButton, textNegativeButton, onClickListenerNegativeButton);
    }

    public void showAlertDialog(String title, String message, boolean cancelable, int textPositiveButton, DialogInterface.OnClickListener onClickListenerPositiveButton, int textNegativeButton, DialogInterface.OnClickListener onClickListenerNegativeButton) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(cancelable);
        if (onClickListenerPositiveButton != null) {
            builder.setPositiveButton(textPositiveButton, onClickListenerPositiveButton);
        }
        if (onClickListenerNegativeButton != null) {
            builder.setNegativeButton(textNegativeButton, onClickListenerNegativeButton);
        }
        builder.show();
    }

}
