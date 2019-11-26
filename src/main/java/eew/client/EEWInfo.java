package eew.client;

public class EEWInfo {
    Result ResultObject;
    private String report_time;
    private String region_code;
    private String request_time;
    private String region_name;
    private String longitude;
    private boolean is_cancel;
    private String depth;
    private String calcintensity;
    private boolean is_final;
    private boolean is_training;
    private String latitude;
    private String origin_time;
    Security SecurityObject;
    private String magunitude;
    private String report_num;
    private String request_hypo_type;
    private String report_id;
    private String alertflg;


    // Getter Methods

    public Result getResult() {
        return ResultObject;
    }

    public String getReport_time() {
        return report_time;
    }

    public String getRegion_code() {
        return region_code;
    }

    public String getRequest_time() {
        return request_time;
    }

    public String getRegion_name() {
        return region_name;
    }

    public String getLongitude() {
        return longitude;
    }

    public boolean getIs_cancel() {
        return is_cancel;
    }

    public String getDepth() {
        return depth;
    }

    public String getCalcintensity() {
        return calcintensity;
    }

    public boolean getIs_final() {
        return is_final;
    }

    public boolean getIs_training() {
        return is_training;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getOrigin_time() {
        return origin_time;
    }

    public Security getSecurity() {
        return SecurityObject;
    }

    public String getMagunitude() {
        return magunitude;
    }

    public String getReport_num() {
        return report_num;
    }

    public String getRequest_hypo_type() {
        return request_hypo_type;
    }

    public String getReport_id() {
        return report_id;
    }

    public String getAlertflg() {
        return alertflg;
    }

    // Setter Methods

    public void setResult(Result resultObject) {
        this.ResultObject = resultObject;
    }

    public void setReport_time(String report_time) {
        this.report_time = report_time;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public void setRequest_time(String request_time) {
        this.request_time = request_time;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setIs_cancel(boolean is_cancel) {
        this.is_cancel = is_cancel;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public void setCalcintensity(String calcintensity) {
        this.calcintensity = calcintensity;
    }

    public void setIs_final(boolean is_final) {
        this.is_final = is_final;
    }

    public void setIs_training(boolean is_training) {
        this.is_training = is_training;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setOrigin_time(String origin_time) {
        this.origin_time = origin_time;
    }

    public void setSecurity(Security securityObject) {
        this.SecurityObject = securityObject;
    }

    public void setMagunitude(String magunitude) {
        this.magunitude = magunitude;
    }

    public void setReport_num(String report_num) {
        this.report_num = report_num;
    }

    public void setRequest_hypo_type(String request_hypo_type) {
        this.request_hypo_type = request_hypo_type;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }

    public void setAlertflg(String alertflg) {
        this.alertflg = alertflg;
    }

    public static class Result {
        private String status;
        private String message;
        private boolean is_auth;

        // Getter Methods

        public String getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public boolean getIs_auth() {
            return is_auth;
        }

        // Setter Methods

        public void setStatus(String status) {
            this.status = status;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setIs_auth(boolean is_auth) {
            this.is_auth = is_auth;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "status='" + status + '\'' +
                    ", message='" + message + '\'' +
                    ", is_auth=" + is_auth +
                    '}';
        }
    }

    public static class Security {
        private String realm;
        private String hash;

        // Getter Methods

        public String getRealm() {
            return realm;
        }

        public String getHash() {
            return hash;
        }

        // Setter Methods

        public void setRealm(String realm) {
            this.realm = realm;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        @Override
        public String toString() {
            return "Security{" +
                    "realm='" + realm + '\'' +
                    ", hash='" + hash + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "EEWInfo{" +
                "ResultObject=" + ResultObject.toString() +
                ", report_time='" + report_time + '\'' +
                ", region_code='" + region_code + '\'' +
                ", request_time='" + request_time + '\'' +
                ", region_name='" + region_name + '\'' +
                ", longitude='" + longitude + '\'' +
                ", is_cancel=" + is_cancel +
                ", depth='" + depth + '\'' +
                ", calcintensity='" + calcintensity + '\'' +
                ", is_final=" + is_final +
                ", is_training=" + is_training +
                ", latitude='" + latitude + '\'' +
                ", origin_time='" + origin_time + '\'' +
                ", SecurityObject=" + SecurityObject.toString() +
                ", magunitude='" + magunitude + '\'' +
                ", report_num='" + report_num + '\'' +
                ", request_hypo_type='" + request_hypo_type + '\'' +
                ", report_id='" + report_id + '\'' +
                ", alertflg='" + alertflg + '\'' +
                '}';
    }
}
