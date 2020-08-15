package aug15th_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) throws IOException {
		//create stream - method 1 
		
		//IntStream Integer stream class 
		IntStream//class 
		.range(1, 10)//fun of above class
		.forEach(System.out::print);

		System.out.println("\n");

		IntStream
			.range(1, 10)
			.skip(5)
			.forEach(x -> System.out.println(x));

		System.out.println("\n");

		int sum = IntStream
					.range(1, 5)
					.sum();
		System.out.println(sum);

		//directly printing inside sysout
		System.out.println(
				IntStream
					.range(1, 5)
					.sum()
				);
		
		
		//create stream method 2 - using Steam.of (widely used)- it contain any things, Integer, String, float value, or Object
		Stream.of("hari","om","yadav")
			.sorted()//we can pass own comparator logic also
			.findFirst()//return optional
			.ifPresent(System.out::println);
		
		//create stream Method 3 - Arrays.stream
		String[] names = {"hari","om","yadav"};
		Arrays.stream(names)//same as Stream.of
			.filter(x -> x.startsWith("h"))
			.sorted()
			.forEach(System.out::println);
		//same as above
		Stream.of(names)
			.filter(x -> x.startsWith("h"))
			.sorted()
			.forEach(System.out::println);
		
		//for given number - find average of square : 1st find sq, then find average
		Arrays.stream(new int[] {1,2,3,4})
			.map(x -> x*x)
			.average()
			.ifPresent(System.out::println);
		
		List<String> people = Arrays.asList("hari","om","chandan","yadav","op","omprakash");
		people.stream()
			.map(String::toLowerCase)
			.filter(x -> x.startsWith("c"))
			.forEach(System.out::println);
		
		System.out.println("\n");
		
		//method 4 : stram from file - in end close stream file
		Stream<String> band = Files.lines(Paths.get("band.txt"));
		band
			.sorted()
			.filter(x -> x.length() > 3)
			.forEach(System.out::println);
		band.close();//important
		
		System.out.println("\n");
		//read from file and collect in list
		List<String> collect = Files.lines(Paths.get("band.txt"))
								.filter(x -> x.contains("s"))
								.collect(Collectors.toList());
		collect.forEach(x -> System.out.println(x));
		
		System.out.println("\n");
		//read good rows from csv file
		Stream<String> rows = Files.lines(Paths.get("data.txt"));
		long count = rows
						.map(x -> x.split(","))
						.filter(x -> x.length == 3)
						.count();
		System.out.println("Good rows : "+count);
		rows.close();
		
		
		//read file -> split -> filter 2nd index i.e. 2nd column -> print
		Stream<String> lines = Files.lines(Paths.get("data2.txt"));
		lines
			.map(x -> x.split(","))
			.filter(x -> x.length == 3)//filter only good rows
			.filter(x -> Integer.parseInt(x[1]) > 15)
			.forEach(x -> System.out.println(x[0]+" "+x[1]+" "+x[2]));
		lines.close();
		
		//read csv file and collect in map - same as above + collect in map
		Stream<String> rows2 = Files.lines(Paths.get("data2.txt"));
		
		Map<String, Integer> collect2 = rows2.map(x -> x.split(","))
										.filter(x -> x.length == 3)//only good rows
										.filter(x -> Integer.parseInt(x[1]) > 15)
										.collect(Collectors.toMap(x -> x[0], 
																x -> Integer.parseInt(x[1])));
	
		
			
	}
}
