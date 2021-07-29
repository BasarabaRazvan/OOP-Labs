import java.util.Collections;
import java.util.Vector;

interface Persoana extends Comparable {
    public double calculMedieGenerala();
    public String getNume();
    public void setNume(String nume);
    public void addMedie(double medie);
}

public class Student implements Persoana {
    private String nume;
    private Vector<Double> medii;

    public Student() {
        medii = new Vector<Double>();
    }
    public Student(String nume, Vector medii) {
        this.nume = nume;
        this.medii = medii;
    }

    public double calculMedieGenerala() {
        double media = 0;
        for (Double i : this.medii)
        {
            media = media + i;
        }
        media = media / this.medii.size();
        return media;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void addMedie(double medie) {
        this.medii.add(medie);
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        int n = nume.compareTo(s.nume);
        if(n != 0)
            return n;
        else
        {
            if((calculMedieGenerala() - s.calculMedieGenerala()) < 0.0) {
                return 1;
            }
            return -1;
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", medii=" + medii + " media - > " + calculMedieGenerala() + '}';
    }
}

class test {
    public static void main(String[] args) {
        Vector<Double> m1 = new Vector<Double>();
        m1.add(3.0);
        m1.add(7.0);
        m1.add(9.0);
        Student s1 = new Student("Andrei", m1);

        Vector<Double> m2 = new Vector<Double>();
        m2.add(8.0);
        m2.add(7.0);
        m2.add(10.0);
        Student s2 = new Student("Andrei", m2);

        Vector<Student> studenti = new Vector<Student>();
        studenti.add(s1);
        studenti.add(s2);
        Collections.sort(studenti);
        System.out.println(studenti);
    }
}