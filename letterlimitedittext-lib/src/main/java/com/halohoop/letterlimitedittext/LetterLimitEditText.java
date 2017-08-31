package com.halohoop.letterlimitedittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pooholah on 2017/8/31.
 */

public class LetterLimitEditText extends AppCompatEditText {

    private Pattern p;

    public LetterLimitEditText(Context context) {
        this(context, null);
    }

    public LetterLimitEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LetterLimitEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        p = Pattern.compile(DEFAULT_REG_TO_LIMIT);
    }

    public void limitEnable(boolean isEnable) {
        if (isEnable) {
            InputFilter inputFilter = new InputFilter() {
                @Override
                public CharSequence filter(CharSequence charSequence,
                                           int i, int i1, Spanned spanned, int i2, int i3) {
                    Matcher m = p.matcher(charSequence);
                    if (m.find()) {
                        String group = m.group();
                        StringBuilder sb = new StringBuilder();
                        sb.append(charSequence);
                        String s = sb.toString();
                        for (int i4 = 0; i4 < group.length(); i4++) {
                            s = s.replaceAll(group.charAt(i4) + "", "");
                        }
                        return s;
                    } else {
                        return charSequence;
                    }
                }
            };
            setFilters(new InputFilter[]{inputFilter});
        } else {
            setFilters(new InputFilter[0]);
        }
    }

    private final static String DEFAULT_REG_TO_LIMIT = "[\n]";
    private String mRegToLimit = DEFAULT_REG_TO_LIMIT;

    public void setLimitReg(String s) {
        mRegToLimit = s;
        p = Pattern.compile(mRegToLimit);
    }

}
