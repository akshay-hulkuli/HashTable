package com.bridgelabz.hashtable;

public class HashMapMain {

	public static void main(String[] args) {
		String sentence = "To be or not to be";
		MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
		String [] words = sentence.toLowerCase().split(" ");	
		for( String word : words) {
			Integer value = myHashMap.get(word);
			if(value == null) value = 1;
			else value  = value+1;
			myHashMap.add(word, value);
		}
		Integer frequency  = myHashMap.get("to");
		System.out.println(myHashMap);
		System.out.println("the word \"to\" is repeated :"+frequency+" times");
	}

}
