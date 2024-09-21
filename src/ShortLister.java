import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            System.out.println("Short words from filter:");


            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                ShortWordFilter filter = new ShortWordFilter();

                InputStream in = Files.newInputStream(file);
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                String line;

                while ((line = reader.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        if (filter.accept(word)) {
                            System.out.println(word);
                        }
                    }
                }

                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");
            }

            else  // User closed the chooser without selecting a file
            {
                System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
