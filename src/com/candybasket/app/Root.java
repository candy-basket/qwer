package com.candybasket.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * com.candybasket.app
 * Root.java
 * Desc:
 * @Company : Candy-basket
 * @author     : ilsung
 * @Date        : 2013. 11. 21. ¿ÀÈÄ 8:20:04
 * @Version    : 1.0.4
 * @See         
 * @Todo       
 */
public class Root extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        Intent i = new Intent(Root.this, A_00.class);
        startActivity(i);
        finish();
        
    }

}
