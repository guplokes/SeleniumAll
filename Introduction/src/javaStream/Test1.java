package javaStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 {

	//count no. of names starting with alphabet 'A'
	//@Test
	public void regular() {
		List<String> names = new ArrayList<String>();
		names.add("Aman");
		names.add("Rohit");
		names.add("Sonika");
		names.add("Ayush");
		names.add("Lokesh");
		
		int count=0;
		String str;
		
		for(int i=0;i<names.size();i++) {
			str = names.get(i);
			if(str.startsWith("A"))
				count++;
			
		}
		System.out.println(count);
	}
	
	//@Test
	public void streamFilter() {
		List<String> names = new ArrayList<String>();
		names.add("Aman");
		names.add("Rohit");
		names.add("Sonika");
		names.add("Ayush");
		names.add("Lokesh");
		
		long count = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(count);
		
		//terminal operation will only execute if filter  returns true
		long d = Stream.of("Aman","Rohit","Sonika","Ayush","Lokesh").filter(s -> {
			s.startsWith("A");
			return false;
		}).count();
		System.out.println(d);
		
		//To print all the names having length greater than 4
		names.stream().filter(s -> s.length()>4).forEach(s -> System.out.println(s));
		//names.stream().filter(s -> s.length()>4).limit(1).forEach(s->System.out.println(s));
	}

	@Test
	public void streamMap() {
		//print the names in uppercase which have last character 'a'		
		Stream.of("Aman","Rohita","Sonika","Ayush","Lokesh").filter(s -> s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		List<String> list = new ArrayList<String>();
		list.add("male");
		list.add("female");
		list.add("gay");
		list.add("lesbian");		
		
		//print names which have first letter as "A" with uppercase and  in sorted way
		List<String> names = Arrays.asList("Aman","Rohita","Sonika","Ayush","Lokesh","Ankita");		
		names.stream().filter(s -> s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println("------------BREAK---------");
		
		Stream<String> newStream = Stream.concat(names.stream(),list.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Sonika"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect() {
		List<String> names = Stream.of("Aman","Rohita","Sonika","Ayush","Lokesh").filter(s -> s.endsWith("a")).map(s->s.toUpperCase())
							.collect(Collectors.toList());
		System.out.println(names.get(0));
	}
	
}
