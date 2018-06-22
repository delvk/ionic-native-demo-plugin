package android.com.charlie.ionic.demo;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;


public class AndroidDemo extends CordovaPlugin {

    private Integer kq;
    
    private CallbackContext callbackContext;
    private JSONObject data = new JSONObject();
    
    public int Subtraction(int a, int b){
        Sub sub = new Sub(a, b);
        return sub.getSub();
    } 

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        
    }

    @Override
    public void onDestroy() {
        
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("start".equals(action)) {
            data.put("ket qua",10987);
            PluginResult result = new PluginResult(PluginResult.Status.OK, this.data);
            callbackContext.sendPluginResult(result);
            return true;
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }

    private Integer getSub(int a, int b){

        data = new JSONObject();
              try {
                  data.put("ket qua",getSub(a,b));
              } catch(JSONException e) {}
    }
}
