package com.example.security.controller;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/**
 * @author DELL
 * @since 1.0.0
 */
public class SparkTest {
    public static void main(String[] args) {
        SparkSession sparkSession = SparkSession.builder().appName("SparkTest").master("local").getOrCreate();
        //spark对普通List的reduce操作
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> originRDD = javaSparkContext.parallelize(data);
        //计算所有元素的和
        System.err.println("reduce操作1:" + originRDD.reduce((a, b) -> a + b));

        //******************map的使用***************//
        //将原始元素每个都乘以2
        JavaRDD<Integer> doubleRDD = originRDD.map(s -> s * 2);
        //将RDD收集起来，组成list
        List<Integer> doubleData = doubleRDD.collect();
        System.err.println("reduce操作2:" + doubleData);
        int total = doubleRDD.reduce((a, b) -> a + b);
        System.err.println("reduce操作3:" + total);

        //使用map将key变成key-value，添加value
        List<String> list = Arrays.asList("af", "bbbb", "c", "d", "e");
        JavaRDD<String> stringRDD = javaSparkContext.parallelize(list);
        //转为key-value形式
        JavaPairRDD pairRDD = stringRDD.mapToPair(k -> new Tuple2<>(k, 1));
        List list1 = pairRDD.collect();
        //[(af,1), (bbbb,1), (c,1), (d,1), (e,1)]
        System.err.println("操作4:" + list1);

        //转为key-value，value不变，修改key
        JavaPairRDD valueRDD = stringRDD.mapToPair(k -> new Tuple2<>(k.length(), k));
        List list2 = valueRDD.collect();
        //[(2, af),(4, bbbb),(1, c),(1, d),(1, e)]
        System.err.println("操作5:" + list2);
        //mapValues
        List list3 = valueRDD.mapValues(s -> s + "_tail").collect();
        //[(2,af_tail), (4,bbbb_tail), (1,c_tail), (1,d_tail), (1,e_tail)]
        System.err.println("操作6:" + list3);
    }
}