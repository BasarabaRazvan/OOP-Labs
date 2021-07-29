public class Pensionar {
    public float salariu;
    public int aniVechime;

    public Pensionar(float salariu, int aniVechime) {
        this.salariu = salariu;
        this.aniVechime = aniVechime;
    }

    public float getPensie() {
        if(aniVechime >= 20 && aniVechime < 30)
            return (float) new TwentyStrategy().calcul(aniVechime, salariu);
        if(aniVechime >= 30 && aniVechime < 40)
            return (float) new ThirtyStrategy().calcul(aniVechime, salariu);
        if(aniVechime > 40)
            return (float) new FortyStrategy().calcul(aniVechime, salariu);
        return 0;
    }
}

class ThirtyStrategy implements Stragety {
    @Override
    public double calcul(int aniVechime, float salariu) {
        return 1.0 * aniVechime / 30 * salariu;
    }
}

class TwentyStrategy implements Stragety {
    @Override
    public double calcul(int aniVechime, float salariu) {
        return 1.0 * aniVechime / 20 * salariu;
    }
}

class FortyStrategy implements Stragety {
    @Override
    public double calcul(int aniVechime, float salariu) {
        return 1.0 * aniVechime / 40 * salariu;
    }
}

class TestStragety {
    public static void main(String[] args) {
        Pensionar p1 = new Pensionar((float) 2000.3, 25);
        Pensionar p2 = new Pensionar((float) 2000.3, 35);
        Pensionar p3 = new Pensionar((float) 2000.3, 45);

        System.out.println(p1.getPensie());
        System.out.println(p2.getPensie());
        System.out.println(p3.getPensie());
    }
}