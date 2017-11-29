package tp.RestPost;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import sun.misc.BASE64Decoder;

@RestController
@SpringBootApplication

public class RestPostApplication {
    
    
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> update(@RequestParam String name, String image ) {
        //JFrame frame = buildFrame();
        StringBuilder sb = new StringBuilder();
        
       
        for (int i = 0; i < (Math.random() * 5); i++){
            Random rn = new Random();
            String poistka = "1";
            String STK = "1";
            if(rn.nextInt(2)==1){
                poistka = "0";
            }
            if(rn.nextInt(2)==1){
                STK = "0";
            }
            Integer a = name.length();
            //System.out.println(name);
            //System.out.println(a);
            //System.out.println(image);
            String name2 = name.toUpperCase();
            sb.append(name).append("=====").append(name2).append("=====").append(plate()).append("=====");
            sb.append(poistka).append("=====").append(STK).append("=====");
            sb.append("Honda").append("=====").append("Civic").append("=====").append("2010").append("=====");
            sb.append("_____");
            System.out.println(i);
        }
         //System.out.println(sb.toString());
        return ResponseEntity.ok(sb.toString());
    }
    

    	
    public static void main(String[] args) {
        SpringApplication.run(RestPostApplication.class, args);
    }
   
    
    public static String plate() {
    String[] okresy = new String[] {"BA", "BL", "MA", "PK", "SC","TT", "TA", "DS", "GA", "HC", "PN", "SE", "SI","TN", "BN", "IL", "MY", "NM", "PE", "PB", "PD", "PU","BB", "BC", "BS", "BR", "LC", "DT", "KA", "PT", "RA", "RS", "VK", "ZV", "ZC", "ZH","ZA", "ZI", "BY", "CA", "DK", "KM", "LM", "MT", "NO", "RK", "TR", "TS","NR", "NI", "KO", "LV", "NZ", "SA", "TO", "ZM","LE", "PO", "PV", "BJ", "HE", "KK", "ML", "PP", "SB", "SV", "SL", "SP", "SK", "VT","KE", "KI", "KS", "GL", "MI", "RV", "SO", "SN", "TV"};
    int pocetOkresov = okresy.length;
  
    Random rn = new Random();   
    
    StringBuilder s = new StringBuilder();
    
    s.append(okresy[rn.nextInt(pocetOkresov)]).append("-");
           
    for (int i = 0; i < 3; i++) {
        char digit1 = (char) (Math.random() * 10 + '0');
           s.append(digit1); 
    }
    
    for (int i = 0; i < 2; i++) {
        char ch = (char) (Math.random() * 26 + 'A');
        s.append(ch);
    }    
        
    System.out.println("Random vehicle plate number: " + s);
    return s.toString();
}

	
}
