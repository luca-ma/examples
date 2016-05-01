package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Locks {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.length() == 0) {
				continue;
			}

			int idx_lastClosed = 0;
			String[] split = line.split(" ");
			Integer N = Integer.valueOf(split[0]);
			Integer M = Integer.valueOf(split[1]);

			Boolean[] doors = new Boolean[N];
			Arrays.fill(doors, Boolean.TRUE);
			// printArray(doors);
			for (int pass = 0; pass < M; pass++) {

				if (pass == (M - 1)) {
					if (doors[idx_lastClosed]) {
						doors[idx_lastClosed] = Boolean.FALSE;
					} else {
						doors[idx_lastClosed] = Boolean.TRUE;
					}
					// printArray(doors);
				} else {
					// LOCKS every second door
					int idx1 = 0;
					int count1 = 1;
					while (idx1 < N) {
						if (count1 == 2) {
							if (doors[idx1]) {
								idx_lastClosed = idx1;
							}
							doors[idx1] = Boolean.FALSE;
							count1 = 0;
						}

						count1++;
						idx1++;
					}
					// for (int idx = 1; idx < N; idx += 2) {
					// if (doors[idx]) {
					// idx_lastClosed = idx;
					// }
					// doors[idx] = Boolean.FALSE;
					//
					// }
					// printArray(doors);

					// switch every third door
					int idx2 = 0;
					int count2 = 1;
					while (idx2 < N) {
						if (idx2 == 3) {
							if (doors[idx2]) {
								doors[idx2] = Boolean.FALSE;
								idx_lastClosed = idx2;
							} else {
								doors[idx2] = Boolean.TRUE;
							}
							count2 = 0;
						}
						idx2++;
						count2++;
					}
					// for (int idx = 0; idx < N; idx += 3) {
					// if (doors[idx]) {
					// doors[idx] = Boolean.FALSE;
					// idx_lastClosed = idx;
					// } else {
					// doors[idx] = Boolean.TRUE;
					// }
					//
					// }
					// printArray(doors);
					// System.out.println("---");
				}

			}
			// System.out.println(doors);
			System.out.println(numOpenDoors(doors));

		}

	}

	private static Integer numOpenDoors(Boolean[] doors) {
		int openDoors = 0;
		for (int idxD = 0; idxD < doors.length; idxD++) {
			if (doors[idxD]) {
				openDoors++;
			}
		}
		return openDoors;
	}

	private static void printArray(Boolean[] doors) {

		StringBuilder printStr = new StringBuilder("");

		for (Boolean door : doors) {
			if (door) {
				printStr.append("0 ");
			} else {
				printStr.append("1 ");
			}
		}

		System.out.println(printStr);
	}

}
