 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlsuite;
import javax.swing.JOptionPane;
 /**
 *
 * @author Administrator
 */
public class MyUtilities {
    static boolean isNumber(String str_number)
    {
        try{
                Integer.parseInt(str_number);
            }
            catch(Exception ex)
            {
                return false;
            }
            return true;
    }
    static int isTable_Column_Name(String str_name)
    {
              //if(str_name.length()>0)         
//                if(str_name.charAt(0)=='_'||str_name.charAt(0)=='$'||str_name.charAt(0)=='#')
//                {
//                        JOptionPane.showMessageDialog(null,"A Table or column name cannot start with _,$ or #");
//                        return false;
//                }
                int len=str_name.length();
                System.out.println(len);
                String pattern = "[a-zA-Z0-9_$#]*";
                if(!str_name.matches(pattern))
                {
                        return 0;
                }
                    //Integer.parseInt(str_name);
                    //Integer.valueOf(str_name.charAt(i));
                
//                if(str_name.charAt(len)!='_'||str_name.charAt(len)!='$'||str_name.charAt(len)!='#')
//                {
//                        return true;
//                }
                return 1;
    }
    static void closeTab(int tabno)
    {
        if(MainWindowClass.tabcr>tabno)
        {
            MainWindowClass.tabcr--;
        }
        if(MainWindowClass.tabct>tabno)
        {
            MainWindowClass.tabct--;
        }
        if(MainWindowClass.tabcu>tabno)
        {
            MainWindowClass.tabcu--;
        }
        if(MainWindowClass.tabcv>tabno)
        {
            MainWindowClass.tabcv--;
        }
        if(MainWindowClass.tabdel>tabno)
        {
            MainWindowClass.tabdel--;
        }
        if(MainWindowClass.tabdesc>tabno)
        {
            MainWindowClass.tabdesc--;
        }
        if(MainWindowClass.tabdup>tabno)
        {
            MainWindowClass.tabdup--;
        }
        if(MainWindowClass.tabins>tabno)
        {
            MainWindowClass.tabins--;
        }
        if(MainWindowClass.tabmod>tabno)
        {
            MainWindowClass.tabmod--;
        }
        if(MainWindowClass.tabpr>tabno)
        {
            MainWindowClass.tabpr--;
        }
    }
}
