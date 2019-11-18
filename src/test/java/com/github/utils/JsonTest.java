/**
 * projectName: utils
 * fileName: JsonTest.java
 * packageName: com.github.utils
 * date: 2019-11-12 14:27
 * copyright(c) 2019 http://www.hydee.cn/ Inc. All rights reserved.
 */
package com.github.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @version: V1.0
 * @author: Tao Fengfeng
 * @className: JsonTest
 * @packageName: com.github.utils
 * @description:
 * @data: 2019-11-12 14:27
 **/
public class JsonTest {

    public static void main(String[] args) {
        String body = "{\n" +
                "  \"receiptId\": \"114\",\n" +
                "  \"acceptanceId\": \"51\",\n" +
                "  \"orgId\": \"123\",\n" +
                "  \"sourceOrgId\": \"\",\n" +
                "  \"supplierInsideCode\": \"123\",\n" +
                "  \"sourceOrderId\": \"\",\n" +
                "  \"sourceOrderType\": \"1\",\n" +
                "  \"storageStatus\": \"2\",\n" +
                "  \"buyerId\": \"123\",\n" +
                "  \"note\": \"123123\",\n" +
                "  \"paymentPeriod\": \"1\",\n" +
                "  \"paymentMethod\": \"1\",\n" +
                "  \"settlerCode\": \"123\",\n" +
                "  \"settlerName\": \"结算户\",\n" +
                "  \"storageWareVos\": [\n" +
                "    {\n" +
                "      \"rowNumber\": \"1\",\n" +
                "      \"wareCode\": \"123\",\n" +
                "      \"wareInsideCode\": \"123\",\n" +
                "      \"productionCp\": \"12\",\n" +
                "      \"productionArea\": \"123\",\n" +
                "      \"storageGoodsNumber\": \"213\",\n" +
                "      \"purchasePrice\": \"12\",\n" +
                "      \"madeDate\": \"1571638881000\",\n" +
                "      \"validUntilTime\": \"1571638881000\",\n" +
                "      \"madeNumber\": \"123\",\n" +
                "      \"purtax\": \"1\",\n" +
                "      \"stallType\": \"1\",\n" +
                "      \"orderGoodsNumber\": \"123\",\n" +
                "      \"acceptanceGoodsNumber\": \"123\",\n" +
                "      \"refuseGoodsNumber\": \"12\",\n" +
                "      \"refuseReasonType\": \"1\",\n" +
                "      \"shipmentTemperature\": \"12\",\n" +
                "      \"arrivalTemperature\": \"12\",\n" +
                "      \"transitTemperature\": \"1\",\n" +
                "      \"transitHumidity\": \"1\",\n" +
                "      \"averageTemperature\": \"12\",\n" +
                "      \"amount\": \"123\",\n" +
                "      \"sterilizationBatchNumber\": \"12312\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";


        Map map = JSONObject.parseObject(body, Map.class);

        System.out.println(map);


    }
}