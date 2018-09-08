package com.example.leidyzuluaga.leagueapp.controllers;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.leidyzuluaga.leagueapp.R;
import com.example.leidyzuluaga.leagueapp.controllers.views.IBaseView;
import com.example.leidyzuluaga.leagueapp.helper.CustomAlertDialog;
import com.example.leidyzuluaga.leagueapp.helper.IValidateInternet;
import com.example.leidyzuluaga.leagueapp.helper.ValidateInternet;
import com.example.leidyzuluaga.leagueapp.presenters.BasePresenter;

public class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseView {

    private T presenter;
    private IValidateInternet validateInternet;
    private CustomAlertDialog customAlertDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.validateInternet = new ValidateInternet(this);
        this.customAlertDialog = new CustomAlertDialog(this);
    }


    public IValidateInternet getValidateInternet() {
        if (validateInternet == null) {
            validateInternet = new ValidateInternet(this);
        } else {

        }
        return validateInternet;
    }


    public CustomAlertDialog getCustomAlertDialog() {
        return customAlertDialog;
    }


    protected T getPresenter() {
        return presenter;
    }

    protected void setPresenter(T presenter) {
        this.presenter = presenter;
    }


}
