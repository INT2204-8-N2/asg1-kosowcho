/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 *
 * @author nchdz
 */
import com.rmtheis.yandtran.language.Language;
import com.rmtheis.yandtran.translate.Translate;

public class Translator {
    public static String Translator(String st) throws Exception
    {
        Translate.setKey("trnsl.1.1.20180926T103812Z.5747fd9778e3e590.75ee43abc85fe5c4bc048b39776e176f96a36bc9");

        String translatedText = Translate.execute(st, Language.ENGLISH, Language.VIETTNAM);
        
        return translatedText;
    }
    public static void main(String[] args) throws Exception {
        Translate.setKey("trnsl.1.1.20180926T103812Z.5747fd9778e3e590.75ee43abc85fe5c4bc048b39776e176f96a36bc9");

        String translatedText = Translate.execute("Hello World!!!", Language.ENGLISH, Language.VIETTNAM);

        System.out.println(translatedText);
    }
}
