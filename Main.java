import java.io.*;
import java.util.*;

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");}
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                   reader.readLine() );}
        return tokenizer.nextToken();}
    static int nextInt() throws IOException {
        return Integer.parseInt( next() ); }	
    static int[] nextIntLine(int n) throws IOException {
    	int[] num = new int[n];
        String[] strNums = reader.readLine().split("\\s");
        for(int i=0; i<strNums.length; i++) {
            num[i] = Integer.parseInt(strNums[i]);}
        return num;}
}
public class Main{
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int n = Reader.nextInt();
		int[] num = Reader.nextIntLine(n);
		int ans = fun1(num,0,0,num.length-1);
		System.out.println(ans);
	}
	private static int fun1(int[] num, int n, int s, int e) {
		if(e==0) {
			return fun2(num[e]);}
		else if(s==0) {
			if(num[s]>num[s+1]) {
				n = n + fun2(num[s]);
				return(fun1(num, n ,s+1 ,e));}
			else {
				return(fun1(num, n ,s+1 ,e));}
		}
		else if(s == e) {
			if(num[s]>num[s-1]) {
				n = n + fun2(num[s]);
				return(n);}
			else {
				return(n);}
		}
		else {
			if(num[s-1]<num[s] && num [s]>num[s+1]) {
				n = n + fun2(num[s]);
				return(fun1(num, n ,s+1 ,e));}
			else {
				return(fun1(num, n ,s+1 ,e));}
		}
	}
	private static int fun2(int n) {
		int x=0;
		if(n>=1 && n<=10) { x = 2;}
		else if(n>=11 && n<=20) { x = 3;}
		else if(n>=21 && n<=30) { x = 4;}
		else if(n>=31 && n<=40) { x = 5;}
		else if(n>=41 && n<=50) { x = 6;}
		return x;
	}
}
