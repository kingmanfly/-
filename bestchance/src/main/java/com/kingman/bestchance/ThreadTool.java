package com.kingman.bestchance;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * Created by wb-lijinwei.a on 2016/5/16.
 */
public class ThreadTool {
    static private final String TAG = "ThreadTool";
    /**
     * UI线程handler
     */
    static private LoopHandler uiThreadHandler = new LoopHandler(Looper.getMainLooper());

    /* methods: API */
    static public void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }

        uiThreadHandler.enqueue(runnable);
    }

    /* methods: API */
    static public void runOnUiThreadPostDelay(Runnable runnable, long mill) {
        if (runnable == null) {
            return;
        }

        uiThreadHandler.enqueue(runnable, mill);
    }

    /* inner type */

    static public final class LoopHandler extends Handler {
        static private final String TAG = ThreadTool.TAG + "_LoopHandler";

        public LoopHandler(Looper looper) {
            super(looper);
        }

        public void enqueue(Runnable runnable) {
            Message message = obtainMessage();
            message.obj = runnable;

            sendMessage(message);
        }

        public void enqueue(Runnable runnable, long milli) {
            Message message = obtainMessage();
            message.obj = runnable;
            sendMessageDelayed(message, milli);
        }

        @Override
        public void handleMessage(Message msg) {
            if (null == msg || null == msg.obj || false == (msg.obj instanceof Runnable))
                return;

            try {
                ((Runnable) msg.obj).run();
            } catch (Exception ex) {
                Log.e(TAG, "run task error: " + (null != ex ? ex.getMessage() : "unknown"));
                ex.printStackTrace();
            }
        }

    }
}
