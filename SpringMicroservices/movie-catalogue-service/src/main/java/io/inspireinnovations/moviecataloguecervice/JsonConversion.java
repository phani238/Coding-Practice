package io.inspireinnovations.moviecataloguecervice;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.json.simple.JSONArray;

public class JsonConversion {
	static List<Integer> reqIndexList;
	static List<String> reqPhoneList;
	static List<Integer> l3;
	static List<String> dbPhoneList;

	static ArrayList<String> uniqueIndex = new ArrayList<String>();
	static ArrayList<Integer> uniquePhoneNumbers = new ArrayList<Integer>();

	private static JSONObject obj;

	public static void main(String[] args) throws JSONException {
		requestList();
		dBList();
		comparision();
		resultedJsonArray();

	}

	@SuppressWarnings("unchecked")
	private static void resultedJsonArray() throws JSONException {
		JSONArray array = new JSONArray();
		for (int i = 0; i < reqIndexList.size(); i++) {
			obj = new JSONObject();
			obj.put("Index", reqIndexList.get(i));
			obj.put("PhoneNo", reqPhoneList.get(i));
			array.add(obj);
		}
		System.out.print(array);
	}

	public static void comparision() {
		
	}

	private static void requestList() {
		reqIndexList = new ArrayList<Integer>();
		reqPhoneList = new ArrayList<String>();
		for (int i = 3; i <= 6; i++) {
			reqIndexList.add(1);
			reqPhoneList.add("01112243" + i);
		}
	}

	private static void dBList() {
		dbPhoneList = new ArrayList<String>();
		for (int i = 0; i <= 4; i++) {
			dbPhoneList.add("01112243" + i);
		}
	}
}
