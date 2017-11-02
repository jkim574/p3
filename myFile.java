public class myFile {

    public static void main(String[] args) {
	String filename = "file0.txt";
	String[] out = filename.split(".");
	System.out.println(filename);
	System.out.println(out[0]);
    }
}
