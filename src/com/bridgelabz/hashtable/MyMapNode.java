package com.bridgelabz.hashtable;

public class MyMapNode<K,V> implements INode<K> {
	private K key;
	private V value;
	private MyMapNode<K,V> next;
	
	public MyMapNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	public K getKey() {
		return this.key;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	public V getValue() {
		return this.value;
	}
	
	public void setNext(INode<K> next) {
		this.next = (MyMapNode<K,V>)next;
	}
	public INode<K> getNext(){
		return this.next;
	}
	
	
	@Override
	public String toString() {
		StringBuilder myMapNodeString = new StringBuilder();
		myMapNodeString.append("MyMapNode{"+"K=").append(key).append(" V=").append(value).append("}");
		if(next != null)
			myMapNodeString.append("->").append(next);
		return myMapNodeString.toString();
	}
}
