package com.github.utils.poi;

import com.github.utils.poi.PoiUtils;

import java.io.File;

/**
 * @Author: Zer01ne
 * @Date: 2018/11/20 14:10
 * @Version 1.0
 */
public class PoiTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        PoiUtils.importExcel(new File("C:\\Users\\Ninee\\Desktop\\表格\\20180509库存商品.xlsx"));
        long end = System.currentTimeMillis() - start;
        long start2 = System.currentTimeMillis();
        PoiUtils.asyncImportExcel(new File("C:\\Users\\Ninee\\Desktop\\表格\\20180509库存商品.xlsx"));
        long end2 = System.currentTimeMillis() - start2;
        System.err.println(end > end2);

    }
}
