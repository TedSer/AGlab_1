public class LawnMower {
    private double widthOfGrassCutting;
    private double enginePower;
    private double fuelVolume;
    private String model;

    LawnMower(String model, double widthOfGrassCutting, double enginePower, double fuelVolume) {
        setModel(model);
        setWidthOfGrassCutting(widthOfGrassCutting);
        setEnginePower(enginePower);
        setFuelVolume(fuelVolume);
    }

    @Override
    public String toString() {
        return "Manufacturer " + getModel() + " Width of grass cutting zone in cm: " + getWidthOfGrassCutting() + " Power of engine: " + getEnginePower() + " Fuel volume: " + getFuelVolume();
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    private void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public double getWidthOfGrassCutting() {
        return widthOfGrassCutting;
    }

    private void setWidthOfGrassCutting(double widthOfGrassCutting) {
        this.widthOfGrassCutting = widthOfGrassCutting;
    }

    public double getEnginePower() {
        return enginePower;
    }

    private void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    private String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }
}