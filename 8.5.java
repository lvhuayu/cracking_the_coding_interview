import java.util.*;

public class ParentheseCombination{
	public static HashSet<String> getCombinations(int n){
		HashSet<String> combinations = new HashSet<String>();
		if(n==1){
			combinations.add("()");
			return combinations;
		}else{
			HashSet<String> set = getCombinations(n-1);
			for(String s: set){
				for(int i = 0;i<=s.length();i++){
					combinations.add(insertAtChar(s,i));
				}
			}
			return combinations;	
		}
	}
	
	public static String insertAtChar(String s, int j){
		String start = s.substring(0,j);
		String end = s.substring(j);
		return "("+start+")"+end;
	}
	
	public static void main(String[] args){
		System.out.println(getCombinations(3));
	}
}