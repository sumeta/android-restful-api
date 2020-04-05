package io.github.sumeta.android.androidrestapi.RecyclerView;

import androidx.lifecycle.ViewModel;

public class RecyclerViewModel extends ViewModel {

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