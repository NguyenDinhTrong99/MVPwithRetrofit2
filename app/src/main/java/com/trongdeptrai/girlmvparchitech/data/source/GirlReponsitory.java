package com.trongdeptrai.girlmvparchitech.data.source;

import com.trongdeptrai.girlmvparchitech.data.model.Girl;
import com.trongdeptrai.girlmvparchitech.data.source.remote.GirlDataJsonListener;

public class GirlReponsitory {
    private static GirlReponsitory sGirlReponsitory;
    private GirlDataSource.RemoteDataSoure mRemoteDataSource;
    private GirlDataSource.LocalDataSource mLocalDataSoucre;

    private GirlReponsitory(GirlDataSource.RemoteDataSoure remoteDataSource,
            GirlDataSource.LocalDataSource localDataSoucre) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSoucre = localDataSoucre;
    }

    public static GirlReponsitory getInstance(GirlDataSource.RemoteDataSoure remoteDataSource,
            GirlDataSource.LocalDataSource localDataSoucre) {
        if (sGirlReponsitory == null) {
            sGirlReponsitory = new GirlReponsitory(remoteDataSource, localDataSoucre);
        }
        return sGirlReponsitory;
    }

    public void getData(GirlDataJsonListener<Girl> listener) {
        mRemoteDataSource.getData(listener);
    }
}
