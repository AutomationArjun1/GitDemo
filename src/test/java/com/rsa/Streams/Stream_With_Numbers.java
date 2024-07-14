package com.rsa.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream_With_Numbers {

	public static void main(String[] args) {
		
		 List<Integer> values = Arrays.asList(5,8,4,8,4,6,1,7);
		 // unique values
		 values.stream().distinct().forEach(s->System.out.println(s));
		 
		 // sorted and unique values ||  unique  and sorted values
		 System.out.println("sorted and unique values : -----------------");
		 values.stream().distinct().sorted().forEach(s->System.out.println(s));
		 

	}

}
