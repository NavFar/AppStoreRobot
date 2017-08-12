/**
 * Created by navidfarahmand on 8/5/17.
 */
public class User {
    private int id=0;
    private String email = new String();
    private String password= new String();
    private String tempPassword = new String();
    private String answer = new String ();
    private int day = 0;
    private int month =0;
    private int year = 0;
    private int namePre = 0;
    private String firstName = new String();
    private String lastName  = new String();
    private String streetName = new String();
    private String city = new String();
    private int state =0;
    private String zipCode =new String();
    private String phoneCode =new String();
    private String phoneNumber= new String();
    public User(String allData){
        String[] sliecedData = allData.split("\t");
        if(sliecedData.length<23)
            return;
        this.id=Integer.parseInt(sliecedData[0]);
        this.email=sliecedData[1];
        this.password=sliecedData[2];
        this.tempPassword=sliecedData[3];
        this.answer= sliecedData[10];
        this.month = Integer.parseInt(sliecedData[11]);
        this.day = Integer.parseInt(sliecedData[12]);
        this.year = Integer.parseInt(sliecedData[13]);
        this.namePre=Integer.parseInt(sliecedData[14]);
        this.firstName=sliecedData[15];
        this.lastName= sliecedData[16];
        this.streetName=sliecedData[17];
        this.city=sliecedData[18];
        this.state=Integer.parseInt(sliecedData[19]);
        this.zipCode=((sliecedData[20]));
        this.phoneCode=(sliecedData[21]);
        this.phoneNumber=((sliecedData[22]));
    }
    public String toString(){
        String output = new String();
        output+="id :"+Integer.toString(this.id)+"\n";
        output+="email :"+this.email+"\n";
        output+="password :"+this.password+"\n";
        output+="temp password :"+this.tempPassword+"\n";
        output+="answer :"+this.answer+"\n";
        output+="date :"+this.year+"/"+this.month+"/"+this.day+"\n";
        output+="namePrefix :"+this.namePre+"\n";
        output+="firstName :"+this.firstName+"\n";
        output+="lastName :"+this.lastName+"\n";
        output+="address :"+this.streetName+"\n";
        output+="state :"+this.state+"\n";
        output+="zip code :"+this.zipCode+"\n";
        output+="phone Code :"+this.phoneCode+"\n";
        output+="phone Number :"+this.phoneNumber+"\n";
        return output;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public String getTempPassword() {
        return tempPassword;
    }

    public String getAnswer() {
        return answer;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getNamePre() {
        return namePre;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public int getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
