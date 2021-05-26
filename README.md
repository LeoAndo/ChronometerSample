# Chronometerについて

[Chronometer](https://developer.android.com/reference/android/widget/Chronometer)は、タイマー機能を実装するためのクラス。</br>
Chronometerは内部では、[SystemClock#elapsedRealtime()](https://developer.android.com/reference/android/os/SystemClock#elapsedRealtime())とsetBaseで設定した値(`SystemClock#elapsedRealtime()`) の差を表示している。<br>

インスタンス生成時に[setBase](https://developer.android.com/reference/android/widget/Chronometer#setBase(long))が必ず呼ばれ[基準時間の設定](https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/android/widget/Chronometer.java;l=128?q=long%20seconds%20%3D%20mCountDown%20&ss=android%2Fplatform%2Fsuperproject:frameworks%2F)を行っている。<br>

## タイマーの経過時間(ミリ秒)の取得　スニペット
```
Chronometer chronometer = findViewById(R.id.chrono);
long time = SystemClock.elapsedRealtime() - chronometer.getBase(); // chronometer.start()してからの経過時間( ms)
```

[Chronometerは１秒間隔のタイマー通知しか行えない](https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/android/widget/Chronometer.java;l=339?q=long%20seconds%20%3D%20mCountDown%20&ss=android%2Fplatform%2Fsuperproject:frameworks%2F)<br>


# Capture

<img src="https://user-images.githubusercontent.com/16476224/119487963-f8170600-bd94-11eb-8511-58734f09a7c0.gif" width=320 />
