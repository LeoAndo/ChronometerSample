# Chronometerについて

[Chronometer](https://developer.android.com/reference/android/widget/Chronometer)は、タイマー機能を実装するためのクラス。</br>
インスタンス生成時に[setBase](https://developer.android.com/reference/android/widget/Chronometer#setBase(long))が必ず呼ばれ[基準時間の設定](https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/android/widget/Chronometer.java;l=128?q=long%20seconds%20%3D%20mCountDown%20&ss=android%2Fplatform%2Fsuperproject:frameworks%2F)を行っている。<br>
その時に使っている基準時間が[SystemClock#elapsedRealtime()](https://developer.android.com/reference/android/os/SystemClock#elapsedRealtime())というAndroid端末の起動からの経過時間(ミリ秒)を返すAPIのため、<br>
タイマーの経過時間(秒)は、`SystemClock#elapsedRealtime() - setBaseメソッドで設定した値` で求められる。<br>
[Chronometerは１秒間隔のタイマー通知しか行えない](https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/android/widget/Chronometer.java;l=339?q=long%20seconds%20%3D%20mCountDown%20&ss=android%2Fplatform%2Fsuperproject:frameworks%2F)<br>


# Capture

<img src="https://user-images.githubusercontent.com/16476224/119487963-f8170600-bd94-11eb-8511-58734f09a7c0.gif" width=320 />
