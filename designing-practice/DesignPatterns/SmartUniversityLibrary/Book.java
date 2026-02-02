package SmartUniversityLibrary;

public class Book {
	private String title;
	private String author;
	private String edition;
	private String genre;

	private Book(BookBuilder builder) {
		this.title = builder.title;
		this.author = builder.author;
		this.edition = builder.edition;
		this.genre = builder.genre;

	}
	public String getTiltle() {
		return title;
	}
	
	public static class BookBuilder{
		private String title;
		private String author;
		private String edition;
		private String genre;

		public BookBuilder(String title) { // title is mandatory
			this.title = title;
		}
		public BookBuilder author(String author) { // non mandatory
			this.author = author;
			return this;
		}
		public BookBuilder edition(String edition) { // non mandatory
			this.edition = edition;
			return this;
		}
		public BookBuilder genre(String genre) { // non mandatory
			this.genre = genre; 
			return this;
		}
		public Book build() {
			return new Book(this);
		}
	}
}
