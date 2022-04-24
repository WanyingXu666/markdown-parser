
  
import static org.junit.Assert.*;

import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.*;

public class MarkdownParseTest { //creates the class
    @Test //lets junit know to run the next function as a test
    public void addition() { //this is a function
        assertEquals(2, 1 + 1); //if theses two terms are not equal, declares an error
    }

    @Test
    public void tutorial() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }

   
    @Test
    public void tutorial3() throws IOException{
        Path fileName = Path.of("test-file8.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals("Test whether the program can work well when there is an image link",List.of("https://www.youtube.com/watch?v=dQw4w9WgXcQ", "https://www.google.com/"), links);
        assertEquals("Test whether the output have the correct length when there is an image link",2, links.size());
    }

    @Test
    public void tutorial4() throws IOException{
        Path fileName = Path.of("new.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://www.youtube.com/watch?v=k67e-Icw4ug", "https://docs.google.com/document/d/1imYmDA9jxAahtM-0pG24BjfkO5F2Q0MVQVtzVYsl_D0/edit"), links);
    }


}