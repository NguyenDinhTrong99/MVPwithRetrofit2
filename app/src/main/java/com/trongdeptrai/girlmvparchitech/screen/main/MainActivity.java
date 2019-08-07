package com.trongdeptrai.girlmvparchitech.screen.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.trongdeptrai.girlmvparchitech.R;
import com.trongdeptrai.girlmvparchitech.data.model.Girl;
import com.trongdeptrai.girlmvparchitech.data.source.GirlReponsitory;
import com.trongdeptrai.girlmvparchitech.data.source.local.GirlLocalDataSoucre;
import com.trongdeptrai.girlmvparchitech.data.source.remote.GirlRemoteDataSource;
import com.trongdeptrai.girlmvparchitech.screen.main.adapter.GirlAdapter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    public static final String TAG = MainActivity.class.getSimpleName();
    private GirlAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    @Override
    public void onSuccess(ArrayList<Girl> list) {
        mAdapter.updateData(list);
    }

    @Override
    public void onFailed(Throwable t) {
        Log.e(TAG, t.getMessage());
    }

    private void initView() {
        mAdapter = new GirlAdapter();
        RecyclerView rcvGirl = findViewById(R.id.recycler_girl);
        rcvGirl.setHasFixedSize(true);
        rcvGirl.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvGirl.setAdapter(mAdapter);
    }

    private void initData() {
        GirlRemoteDataSource remoteDataSource = GirlRemoteDataSource.getInstance();
        GirlLocalDataSoucre localDataSoucre = GirlLocalDataSoucre.getInstance();
        GirlReponsitory reponsitory =
                GirlReponsitory.getInstance(remoteDataSource, localDataSoucre);
        MainContract.Presenter presenter = new MainPresenter(reponsitory);
        presenter.setView(this);
        presenter.getData();
    }
}
