import com.ximpleware.*;
public class loadIndex{
        public static void Main(String[] args)
        {
            try
            {
                VTDGen vg = new VTDGen();
                VTDNav vn = vg.loadIndex("d:/C#_tutorial_by_code_examples/5/input.vxl");
                // do whatever you want here
            }
            catch (IndexReadException e)
            {
            }
	    catch (java.io.IOException e){
	    }
        }
}
