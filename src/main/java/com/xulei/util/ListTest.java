package com.xulei.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 批量导入数据
 */
public class ListTest {

    public static void main(String[] args) {

        List list=new ArrayList();

        int dataSize = 1000;
        int start = 0;
        while (start < list.size()) {

            int from = start;

            int end = start + dataSize;

            if (end >= list.size()) {

                end = list.size();
            }
            List subList = list.subList(from, end);

            if (subList.isEmpty()) {
                break;
            }
            start = end;
//            paymentInstemService.batchInsert(subList);
        }


    }
}
