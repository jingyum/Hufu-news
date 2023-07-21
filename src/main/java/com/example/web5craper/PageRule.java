package com.example.web5craper;

import generator.domain.Interfaces;

public class PageRule {
    public static String get_page(Interfaces iface, int page) {
        String page_number = "";
        if (iface.getInterf().contains("baidu")) {
            page_number = "&pn=" + ((page - 1) * 10);
        } else if (iface.getInterf().contains("news.so.com")) {
            page_number = "&pn=" + page + "&rank=rank&j=0&nso=10&tp=20&nc=0&src=page";
        }
        return page_number;
    }

    public static String page_num(Interfaces iface) {
        String pn = "";
        if (iface.getInterf().contains("baidu")) {
            pn = "//*[@id=\"page\"]/div/strong/span[2]";
        } else if (iface.getInterf().contains("news.so.com")) {
            pn = "";
        }
        return pn;
    }
}
