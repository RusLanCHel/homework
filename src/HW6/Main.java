import java.io.*;

public class Main {

    public static void main(String[] args){

        InputStream in;
        OutputStream out;

        try{

            FileOutputStream fos = new FileOutputStream("test1.txt");
            for(int i = 0; i < 8; i++){
                fos.write("Hello".getBytes());
            }


            FileOutputStream fos1 = new FileOutputStream("test2.txt");
            for(int i = 0; i < 8; i++){
                fos1.write("World".getBytes());
            }
            fos.close();
            fos1.close();

            FileInputStream fis1 = new FileInputStream("test1.txt");
            FileInputStream fis2 = new FileInputStream("test2.txt");
            FileOutputStream fos3 = new FileOutputStream("test3.txt");

            int b;
            while((b = fis1.read()) != -1){
                fos3.write((char)b);
            }
            int c;
            while((c = fis2.read()) != -1){
                fos3.write((char)c);
            }
            fos3.close();
            fis1.close();
            fis2.close();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }

}
