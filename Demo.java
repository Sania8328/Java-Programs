import java.io.*;

class Student implements Serializable {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Demo {
    public static void main(String[] args) {
        try {
            // Serialization
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream("data.txt"));

            out.writeObject(new Student(1, "Sania"));
            out.writeObject(new Student(2, "Ayesha"));
            out.writeObject(new Student(3, "Fatima"));
            out.close();

            // Deserialization
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream("data.txt"));

            for (int i = 0; i < 3; i++) {
                Student obj = (Student) in.readObject();
                System.out.println(obj.id + " " + obj.name);
            }
            in.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

