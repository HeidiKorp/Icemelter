import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Read instruction.
 */
public class ReadInstruction {

    /**
     * Name of the file.
     */
    private String filename;

    /**
     * List of lines from the file.
     */
    private List<String> lines = new ArrayList<>();

    /**
     * Read the instruction.
     * @param filename Instruction file.
     */
    public ReadInstruction(String filename) {

        if (filename != null && !filename.isEmpty()) {

            this.filename = filename;
            //Path path = Paths.get("C:\\Users\\korph\\IdeaProjects\\IceBreaker\\Game\\src\\Instructions.txt");
            Path path = Paths.get("Game\\src\\Instructions.txt");

            try (Scanner scanner = new Scanner(path)) {
                while (scanner.hasNext()) {
                    lines.add(scanner.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Read the file into a list of text lines.
     * @return List of lines.
     */
    public List<String> getLines() {
        return lines;
    }
}
