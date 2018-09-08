package com.example.leidyzuluaga.leagueapp.presenters;

import com.example.leidyzuluaga.leagueapp.controllers.views.IBaseView;
import com.example.leidyzuluaga.leagueapp.helper.IValidateInternet;

public class BasePresenter<T extends IBaseView> {

    private T view;
    private IValidateInternet validateInternet;

    public void inject(T view, IValidateInternet validateInternet) {
        this.view = view;
        this.validateInternet = validateInternet;
    }

    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }

    public IValidateInternet getValidateInternet() {
        return validateInternet;
    }


}


