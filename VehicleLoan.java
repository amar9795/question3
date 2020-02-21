class VehicleLoan extends SecuredLoan
{
    private String vehicleCategory;
    private String vehicleModelNo;
    private String manufacturer;
    private int yearOfmanufacture;
    private double assetValue;

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getVehicleModelNo() {
        return vehicleModelNo;
    }

    public void setVehicleModelNo(String vehicleModelNo) {
        this.vehicleModelNo = vehicleModelNo;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfmanufacture() {
        return yearOfmanufacture;
    }

    public void setYearOfmanufacture(int yearOfmanufacture) {
        this.yearOfmanufacture = yearOfmanufacture;
    }

    public double getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(double assetValue) {
        this.assetValue = assetValue;
    }

    public void vehicleLoneLTV(){
        double LTV = getLoanAmount()/getAssetValue();
        System.out.println("Vehicle Lone LTV is:" + LTV);

    }



}
