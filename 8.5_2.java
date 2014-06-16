//这个方法的思路是：首先得知道valid括号的规律。在决定"("和")"时候,")"的数量必须不小于"("的数量。否则违法。
//有了这个condition就比较容易了, 用 int l 和 int r 来算两种括号的数量。
//如果 l 和 r 都为零时，打印“”，如果 l > 0 的时候可以打印 "(", 如果 r > l, 可以打印")"。
//举例说,如果要实现input为3的话,char[]中第一个肯定是"(", 但对第二个可以是"(",也可以是")"。
public class PrintPar{
	
	public static void printPar(int l, int r, char[] str, int count){
		if(l<0||r<l) 
			return; // invalid state
		if(l==0&r==0){
			System.out.println(str); //found one
		}else{
			if(l>0) {
				str[count]='(';
				printPar(l-1, r, str, count+1);
			}
			if(r>l){
				str[count]=')';
				printPar(l, r-1, str, count + 1);
			}
		}
	}
	
	public static void printPar(int count){
		char[] str = new char[count*2];
		printPar(count, count, str, 0);
	}

	public static void main(String[] args){
		printPar(3);
	}
}