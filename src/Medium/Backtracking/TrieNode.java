package Medium.Backtracking;
import java.util.*;
import java.io.*;

public class TrieNode {
	Character c;
	ArrayList<TrieNode> children = new ArrayList<TrieNode>();
	
	public TrieNode() {
		// TODO Auto-generated constructor stub
	}
	
	public TrieNode(Character c) {
		this.c = c;
	}
	
	public TrieNode(Character c1, Character c2, Character c3) {
		children.add(new TrieNode(c1));
		children.add(new TrieNode(c2));
		children.add(new TrieNode(c3));
	}
	
}
