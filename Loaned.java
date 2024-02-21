public class Loaned {

    String person;
    String use;
    int amt;
    String ctry;
    String activ;
  
    Loaned(String person, String use, int amt, String ctry, String activ) {
        this.person = person;
        this.use = use;
        this.amt = amt;
        this.ctry = ctry;
        this.activ = activ;
    }

    public String getActivity(){
        return activ;
    }

    public String getUse(){
        return use;
    }

    public String toString(){
        return "\nName: " + person + " Country: " + ctry + " Loan Amount: " + amt + " Use: " + use + " Activity: " + activ + "\n";
    }

    
}
