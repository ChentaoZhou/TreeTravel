
public class TreeTraverse {
	
	int[] post,pre,in;

	/*
	 * 给出前序和中序遍历，打印出后续遍历
	 */
	public void solve(int preL,int inL,int postL,int n) {
		int L = 0, R = 0, root;
		if(n==0) return;
		/*
		 * 递归终止条件
		 */
		if(n==1) {
			post[postL] = pre[preL];
			return;
		}
		//the first node in the preOrder is the root
		root = pre[preL];
		post[postL+n-1] = root;			//put it into the last of PostOrder
		/*
		 找到中序遍历中和根root值相同的点，左边的就是左子树，右边的就是右子树
		 */
		for(int i=0; i<n; i++) {
			if(in[inL+i]==root) {
				L=i; R=n-L-1;			//the node numbers of left and right subtree
				break;
			}
		}
		/*
		  分别对左右子树做相同的递归
		 */
		solve(preL+1, inL, postL, L);
		solve(preL+L+1, inL+L+1, postL+L, R);
	}
}
