package utils;

public class Alphabet {

    public static char[] matrixEnglish2 = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    public static char[] matrixVN2 = {'a', 'á', 'à', 'ả', 'ạ', 'ã', 'ă', 'ắ', 'ằ', 'ẳ', 'ẵ', 'ặ', 'â',
            'ấ', 'ầ', 'ẩ', 'ẫ', 'ậ', 'b', 'c', 'd', 'đ', 'e', 'é', 'è', 'ẻ', 'ẹ', 'ẽ', 'ê', 'ế', 'ề',
            'ể', 'ễ', 'ệ', 'f', 'g', 'h', 'i', 'í', 'ì', 'ỉ', 'ị', 'ĩ', 'k', 'l', 'm', 'n', 'o', 'ó',
            'ò', 'ỏ', 'ọ', 'õ', 'ô', 'ố', 'ồ', 'ổ', 'ỗ', 'ộ', 'ơ', 'ớ', 'ờ', 'ở', 'ỡ', 'ợ', 'p', 'q',
            'r', 's', 't', 'u', 'ú', 'ù', 'ủ', 'ụ', 'ũ', 'ư', 'ứ', 'ừ', 'ử', 'ữ', 'ự', 'v', 'x', 'y',
            'ý', 'ỳ', 'ỷ', 'ỵ', 'ỹ',
            'A', 'Á', 'À', 'Ả', 'Ạ', 'Ã', 'Ă', 'Ắ', 'Ằ', 'Ẳ', 'Ẵ', 'Ặ', 'Â', 'Ấ', 'Ầ', 'Ẩ', 'Ẫ', 'Ậ',
            'B', 'C', 'D', 'Đ', 'E', 'É', 'È', 'Ẻ', 'Ẹ', 'Ẽ', 'Ê', 'Ế', 'Ề', 'Ể', 'Ễ', 'Ệ', 'F', 'G',
            'H', 'I', 'Í', 'Ì', 'Ỉ', 'Ị', 'Ĩ', 'K', 'L', 'M', 'N', 'O', 'Ó', 'Ò', 'Ỏ', 'Ọ', 'Õ', 'Ô',
            'Ố', 'Ồ', 'Ổ', 'Ỗ', 'Ộ', 'Ơ', 'Ớ', 'Ờ', 'Ở', 'Ỡ', 'Ợ', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ú',
            'Ù', 'Ủ', 'Ụ', 'Ũ', 'Ư', 'Ứ', 'Ừ', 'Ử', 'Ữ', 'Ự', 'V', 'X', 'Y', 'Ý', 'Ỳ', 'Ỷ', 'Ỵ', 'Ỹ'};


    public static int sizeEnglish2 = matrixEnglish2.length;
    public static int sizeVN2 = matrixVN2.length;

    public static int indexInEnglish2(char s) {
        for (int i = 0; i < sizeEnglish2; i++) {
            if (s == matrixEnglish2[i]) return i;
        }
        return -1;
    }

    public static int indexInVN2(char s) {
        for (int i = 0; i < sizeVN2; i++) {
            if (s == matrixVN2[i]) return i;
        }
        return -1;
    }

    public static String valueInEnglish2(int index) {
        return String.valueOf(matrixEnglish2[index]);
    }
    public static String valueInVN2(int index) {
        return String.valueOf(matrixVN2[index]);
    }
    public static String[][] generateVigenereTableEnglish() {
        int numRows = Alphabet.sizeEnglish2;
        int numCols = Alphabet.sizeEnglish2;

        String[][] table = new String[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                table[i][j] = Alphabet.valueInEnglish2((i + j) % Alphabet.sizeEnglish2);
            }
        }

        return table;
    }
        public static String[][] generateVigenereTableVN() {
        int numRows = Alphabet.sizeVN2;
        int numCols = Alphabet.sizeVN2;

        String[][] table = new String[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                table[i][j] = Alphabet.valueInVN2((i + j) % Alphabet.sizeVN2);
            }
        }

        return table;
    }

    public static void main(String[] args) {




    }
}
