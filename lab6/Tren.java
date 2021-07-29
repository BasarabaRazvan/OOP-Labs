import java.util.Vector;
abstract class Vagon {
    private int capacitate_pasageri;
    private int capacitate_colete;

    public Vagon() {
        super();
    }

    public Vagon(int capacitate_pasageri, int capacitate_colete) {
        this.capacitate_pasageri = capacitate_pasageri;
        this.capacitate_colete = capacitate_colete;
    }

    public int getCapacitate_pasageri() {
        return capacitate_pasageri;
    }

    public int getCapacitate_colete() {
        return capacitate_colete;
    }

    public void setCapacitate_pasageri(int capacitate_pasageri) {
        this.capacitate_pasageri = capacitate_pasageri;
    }

    public void setCapacitate_colete(int capacitate_colete) {
        this.capacitate_colete = capacitate_colete;
    }
    public abstract boolean inchidereUsi();
    public abstract boolean deschidereUsi();
    public abstract boolean blocareGeamuri();
}
class CalatoriA extends Vagon {
    public CalatoriA() {
        super();
    }

    public CalatoriA(int capacitate_pasageri, int capacitate_colete) {
        super(capacitate_pasageri, capacitate_colete);
    }

    public boolean inchidereUsi() {
        return true;
    }

    public boolean deschidereUsi() {
        return true;
    }

    public boolean blocareGeamuri() {
        return false;
    }
}

class CalatoriB extends Vagon {
    public CalatoriB() {
        super();
    }

    public CalatoriB(int capacitate_pasageri, int capacitate_colete) {
        super(capacitate_pasageri, capacitate_colete);
    }
    public boolean inchidereUsi() {
        return true;
    }

    public boolean deschidereUsi() {
        return true;
    }

    public boolean blocareGeamuri() {
        return true;
    }
}
class Marfa extends Vagon {
    public Marfa() {
        super();
    }

    public Marfa(int capacitate_pasageri, int capacitate_colete) {
        super(capacitate_pasageri, capacitate_colete);
    }
    public boolean inchidereUsi() {
        return false;
    }

    public boolean deschidereUsi() {
        return false;
    }

    public boolean blocareGeamuri() {
        return false;
    }
}

public class Tren implements Comparable {
    Vector<Vagon> vagon;

    public Tren() {
        vagon = new Vector<Vagon>();
    }

    public Tren(Vector<Vagon> vagon) {
        this.vagon = vagon;
    }

    public void addVagon(Vagon v) {
        vagon.add(v);
    }

    public Vector<Vagon> getVagon() {
        return vagon;
    }

    public void setVagon(Vector<Vagon> vagon) {
        this.vagon = vagon;
    }

    public int totalColete() {
        int total = 0;
        for(int i = 0; i < vagon.size(); i++)
            total += vagon.get(i).getCapacitate_colete();
        return total;
    }
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < vagon.size(); i++) {
            if (vagon.get(i) instanceof CalatoriA) {
                s += "Vagon de tip CalatoriA" + '\n';
            } else if (vagon.get(i) instanceof CalatoriB) {
                s += "Vagon de tip CalatoriB" + '\n';
            } else if (vagon.get(i) instanceof Marfa) {
                s += "Vagon de tip Marfa" + '\n';
            }
        }
        return s;
    }

    @Override
    public int compareTo(Object o) {
        Tren tren = new Tren();
        if(tren.totalColete() - this.totalColete() > 0) {
            return 1;
        } else if(tren.totalColete() - this.totalColete() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Problema5 {
    public static void main(String args[]) {
        Tren t = new Tren();
        t.addVagon(new CalatoriA());
        t.addVagon(new CalatoriB());
        t.addVagon(new CalatoriA());
        t.addVagon(new CalatoriA());
        t.addVagon(new CalatoriA());
        t.addVagon(new CalatoriB());
        t.addVagon(new CalatoriB());
        t.addVagon(new Marfa());
        System.out.println(t);
    }
}