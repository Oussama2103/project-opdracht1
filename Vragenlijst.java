import java.util.ArrayList;

public class Vragenlijst {
    private ArrayList <String> vragen = new ArrayList<>();
    private ArrayList <String> antwoorden = new ArrayList<>();

    public Vragenlijst(ArrayList<String> vragen, ArrayList<String> antwoorden) {
        this.vragen = vragen;
        this.antwoorden = antwoorden;
    }

    //getters

    public ArrayList<String> getVragen() {
        return vragen;
    }

    public ArrayList<String> getAntwoorden() {
        return antwoorden;
    }

    //setters

    public void setVragen(ArrayList<String> vragen) {
        this.vragen = vragen;
    }

    public void setAntwoorden(ArrayList<String> antwoorden) {
        this.antwoorden = antwoorden;
    }

}
