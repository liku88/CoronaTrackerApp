package in.mangaldeepDeveloper;

public class HelperClass {
    private  String  country , cases , todayCases , todayDeaths , deaths, flags , recovered , active , critical;

    public HelperClass() {
    }

    public HelperClass(String country, String cases, String todayCases, String todayDeaths, String deaths, String flags, String recovered, String active, String critical) {
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.todayDeaths = todayDeaths;
        this.deaths = deaths;
        this.flags = flags;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }
}
