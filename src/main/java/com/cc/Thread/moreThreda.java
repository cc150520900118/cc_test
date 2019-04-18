package com.cc.Thread;

import java.util.List;

/**
 * Created by admin on 2019/4/16.
 */
public class moreThreda extends Thread {
    private List<String> data;
    private int start;
    private int end;
    private int step;
    private int ticket =10;
    private String name;


    public moreThreda(String name) {

        this.name = name;
    }

    public void run() {
        if (start > data.size()) {
            return;
        }
        if (end > data.size()) {
            end = data.size();
        }
        List<String> citylist = data.subList(start, end);  //从fromIndex（包含），到toIndex（不包含）
        for (int i = 0; i < 500; i++) {
            if (this.ticket > 0) {
                System.out.println(this.name + "卖票---->" + (this.ticket--));
            }
        }
}
}
