package com.rsa.Streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Stream_List {

	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("moto");
		al.add("malli");
		al.add("arjun");
		al.add("mouni");
		
		ArrayList<String> al1 = new ArrayList<String>();
		al.add("anand");
		al.add("jhon");
		al.add("mahi");
		al.add("chai");
		
//		int count=0;
//		for (int i = 0; i < al.size(); i++) {
//			String actualname =al.get(i);
//			if(actualname.startsWith("M")||actualname.startsWith("m")) {
//				count++;
//			}
//		}
//		System.out.println(count);
		
		//stream
		System.out.println(al.stream().filter(s->s.startsWith("m")).count());
		
		// assigning also with Stream------- if multiple statements are there
//		long name = Stream.of("Arjun","Moto","Auto","aa").filter(s->
//		{
//			s.startsWith("A");
//			return true;
//		}).count();
		
		long name = Stream.of("Akash","Manas","Auto","aa").filter(s->s.startsWith("A")).count();
		System.out.println(name);
		
		al.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		al.stream().filter(s->s.length()>4).limit(2).forEach(s->System.out.println("limits 2 :"+s));
		
		
		// converting to uppercase which ends with i
		al.stream().filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		// soting and converting to uppercase which ends with i
		
		al.stream().filter(s->s.startsWith("m")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println("sorted and covert to upper which starts with m :"+s));
		
		// merging 2 lists
		Stream<String> merge = Stream.concat(al.stream(), al1.stream());
		System.out.println(merge.anyMatch(s->s.equalsIgnoreCase("arjun")));
	}

}
