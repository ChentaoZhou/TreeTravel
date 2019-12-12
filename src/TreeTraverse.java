
public class TreeTraverse {
	
	int[] post,pre,in;

	/*
	 * ����ǰ��������������ӡ����������
	 */
	public void solve(int preL,int inL,int postL,int n) {
		int L = 0, R = 0, root;
		if(n==0) return;
		/*
		 * �ݹ���ֹ����
		 */
		if(n==1) {
			post[postL] = pre[preL];
			return;
		}
		//the first node in the preOrder is the root
		root = pre[preL];
		post[postL+n-1] = root;			//put it into the last of PostOrder
		/*
		 �ҵ���������к͸�rootֵ��ͬ�ĵ㣬��ߵľ������������ұߵľ���������
		 */
		for(int i=0; i<n; i++) {
			if(in[inL+i]==root) {
				L=i; R=n-L-1;			//the node numbers of left and right subtree
				break;
			}
		}
		/*
		  �ֱ��������������ͬ�ĵݹ�
		 */
		solve(preL+1, inL, postL, L);
		solve(preL+L+1, inL+L+1, postL+L, R);
	}
}
