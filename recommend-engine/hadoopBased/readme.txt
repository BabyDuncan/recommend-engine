step 1
hdfs dfs -mkdir -p /user/zhaoguohao/itemBasedCF
step 2
/Users/zhaoguohao/github/recommend-engine/recommend-engine/src/main/java/com/babyduncan/testData.txt
hdfs dfs -copyFromLocal -f /Users/zhaoguohao/github/recommend-engine/recommend-engine/src/main/java/com/babyduncan/testData.txt /user/zhaoguohao/itemBasedCF
hdfs dfs -ls /user/zhaoguohao/itemBasedCF
step 3
mahout recommenditembased -s SIMILARITY_LOGLIKELIHOOD -i /user/zhaoguohao/itemBasedCF/testData.txt -o /user/zhaoguohao/itemBasedCF/output --numRecommendations 3
