package assignment04;

// When programming I normally prefer using promises, which return success and the reason,
// This is a web concept that was introduced in ES6, unfortunately I can't bring in all of
// the promised based functions, like `.then`, `.success`, `.fail` and chain functions
public interface Response {
	public boolean success = false;
	public String reason = "";
}
