public class Main {
    private static Logger logger = Logger.getInstance();

    public static void main(String[] args) {
        logger.log("Hello");

        try {
            int i = Integer.parseInt("blah");
        } catch (Exception e) {
            logger.log(e);
        }

        try {
            double d = Double.parseDouble("1.2.3");
        } catch (Exception e) {
            logger.log(e, "Invalid input!!");
        }
    }
}
