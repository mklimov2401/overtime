import util.Proc;

import java.io.FileInputStream;
import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {
        FileInputStream file = Proc.loadFile();
        Proc.processing(file);
    }


}
