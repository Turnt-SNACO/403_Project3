package project3;

import java.util.ArrayList;
import java.util.Hashtable;

import com.google.gson.Gson;

class Operator {
	InList in;
	Operator(String json){
		in = new Gson().fromJson(json, InList.class);
	}
	String doAll() {
		Hashtable<Integer, ArrayList<String>> hash = new Hashtable<Integer, ArrayList<String>>();
		for (Object s : in.inList) {
			if (s instanceof String) {
				int sum = 0;
				String low = ((String) s).toLowerCase();
				for (char c : low.toCharArray()) sum+=(int) c;
				ArrayList<String> temp;
				if (hash.get(sum)!=null) temp = hash.get(sum);
				else temp = new ArrayList<String>();
				temp.add((String)s);
				hash.put(sum, temp);	
			}
			else return null;
		}
		OutList out = new OutList();
		for (int key : hash.keySet()) {
			if (hash.get(key).size() > 1)
				out.outList.add(hash.get(key));
		}
		return new Gson().toJson(out);
	}
}
