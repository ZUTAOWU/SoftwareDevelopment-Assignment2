import java.text.DecimalFormat;

import assign2.ngram.NGramException;
import assign2.ngram.NGramStore;


public class test {

	public static void main(String[] args) throws NGramException {
//		NGramStore ns = new NGramStore();
//		ns.getNGramsFromService("test", 5);
//		
//		try {
//			ns.getNGramsFromService("qwewqfdsagffhghd", 5);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		
//		ns.getNGramsFromService("be or not to", 5);
//		
//		System.out.println(ns);
		
		DecimalFormat df = new DecimalFormat("0.000000");
		
		double a= 0.1;
		String s = df.format(a);
		System.out.println(s);
	}

}
