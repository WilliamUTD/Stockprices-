package com.wjh160030.stockprices;

import java.util.ArrayList;

public class StockItemInfo {
    public String date;
    public String open;
    public String high;
    public String low;
    public String sclose;
    public String volume;
    public String adj;
    public String close;

    String error;

    StockItemInfo(String al) {

        if (al.contains("http")) {
            error = al;
        } else {
            String[] split = al.split(",");

            date = split[0];
            open = split[1];
            high = split[2];
            low = split[3];
            sclose = split[4];
            volume = split[5];
            adj = split[6];
            close = split[7];
        }
    }

    @Override
    public String toString(){
        return ("Date: " + date + " Open "+open+" High "+high+" Low " + low+" Close "+sclose+" Volume " + volume+" Adj: " + adj + " Close: "+close);
    }



}


