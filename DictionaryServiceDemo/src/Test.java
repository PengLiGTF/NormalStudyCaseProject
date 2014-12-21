import java.util.Arrays;

public class Test {

	static class WorkerThread extends Thread {

		@Override
		public void run() {
			boolean interrupted = false;
			do {
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					interrupted = true;
					System.out.println(Thread.currentThread().isInterrupted());
				}
			} while (!Thread.currentThread().isInterrupted());
		}

		public void cancel() {
			interrupt();
		}

	}

	public static void main(String[] args) {

		WorkerThread wt = new WorkerThread();
		wt.start();
		
		wt.cancel();
		
		//
		// int len = 66;
		//
		// int[] a = new int[len];
		//
		// for (int i = 0; i < len; i++) {
		// a[i] = i + 1;
		// }
		//
		// while (len != 1) {
		// int[] newArr = new int[len / 2];
		// int j = 0;
		// for (int i = 0; i < len; i++) {
		// if ((i + 1) % 2 == 0) {
		// newArr[j++] = a[i];
		// }
		// }
		// System.out.println(Arrays.toString(newArr));
		// len = newArr.length;
		// a= newArr;
		// }
	}
}
