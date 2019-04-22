import java.util.*;

/**
 * @author ashura1110
 * @ClassName Test02
 * @description TODO
 * @Date 2019/4/20 11:50
 * @Version 1.0
 */
public class Test02 {


    public static void main(String[] args) {

//        线程id、request-id（每次请求的request-id是同一个）、时间戳、日志文本
        String s1 = "[thread-1][100000][2019-03-15 13:07:42.164]login";
        String s2 = "[thread-1][100000][2019-03-15 13:07:42.164]read db";
        String s3 = "[thread-1][100000][2019-03-15 13:07:42.166]return json to frontend";
        String s4 = "[thread-2][100001][2019-03-15 13:07:47.102]login";

        Map<String, Integer> map = new LinkedHashMap<>();


        Map<String, Integer> map3 = new HashMap<>();
        map3 = getMapData2(s1, map);
        map3 = getMapData2(s2, map);
        map3 = getMapData2(s3, map);
        map3 = getMapData2(s4, map);

        List<Map.Entry<String,Integer>> list=new ArrayList(map3.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        //1、找出哪一秒日志数量最多，打印时间和日志条数；
        System.out.println(list.get(0));



        Map<String, Integer> map4 = new HashMap<>();
        Map<String, Integer> map01 = new LinkedHashMap<>();
        map4 = getMapData3(s1, map01);
        map4 = getMapData3(s2, map01);
        map4 = getMapData3(s3, map01);
        map4 = getMapData3(s4, map01);
        //2、统计平均每个请求产生多少条日志；
        System.out.println(map01.toString());
    }


    private static Map<String, Integer> getMapData2(String str, Map<String, Integer> map) {
        String[] split = str.split("]");
        String str2 = split[2];
        String substring = str2.substring(1, str2.length());
        int count = map.containsKey(substring) ? map.get(substring) : 0;
        map.put(substring, ++count);
        return map;
    }


    private static Map<String, Integer> getMapData3(String str, Map<String, Integer> map) {
        String[] split = str.split("]");
        String str1 = split[1];
        String substring = str1.substring(1, str1.length());
        int count = map.containsKey(substring) ? map.get(substring) : 0;
        map.put(substring, ++count);
        return map;
    }

}
