package src;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTest {
   MorseCodeTree tree;
   ArrayList<String> list;
   TreeNode root;
	@Before
	public void setUp() throws Exception 
	{
	list = new ArrayList<>();
	tree = new MorseCodeTree();
	root = new TreeNode<String>("");
	}

	@After
	public void tearDown() throws Exception 
	{
		tree = null;
	}

	@Test
	public void testInsert() {
		MorseCodeTree tree2 = new MorseCodeTree(root);
		tree2.insert(".", "e");
		tree2.insert("-", "t");
		assertEquals(tree2.fetch("-"), "t");
		assertEquals(tree2.fetch("."), "e");
	}

	

	@Test
	public void testFetch() {
		assertEquals(tree.fetch(".-"), "a");
		assertEquals(tree.fetch("--."), "g");
		assertEquals(tree.fetch("--.."), "z");
	}

	

	@Test
	public void testBuildTree() {
		ArrayList<String> list = new ArrayList<>();
		list = tree.toArrayList();
		assertEquals(list.toString(), "[h, s, v, i, f, u, e, l, r, a, p, w, j, , b, d, x, n, c, k, y, t, z, g, q, m, o]");
	}

	@Test
	public void testToArrayList() {
		list = tree.toArrayList();
		assertEquals(list.get(0), "h");
		assertEquals(list.get(1), "s");
		assertEquals(list.get(2), "v");
		assertEquals(list.get(3), "i");
		assertEquals(list.get(4), "f");
		assertEquals(list.get(5), "u");
		assertEquals(list.get(6), "e");
		assertEquals(list.get(7), "l");
		assertEquals(list.get(8), "r");
		assertEquals(list.get(9), "a");
		assertEquals(list.get(10), "p");
		assertEquals(list.get(11), "w");
		assertEquals(list.get(12), "j");
		assertEquals(list.get(13), "");
		assertEquals(list.get(14), "b");
		assertEquals(list.get(15), "d");
		assertEquals(list.get(16), "x");
		assertEquals(list.get(17), "n");
		assertEquals(list.get(18), "c");
		assertEquals(list.get(19), "k");
		assertEquals(list.get(20), "y");
		assertEquals(list.get(21), "t");
		assertEquals(list.get(22), "z");
		assertEquals(list.get(23), "g");
		assertEquals(list.get(24), "q");
		assertEquals(list.get(25), "m");
		assertEquals(list.get(26), "o");
		}


	
}
