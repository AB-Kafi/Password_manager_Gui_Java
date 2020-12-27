package sample;

public class Container {
    private String website;
    private String password;
    public Integer numberofsearch;


    public Container(String website, String password) {
        this.website = website;
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumberofsearch() {
        return numberofsearch;
    }

    public void setNumberofsearch(int numberofsearch) {
        this.numberofsearch = numberofsearch;
    }

    @Override
    public String toString() {
        return "Website = "+this.website;
    }
}
