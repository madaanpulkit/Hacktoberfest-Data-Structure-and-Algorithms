public class In_Pre_to_Post
{
    
    public static void main(String[] args) 
    {
    	//  Number of Nodes in trees
	    int N = 5;

	    // Pre-order Traversal
	    int[] Pre = {1, 2, 4, 5, 3};
	    
	    // In-order Traversal
	    int[] In = {4, 2, 5, 1, 3};

	    Node root = maketree(Pre, In, 0, N-1);
	    
	    postdisp(root);                    
    }

    static int ind_pre = 0;
    
    public static Node maketree(int[] Pre, int[] In, int low, int high)
    {
        if(low > high)
        {
            return null;
        }

        else
        {
            Node root = new Node(Pre[ind_pre]);
            ind_pre++;

            int ind_in = low;

            for(ind_in=low; ind_in<=high; ind_in++)
            {
                if(In[ind_in] == root.data)
                {
                    break;
                }
            }

            root.left = maketree(Pre, In, low, ind_in - 1);
            root.right = maketree(Pre, In, ind_in + 1, high);

            return root;
        }
    }

    public static void postdisp(Node root)
    {
        if(root != null)
        {
            postdisp(root.left);
            postdisp(root.right);
            System.out.print(root.data + " ");
        }
    }
}

class Node
{
    int data;
    Node left;
    Node right;

    Node()
    {
        data = 0;
        left = null;
        right = null;
    }

    Node(int d)
    {
        data = d;
        left = null;
        right = null;
    }
    
    Node(int d, Node l, Node r)
    {
        data = d;
        left = l;
        right = r;
    }

}
