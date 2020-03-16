package com.practicas.exercise2.utils;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DatabaseJson {

    private static JSONArray _jsonArray = new JSONArray();

    private static final Logger _log = Logger.getLogger(DatabaseJson.class.getName());

    private DatabaseJson() {
        try{
            loadJSONDB();
        }catch (IOException e){
            _log.log(Level.SEVERE, "Error loading database" , e);
        }
    }

    public static DatabaseJson loadDatabase() {

        return new DatabaseJson();
    }

    private void loadJSONDB() throws IOException {

        InputStream inputStream = this.getClass()
                .getClassLoader().getResourceAsStream("cars.json");

        if (inputStream == null) return;

        StringBuilder jsonText = new StringBuilder();
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream))) {
            jsonText.append(buffer.lines().collect(Collectors.joining("\n")));
        }

        _jsonArray = new JSONArray(jsonText.toString());
    }

    public JSONArray getData(){
        return _jsonArray;
    }
}
