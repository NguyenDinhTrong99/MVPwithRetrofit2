package com.trongdeptrai.girlmvparchitech.screen.main;

import com.trongdeptrai.girlmvparchitech.data.model.Girl;
import com.trongdeptrai.girlmvparchitech.utils.BasePresenter;
import java.util.ArrayList;

public interface MainContract {
    interface View{
        void onSuccess(ArrayList<Girl> list);
        void onFailed(Throwable t);
    }

    interface Presenter extends BasePresenter<View> {
        void getData();
    }
}
