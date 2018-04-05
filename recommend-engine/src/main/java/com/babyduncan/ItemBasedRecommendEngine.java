package com.babyduncan;


import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveArrayIterator;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhaoguohao on 2018/4/5.
 */
public class ItemBasedRecommendEngine {

    private static final Logger logger = Logger.getLogger(ItemBasedRecommendEngine.class);
    private static DataModel dataModel;
    private static Recommender itemBasedRecommend;
    private static int RECOMMEND_NUM = 3;

    public static DataModel getDataModel(String filePath) {
        DataModel dataModel = null;
        try {
            dataModel = new FileDataModel(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataModel;
    }

    public static List<RecommendedItem> recommend(int uid) {
        List<RecommendedItem> recommendedItems = null;
        try {
            recommendedItems = itemBasedRecommend.recommend(uid, RECOMMEND_NUM);
        } catch (TasteException e) {
            logger.error(e.getMessage(), e);
        }
        return recommendedItems;
    }

    public static void ItemBasedCF(DataModel dataModel) {

        ItemSimilarity itemSimilarity;
        try {
            //欧几里得距离
            itemSimilarity = new EuclideanDistanceSimilarity(dataModel);
            itemBasedRecommend = new GenericItemBasedRecommender(dataModel, itemSimilarity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }

    public static void main(String[] args) {
        DataModel dataModel = getDataModel("/Users/zhaoguohao/github/recommend-engine/recommend-engine/src/main/java/com/babyduncan/testData.txt");
        ItemBasedCF(dataModel);
        int uid = 12;
        System.out.print("UID:" + uid + " recommend ");
        List<RecommendedItem> recommendedItems = recommend(uid);
        for (RecommendedItem recommendedItem : recommendedItems) {
            System.out.print(recommendedItem.getItemID() + " , ");
        }
        System.out.println(";");
    }

}
