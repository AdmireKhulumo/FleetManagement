public class Reservation extends Car{
    private String fname, sname, phone, address;
    private int id;

    //default constructor
    public Reservation() {
        super();
        this.fname = "";
        this.sname = "";
        this.phone = "";
        this.address = "";
        this.id = 0;
    }

    //paramterised constructor
    public Reservation(String fname, String sname, String phone, String address, int id, String make, String model, String regNo, int year, String available ,String url) {
        //initialise parent instance variables
        super(make, model, regNo, year, available, url);

        //initilise the local instance variables
        this.fname = fname;
        this.sname = sname;
        this.phone = phone;
        this.address = address;
        this.id = id;
    }

    //getters and setters
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //to string method

    @Override
    public String toString() {
        return super.toString() + "\nReservation{" +
                "fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
