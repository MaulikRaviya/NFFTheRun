
package maulikgame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author MaulikRaviya
 */
public class CodeSecurity {

    public static int findHash(File file) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
        int hash = 0;

        FileInputStream fis = new FileInputStream(file);
        int data = 0;
        while ((data = fis.read()) != -1) {
            hash += data;
        }
        return hash;
    }
}