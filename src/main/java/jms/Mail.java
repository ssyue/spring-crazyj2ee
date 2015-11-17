package jms;

public class Mail {
    private String mailID;

    private String name;

    private double weight;
    
    Mail(){
        
    }
    Mail(String mail,String name,double w){
        this.mailID=mail;
        this.name=name;
        this.weight=w;
    }
    public String getMail() {
        return mailID;
    }

    public void setMail(String mail) {
        this.mailID = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
