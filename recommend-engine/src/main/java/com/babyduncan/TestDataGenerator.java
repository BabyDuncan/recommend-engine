package com.babyduncan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 * Created by zhaoguohao on 2018/4/5.
 * 生成测试数据
 */
public class TestDataGenerator {

    private static final String SPLIT_CHAR = "\t";

    public static void main(String[] args) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                new File("/Users/zhaoguohao/github/recommend-engine/recommend-engine/src/main/java/com/babyduncan/testData.txt")
        ));
        for (int i = 0; i < 10000; i++) {
            StringBuffer stringBuffer = new StringBuffer(24);
            stringBuffer.append(generateUId());
            stringBuffer.append(SPLIT_CHAR);
            stringBuffer.append(generateMId());
            stringBuffer.append(SPLIT_CHAR);
            stringBuffer.append(generateScore());
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();

    }

    private static float generateScore() {
        return new Random().nextInt(10);
    }

    private static int generateMId() {
        return new Random().nextInt(500);
    }

    private static int generateUId() {
        return new Random().nextInt(200);
    }


}
