package multi_threading;

import java.util.Random;

class FileDownloaderbyRunnable implements Runnable{
	@Override
	public void run() {

	}
}

class FileDownloaderbyClass extends Thread {
	private String fileName;

	public FileDownloaderbyClass(String name) {
		this.fileName = name;
	}
	private Random random = new Random();

	public void run() {
		for(int i  = 0 ; i <= 100 ; i += 20) {
			try {
				System.out.println(Thread.currentThread().getName() + " : " + i);
				Thread.sleep(50 + random.nextInt(1000));  // Pause for 500 milliseconds 
			} catch (InterruptedException e) { 
				System.out.println(e); 
			} 
		}
	}

}

public class DownloadManager {
	public static void main(String[] args) throws InterruptedException {

		FileDownloaderbyClass d1 = new FileDownloaderbyClass("Document.pdf");
		FileDownloaderbyClass d2 = new FileDownloaderbyClass("Image.jpg");
		FileDownloaderbyClass d3 = new FileDownloaderbyClass("Video.mp4");

		d1.start();
		d2.start();
		d3.start();

		// main thread waits
		d1.join();
		d2.join();
		d3.join();

		System.out.println("All downloads complete!");
	}
}

