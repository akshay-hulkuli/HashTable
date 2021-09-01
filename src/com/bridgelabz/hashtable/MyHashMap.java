package com.bridgelabz.hashtable;

import java.util.ArrayList;

public class MyHashMap<K,V> {
	private final int numBuckets; 
	ArrayList<MyLinkedList<K>> myBucketArray; 
	
	public MyHashMap() {
		this.numBuckets = 10;
		this.myBucketArray = new ArrayList<>(numBuckets);
		for(int i=0; i< numBuckets; i++) this.myBucketArray.add(null);
	}
	
	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode% numBuckets;
		return index;
	}
	
	public V get(K key) {
		int index = getBucketIndex(key);
		MyLinkedList<K> myLinkedList = myBucketArray.get(index);
		if(myLinkedList == null) return null;
		MyMapNode<K,V> myMapNode = (MyMapNode<K,V>) myLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}
	
	public void add(K key, V value) {
		int index = getBucketIndex(key);
		MyLinkedList<K> myLinkedList = myBucketArray.get(index);
		if(myLinkedList == null) {
			myLinkedList = new MyLinkedList<K>();
			this.myBucketArray.set(index,myLinkedList);
		}
		MyMapNode<K,V> myMapNode = (MyMapNode<K,V> ) myLinkedList.search(key);
		if(myMapNode == null) {
			myMapNode = new MyMapNode<K,V> (key, value);
			myLinkedList.append(myMapNode);
		}
		else {
			myMapNode.setValue(value);
		}
	}
	
	public void remove(K key){
		int index = getBucketIndex(key);
		MyLinkedList<K> myLinkedList = myBucketArray.get(index);
		if(myLinkedList == null) return;
		MyMapNode<K,V> myMapNode = (MyMapNode<K,V>)myLinkedList.delete(key); 
		System.out.println("Deleted (key="+myMapNode.getKey()+",value="+myMapNode.getValue()+")");
	}
	
	@Override
	public String toString() {
		return "MyHashMapNodes{" + myBucketArray+ "}";
	}
	
}
