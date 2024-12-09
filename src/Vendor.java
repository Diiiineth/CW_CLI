public class Vendor {
    private int id;
    private String vendorName;

    public Vendor(int id, String vendorName) {
        this.id = id;
        this.vendorName = vendorName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return vendorName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String vendorName) {
        this.vendorName = vendorName;
    }
}
