package day13;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
	public Map<Character, TrieNode> children;
	public boolean isEndOfWord;
	
	public TrieNode() {
		children = new HashMap<>();
		isEndOfWord = false;
	}
}
public class Trie {
	private TrieNode root;
	public Trie() {
		root=new TrieNode();
	
	}
	public void insert(String word) {
		TrieNode currentNode=root;
		for(char c : word.toCharArray()) {
			currentNode.children.putIfAbsent(c,new TrieNode());
			currentNode=currentNode.children.get(c);
		}
		currentNode.isEndOfWord=true;
	}
	public boolean startsWith(String prefix) {
		TrieNode currentNode=root;
		for(char c: prefix.toCharArray()) {
			currentNode=currentNode.children.get(c);
			if(currentNode==null) {
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trie trie=new Trie();
		trie.insert("apple");
		trie.insert("app");
		trie.insert("application");
		trie.insert("banana");
		
		System.out.println(trie.startsWith("app"));
		System.out.println(trie.startsWith("ban"));
		System.out.println(trie.startsWith("cat"));
		System.out.println(trie.startsWith("appl"));
		System.out.println(trie.startsWith("appla"));
	}

}
