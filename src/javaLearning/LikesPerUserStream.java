package javaLearning;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Post {
	private int userID;
	private int likes;
	private String content;

	public Post(int userID, int likes, String content) {
		super();
		this.userID = userID;
		this.likes = likes;
		this.content = content;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Post [userID=" + userID + ", likes=" + likes + ", content=" + content + "]";
	}

}

public class LikesPerUserStream {

	public static void main(String[] args) {
		List<Post> post = Arrays.asList(new Post(1, 50, "Post 1 by user 1"), new Post(2, 30, "Post 1 by user 2"),
				new Post(1, 20, "Post 2 by user 1"), new Post(3, 70, "Post 1 by user 3"),
				new Post(2, 10, "Post 2 by user 2"), new Post(3, 100, "Post 2 by user 3"));

		Map<Integer, Integer> likesSum = post.stream()
				.collect(Collectors.groupingBy(n -> n.getUserID(), Collectors.summingInt(n -> n.getLikes())));
		likesSum.forEach((t, u) -> System.out.println("User Id: " + t + " Likes: " + u));

		List<Entry<Integer, Integer>> likesabove50 = post.stream()
				.collect(Collectors.groupingBy(n -> n.getUserID(), Collectors.summingInt(n -> n.getLikes()))).entrySet()
				.stream().filter(n -> n.getValue() > 50).collect(Collectors.toList());
		likesabove50.forEach(entry -> System.out.println("User Id: " + entry.getKey() + " Likes: " + entry.getValue()));

		// find the unique characters...
		String s = "welcome";

		String distinct = s.chars(). // Converting the string to an IntStream of characters using s.chars().
				mapToObj(c -> (char) c). // Convert each character to an object using mapToObj(c -> (char) c).
				filter(c -> s.indexOf(c) == s.lastIndexOf(c)) // Keep only unique characters
				.map(a -> String.valueOf(a)). // convert each element of the stream into a String.
				collect(Collectors.joining());
		System.out.println(distinct);

		Map<String, Long> collect = Arrays.stream(s.split(""))
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		System.out.println(collect);

		Map<Object, Long> collect2 = Arrays.stream(s.split("")).filter(c -> s.indexOf(c) != s.lastIndexOf(c))
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		System.out.println(collect2);
	}

}
