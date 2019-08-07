package com.trongdeptrai.girlmvparchitech.data.source.remote;

import java.util.ArrayList;

public interface GirlDataJsonListener<T> {
    void getSuccess(ArrayList<T> data);
    void getFailed(Throwable t);
}
