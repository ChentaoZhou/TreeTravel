
import java.util.Scanner;

/*
 * 完全二叉搜索树，给一个排好序的树（数组），构造一个完全二叉搜索树并用层序遍历返回数组结果。
 * 在这个例子中使用数组而不是链表来存储树是因为：1.完全二叉树不会浪费空间
 */
public class CompletelyBinarySearchTree {
		static int[] T ;	//the result tree
		static int[] A ;	//the input tree after sorting
	public static void solve(int aLeft, int aRight,int tRoot) {
		
		//first solve input: (0,N-1,0)
		int n = aRight -aLeft +1;
		if(n==0) return;
		int L = getLeftLength(n);		//get the length of left subtree (A method need to write)
		T[tRoot] = A[aLeft +L];			//put the root node into the result tree
		int leftTRoot = tRoot*2+1;		//the root node of left subtree
		int rightTRoot = leftTRoot+1;	//the root node of the right subtree
		solve(aLeft, aLeft+L-1, leftTRoot);
		solve(aLeft+L+1, aRight,rightTRoot);
	}
	
	public static int getLeftLength(int n) {
		int half = 1;
		int result =0;
		int remain = n-1;
		
		while(remain>half*2) {
			result = result+half;
			remain = remain-half*2;
			half = half*2;
			//System.out.println(result);
		}
		if(remain>half) {
			result = result+half;
		}
		else {
			result = result+remain;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		
		T = new int[num];
		A = new int[num];
		for(int i= 0; i<num;i++) {
			A[i]=s.nextInt();
		}
		solve(0,num-1,0);
		for(int i=0; i<num; i++) {
			System.out.print(T[i]+" ");
		}
		//System.out.println(getLeftLength(23));
		s.close();
	}
	
	
}
