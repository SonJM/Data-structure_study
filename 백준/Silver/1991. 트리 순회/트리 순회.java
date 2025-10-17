import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Node {
		char data;
		Node left;
		Node right;

		Node(char data){
			this.data = data;
		}
	}

	static Node root = new Node('A');
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			char parentData = st.nextToken().charAt(0);
			char leftData = st.nextToken().charAt(0);
			char rightData = st.nextToken().charAt(0);

			insertNode(root, parentData, leftData, rightData);
		}

		preOrder(root);
		sb.append("\n");
		inOrder(root);
		sb.append("\n");
		postOrder(root);

		System.out.println(sb);
	}

	public static void insertNode(Node temp, char parentData, char leftData, char rightData) {
		if (temp.data == parentData) {
			temp.left = (leftData == '.' ? null : new Node(leftData));
			temp.right = (rightData == '.' ? null : new Node(rightData));
		} else {
			if (temp.left != null) {
				insertNode(temp.left, parentData, leftData, rightData);
			}
			if (temp.right != null) {
				insertNode(temp.right, parentData, leftData, rightData);
			}
		}
	}

	//전위순회 Preorder : Root -> Left -> Right
	private static void preOrder(Node node) {
		if(node != null) {
			sb.append(node.data);
			if(node.left != null) preOrder(node.left);
			if(node.right != null) preOrder(node.right);
		}
	}

	//중위 순회 Inorder : Left -> Root -> Right
	private static void inOrder(Node node) {
		if(node != null) {
			if(node.left != null) inOrder(node.left);
			sb.append(node.data);
			if(node.right != null) inOrder(node.right);
		}
	}

	//후위순회 Postorder : Left -> Right -> Root
	private static void postOrder(Node node) {
		if(node != null) {
			if(node.left != null) postOrder(node.left);
			if(node.right != null) postOrder(node.right);
			sb.append(node.data);
		}
	}
}