package io.github.sumeta.android.androidrestapi.Retrofit2;

import androidx.lifecycle.ViewModel;

public class Retrofit2ViewModel extends ViewModel {

    private String login;
    private int number;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}