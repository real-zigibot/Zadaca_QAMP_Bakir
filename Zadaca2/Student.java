import java.util.HashMap;
import java.util.*;


public class Student {
    private HashMap<Integer, String> studentInfo;

    private Student() {
        studentInfo = new HashMap<Integer, String>();
    }

    private Student(HashMap<Integer, String> map) {
        studentInfo = map;
    }

    public Student addStudent(int key, String name) throws Exception { //necemo da se entry u mapi preslika na
        // postojece podatke(overwrite nema smisla pa gledamo jedinstvneost kljuca)
        if (studentInfo.size() != 0)
            for (Integer kljuc : studentInfo.keySet()) {
                if (kljuc == key)
                    throw new Exception("Proslijedjeni kljuc za novog studenta vec postoji.");
            }
        studentInfo.put(key, name);
        return this;
    }

    public Student deleteStudent(int key) {
        studentInfo.remove(key);
        return this;
    }

    public String getStudentName(Integer key) {
        return studentInfo.get(key);
    }

    /*
  public void getStudentKey(String s) {
      return studentInfo.get()
  }

    public void writeOut(){
        for(Map.Entry<Integer,Double>element:studentInfo.entrySet())
            System.out.println("Kljuc= "+element.getKey()+", Vrijednost= "+element.getValue());
    }
*/
    public void writeNamesOut() {
        for (String value : studentInfo.values()) {
            System.out.print("Vrijednost = " + value + " ");
        }
    }

    public void writeStudentNumbersOut() {
        for (Integer kljuc : studentInfo.keySet()) {
            System.out.print("Kljuc = " + kljuc + " ");
        }

    }

    public void writeOut() {
        writeStudentNumbersOut();
        writeNamesOut();
    }


    public static void main(String[] args) {
        try {
            Student S = new Student();
            S.studentInfo.put(17899, "Igor");
            S.writeOut();
            System.exit(0);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
