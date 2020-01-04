package com.example.redma.sensorget

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //取得したセンサー情報を追加するようの変数
        val buffer = StringBuilder()

        //センサーの一覧を取得⇒getSystemServiciはObject型を返すためSensorManager型にキャスト
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        //センサーを取得、引数には取得したいセンサーを指定⇒ここではすべてのセンサーを指定
        val sList:List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
        //個々のSensorオブジェクトを取得⇒いタイプ、名前、ベンダーを一行ごとに保存
        for (sensor : Sensor in sList){
            buffer.append("{${sensor.stringType},${sensor.name},${sensor.vendor}\n")
        }
        //txt01に保存したセンサーの情報を表示
        txt01.text = buffer.toString()
    }
}
