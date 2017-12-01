public class PolarPoint {

    private double rho;
    private double phi;

    PolarPoint(double rho, double phi){
        this.rho = rho;
        this.phi = phi;
        while (this.phi >= 2 * Math.PI){
            this.phi -= 2 * Math.PI;
        }
        while (this.phi < 0){
            this.phi += 2 * Math.PI;
        }
    }

    public double getRho() {
        return rho;
    }

    public double getPhi() {
        return phi;
    }

    Point toCartesian(){
        return new Point(rho * Math.cos(phi), rho * Math.sin(phi));
    }
}
