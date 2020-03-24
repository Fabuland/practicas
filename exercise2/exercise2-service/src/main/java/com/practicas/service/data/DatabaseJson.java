package com.practicas.service.data;

import org.json.JSONArray;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.practicas.model.Car;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DatabaseJson {

	private static JSONArray _jsonArray = new JSONArray();

	private static final Logger _log = Logger.getLogger(DatabaseJson.class.getName());
	
	private static DatabaseJson db;

	private DatabaseJson() {
		try {
			loadJSONDB();
		} catch (IOException e) {
			_log.log(Level.SEVERE, "Error loading database", e);
		}
	}

	public static DatabaseJson loadDatabase() {

    	if(db == null) {
    		db = new DatabaseJson();
    	}
        return db; 
    }
	private void loadJSONDB() throws IOException {

		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("cars-id.json");

		if (inputStream == null)
			return;

		StringBuilder jsonText = new StringBuilder();
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream))) {
			jsonText.append(buffer.lines().collect(Collectors.joining("\n")));
		}

		_jsonArray = new JSONArray(jsonText.toString());
	}

	public JSONArray getData() {
		return _jsonArray;
	}

	public List<Car> getDataParsed() {
		Gson gson = new Gson();
		Type userListType = new TypeToken<ArrayList<Car>>() {
		}.getType();

		return gson.fromJson(_jsonArray.toString(), userListType);
	}
}
