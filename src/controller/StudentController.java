package controller;

import model.Student;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
  private static List<Student> students = new ArrayList<>();
  private List<Student> getStudents() {
      return students;
  }

  public static void addStudent(Student student) {
      students.add(student);

  }

  public static void writeFile(List<Student> students) throws IOException {
    File file = new File("students.txt");

    FileOutputStream fileOutputStream = null;
    ObjectOutputStream objectOutputStream = null;

      try {
          fileOutputStream = new FileOutputStream(file);
      } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
      }
      try {
          objectOutputStream = new ObjectOutputStream(fileOutputStream);
          objectOutputStream.writeObject(students);
      } catch (IOException e) {
          throw new RuntimeException(e);
      }finally {
          fileOutputStream.close();
          objectOutputStream.close();
      }

  }

    public static List<Student> readFile() throws IOException {
     File file = new File("students.txt");

     FileInputStream fileInputStream = null;
     ObjectInputStream objectInputStream = null;

     List<Student> students = new ArrayList<>();

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            objectInputStream.close();
            fileInputStream.close();
        }


        return students;
    }
}
