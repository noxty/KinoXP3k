package Classes;

public class Customer extends Person
{
    private int customerID;
    private String fName;
    private String lName;
    private int phoneNo;

    public Customer(int customerID, String fName, String lName, int phoneNo) {
        this.customerID = customerID;
        this.fName = fName;
        this.lName = lName;
        this.phoneNo = phoneNo;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phoneNo=" + phoneNo +
                ", lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                ", customerID=" + customerID +
                '}';
    }
}
