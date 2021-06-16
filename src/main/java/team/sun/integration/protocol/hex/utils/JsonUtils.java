package team.sun.integration.protocol.hex.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class JsonUtils {
    /**
     * 将json字符串转化为Map
     * json字符串中所有字段不能重复
     *
     * @param jsonStr {\"topic\":\""+1+"\",\"payload\":\"{'data':{'lock':"+1+",'door':"+1+"},'code':"+1+"}\"}
     * @return {door=1, code=1, topic=1, lock=1}
     */
    public static Map<String, Object> jsonStrToMap(String jsonStr) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        Set<Map.Entry<String, Object>> set = jsonObject.entrySet();
        Map<String, Object> map = new HashMap<>();
        while (true) {
//            System.out.println("entrySet,长度："+jsonObject.entrySet().size());
            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                if (null != entry.getValue() && null != entry.getValue()) {
                    String value = entry.getValue().toString().trim();
                    if (value.startsWith("{") && value.endsWith("}")) {
                        JSONObject jb = JSON.parseObject(entry.getValue().toString());
                        jsonObject.remove(entry.getKey());
                        jsonObject.putAll(jb);
                        break;
                    } else if (value.startsWith("[") && value.endsWith("]")) {
                        //暂时没有的数组类型，不做处理

                    } else {
//                        System.out.println(entry.getKey()+","+entry.getValue());
                        map.put(entry.getKey(), entry.getValue());
                        jsonObject.remove(entry.getKey());
                        break;
                    }

                }
            }
            if (jsonObject.size() == 0) {
                break;
            }
        }

        return map;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        List<String> protocol2 = new ArrayList<>();
        protocol2.add("4_command");
        protocol2.add("4_topic1");
        protocol2.add("4_topic2");
        protocol2.add("4_topic1");
        protocol2.add("4_topic2");
        protocol2.add("4_topic1");
        for (String str : protocol2) {
            System.out.println(str);
        }

        Calendar cl = Calendar.getInstance();
        // 获得日期
        int date = cl.get(Calendar.DATE);
        // 获得小时
        int hour = cl.get(Calendar.HOUR_OF_DAY);
        // 获得分钟
        int minute = cl.get(Calendar.MINUTE);
        // 获得秒
        int second = cl.get(Calendar.SECOND);

        String time = "" + date + hour + minute + second;
        System.out.println(time);
        System.out.println(Integer.parseInt(time));
        System.out.println(Integer.MAX_VALUE);

        System.out.println();
        System.out.println(Math.abs(ThreadLocalRandom.current().nextInt()));
        String json = "{\"topic\":\"" + 1 + "\",\"payload\":\"{'data':{'lock':" + 1 + ",'door':" + 1 + "},'code':" + 1 + "}\"}";
        Map<Integer, String> data = new TreeMap<>();
//        json =
//                "{\"topic\":\""+data.get("topic")+"\",\"payload\":\"{'data':{'lock':"+data.get("lock")+",'door':"+data.get("door")+"},'code':"+data.get("code")+"}\"}"
//        +"{\"topic\":\""+data.get("topic")+"\",\"payload\":\"{'command':"+data.get("command")+",'data':{'equipid':"+data.get("equipid")+",'name':'"+data.get("name")+"'}}\"}"
//        +",{\"topic\":\""+data.get("topic")+"\",\"payload\":\"{'lock':"+data.get("lock")+",'door':"+data.get("door")+"}\",\"code\":"+data.get("code")+"}"
//                +",{\"topic\":\""+data.get("topic")+"\",\"payload\":\"{'data':{'down_epcs':"+data.get("down_epcs")+",'up_epcs':"+data.get("up_epcs")+",'scan_epcs':"+data.get("scan_epcs")+"},'code':"+data.get("code")+"}\"}"
//                + ",{\"topic\":\""+data.get("topic")+"\",\"payload\":\"{'command':"+data.get("command")+"}\"}"
//                    + ",{\"topic\":\""+data.get("topic")+"\",\"payload\":\"{'data':{'lock':"+data.get("lock")+",'door':"+data.get("door")+"},'code':"+data.get("code")+"}\"}"
//                + ",{\"topic\":\""+data.get("topic")+"\",\"payload\":\"{'command':"+data.get("command")+",'data':{'equipid':"+data.get("equipid")+",'name':'"+data.get("name")+"'}}\"}"
//                +",{\"topic\":\""+data.get("topic")+"\",\"payload\":\"{'command':"+data.get("command")+",'number':"+data.get("number")+",'status':"+data.get("status")+"}\"}"
//                +",{\"topic\":\""+data.get("topic")+"\",\"payload\":\"{'data':{'equipid':"+data.get("equipid")+"},'code':"+data.get("code")+"}\"}";

        //        Map<String, Object> param = JsonUtils.readFromJson(json, Map.class);
        System.out.println(json);
        System.out.println(jsonStrToMap(json));

    }


}
