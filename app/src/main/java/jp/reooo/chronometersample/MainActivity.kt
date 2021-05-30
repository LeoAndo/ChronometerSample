package jp.reooo.chronometersample

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var lastStartClickedTime = 0L; // milliseconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityBootTimer = findViewById<Chronometer>(R.id.activityBootTimer)
        Log.d(LOG_TAG, "activityBootTimer Base" + activityBootTimer.base)
        activityBootTimer.start()
        val countTimer = findViewById<Chronometer>(R.id.countTimer)
        countTimer.setOnChronometerTickListener {
            Log.d(LOG_TAG, "countTimer base: " + countTimer.base)
        }

        val buttonStart = findViewById<Button>(R.id.buttonStart)
        buttonStart.setOnClickListener {
            countTimer.base = SystemClock.elapsedRealtime() - lastStartClickedTime
            countTimer.start()
        }
        val buttonStop = findViewById<Button>(R.id.buttonStop)
        buttonStop.setOnClickListener {
            countTimer.stop()
            lastStartClickedTime = SystemClock.elapsedRealtime() - countTimer.base
        }
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        buttonReset.setOnClickListener {
            countTimer.stop()
            countTimer.base = SystemClock.elapsedRealtime()
            lastStartClickedTime = 0
        }
        val textContentDescription = findViewById<TextView>(R.id.textContentDescription)
        val buttonContentDescription = findViewById<Button>(R.id.buttonContentDescription)
        buttonContentDescription.setOnClickListener {
            textContentDescription.text = activityBootTimer.contentDescription
        }

        val buttonStartYoutube = findViewById<Button>(R.id.buttonStartYoutube)
        buttonStartYoutube.setOnClickListener {
            activityBootTimer.isTheFinalCountDown
        }
    }

    companion object {
        private val LOG_TAG = MainActivity::class.simpleName
    }
}