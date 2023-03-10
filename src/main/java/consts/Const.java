package consts;

public class Const {
    public enum menuOptions {
        ENCRYPT("1"),
        DECRYPT("2"),
        QUIT("3");

        private final String menuOption;

        public String getMenuOption() {
            return menuOption;
        }

        private menuOptions(String option) {
            this.menuOption = option;
        }
    }

    public enum encryptionOptions {
        CAESAR("1"),
        XOR("2"),
        MULTIPLICATION("3"),
        REVERSE("4");

        private final String encryptionOption;

        public String getEncryptionOption() {
            return encryptionOption;
        }

        private encryptionOptions(String option) {
            this.encryptionOption = option;
        }
    }
}