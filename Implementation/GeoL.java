package api.Implementation;

import api.api.GeoLocation;

public class GeoL implements GeoLocation {
    private double _x;
    private double _y;
    private double _z;

    public GeoL(double x, double y, double z){
        this._x = x;
        this._y = y;
        this._z = z;
    }
    @Override
    public double x() {
        return this._x;
    }

    @Override
    public double y() {
        return this._y;
    }

    @Override
    public double z() {
        return this._z;
    }

    @Override
    public double distance(GeoLocation g) {
        double d1 = Math.pow(this._x - g.x(), 2);
        double d2 = Math.pow(this._y - g.y(), 2);
        double d3 = Math.pow(this._z - g.z(), 2);
        return Math.sqrt(d1 + d2 + d3);
    }

    public String toString(){
        return this._x + "," + this._y + "," + this._z;
    }
}
