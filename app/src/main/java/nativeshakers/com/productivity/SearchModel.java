package nativeshakers.com.productivity;

/**
 * Created with Android Studio
 * User: Xaver
 * Date: 24/05/15
 */
public class SearchModel {

    private final String mText;

    public SearchModel(String text) {
        mText = text;
    }

    public String getText() {
        return mText;
    }
}