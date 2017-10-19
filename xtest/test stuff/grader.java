import java.util.*;
import java.io.*;

public class grader {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter submission directory:");
		String sub_dir = in.next();
		String dir_path = sub_dir + "\\";
		
		
		// get directory of all submissions
		File root = new File(sub_dir);
		String[] in_dir = root.list(); // get list of all files in directory
		ArrayList<String> student_folders = new ArrayList<>();

		// sort the list
		Arrays.sort(in_dir);
		
		// add only folders to arraylist
		for (String s : in_dir) {
			if (new File(dir_path + s).isDirectory())
				student_folders.add(s);
		}


		// compile(student_folders, root);
		run(student_folders, root);
		
	}
	
	public static void run(ArrayList<String> student_folders, File root) {
		PrintStream p = System.out;
		for(int i = 0; i < student_folders.size(); i++) {
			
			// get all .class files
			ArrayList<String> student_files = getFilesInDirectory(root, 
																student_folders.get(i),
																".class");
			for(int j = 0; j < student_files.size(); j++) {
				String fileName = student_files.get(j);
				try{
					Runtime rt = Runtime.getRuntime();
					Process proc = rt.exec("java -cp d:\\School\\221\\hw_1\\" + 
											root.getPath() + "\\" + 
											student_folders.get(i) + "\\ " + 
											fileName.substring(0,fileName.indexOf('.')));
					
					System.out.println("java -cp d:\\School\\221\\hw_1\\" + 
											root.getPath() + "\\" + 
											student_folders.get(i) + "\\ " + 
											fileName.substring(0,fileName.indexOf('.')));
					
					// this is what the other program is outputting
					BufferedReader stdInput = new BufferedReader(new 
										InputStreamReader(proc.getInputStream()));

					BufferedReader stdError = new BufferedReader(new 
										InputStreamReader(proc.getErrorStream()));

					System.out.println(stdInput.readLine());
					System.out.println(stdError.readLine());
					
					// this is what to send the other program as input
					OutputStream stdout = proc.getOutputStream ();
					stdout.write ("password".getBytes ());
										
										
					// read the output from the command
					// System.out.println("Here is the standard output of the command:\n");
					// String s = null;
					// while ((s = stdInput.readLine()) != null) {
						// System.out.println(s);
					// }
					
					proc.waitFor();
				}
				catch(Throwable t) {
					System.out.println("***Error Compiling " + student_folders.get(i));
				}
			}
																
			
			
		}
	}
	
	public static ArrayList<String> getFilesInDirectory(File root, String name, String regex) {
		// get the files in the directory
		File single = new File(root.getPath() + "\\" + name);
		String[] sub_files = single.list();
		
		// sort the files
		Arrays.sort(sub_files);
		
		// add submitted .regex files to arrayList
		ArrayList<String> student_files = new ArrayList<>();
		for(String s : sub_files)
			if(s.endsWith(regex))
				student_files.add(s);
		return student_files;
	}
	
	public static void compile(ArrayList<String> stud_fold, File r) {
		// looping through all submission folders
		for(int i = 0; i < stud_fold.size(); i++) {
			boolean compiledOK = true;
			
			// get the files in the directory
			File single = new File(r.getPath() + "\\" + stud_fold.get(i));
			String[] sub_files = single.list();
			
			// sort the files
			Arrays.sort(sub_files);
			
			// add submitted .java files to arrayList
			ArrayList<String> student_files = new ArrayList<>();
			for(String s : sub_files)
				if(s.endsWith(".java"))
					student_files.add(s);
			for(int j = 0; j < student_files.size(); j++) {
				try{
					Runtime rt = Runtime.getRuntime();
					Process proc = rt.exec("javac " + 
											r.getPath() + "\\" + 
											stud_fold.get(i) + "\\" + 
											student_files.get(j));
					proc.waitFor();
				}
				catch(Throwable t) {
					System.out.println("***Error Compiling " + stud_fold.get(i));
					compiledOK = false;
				}
			}

			if(compiledOK) {
				System.out.println(stud_fold.get(i));
				for(String s : student_files)
					System.out.println("\t" + s);
			}
			student_files.clear();
		}
	}
	
}