package pojoClasses;

public class User {
    private String payfare_id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String date_of_birth;
    private String created_at;
    private String status;
    private Object reason_code;
    private String reward_tier;
    private Object metadata;
    private String email;
    private Object middle_name;
    private String embossed_name;
    private String external_id;
    private ExpressConsent express_consent;
    private String preferred_language;
    private Address address;

    public String getPayfare_id() {
        return payfare_id;
    }

    public void setPayfare_id(String payfare_id) {
        this.payfare_id = payfare_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getReason_code() {
        return reason_code;
    }

    public void setReason_code(Object reason_code) {
        this.reason_code = reason_code;
    }

    public String getReward_tier() {
        return reward_tier;
    }

    public void setReward_tier(String reward_tier) {
        this.reward_tier = reward_tier;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(Object middle_name) {
        this.middle_name = middle_name;
    }

    public String getEmbossed_name() {
        return embossed_name;
    }

    public void setEmbossed_name(String embossed_name) {
        this.embossed_name = embossed_name;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public ExpressConsent getExpress_consent() {
        return express_consent;
    }

    public void setExpress_consent(ExpressConsent express_consent) {
        this.express_consent = express_consent;
    }

    public String getPreferred_language() {
        return preferred_language;
    }

    public void setPreferred_language(String preferred_language) {
        this.preferred_language = preferred_language;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
