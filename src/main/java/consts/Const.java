package consts;

public class Const {
    public enum options {
        ENCRYPT("1"),
        DECRYPT("2"),
        QUIT("3");

        private final String option;

        public String getOption() {
            return option;
        }

        private options(String option) {
            this.option = option;
        }
    }
}