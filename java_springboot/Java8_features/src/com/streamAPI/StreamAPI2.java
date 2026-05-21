package com.streamAPI;

	import java.util.Arrays;
	import java.util.List;
	import java.util.stream.Collectors;
	import java.util.stream.Stream;

	public class StreamAPI2 {
		public static void main(String[] args) {
			List<String> names=Arrays.asList("pavan","murali","mohan","jagadesh","darshan","abhi");
			List<String> collect=names.stream().filter((s)->s.startsWith("a")).collect(Collectors.toList());
			System.out.println(collect);
			
			List<Integer>numbers =Arrays.asList(1,2,3,4,5,6,7,8,9,10);
			List<Integer> res=numbers.stream().map(ele->ele*ele).collect(Collectors.toList());
			System.out.println(res);
			
			Stream<Integer> stream =numbers.stream();
			Stream<Integer> map=stream.map(ele->ele*ele);
			List<Integer> collect2=map.collect(Collectors.toList());
			System.out.println(collect2);
			
			
		}

	}

