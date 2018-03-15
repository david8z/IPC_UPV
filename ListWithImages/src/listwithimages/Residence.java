
package listwithimages;


public class Residence {
    private final String city;
    private final String province;

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }
    
    public Residence(String city, String province) {
        this.city = city;
        this.province = province;
    }
}
