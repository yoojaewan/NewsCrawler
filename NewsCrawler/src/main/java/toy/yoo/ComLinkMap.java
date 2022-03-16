package toy.yoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComLinkMap {

	private static Map<String, List<String>> comLinkMap = new HashMap<String, List<String>>();

	public static void put(String key, String data) {
		if (comLinkMap.containsKey(key)) {
			comLinkMap.get(key).add(data);
		} else {
			List<String> urlList = new ArrayList<String>();
			urlList.add(data);
			comLinkMap.put(key, urlList);
		}
	}

	public static Set<String> keySet() {
		return comLinkMap.keySet();
	}

	public static List<String> getList(String key) {
		return comLinkMap.get(key);
	}

}
