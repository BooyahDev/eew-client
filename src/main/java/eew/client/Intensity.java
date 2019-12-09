package eew.client;

public class Intensity {
    private double lat = -1;
    private double lon = -1;
    private double avs = 600;

    public void setAvs(double avs) {
        this.avs = avs;
    }

    public void setHouseCoordinate(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * 下記の計算式を元に震度を算出
     * http://www.j-map.bosai.go.jp/j-map/result/tn_246/html/html/2-4-1.html
     *
     * AVS30は下記URL「表層地盤」→ 「30m平均S波速度」で求める
     * http://www.j-shis.bosai.go.jp/map/
     * 赤羽岩淵の場合は 142m/s
     *
     * @param magnitude : マグニチュード
     * @param depth     : 震源の深さ
     * @param lat       : 震源緯度
     * @param lon       : 震源軽度
     * @return : 予測震度
     */
    public double getInstr(double magnitude, double depth, double lat, double lon) {
        // 震源距離
        double x = Math.sqrt(Math.pow(getDistance(this.lat, this.lon, lat, lon), 2) + Math.pow(depth, 2));
        // 増幅率
//        double momentmagnitute = 0.78*magnitude + 1.08;
//        double momentmagnitute = (Math.log10(magnitude)-9.1)/1.5;
        double momentmagnitute = magnitude;
        double pgv = 0.58 * momentmagnitute + 0.0038 * depth + 0 - 1.29 - Math.log10(x + 0.0028 * Math.pow(10, 0.5 * momentmagnitute)) - 0.002 * x;
        double amp = 2.367 - 0.852 * Math.log10(avs);
        double PGV = Math.pow(Math.E,amp) * Math.pow(Math.E,pgv);
        double I = 2.002 + 2.603 * Math.log10(PGV);
        System.out.println(pgv);
        return I;
//        double pgv = 0.58 * momentmagnitute + 0.0038 * depth + 0 - 1.29 - Math.log10(x + 0.0028 * Math.pow(10, 0.5 * momentmagnitute)) - 0.002 * x;
//        return 2.68 + 1.72 * pgv;
    }

    private static double getDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        return (dist * 60 * 1.1515 * 1.609344);
    }

    private static double rad2deg(double radian) {
        return radian * (180f / Math.PI);
    }

    private static double deg2rad(double degree) {
        return degree * (Math.PI / 180f);
    }


}
