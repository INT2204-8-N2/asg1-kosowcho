package TextOnImage;
import java.io.PrintWriter;
	public class my_main {
                public static String pathFile(String input_file)
                {
                        //String input_file="C:\\Users\\nchdz\\Documents\\NetBeansProjects\\KSowCho\\one.jpg";
			String output_file="C:\\Users\\nchdz\\Documents\\NetBeansProjects\\KSowCho\\textonimage.txt";	
			String tesseract_install_path="D:\\Tesseract-OCR\\tesseract";
			String[] command =
		    {
		        "cmd",
		    };
		    Process p;
			try {
				p = Runtime.getRuntime().exec(command);
			        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
		                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
		                PrintWriter stdin = new PrintWriter(p.getOutputStream());
		                stdin.println("\""+tesseract_install_path+"\" \""+input_file+"\" \""+output_file+"\" -l eng");
		        	    stdin.close();
		                p.waitFor();
		                System.out.println();
		                System.out.println();
		                System.out.println();
		                System.out.println();
		              //  System.out.println(Read_File.read_a_file(output_file+".txt"));
		    	} catch (Exception e) {
		 		e.printStackTrace();
			}
			return Read_File.read_a_file(output_file+".txt");
                }
		public static void main(String[] args) {
			String input_file="C:\\Users\\nchdz\\Documents\\NetBeansProjects\\KSowCho\\one.jpg";
			String output_file="D:\\Tesseract-OCR\\demo.txt";	
			String tesseract_install_path="D:\\Tesseract-OCR\\tesseract";
			String[] command =
		    {
		        "cmd",
		    };
		    Process p;
			try {
				p = Runtime.getRuntime().exec(command);
			        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
		                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
		                PrintWriter stdin = new PrintWriter(p.getOutputStream());
		                stdin.println("\""+tesseract_install_path+"\" \""+input_file+"\" \""+output_file+"\" -l eng");
		        	    stdin.close();
		                p.waitFor();
		                System.out.println();
		                System.out.println();
		                System.out.println();
		                System.out.println();
		                System.out.println(Read_File.read_a_file(output_file+".txt"));
		    	} catch (Exception e) {
		 		e.printStackTrace();
			}
		}	
	}	