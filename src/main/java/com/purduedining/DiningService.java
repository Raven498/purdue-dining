package com.purduedining;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
@Service
public class DiningService {
    private final String meal_query = "query getLocationMenu($name: String!, $date: Date!) { diningCourtByName(name: $name) { dailyMenu(date: $date) { meals { name stations { name items { item { itemId name } } } } } } }";
    private final String variables = "query ($id: Guid!) { itemByItemId(itemId: $id) { name nutritionFacts { label name } } }";

    public ArrayList<String> getAvailableMeals(String court, String date) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().writeTimeout(20, TimeUnit.SECONDS).build();
        String json = String.format("{\"query\": \"%s\", \"variables\": {\"name\": \"%s\", \"date\": \"%s\"}}", meal_query, court, date);
        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url("https://api.hfs.purdue.edu/menus/v3/GraphQL")
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();
        ResponseBody response = client.newCall(request).execute().body();
        String responseJson = response.string();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseNode = mapper.readTree(responseJson);
        JsonNode meals = responseNode.get("data").get("diningCourtByName").get("dailyMenu").get("meals");
        ArrayList<String> availMeals = new ArrayList<>();
        for(JsonNode m : meals){
            if(!m.get("stations").isEmpty()){
                availMeals.add(m.get("name").asText());
            }
        }
        return availMeals;
    }

    public JsonNode getMenu(String court, String meal_period, String date) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().writeTimeout(20, TimeUnit.SECONDS).build();
        String json = String.format("{\"query\": \"%s\", \"variables\": {\"name\": \"%s\", \"date\": \"%s\"}}", meal_query, court, date);
        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url("https://api.hfs.purdue.edu/menus/v3/GraphQL")
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();
        ResponseBody response = client.newCall(request).execute().body();
        String responseJson = response.string();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseNode = mapper.readTree(responseJson);
        JsonNode meals = responseNode.get("data").get("diningCourtByName").get("dailyMenu").get("meals");
        System.out.println(responseJson);
        for(JsonNode m : meals){
            if(m.get("name").asText().equals(meal_period)){
                return m.get("stations");
            }
        }
        return null;
    }

    public Macro getNutrition(){
        return null;
    }
}