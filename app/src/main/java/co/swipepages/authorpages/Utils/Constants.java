package co.swipepages.authorpages.Utils;

import android.content.Context;
import android.graphics.Typeface;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

    public static String getTimeStamp(){
        Long tsLong = System.currentTimeMillis()/1000;
        return ""+tsLong;
    }

    public static String getDate(long timeStamp){

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("EEE \n dd MMM yyyy");
            Date netDate = (new Date(timeStamp));
            return sdf.format(netDate);
        }
        catch(Exception ex){
            return "xx";
        }
    }

    public static Typeface getTxtType(Context ctx){
        return Typeface.createFromAsset(ctx.getAssets(),"san_frediano.ttf");
    }

}
