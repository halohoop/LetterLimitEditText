package com.halohoop.letterlimitedittext;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.halohoop.letterlimitedittext.test", appContext.getPackageName());
    }
    @Test//开启限制
    public void editTextTest0() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        LetterLimitEditText letterLimitEditText = new LetterLimitEditText(appContext);
        letterLimitEditText.limitEnable(true);

        letterLimitEditText.setText("///a//");
        String s = letterLimitEditText.getText().toString();

        assertEquals("", s);
    }
    @Test//关闭限制
    public void editTextTest1() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        LetterLimitEditText letterLimitEditText = new LetterLimitEditText(appContext);
        letterLimitEditText.limitEnable(false);

        letterLimitEditText.setText("///a//");
        String s = letterLimitEditText.getText().toString();

        Log.i(TAG, "editTextTest1: " + s);

        assertEquals("///a//",s);
    }

    @Test//开启限制
    public void editTextTest2() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        LetterLimitEditText letterLimitEditText = new LetterLimitEditText(appContext);
        letterLimitEditText.setLimitReg("[/]");
        letterLimitEditText.limitEnable(true);

        letterLimitEditText.setText("///a//");
        String s = letterLimitEditText.getText().toString();

        assertEquals("a",s);
    }
    @Test//开启限制 限制回车\n
    public void editTextTest3() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        LetterLimitEditText letterLimitEditText = new LetterLimitEditText(appContext);
        letterLimitEditText.setLimitReg("[\n]");
        letterLimitEditText.limitEnable(true);

        letterLimitEditText.setText("/\n//a//");
        String s = letterLimitEditText.getText().toString();

        assertEquals("///a//",s);
    }
    @Test//开启限制 限制回车\n和/
    public void editTextTest4() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        LetterLimitEditText letterLimitEditText = new LetterLimitEditText(appContext);
        letterLimitEditText.setLimitReg("[\n/]");
        letterLimitEditText.limitEnable(true);

        letterLimitEditText.setText("/\n//a//");
        String s = letterLimitEditText.getText().toString();

        assertEquals("a",s);
    }

    private static final String TAG = "ExampleInstrumentedTest";
}
