package com.trongdeptrai.girlmvparchitech.retrofit2;

import com.trongdeptrai.girlmvparchitech.utils.Constrants;

public class APIUtils {
    public static DataClient getClient() {
        return RetrofitClient.getClient(Constrants.BASE_URL).create(DataClient.class);
    }
}
