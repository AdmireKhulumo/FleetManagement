public class Car {
    private String make, model, regNo, available, url = "./src/main/resources/images/mercedes-c43.jpg";
    private int year;

    //default constructor
    Car(){
        this.make = "";
        this.model = "";
        this.regNo = "";
        this.year = 0;
        this.available = "";
    }

    //parameterised constructor
    Car(String make, String model, String regNo, int year, String available ,String url){
        this.make = make;
        this.model = model;
        this.regNo = regNo;
        this.year = year;
        this.available = available;

        //if an empty url is not received, set the url to the url received; otherwise leave it as it is
        if (!url.isEmpty() ){
            this.url = url;
        }
    }

    //for printing out car object details
    @Override
    public String toString() {
        return "\nRegistration: " + regNo + "\nMake: " + make + "\nModel: " + model + "\nYear: " + year + "\nAvailable: " + available + "\nURL: " + url;
    }

    //getters and setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
