package net.davidnorton.securityapp.ui;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.davidnorton.securityapp.R;

/**
 * Fragment used to contain the Help page.
 *
 * @author David Norton
 */
public class Help extends Fragment {

    private ImageView ivIcon;
    private TextView tvItemName;

    public static final String IMAGE_RESOURCE_ID = "iconResourceID";
    public static final String ITEM_NAME = "itemName";

    /**
     * Creates the Help fragment.
     *
     * @param inflater Instantiates a layout XML file into its corresponding View objects.
     * @param container Container used to the base for layouts and views containers.
     * @param savedInstanceState Saves current state of application to be referred back to.
     * @return The view.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_help, container, false);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this.getActivity());

        ivIcon = (ImageView) view.findViewById(R.id.help_icon);
        tvItemName = (TextView) view.findViewById(R.id.help_title);

        tvItemName.setText(getArguments().getString(ITEM_NAME));
        ivIcon.setImageDrawable(ResourcesCompat.getDrawable(getResources(), getArguments().getInt(IMAGE_RESOURCE_ID), null));

        // Apply correct colour scheme.
        if (pref.getBoolean("dark_theme", false) ) {
            CardView cardView = (CardView) view.findViewById(R.id.card_1);
            cardView.setCardBackgroundColor(Color.rgb(40, 40, 40));
            cardView = (CardView) view.findViewById(R.id.card_2);
            cardView.setCardBackgroundColor(Color.rgb(40, 40, 40));
            cardView = (CardView) view.findViewById(R.id.card_3);
            cardView.setCardBackgroundColor(Color.rgb(40, 40, 40));
        }

        return view;
    }

}