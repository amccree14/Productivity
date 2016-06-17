package nativeshakers.com.productivity;

import android.app.Application;

import java.util.List;

public class GlobalVariable extends Application
{
    private List<Object> myState;

    public  List<Object>  getState()
    {
        return myState;
    }//End method

    public void setState(List<Object>  s)
    {
        myState = s;
    }//End method

    public void setState(List<Object>  s)
    {
        myState = s;
    }//End method

}//End Class
