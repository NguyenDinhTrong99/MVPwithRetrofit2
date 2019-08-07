package com.trongdeptrai.girlmvparchitech.data.source.remote;

import com.trongdeptrai.girlmvparchitech.data.model.Girl;
import com.trongdeptrai.girlmvparchitech.data.source.GirlDataSource;
import com.trongdeptrai.girlmvparchitech.data.source.remote.fetchjson.GetJsonFromUrl;

public class GirlRemoteDataSource implements GirlDataSource.RemoteDataSoure {
    private static GirlRemoteDataSource sGirlRemoteDataSource;

    public static GirlRemoteDataSource getInstance() {
        if (sGirlRemoteDataSource == null) sGirlRemoteDataSource = new GirlRemoteDataSource();
        return sGirlRemoteDataSource;
    }

    @Override
    public void getData(GirlDataJsonListener<Girl> listener) {
        GetJsonFromUrl json = new GetJsonFromUrl(listener);
        json.getListGirl();
    }

}
