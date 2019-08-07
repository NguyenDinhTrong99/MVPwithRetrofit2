package com.trongdeptrai.girlmvparchitech.data.source;

import com.trongdeptrai.girlmvparchitech.data.model.Girl;
import com.trongdeptrai.girlmvparchitech.data.source.remote.GirlDataJsonListener;

public interface GirlDataSource {
    interface LocalDataSource {

    }

    interface RemoteDataSoure {
        void getData(GirlDataJsonListener<Girl> litenser);
    }
}
