/*
package com.example.loginfunc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class AppInstallActivity extends AppCompatActivity {
    private Button unityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unitystory);

       unityBtn = findViewById(R.id.unitybtn);

       unityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AssetManager am = getResources().getAssets() ;
                InputStream is = null ;

                try {
                    is = am.open("ar_build.apk") ;
                } catch (Exception e) {
                    e.printStackTrace() ;
                }

                File apk = new File(getCacheDir(), "ar_build.apk");
                copyInputStreamToFile(is, apk);

                if (is != null) {
                    try {
                        is.close() ;
                    } catch (Exception e) {
                        e.printStackTrace() ;
                    }
                }

                Uri uri = FileProvider.getUriForFile(AppInstallActivity.this, getPackageName() + ".provider", apk);

                Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
                intent.setData(uri);
                 finish();

                 Intent intent1 = new Intent(AppInstallActivity.this,Story1btn.class);
                startActivity(intent1);

                PackageManager packageManager = getPackageManager();
                if (intent.resolveActivity(packageManager) != null) {
                    List<ResolveInfo> resInfoList = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                    for (ResolveInfo resolveInfo : resInfoList) {
                        String packageName = resolveInfo.activityInfo.packageName;
                        grantUriPermission(packageName, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    }

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    startActivity(intent);
                } else {
                    Log.d("abc", "No Intent available to handle action");
                }
            }
        });
    }

    private void copyInputStreamToFile(InputStream in, File file) {
        OutputStream out = null;

        try {
            out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if ( out != null ) {
                    out.close();
                }
                in.close();
            }
            catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }
}
*/
