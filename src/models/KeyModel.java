
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KeyModel implements Serializable{
    private String name;
    private String key;
    private int keySize;
    private String mode;
    private String padding;

    public KeyModel(String name, String key, int keySize, String mode, String padding) {
        this.name = name;
        this.key = key;
        this.keySize = keySize;
        this.mode = mode;
        this.padding = padding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getKeySize() {
        return keySize;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getPadding() {
        return padding;
    }

    public void setPadding(String padding) {
        this.padding = padding;
    }

    @Override
    public String toString() {
        return "KeyModel{" + "name=" + name + ", key=" + key + ", keySize=" + keySize + ", mode=" + mode + ", padding=" + padding + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KeyModel other = (KeyModel) obj;
        if (this.keySize != other.keySize) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        if (!Objects.equals(this.mode, other.mode)) {
            return false;
        }
        return Objects.equals(this.padding, other.padding);
    }
    
    
    
    
}
