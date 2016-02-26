package com.prathimad.ankushc.ballyhoo.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.prathimad.ankushc.ballyhoo.R;

/**
 * Created by ankushc on 2/26/16.
 */
public class ActivityHelper{

        /** The activity. */
        private final Activity activity;

        /**
         * Instantiates a new common.
         *
         * @param activity
         *            the activity
         */
        public ActivityHelper(final Activity activity) {
            this.activity = activity;
        }

        /**
         * Start next activity.
         *
         * @param cl
         *            the cl
         */
        public void startNextActivity(final Class< ? > cl) {
            final Intent intent = new Intent(this.activity, cl);
            this.activity.startActivity(intent);
        }

        /**
         * Check network and asks user to connect to Internet if not connected.
         *
         * @return true, if successful
         */
        public boolean checkNetwork() {
            final ConnectivityManager connManager =
                    (ConnectivityManager) this.activity.getSystemService(Context.CONNECTIVITY_SERVICE);

            final NetworkInfo info = connManager.getActiveNetworkInfo();
            if (info == null) {
                Toast.makeText(this.activity, "Please check you conecntivity.",
                        Toast.LENGTH_SHORT).show();
            } else {
                final boolean status = info.isAvailable();
                if (!status) {
                    Toast.makeText(this.activity, "NO_NETWORK_AVAILABLE",
                            Toast.LENGTH_SHORT).show();
                } else {
                    return true;
                }
            }
            return false;
        }

        /**
         * Gets the application version number.
         *
         * @return the application version number
         * @throws PackageManager.NameNotFoundException
         *             the name not found exception
         */
        public String getApplicationVersionNumber() throws PackageManager.NameNotFoundException {
            final String versionName =
                    this.activity.getPackageManager().getPackageInfo(this.activity.getPackageName(), 0).versionName;
            return versionName;
        }

        /**
         * Gets the device IMIE number.
         *
         * @return the device imie
         */
        public String getDeviceIMIE() {
            final TelephonyManager mangr = (TelephonyManager) this.activity.getSystemService(Context.TELEPHONY_SERVICE);
            return mangr.getDeviceId();
        }

        /**
         * Opens the url in web-browser.
         *
         * @param url
         *            the url
         */
        public void openInWebBrowserAndCloseApp(final Activity act, final String url) {
            this.openInWebBrowser(url);
            act.finishAffinity();
        }

        /**
         * Opens the url in web-browser.
         *
         * @param url
         *            the url
         */
        public void openInWebBrowser(final String url) {
            final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            this.activity.startActivity(intent);
        }
}
