public class StringProcess {
    public static void checkRotation(String str1, String str2) {
        boolean isRotation = true;

        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(0)) {
                int k = i + 1;
                for (int j = 1; j < str1.length(); j++) {
                    if (k >= str2.length()) {
                        k = 0;
                    }
                    if (str2.charAt(k) != str1.charAt(j)) {
                        isRotation = false;
                        break;
                    }
                    k++;
                }
            }
        }

        if (isRotation) {
            System.out.println("2 chuoi tuan hoan nhau");
        } else {
            System.out.println("2 chuoi khong tuan hoan nhau");
        }
    }

    public static void checkRotation2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("2 chuoi khong tuan hoan nhau");
            return;
        }

        String concatenated = str1 + str1;

        if (concatenated.contains(str2)) {
            System.out.println("2 chuoi tuan hoan nhau");
        } else {
            System.out.println("2 chuoi khong tuan hoan nhau");
        }
    }

    public static void main(String[] args) {
//        StringProcess.checkRotation("IndiaVsEngland", "EnglandIndiaVs");
        StringProcess.checkRotation2("IndiaVsEngland", "EnglandIndiaVs1");
    }
}
