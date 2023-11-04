
package models;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileModel {
    public String addCipherSuffix(String inputFileName) {
    // Tìm vị trí của dấu chấm (.) cuối cùng trong tên tệp
        int lastDotIndex = inputFileName.lastIndexOf(".");

        if (lastDotIndex != -1) {
            // Nếu có dấu chấm, thêm "_cipher" vào trước dấu chấm
            String namePart = inputFileName.substring(0, lastDotIndex);
            String extension = inputFileName.substring(lastDotIndex);
            return namePart + "_cipher" + extension;
        } else {
            // Nếu không có dấu chấm, thêm "_cipher" vào cuối tên tệp
            return inputFileName + "_cipher";
        }
    }
    
    public String addDecryptSuffix(String inputFileName) {
    // Tìm vị trí của dấu chấm (.) cuối cùng trong tên tệp
        int lastDotIndex = inputFileName.lastIndexOf(".");

        if (lastDotIndex != -1) {
            // Nếu có dấu chấm, thêm "_cipher" vào trước dấu chấm
            String namePart = inputFileName.substring(0, lastDotIndex);
            String extension = inputFileName.substring(lastDotIndex);
            return namePart + "_decrypt" + extension;
        } else {
            // Nếu không có dấu chấm, thêm "_cipher" vào cuối tên tệp
            return inputFileName + "_decrypt";
        }
    }
    public void openFolderContainingFile(String fileName) {
        try {
            File file = new File(fileName);

            if (file.exists()) {
                Desktop.getDesktop().open(file.getParentFile());
            } else {
                System.err.println("Tệp không tồn tại.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String path(String filename) {
         // Lưu danh sách xuống tệp
        String workingDir = System.getProperty("user.dir");
        // Xây dựng đường dẫn đến thư mục "fileKeys" trong thư mục gốc của dự án
        String fileKeysDir = workingDir + File.separator + "src" + File.separator + "fileKeys";

        // Xây dựng đường dẫn đầy đủ tới tệp cần lưu
        return fileKeysDir + File.separator + filename;
    }
    // Ghi danh sách đối tượng KeyModel vào tệp
    public void saveKeyModels(List<KeyModel> keyModels, String pathfile) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathfile));
            oos.writeObject(keyModels);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Đọc danh sách đối tượng KeyModel từ tệp
    public List<KeyModel> loadKeyModels(String pathfile) {
        List<KeyModel> keyModels = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathfile));
            keyModels = (List<KeyModel>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return keyModels;
    }
    

    
    public static void main(String[] args) {


    }
 
}
