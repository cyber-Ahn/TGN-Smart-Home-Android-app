package cyber.ahn.mqtt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MainActivity extends AppCompatActivity {
    MqttHelper mqttHelper;
    TextView versionReceived;
    TextView ipReceived;
    TextView WtempReceived;
    TextView WhumReceived;
    TextView WcloudReceived;
    TextView WwindReceived;
    TextView langReceived;
    TextView clientReceived;
    TextView blockReceived;
    TextView querReceived;
    TextView roomReceived;
    TextView luxReceived;
    TextView mcpReceived;
    TextView lcdReceived;
    TextView rtcReceived;
    TextView romReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        versionReceived = findViewById(R.id.versionReceived);
        ipReceived = findViewById(R.id.ipReceived);
        WtempReceived = findViewById(R.id.WtempReceived);
        WhumReceived = findViewById(R.id.WhumReceived);
        WcloudReceived = findViewById(R.id.WcloudReceived);
        WwindReceived = findViewById(R.id.WwindReceived);
        langReceived = findViewById(R.id.langReceived);
        clientReceived = findViewById(R.id.clientReceived);
        blockReceived = findViewById(R.id.blockReceived);
        querReceived = findViewById(R.id.querReceived);
        roomReceived = findViewById(R.id.roomReceived);
        luxReceived = findViewById(R.id.luxReceived);
        mcpReceived = findViewById(R.id.mcpReceived);
        lcdReceived = findViewById(R.id.lcdReceived);
        rtcReceived = findViewById(R.id.rtcReceived);
        romReceived = findViewById(R.id.romReceived);
        startMqtt();
    }

    private void startMqtt(){
        mqttHelper = new MqttHelper(getApplicationContext());
        mqttHelper.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {

            }
            @Override
            public void connectionLost(Throwable throwable) {

            }
            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) {
                Log.w("Debug",mqttMessage.toString());
                if (topic.equals("tgn/version")){
                    versionReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/ip")){
                    ipReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/weather/temp")){
                    WtempReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/weather/humidity")){
                    WhumReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/weather/clouds")){
                    WcloudReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/weather/wind")){
                    WwindReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/language")){
                    langReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/pihole/clients")){
                    clientReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/pihole/adBlock")){
                    blockReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/pihole/queries")){
                    querReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/room/temp")){
                    roomReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/room/light")){
                    luxReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/i2c/mcp")){
                    mcpReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/i2c/lcd")){
                    lcdReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/i2c/rtc")){
                    rtcReceived.setText(mqttMessage.toString());
                }
                if (topic.equals("tgn/i2c/eeprom")){
                    romReceived.setText(mqttMessage.toString());
                }

            }
            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
            }
        });
    }
}
