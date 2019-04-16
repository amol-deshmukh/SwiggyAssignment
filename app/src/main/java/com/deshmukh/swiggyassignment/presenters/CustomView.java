package com.deshmukh.swiggyassignment.presenters;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.deshmukh.swiggyassignment.R;
import com.deshmukh.swiggyassignment.models.APiResponse;
import com.deshmukh.swiggyassignment.models.ExcludeList;
import com.deshmukh.swiggyassignment.models.Variation;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * Created by
 *
 * @author Amol Deshmukh
 * @since 16/04/19
 */
public class CustomView extends LinearLayout implements View.OnClickListener {
    Context context;

    public CustomView(Context context) {
        super(context);
        initUI(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initUI(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUI(context, attrs);

    }


    private void initUI(Context context, AttributeSet attrs) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout, this, true);
        mLinearLayout = view.findViewById(R.id.lyt);
        this.context = context;


    }

    LinearLayout mLinearLayout;

    RadioGroup radioGroup;
    RadioButton[] radioButtons;
    List<RadioButton> mHiddenButtons = new ArrayList<>();
    APiResponse aPiResponse;

    public void init(APiResponse aPiResponse) {
        this.aPiResponse=aPiResponse;
        for (int i = 0; i < aPiResponse.getVariants().getVariantGroups().size(); i++) {
            Log.e("@@@@@", i + "");

            showRadioGroupName(aPiResponse.getVariants().getVariantGroups().get(i).getName());

            radioGroup = new RadioGroup(context);
            radioGroup.setOrientation(RadioGroup.VERTICAL);
            radioGroup.setPadding(24, 0, 0, 24);
            radioGroup.setId(1000 + i);

            mLinearLayout.addView(radioGroup);

            List<Variation> mListVariations = aPiResponse.getVariants().getVariantGroups().get(i).getVariations();

            radioButtons = new RadioButton[mListVariations.size()];

            for (int j = 0; j < mListVariations.size(); j++) {

                radioButtons[j] = new RadioButton(context);

                radioButtons[j].setPadding(8, 0, 0, 0);

                radioButtons[j].setText(mListVariations.get(j).toString());

                radioButtons[j].setId(Integer.parseInt(mListVariations.get(j).getId()));

                radioButtons[j].setTag(aPiResponse.getVariants().getVariantGroups().get(i).getGroupId() + "," + radioGroup.getId());


                radioButtons[j].setOnClickListener(this);

                radioGroup.addView(radioButtons[j]);
            }
        }


    }

    void showRadioGroupName(String name) {

        TextView view = new TextView(context);
        view.setText(name);
        view.setTextSize(16);
        mLinearLayout.addView(view);
    }

    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();
        String[] parts = tag.split(",");
        String group_id = parts[0];
        String radioGroupID = parts[1];


        unHideButtons(radioGroupID);
        //uncheckAllOthers(radioGroupID);
        mHiddenButtons.clear();

        int variation_id = v.getId();

        for (int i = 0; i < aPiResponse.getVariants().getExcludeList().size(); i++) {
            List<ExcludeList> excludeListPair = aPiResponse.getVariants().getExcludeList().get(i);
            for (int j = 0; j < excludeListPair.size(); j++) {

                if (excludeListPair.get(j).getGroupId().equals(group_id) &&
                        excludeListPair.get(j).getVariationId().equals(Integer.toString(variation_id))) {

                    for (int k = 0; k < excludeListPair.size(); k++) {

                        if (k == j)
                            continue;

                        int var_id = Integer.parseInt(excludeListPair.get(k).getVariationId());

                        RadioButton rb = findViewById(var_id);
                        mHiddenButtons.add(rb);
                        rb.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }
    }

   /* private void uncheckAllOthers(String radioGroupID) {
        for (int i=0;i<mLinearLayout.getChildCount();i++){
            RadioGroup radioGroup= (RadioGroup) mLinearLayout.getChildAt(i);
            if (!radioGroupID.equals((radioGroup.getId()))) {
                RadioGroup rg =  findViewById(Integer.parseInt(radioGroupID));
                rg.clearCheck();
            }

        }

    }
*/
    public void unHideButtons(String currentClickedRadioGroupId) {

        for (RadioButton rb : mHiddenButtons) {
            rb.setVisibility(View.VISIBLE);
            String tag = (String) rb.getTag();
            String[] parts = tag.split(",");
            String radioGroupID = parts[1];
            if (!currentClickedRadioGroupId.equals((radioGroupID))) {
                RadioGroup rg =findViewById(Integer.parseInt(radioGroupID));
                rg.clearCheck();
            }
            //uncheckAllOthers(radioGroupID);

        }
    }
}





