import java.util.HashMap;

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
            for (Integer loopkey : studentInfo.keySet()) {
                if (loopkey == key)
                    throw new Exception("Proslijedjeni kljuc za novog studenta vec postoji.");
            }
        studentInfo.put(key, name);
        return this;
    }

    public Student deleteStudent(int key) throws Exception {
        if(!studentInfo.containsKey(key))
            throw new Exception("Nije moguce brisanje studenta iz baze, kljuc ne postoji.");
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
            System.out.print("Vrijednost = " + value + " \n");
        }
    }

    public void writeStudentNumbersOut() {
        for (Integer key : studentInfo.keySet()) {
            System.out.print("Kljuc = " + key + " ");
        }

    }

    public void writeOut() {
        System.out.println("Svi studenti klase su:");
        writeStudentNumbersOut();
        writeNamesOut();
    }
    public Student editStudent(int key, String newValue) throws  Exception{
        if(!studentInfo.containsKey(key))
            throw new Exception("Student pod datim kljucem ne postoji.");
        studentInfo.replace(key,newValue);
        return  this;
    }

    public static void main(String[] args) {
        try {
            Student S = new Student();
            S.studentInfo.put(17899, "Igor");
            S.writeOut();
            S.deleteStudent(17899);
            S.addStudent(18999,"Ivana");
            S.writeOut();
            S.editStudent(17999,"Alma");
            S.writeOut();
            System.exit(0);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
