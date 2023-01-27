class StringOperations {

    // create static nested class EngString
    static class EngString{
        boolean english;
        String string;

        public EngString(boolean english, String string) {
            this.english = english;
            this.string = string;
        }

        public boolean isEnglish() {
            return english;
        }

        public void setEnglish(boolean english) {
            this.english = english;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }

}