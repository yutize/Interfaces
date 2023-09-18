import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
public class ShortLister {
    public static ArrayList<Object> collectAll(ArrayList<Object> objects, Filter f) {
        ArrayList<Object> result = new ArrayList<Object>();
        for (Object ob : objects) {
            if (f.accept(ob)) {
                result.add(ob);
            }
        }
        return result;
    }
    public static void main(String[] args) throws FileNotFoundException {
        JFileChooser chooser=new JFileChooser();
        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            File file=chooser.getSelectedFile();
            Scanner scanner=new Scanner(file);
            ArrayList<Object> words=new ArrayList<Object>();
            while(scanner.hasNext()){
                words.add(scanner.next());
            }
            scanner.close();
            words=collectAll(words, new ShortWordFilter());
            System.out.println("Filtered words:");
            for(Object str:words){
                System.out.println(str);

            }
        }
    }
}