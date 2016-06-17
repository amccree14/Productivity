package nativeshakers.com.productivity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class SearchViewHolder extends RecyclerView.ViewHolder {

    private final TextView searchText;

    public SearchViewHolder(View itemView) {
        super(itemView);

        searchText = (TextView) itemView.findViewById(R.id.search_text);
    }

    public void bind(SearchModel model) {
        searchText.setText(model.getText());
    }
}