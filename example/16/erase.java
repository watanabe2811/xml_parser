import com.ximpleware.*;
import java.io.*;

public class erase {
    public static void main(String[] args) throws Exception{
        VTDGen vg = new VTDGen();
        AutoPilot ap = new AutoPilot();
        ap.selectXPath("/CATALOG/CD[PRICE=10.2]/*/text()");
        if (vg.parseFile("old_cd.xml",false)){
           VTDNav vn = vg.getNav();
           ap.bind(vn);
           int i;
           byte[] ba = "".getBytes();
           while((i=ap.evalXPath())!=-1){
               vn.overWrite(i,ba);
           }
           FileOutputStream fos = new FileOutputStream("new_cd.xml");
           fos.write(vn.getXML().getBytes());
           fos.close();
        }        
    }
}
