import java.util.*;
public class BellmanFord{
static final int INF=999;
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the number of vertices:");
	int n=sc.nextInt();
	int[][] cost = new int[n][n];
	int[] dist = new int[n];
	int[] parent = new int[n];
	System.out.println("Enter the adjacency matrix:");
	for(int i=0;i<n;i++)
	{
	for(int j=0;j<n;j++)
	{
	cost[i][j]=sc.nextInt();
	}
	}
	System.out.println("Enter the source vertex:");
	int src=sc.nextInt();
	
	for(int i=0;i<n;i++)
	{
	dist[i]=cost[src][i];
	parent[i]=src;
	}
	dist[src]=0;

	for(int k=1;k<n-1;k++)
	{
	for(int i=0;i<n;i++)
	{
	for(int j=0;j<n;j++)
	{
	if(dist[i]>dist[j]+cost[j][i])
	{
	dist[i]=dist[j]+cost[j][i];
	parent[i]=j;
	}
	}
	}
	}
	
	System.out.println("The results is:");
	for(int i=0;i<n;i++)
	{
	System.out.println("The Distance from"+src+"to"+i+"is"+dist[i]+".");
	printpath(i,parent,src);
	}
	sc.close();
	}
	static void printpath(int node,int[] parent,int src)
	{	
	if(node==src)
	System.out.print(src);
	else
	{
	printpath(parent[node],parent,src);
	System.out.print(" -> "+node);
	}
	}
}