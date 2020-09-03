import com.ximpleware.*;
import java.io.*;
//generate an index file for an input XML
public class writeIndex{
	public static void main(String[] args) throws IndexWriteException,IOException{
            VTDGen vg = new VTDGen();
            if (vg.parseFile("d:/java_tutorial_by_code_examples/4/input.xml",true)){
                vg.writeIndex("d:/java_tutorial_by_code_examples/4/input.vxl");
            }
        }
}
