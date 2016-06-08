package bigdataSpark.bigdataSpark;
import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.*;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main0(String[] args) {
        String logFile = "sparkinput.txt";
        JavaSparkContext sc = new JavaSparkContext("local", "Appliation");
        JavaRDD<String> logData = sc.textFile(logFile).cache();

        long numAs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) {
                return s.contains("a");
            }
        }).count();

        long numBs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) {
                return s.contains("b");
            }
        }).count();

        if (numAs != 2 || numBs != 2) {
            System.out.println("Failed to parse log files with Spark");
            System.exit(-1);
        }
        System.out.println("Test succeeded");
        sc.stop();
    }

    public static void main(String[] args) {
        List<String> data0
                = Arrays.asList("110,grapefruit", "100,mango", "200,orange");
        JavaSparkContext sc = new JavaSparkContext("local", "App");
        JavaRDD<String> data1 = sc.parallelize(data0);
        JavaRDD<Integer> data3 = data1.map(new Function<String,
                Integer>() {
            @Override
            public Integer call(String s) throws Exception {
                String[] tmp = s.split(",");
                return Integer.parseInt(tmp[0]);

            }
        });

        int result = data3.reduce(new Function2<Integer, Integer, Integer>() {

            @Override
            public Integer call(Integer a, Integer b) throws Exception {
                return a + b;
            }
        });
        System.out.println("result:" + result);
    }
}
