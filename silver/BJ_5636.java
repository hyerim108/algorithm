import java.util.*;
import java.io.*;

public class Main
{
    //생일
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String[][] arr = new String[N][4];
		for(int i=0;i<N;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    arr[i][0] = st.nextToken();
		    arr[i][1] = st.nextToken();
		    arr[i][2] = st.nextToken();
		    arr[i][3] = st.nextToken();
		}
		Arrays.sort(arr, new Comparator<String[]>(){ //정렬직접구현
		   @Override
		   public int compare(String[] o1, String[] o2)
		   {
		       if (o1[3].equals(o2[3])){
		           if(o1[2].equals(o2[2])){
		               return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);  //내림차순구현은 반대로 적으면됨
		           }
		           return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
		       }
		       return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]);
		   }
		});
	    System.out.println(arr[N-1][0] + "\n" + arr[0][0]);
	}
}
