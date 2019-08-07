package com.trongdeptrai.girlmvparchitech.screen.main;

import com.trongdeptrai.girlmvparchitech.data.model.Girl;
import com.trongdeptrai.girlmvparchitech.data.source.GirlReponsitory;
import com.trongdeptrai.girlmvparchitech.data.source.remote.GirlDataJsonListener;
import com.trongdeptrai.girlmvparchitech.screen.main.adapter.GirlAdapter;
import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private GirlReponsitory mReponsitory;

    public MainPresenter(GirlReponsitory reponsitory){
        mReponsitory = reponsitory;
    }


    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void getData() {
       mReponsitory.getData(new GirlDataJsonListener<Girl>() {
           @Override
           public void getSuccess(ArrayList<Girl> data) {
               mView.onSuccess(data);
           }

           @Override
           public void getFailed(Throwable t) {
            mView.onFailed(t);
           }
       });
    }
}
