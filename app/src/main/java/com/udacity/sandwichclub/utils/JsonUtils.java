package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameObject = jsonObject.getJSONObject("name");

            // Getting Main Name
            String mainName = nameObject.getString("mainName");

            // Getting Also known as in a String array
            JSONArray alsoKnownAsJsonArray = nameObject.getJSONArray("alsoKnownAs");
            String alsoKnownAs = "";
            for(int i=0 ; i< alsoKnownAsJsonArray.length() ; i++){
                if(i< alsoKnownAsJsonArray.length()-1){
                    alsoKnownAs += alsoKnownAsJsonArray.getString(i)+", ";
                }else{
                    alsoKnownAs += alsoKnownAsJsonArray.getString(i);
                }
            }

            // Getting place of origin
            String origin = jsonObject.getString("placeOfOrigin");

            // Getting Description
            String description = jsonObject.getString("description");

            // Getting image url as a String
            String image =jsonObject.getString("image");

            // Getting ingredients as String array
            JSONArray ingredientsJsonArray = jsonObject.getJSONArray("ingredients");
            String ingredients = "";
            for(int i=0 ;i< ingredientsJsonArray.length(); i++){
                ingredients += ingredientsJsonArray.getString(i)+"\n";
            }

            // Setting the values to Sandwich object
            sandwich.setMainName(mainName);
            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setPlaceOfOrigin(origin);
            sandwich.setImage(image);
            sandwich.setDescription(description);
            sandwich.setIngredients(ingredients);

        }catch (Exception e){
            Log.d("----Error----",e.toString());
        }
        return sandwich;
    }
}
