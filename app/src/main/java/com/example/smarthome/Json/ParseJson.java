package com.example.smarthome.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.smarthome.Database.Device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseJson {
    //    List<Map<String,String>> dataArrays=new ArrayList<Map<String,String>>();
//    List<Map<String, String>> parseJSONWithJSONObject(String jsonData) {
//        try {
//            JSONArray jsonArray = new JSONArray(jsonData);
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                Map<String,String> dataArray=new HashMap<>();
//                String adress = jsonObject.getString("adress");//
//                String code = jsonObject.getString("code");
//                String mess = jsonObject.getString("mess");
//                dataArray.put("adress",adress);
//                dataArray.put("code",code);
//                dataArray.put("mess",mess);
//                dataArrays.add(dataArray);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dataArrays;
//    }
//    void ParseJsonWithObject(String jsonData, Info object){
//        try {
//            JSONObject jsonObject=new JSONObject(jsonData);
//            object.setAdress(jsonObject.getString("adress"));//
//            object.setCode(jsonObject.getString("code"));
//            object.setMess(jsonObject.getString("mess"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    //这个是如果app向中控发送数据请求具体设备信息的

    void parseJson(String jsonData, Map<String,String> map){
        JSONObject jsonObject=JSONObject.parseObject(jsonData);
        JSONArray sensors=jsonObject.getJSONArray("sensors");
        JSONArray jsonArray= JSON.parseArray(sensors.toString());
        int size=jsonArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject1=jsonArray.getJSONObject(i);
            map.put("source_short_address",jsonObject1.getString("source_short_address"));
            map.put("network_flag",jsonObject1.getString("network_flag"));
            map.put("source_command",jsonObject1.getString("source_command"));//设备类型
            map.put("source_data",jsonObject1.getString("source_data"));
            map.put("misc",jsonObject1.getString("misc"));

        }
//"{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";


    }

    void parseJsonAndUpdateDatabase(String jsonData, List<Map<String,String>> devicesList){
        Map<String,String> map=new HashMap<>();
        JSONObject jsonObject=JSONObject.parseObject(jsonData);
        JSONArray sensors=jsonObject.getJSONArray("sensors");
        JSONArray jsonArray= JSON.parseArray(sensors.toString());
        int size=jsonArray.size();

        for (int i = 0; i < size; i++) {

            JSONObject jsonObject1=jsonArray.getJSONObject(i);
            map.put("source_short_address",jsonObject1.getString("source_short_address"));
            map.put("network_flag",jsonObject1.getString("network_flag"));
            map.put("source_command",jsonObject1.getString("source_command"));//设备类型
            map.put("source_data",jsonObject1.getString("source_data"));
            map.put("misc",jsonObject1.getString("misc"));
            //储存数据到数据库
            Device device=new Device();
            device.setSource_short_address(jsonObject1.getString("source_short_address"));
            device.setNetwork_flag(jsonObject1.getInteger("network_flag"));
            device.setSource_command(jsonObject1.getInteger("source_command"));
            device.save();
            devicesList.add(map);
        }
    }



}