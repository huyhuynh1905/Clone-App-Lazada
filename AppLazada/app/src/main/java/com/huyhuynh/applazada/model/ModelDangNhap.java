package com.huyhuynh.applazada.model;

import android.content.Context;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class ModelDangNhap {

    AccessToken accessToken;
    AccessTokenTracker accessTokenTracker;
    public AccessToken layTokenFacebook(){
        AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                accessToken = currentAccessToken;
            }
        };
        accessToken = AccessToken.getCurrentAccessToken();

        return accessToken;
    }

    public void desTroyTokenTracker(){
        accessTokenTracker.stopTracking();
    }

    public GoogleSignInClient xuLiDangNhapBangGoogle(Context context) {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        return GoogleSignIn.getClient(context,gso);
    }

    public GoogleSignInAccount layTaiKhoanGoogle(Context context){
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(context);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Log.d("layTaiKhoanGoogle", "handleSignInResult: Thành công!\n"+personName+" - "
            +personEmail);
        }
        return acct;
    }
}
