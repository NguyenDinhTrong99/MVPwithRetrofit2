package com.trongdeptrai.girlmvparchitech.data.source.local;

import com.trongdeptrai.girlmvparchitech.data.source.GirlDataSource;

public class GirlLocalDataSoucre implements GirlDataSource.LocalDataSource {
    private static GirlLocalDataSoucre sLocalDataSoucre;

    public static GirlLocalDataSoucre getInstance() {
        if (sLocalDataSoucre == null) sLocalDataSoucre = new GirlLocalDataSoucre();
        return sLocalDataSoucre;
    }
}
