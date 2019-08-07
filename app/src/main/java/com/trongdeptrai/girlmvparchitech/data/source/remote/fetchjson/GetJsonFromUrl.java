package com.trongdeptrai.girlmvparchitech.data.source.remote.fetchjson;

import com.trongdeptrai.girlmvparchitech.data.model.Girl;
import com.trongdeptrai.girlmvparchitech.data.source.remote.GirlDataJsonListener;
import com.trongdeptrai.girlmvparchitech.retrofit2.APIUtils;
import com.trongdeptrai.girlmvparchitech.retrofit2.DataClient;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetJsonFromUrl {
    private GirlDataJsonListener<Girl> mListener;

    public GetJsonFromUrl(GirlDataJsonListener<Girl> listener) {
        mListener = listener;
    }

    public void getListGirl() {
        DataClient dataClient = APIUtils.getClient();
        Call<ArrayList<Girl>> callback = dataClient.getListGirl();
        callback.enqueue(new Callback<ArrayList<Girl>>() {
            @Override
            public void onResponse(Call<ArrayList<Girl>> call, Response<ArrayList<Girl>> response) {
                if (response.isSuccessful()) {
                    mListener.getSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Girl>> call, Throwable t) {
                mListener.getFailed(t);
            }
        });
    }
}
