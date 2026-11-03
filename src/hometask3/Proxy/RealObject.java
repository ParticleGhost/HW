package hometask3.Proxy;

import com.fasterxml.jackson.databind.ObjectMapper;
import hometask2.Student;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class RealObject implements ProxyStudents {
    private Student[] students = null;

    public RealObject() {
        System.out.println("Loading students from json...");
        ObjectMapper mapper = new ObjectMapper();
        Path path = Paths.get("data", "Student_base.json");
        try {
            this.students = mapper.readValue(path.toFile(), Student[].class);
        } catch (IOException e) {
            System.out.println("Cannot load Student_base.json");
        }
    }

    @Override
    public void run() {
        if (students != null) {
            System.out.println("Loaded json with " + Arrays.stream(students).count() + " students.");
        } else {
            System.out.println("Student_base.json doesn't loaded.");
        }
    }
}
