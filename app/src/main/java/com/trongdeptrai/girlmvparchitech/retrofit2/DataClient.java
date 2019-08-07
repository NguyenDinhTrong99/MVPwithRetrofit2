package com.trongdeptrai.girlmvparchitech.retrofit2;

import com.trongdeptrai.girlmvparchitech.data.model.Girl;
import com.trongdeptrai.girlmvparchitech.utils.Constrants;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DataClient {
    @GET(Constrants.GET_GIRL)
    Call<ArrayList<Girl>> getListGirl();
}
