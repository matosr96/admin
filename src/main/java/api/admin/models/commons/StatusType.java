package api.admin.models.commons;

public class StatusType {

    public enum StatusTypeEnum {
        ACTIVE("active");

        private final String value;

        // Constructor del enum
        private StatusTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
}
