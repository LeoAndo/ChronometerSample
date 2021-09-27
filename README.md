# 開発環境

<img width="686" alt="スクリーンショット 2021-09-27 15 58 09" src="https://user-images.githubusercontent.com/16476224/134859783-1ef8cf7e-2ca2-4519-afa0-5a53a4435fec.png">



# Chronometerについて

[Chronometer](https://developer.android.com/reference/android/widget/Chronometer)は、タイマー機能を実装するためのクラス。</br>
Chronometerは内部では、[SystemClock#elapsedRealtime()](https://developer.android.com/reference/android/os/SystemClock#elapsedRealtime())とsetBaseで設定した値(`SystemClock#elapsedRealtime()`) の差を表示している。<br>

インスタンス生成時に[setBase](https://developer.android.com/reference/android/widget/Chronometer#setBase(long))が必ず呼ばれ[基準時間の設定](https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/android/widget/Chronometer.java;l=128?q=long%20seconds%20%3D%20mCountDown%20&ss=android%2Fplatform%2Fsuperproject:frameworks%2F)を行っている。<br>

[Chronometerは１秒間隔のタイマー通知しか行えない](https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/android/widget/Chronometer.java;l=339?q=long%20seconds%20%3D%20mCountDown%20&ss=android%2Fplatform%2Fsuperproject:frameworks%2F)<br>

[isFinalCountDown](https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/android/widget/Chronometer.java;l=159?q=long%20seconds%20%3D%20mCountDown%20&ss=android%2Fplatform%2Fsuperproject:frameworks%2F)というメソッドがある。<br>
Googleのお茶目なエンジニアが入れたと思われる機能. youtubeアプリを起動して、「The Final Countdown」を流すだけ<br>

## タイマーの経過時間(ミリ秒)の取得　スニペット
```
Chronometer chronometer = findViewById(R.id.chrono);
long time = SystemClock.elapsedRealtime() - chronometer.getBase();
```

# Capture

<img src="https://user-images.githubusercontent.com/16476224/120098968-d7bfc080-c173-11eb-86f9-795be1d3f63a.gif" width=320 />
