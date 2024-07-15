package java0712;

public class ArrayCopyEx {
    public static void main(String[] args) {
        String[] oldStrArray = {"java", "array", "copy"};
        
        String[] newStrArray = new String[5];
        
        System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
        
        for (int i = 0; i < newStrArray.length; i++) {
            if (newStrArray[i] != null) {
                System.out.print(newStrArray[i]);
                if (i < newStrArray.length - 1 && newStrArray[i + 1] != null) {
                    System.out.print(", ");
                }
                
            }
        }
    }
}
