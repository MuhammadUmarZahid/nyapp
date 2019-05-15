package com.task.nytimes;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A fragment representing a single Article detail screen.
 * This fragment is either contained in a {@link ArticleListActivity}
 * in two-pane mode (on tablets) or a {@link ArticleDetailActivity}
 * on handsets.
 */
public class ArticleDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "article";

    /**
     * The dummy content this fragment is presenting.
     */
    private MultipleResource.Article mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ArticleDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = (MultipleResource.Article) getArguments().getSerializable(ARG_ITEM_ID);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            ImageView toolbarImage = activity.findViewById(R.id.collapsing_toolbar_image_view);
            if(toolbarImage != null){
                Picasso.get().load(mItem.media.get(0).metadataList.get(3).url).into(toolbarImage);
            }
            if (appBarLayout != null) {
                appBarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
                appBarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
                appBarLayout.setCollapsedTitleTypeface(Typeface.SANS_SERIF);
                appBarLayout.setExpandedTitleTypeface(Typeface.SANS_SERIF);
                appBarLayout.setTitle(mItem.byline);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.article_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.article_detail)).setText(mItem.title);
            ((TextView) rootView.findViewById(R.id.date)).setText(mItem.publishedDate);
            ((TextView) rootView.findViewById(R.id.abs)).setText(mItem.abs);
        }

        return rootView;
    }
}
