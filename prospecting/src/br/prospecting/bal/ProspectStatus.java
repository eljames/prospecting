package br.prospecting.bal;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class ProspectStatus {
	
	public static final int CONTACT = 1;
	public static final int BACK_CONTACT = 2;
	public static final int BUDGET_REQUESTED = 3;
	public static final int BUDGET_ACCEPTED = 4;
	public static final int BUDGET_NOT_REQUESTED = 5;
	public static final int BUDGET_NOT_ACCEPTED = 6;
	
	public static final Map<Integer, String> statusMap = new TreeMap<Integer, String>();
	
	static {
		statusMap.put(CONTACT, "Contact");
		statusMap.put(BACK_CONTACT, "Back contact");
		statusMap.put(BUDGET_REQUESTED, "Budget requested");
		statusMap.put(BUDGET_ACCEPTED, "Budget accepted");
		statusMap.put(BUDGET_NOT_REQUESTED, "Budget not requested");
		statusMap.put(BUDGET_NOT_ACCEPTED, "Budget not accepted");
	}
	
	public String getText(int status) {
		return statusMap.get(status);
	}
	
	public static Set<Entry<Integer, String>> toList() {
		return statusMap.entrySet();
	}
}
